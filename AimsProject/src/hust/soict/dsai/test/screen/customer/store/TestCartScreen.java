package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.customer.controller.CartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCartScreen extends Application {
    
    private static Cart cart;

    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        CartController cartController = new CartController(cart);
        fxmlLoader.setController(cartController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        cart = new Cart();

		// Create DVDs
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars 2", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars 3", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);

        Track track1 = new Track("Bruh1", 13);
		Track track2 = new Track("Bruh2", 21);
		Track track3 = new Track("Bruh3");
		CompactDisc cd1 = new CompactDisc("Allstars", "Yes", "Smash Mouth", "Dunno", 69.420f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		CompactDisc cd2 = new CompactDisc("Allstars 2", "Yes", "Smash Mouth", "Dunno", 69.420f);
		cd2.addTrack(track1);
		cd2.addTrack(track3);
		cd2.addTrack(track2);

        Book book = new Book("Harry Potter", "Fantasy", 30.00f);
        book.addAuthor("Rowling");
        book.setProcessContent("There were Mr. and Mrs. Dursley of number four, Privet Drive. They were proud to say that they were perfectly normal, thank you very much.");

        // Try adding DVDs
		cart.addMedia(dvd2);
		cart.addMedia(dvd1);
		cart.addMedia(dvd3);
		cart.addMedia(cd1);
		cart.addMedia(cd2);
		cart.addMedia(book);
		cart.addMedia(dvd4);
		cart.addMedia(dvd5);
		cart.addMedia(dvd6);

        launch(args);
    }

}
