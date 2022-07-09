package hust.soict.dsai.aims.screen.customer.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import javafx.beans.value.ChangeListener;
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

public class CartController {

    private Cart cart;
    private boolean filterByID = true;
	private FilteredList<Media> filteredCart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

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
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

		tfFilter.textProperty().addListener(new ChangeListener<String> () {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
    }

    void updateButtonBar(Media media) { 
        if (media == null) { 
            btnPlay.setVisible(false); 
            btnRemove.setVisible(false);
        } else { 
            btnRemove.setVisible(true); 
            if(media instanceof Playable) {
                btnPlay.setVisible(true); 
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

	private void showFilteredMedia(String filter) {
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
    void btnPlayPressed(ActionEvent event) {
		Media media = this.tblMedia.getSelectionModel().getSelectedItem();
        if (((Playable)media).play()) {
            Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Media Player");
			alert.setHeaderText("Media: " + media.getTitle());
			alert.setContentText("Playing...");
			alert.showAndWait();
        } else {
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
        cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        // todo
    }

    @FXML
    void filterByIDChosen(ActionEvent event) {
        filterByID = true;
    }

    @FXML
    void filterByTitleChosen(ActionEvent event) {
        filterByID = false;
    }

}