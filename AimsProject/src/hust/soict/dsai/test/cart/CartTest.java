package hust.soict.dsai.test.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.*;

public class CartTest {
    public static void main(String[] args)  {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Trek");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Harry Potter", "Fantasy", 30.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Harry Potter", "Fantasy", 32.99f);
        DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd3};

        try {
            cart.addMedia(dvdList);
        } catch (IllegalItemException | LimitExceededException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            cart.removeMedia(dvd3);
        } catch (IllegalItemException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            cart.removeMedia(dvd3);
        } catch (IllegalItemException ex) {
            System.err.println(ex.getMessage());
        }

        Book book = new Book("Harry Potter", "Fantasy", 30.00f);

        ArrayList<String> authorsToAdd = new ArrayList<String>();
        authorsToAdd.add("Rowling");
        authorsToAdd.add("J.K.");
        authorsToAdd.add("NguyenTRungHIEU");
        authorsToAdd.add("NGUyenTRUnghIEU");

        ArrayList<String> authorsToRemove = new ArrayList<String>();
        authorsToRemove.add("NGUyenTRUnghIEU");
        authorsToRemove.add("NgUyEnTrUnGhIeU");

        for (String author : authorsToAdd) {
            try {
                book.addAuthor(author);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        for (String author : authorsToRemove) {
            try {
                book.removeAuthor(author);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        try {
            cart.removeMedia(book);
        } catch (IllegalItemException ex) {
            System.err.println(ex.getMessage());
        }

        Track track1 = new Track("Bruh1", 13);
		Track track2 = new Track("Bruh2", 21);
		CompactDisc cd1 = new CompactDisc("Allstars", "Yes", "Smash Mouth", "Dunno", 69.420f);
        try {
            cd1.addTrack(track1);
        } catch (IllegalItemException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            cd1.addTrack(track2);
        } catch (IllegalItemException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            cd1.addTrack(track1);
        } catch (IllegalItemException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            cd1.removeTrack(track1);
        } catch (IllegalItemException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            cd1.removeTrack(track2);
        } catch (IllegalItemException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            cd1.addTrack(track1);
        } catch (IllegalItemException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            cd1.addTrack(track2);
        } catch (IllegalItemException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            cart.addMedia(cd1);
        } catch (IllegalItemException | LimitExceededException ex) {
            System.err.println(ex.getMessage());
        }

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