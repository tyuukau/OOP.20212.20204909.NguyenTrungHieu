package hust.soict.dsai.aims.screen.customer.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;
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
        Alert alert = new Alert(AlertType.INFORMATION);
        try {
            cart.addMedia(this.media);
            alert.setTitle("Cart");
			alert.setHeaderText("Media: " + this.media.getTitle());
			alert.setContentText("was added to the cart.");
        } catch (IllegalItemException | LimitExceededException ex) {
            alert = new Alert(AlertType.WARNING);
			alert.setTitle("Cart");
			alert.setHeaderText("Media: " + this.media.getTitle() + " was not added to the cart.");
			alert.setContentText("The cart was full or the media was already in the cart.");
        } finally {
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        try {
            ((Playable)media).play();
            Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Media Player");
			alert.setHeaderText("Media: " + media.getTitle());
			alert.setContentText("Playing...");
			alert.showAndWait();
        } catch (PlayerException ex) {
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

    public ItemController(Cart cart) {
        this.cart = cart;
    }

}
