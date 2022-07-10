package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.*;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media media) throws IllegalItemException {
		if (this.itemsInStore.contains(media)) {
			throw new IllegalItemException(media.getTitle() + " is already in the store.");
		} else {
			this.itemsInStore.add(media);
			System.out.println(media.getTitle() + " has been added to the store.");
		}
	}
	
	public void removeMedia(Media media) throws IllegalItemException {
		if (this.itemsInStore.remove(media)) {
			System.out.println(media.getTitle() + " has been removed from the store.");
		} else {
			throw new IllegalItemException(media.getTitle() + " was not found in the store.");
		}
	}

	public Media searchMedia(String title) {
		for (Media medium : this.itemsInStore) {
			if (medium.getTitle().equalsIgnoreCase(title)) {
				return medium;
			}
		}
		return null;
	}

	public void print() {
		System.out.println("********STORE*************************************");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(Integer.toString(i + 1) + "." + "\t" + this.itemsInStore.get(i).toString());
		}
		System.out.println("**************************************************");
		System.out.println("\n");
	}


	public ArrayList<Media> getItemsInStore() {
		return this.itemsInStore;
	}

}
