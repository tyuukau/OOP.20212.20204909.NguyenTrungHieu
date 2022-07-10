package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.exception.IllegalItemException;
import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public int addMedia(Media media) throws LimitExceededException, IllegalItemException {
        int numberOfAddedMedia = 0;
        if (this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("The cart is already full. No media was added.");
        } else if (this.itemsOrdered.contains(media)) {
            throw new IllegalItemException("'" + media.getTitle() + "' is already in the cart. No media was added.");
        } else {
            this.itemsOrdered.add(media);
            numberOfAddedMedia = 1;
            System.out.printf("%d media, '%s', has been added to the cart.%n", numberOfAddedMedia, media.getTitle());
        }
        return numberOfAddedMedia;
    }

    public int addMedia(Media ... mediaList) throws LimitExceededException, IllegalItemException {
        int numberOfAddedMedia = 0;
        for (Media media : mediaList) {
			if (this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
				throw new LimitExceededException("The cart is already full. No media was added.");
			} else if (this.itemsOrdered.contains(media)) {
				throw new IllegalItemException("'" + media.getTitle() + "' is already in the cart. No media was added.");
			} else {
				this.itemsOrdered.add(media);
				numberOfAddedMedia += 1;
				System.out.printf("%d media, '%s', has been added to the cart.%n", numberOfAddedMedia, media.getTitle());
			}
		}
        System.out.printf("In total, %d media(s) have been added to the cart.%n", numberOfAddedMedia);
        return numberOfAddedMedia;
    }

    public int removeMedia(Media media) throws IllegalItemException {
        int numberOfRemovedMedia = 0;
        for (Media mediaFromCart : this.itemsOrdered) {
            if (mediaFromCart.getTitle() == media.getTitle()) {
                this.itemsOrdered.remove(mediaFromCart);
                numberOfRemovedMedia += 1;
                System.out.printf("1 media, '%s', has been removed the cart.%n", media.getTitle());
                break;
            }
        }
        if (numberOfRemovedMedia == 0) {
            throw new IllegalItemException("The media '" + media.getTitle() + "' was not found in the cart.%n");
        }
        System.out.printf("In total, %d media(s) have been removed to the cart.%n", numberOfRemovedMedia);
        return numberOfRemovedMedia;
    }

	public Media searchMedia(String title) {
		for (Media media : this.itemsOrdered) {
			if (media.isMatch(title)) {
				return media;
			}
		}
		return null;
	}

	public boolean searchByID(int id) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("********SEARCH RESULT*****************************");
		System.out.println("Product ID: " + id);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getId() == id) {
				System.out.println(Integer.toString(i+1) + ".\t" + this.itemsOrdered.get(i).toString() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total number of product " + id + " found: " + qty);
			System.out.println("Total cost for these product: " + "$" + (cost*qty));
			System.out.println("**************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("No such product was found.");
			System.out.println("**************************************************");
			System.out.println("\n");
			return false;
		}
	}

	public boolean searchByTitle(String title) {
		boolean found = false;
		System.out.println("********SEARCH RESULT*****************************");
		System.out.println("Product Title: " + title);
        for (Media media : this.itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println(media.toString());
                found = true;
            }
        }
		if  (!found) {
			System.out.println("No such product was found.");
			System.out.println("**************************************************");
			System.out.println("\n");
            return false;
		} else {
            System.out.println("**************************************************");
			return true;
		}
	}

    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		System.out.println("********CART**************************************");
		System.out.println("Ordered Items  (Sorted by Title):");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(Integer.toString(i+1) + ".\t" + this.itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + "$" + this.totalCost());
		System.out.println("**************************************************");
		System.out.println("\n");
    }

    public void sortByCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		System.out.println("********CART**************************************");
		System.out.println("Ordered Items  (Sorted by Cost):");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(Integer.toString(i+1) + ".\t" + this.itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + "$" + this.totalCost());
		System.out.println("**************************************************");
		System.out.println("\n");
    }

    public boolean filterCart(int id) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("********SEARCH RESULT*****************************");
		System.out.println("Product ID: " + id);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getId() == id) {
				System.out.println(Integer.toString(i+1) + ".\t" + this.itemsOrdered.get(i).toString() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total number of product " + id + " found: " + qty);
			System.out.println("Total cost for these product: " + "$" + (cost*qty));
			System.out.println("**************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("No such product was found.");
			System.out.println("**************************************************");
			System.out.println("\n");
			return false;
		}
	}
	
	public boolean filterCart(String title) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("********SEARCH RESULT*****************************");
		System.out.println("Product title: " + title);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).isMatch(title)) {
				System.out.println(Integer.toString(i+1) + ".\t" + this.itemsOrdered.get(i).toString() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total number of product " + title + " found: " + qty);
			System.out.println("Total cost for these product: " + "$" + (cost*qty));
			System.out.println("**************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("No such product was found.");
			System.out.println("**************************************************");
			System.out.println("\n");
			return false;
		}
	}

    public float totalCost() {
		float cost = 0.0f;
		for (Media media: itemsOrdered) {
			cost += media.getCost();
		}
		return cost;
	}

    public int getSize() {
        return this.itemsOrdered.size();
    }

	public Media getALuckyItem() { 
		int indexOfFreeItem = 0;
		if (this.itemsOrdered.size() >= 5) {
			indexOfFreeItem = ThreadLocalRandom.current().nextInt(this.itemsOrdered.size());
			return this.itemsOrdered.get(indexOfFreeItem);
		} else {
			return null;
		}
	}

    public void print() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		System.out.println("********CART**************************************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(Integer.toString(i+1) + ".\t" + this.itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + "$" + this.totalCost());
		System.out.println("**************************************************");
		System.out.println("\n");
    }

	public ObservableList<Media> getItemsOrdered() {
		return this.itemsOrdered;
	}

	public void empty() {
		this.itemsOrdered.clear();
	}

}
