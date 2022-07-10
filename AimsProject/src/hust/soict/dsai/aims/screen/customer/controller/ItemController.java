package hust.soict.dsai.aims.screen.customer.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;

public class ItemController {

    private Media media;
    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (cart.addMedia(this.media) > 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Cart");
			alert.setHeaderText("Media: " + this.media.getTitle());
			alert.setContentText("was added to the cart.");
			alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Cart");
			alert.setHeaderText("Media: " + this.media.getTitle());
			alert.setContentText("was not added to the cart. Error.");
			alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (((Playable)this.media).play()) {
            Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Media Player");
			alert.setHeaderText("Media: " + this.media.getTitle());
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

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(this.media.getTitle());
        lblCost.setText(this.media.getCost() + " $");
        if (this.media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 112.5));
        }
    }


}
