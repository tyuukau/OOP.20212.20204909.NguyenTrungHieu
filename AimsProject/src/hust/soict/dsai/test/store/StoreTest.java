package hust.soict.dsai.test.store;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// Create the store
		Store myStore = new Store();

		// Create media
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

		Book book = new Book("Harry Potter", "Fantasy", 30.00f);

		try {
        	book.addAuthor("Rowling");
			book.setProcessContent("There were Mr. and Mrs. Dursley of number four, Privet Drive. They were proud to say that they were perfectly normal, thank you very much.");
		} catch (IllegalItemException ex) {
			System.err.println(ex.getMessage());
		}

		// Add media
		ArrayList<Media> mediaToAdd = new ArrayList<Media>();
		Collections.addAll(mediaToAdd, dvd2, dvd1, dvd3, dvd1, dvd1, book);
		for (Media media : mediaToAdd) {
			try {
				myStore.addMedia(media);
			} catch (IllegalItemException ex) {
				System.err.println(ex.getMessage());
			}
		}
		myStore.print();

		// Remove media
		ArrayList<Media> mediaToRemove = new ArrayList<Media>();
		Collections.addAll(mediaToRemove, dvd3, dvd1);
		for (Media media : mediaToRemove) {
			try {
				myStore.removeMedia(media);
			} catch (IllegalItemException ex) {
				System.err.println(ex.getMessage());
			}
		}
		myStore.print();
	}

}