package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.FloatBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class CartController {

    private Cart cart;
    private Store store;
    private boolean filterByID = true;
	private FilteredList<Media> filteredCart;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label costLabel;

    @FXML
    public void initialize() {
		filteredCart = new FilteredList<Media>(this.cart.getItemsOrdered(), s -> true);

        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(filteredCart);
        }

        btnPlay.setVisible(false); 
        btnRemove.setVisible(false); 
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends Media> observable, Media oldValue, Media newValue) -> {
                updateButtonBar(newValue);
            }
        );

        tfFilter.textProperty().addListener(
            (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                showFilteredMedia(newValue);
            }
        );

        FloatBinding totalCost = Bindings.createFloatBinding(() -> {
            float total = 0.0f;
            for (Media media : this.cart.getItemsOrdered()) {
                total = total + media.getCost();
            }
            return total ;
        }, this.cart.getItemsOrdered());

        costLabel.textProperty().bind(totalCost.asString());
        
    }

    void updateButtonBar(Media media) { 
        if (media == null) { 
            btnPlay.setVisible(false); 
            btnRemove.setVisible(false);
        } else { 
            btnRemove.setVisible(true); 
            if (media instanceof Playable) {
                btnPlay.setVisible(true); 
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

	void showFilteredMedia(String filter) {
		if (filter == null || filter.length() == 0) {
			filteredCart.setPredicate(s -> true);
		} else {
			if (filterByID) {
				try {
					filteredCart.setPredicate(s -> s.getId() == Integer.parseInt(filter));
				} catch (NumberFormatException e) {}
			} else {
				filteredCart.setPredicate(s -> s.getTitle().toLowerCase().contains(filter));
			}
		}
	}

    @FXML
    void btnPlayPressed(ActionEvent event) {
		Media media = this.tblMedia.getSelectionModel().getSelectedItem();
        try {
            ((Playable)media).play();
            Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Media Player");
			alert.setHeaderText("Media: " + media.getTitle());
			alert.setContentText("Playing...");
			alert.showAndWait();
        } catch (PlayerException e) {
            Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Media Player");
			alert.setHeaderText("ERROR: Media length is non-positive.");
			alert.setContentText("Media cannot be played.");
			alert.showAndWait();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            cart.removeMedia(media);
        } catch (IllegalItemException e) {
            Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Notification");
			alert.setHeaderText("Failed to remove.");
			alert.setContentText("The media is not in cart.");
			alert.showAndWait();
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
			final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
			fxmlLoader.setController(new StoreController(store, cart));
			Parent root = fxmlLoader.load();
			
			Stage nextStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			nextStage.setScene(new Scene(root));
			nextStage.setTitle("Store");
			nextStage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void filterByIDChosen(ActionEvent event) {
        filterByID = true;
    }

    @FXML
    void filterByTitleChosen(ActionEvent event) {
        filterByID = false;
    }

    @FXML
    void placeOrderClicked(ActionEvent event) {
        String content;
		if (this.cart.getSize() > 0) {
            Media luckyItem = this.cart.getALuckyItem();
            if (luckyItem != null) {
                content = "(!) A lucky item: " + luckyItem.toString() + "\n" +
                          "Cost: $" + (this.cart.totalCost() - luckyItem.getCost()) + ".";
            } else {
                content = "Cost: $" + this.cart.totalCost() + ".";
            }

            this.cart.empty();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Notification");
			alert.setHeaderText("Success! Your order has been placed.");
			alert.setContentText(content);
			alert.showAndWait();
        } else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Notification");
			alert.setHeaderText("ERROR: Failed to place order.");
			alert.setContentText("Your cart is empty.");
			alert.showAndWait();
		}
    }

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

}
