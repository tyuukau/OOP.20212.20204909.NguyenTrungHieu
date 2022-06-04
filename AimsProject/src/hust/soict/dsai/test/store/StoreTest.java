package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		//Create the store
		Store myStore = new Store();

		//Create DVDs
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

		//Try adding DVDs
		myStore.addDVD(dvd2);
		myStore.addDVD(dvd1);
		myStore.addDVD(dvd3);
		myStore.addDVD(dvd1);
		myStore.addDVD(dvd1);
		myStore.print();

		//Try removing DVDs
		myStore.removeDVD(dvd3);
		myStore.removeDVD(dvd1);
		myStore.print();
	}
}