package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Trek");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Harry Potter", "Fantasy", 30.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Harry Potter", "Fantasy", 32.99f);
        DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6};
        cart.addMedia(dvdList);
		cart.addMedia(dvd3);
		cart.removeMedia(dvd3);
		cart.removeMedia(dvd3);

		Book book1 = new Book("Sherlock Holmes", "Detective", 5.99f);
		book1.addAuthor("Conan Doyle");
		book1.addAuthor("Nguyen Trung Hieu");
		book1.addAuthor("nguyen TRUNG hieu");
		book1.removeAuthor("Nguyen Trung HIEU");
		book1.removeAuthor("NGUYEN trung HIEU");
        book1.setProcessContent("With a wry face I went out into the hall and opened the door. To my astonishment it was Sherlock Holmes who stood upon my step.");
		cart.addMedia(book1);

        Track track1 = new Track("Bruh1", 13);
		Track track2 = new Track("Bruh2", 21);
		CompactDisc cd1 = new CompactDisc("Allstars", "Yes", "Smash Mouth", "Dunno", 69.420f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd1.addTrack(track1);
		cd1.removeTrack(track2);
		cd1.removeTrack(track2);
		cd1.addTrack(track2);
		cd1.addTrack(track1);
		cart.addMedia(cd1);

        // Test the searchByID method
        cart.searchByID(1);

        // Test the sortByCost method
        cart.sortByCost();
        
        // Test the sortByTitle method
        cart.sortByTitle();

        // Test the print method
        cart.print();
    }
}