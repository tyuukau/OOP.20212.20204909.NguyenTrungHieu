package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.ArrayList;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();

	public void addDVD(DigitalVideoDisc disc) {
		if (this.itemsInStore.contains(disc)) {
			System.out.println(disc.getTitle() + " is already in the store.");
		} else {
			this.itemsInStore.add(disc);
			System.out.println(disc.getTitle() + " has been added to the store.");
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		if (this.itemsInStore.remove(disc)) {
			System.out.println(disc.getTitle() + " has been removed from the store.");
		} else {
			System.out.println(disc.getTitle() + " was not found in the store.");;
		}
	}

	public void print() {
		System.out.println("\n");
		System.out.println("*************AVAILABLE MEDIA IN STORE**************");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsInStore.get(i).toString());
		}
		System.out.println("***************************************************");
		System.out.println("\n");
	}
	
	public ArrayList<DigitalVideoDisc> getItemsInStore() {
		return this.itemsInStore;
	}

	public DigitalVideoDisc searchDVD(String title) {
		for (DigitalVideoDisc medium : this.itemsInStore) {
			if (medium.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return medium;
			}
		}
		return null;
	}

}
