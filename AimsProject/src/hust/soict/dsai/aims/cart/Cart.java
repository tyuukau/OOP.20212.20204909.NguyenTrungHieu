package hust.soict.dsai.aims.cart;

import java.util.Comparator;

import hust.soict.dsai.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    private int qtyOrdered = 0;

    public int addMedia(Media media) {
        int numberOfAddedMedia = 0;
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full. No media was added.%n");
        // If the item is not allowed to be duplicated
        // } else if (this.itemsOrdered.contains(media)) {
        //     System.out.printf("'%s' is already in the cart. No media was added.%n", media.getTitle());
        } else {
            this.itemsOrdered.add(media);
            numberOfAddedMedia = 1;
            this.qtyOrdered += numberOfAddedMedia;
            System.out.printf("%d media, '%s', has been added to the cart.%n", numberOfAddedMedia, media.getTitle());
        }
        return numberOfAddedMedia;
    }

    public int addMedia(Media ... mediaList) {
        int numberOfAddedMedia = 0;
        for (Media media: mediaList) {
            if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered.add(media);
                numberOfAddedMedia += 1;
                this.qtyOrdered += 1;
                System.out.printf("1 media, '%s', has been added to the cart.%n", media.getTitle());
            } else {
                System.out.println("The cart is already full. No media was added.");
                break;
            }
        }
        System.out.printf("In total, %d media(s) have been added to the cart.%n", numberOfAddedMedia);
        return numberOfAddedMedia;
    }

    public int addMedia(Media media1, Media media2) {
        int numberOfAddedMedia = 0;
        Media[] mediaList = {media1, media2};
        for (Media media: mediaList) {
            if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered.add(media);
                numberOfAddedMedia += 1;
                this.qtyOrdered += 1;
                System.out.printf("1 media, '%s', has been added to the cart.%n", media.getTitle());
            } else {
                System.out.println("The cart is already full. No media was added.");
                break;
            }
        }
        System.out.printf("In total, %d media(s) have been added to the cart.%n", numberOfAddedMedia);
        return numberOfAddedMedia;
    }

    public int removeMedia(Media media) {
        int numberOfRemovedMedia = 0;
        for (Media mediaFromCart : this.itemsOrdered) {
            if (mediaFromCart.getTitle() == media.getTitle()) {
                this.itemsOrdered.remove(mediaFromCart);
                numberOfRemovedMedia += 1;
                this.qtyOrdered -= numberOfRemovedMedia;
                System.out.printf("1 media, '%s', has been removed the cart.%n", media.getTitle());
                break;
            }
        }
        if (numberOfRemovedMedia == 0) {
            System.out.printf("The media '%s' was not found in the cart.%n", media.getTitle());
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
		System.out.println("\n******************SEARCH RESULT********************");
		System.out.println("Product ID: " + id);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getID() == id) {
				System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).toString() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total number of product " + id + " found: " + qty);
			System.out.println("Total cost for these product: " + "$" + (cost*qty));
			System.out.println("***************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("No such product was found.");
			System.out.println("***************************************************");
			System.out.println("\n");
			return false;
		}
	}

	public boolean searchByTitle(String title) {
		boolean found = false;
		System.out.println("\n******************SEARCH RESULT********************");
		System.out.println("Product Title: " + title);
        for (Media media : this.itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println(media.toString());
                found = true;
            }
        }
		if  (!found) {
			System.out.println("No such product was found.");
			System.out.println("***************************************************");
			System.out.println("\n");
            return false;
		} else {
            System.out.println("***************************************************");
			return true;
		}
	}

    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE);
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items  (Sorted by Title):");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + "$" + this.totalCost());
		System.out.println("***************************************************");
		System.out.println("\n");
    }

    public void sortByCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST);
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items  (Sorted by Cost):");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + "$" + this.totalCost());
		System.out.println("***************************************************");
		System.out.println("\n");
    }

    public boolean filterCart(int id) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("\n******************SEARCH RESULT********************");
		System.out.println("Product ID: " + id);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getID() == id) {
				System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).toString() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total number of product " + id + " found: " + qty);
			System.out.println("Total cost for these product: " + "$" + (cost*qty));
			System.out.println("***************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("No such product was found.");
			System.out.println("***************************************************");
			System.out.println("\n");
			return false;
		}
	}
	
	public boolean filterCart(String title) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("\n******************SEARCH RESULT********************");
		System.out.println("Product title: " + title);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).isMatch(title)) {
				System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).toString() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Total number of product " + title + " found: " + qty);
			System.out.println("Total cost for these product: " + "$" + (cost*qty));
			System.out.println("***************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("No such product was found.");
			System.out.println("***************************************************");
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

    public void print() {

	    // final Comparator<Media> COMPARE_BY_TITLE_COST_LENGTH = new Comparator<Media>() {
		// 	public int compare(Media media1, Media media2) {
		// 		int titleCondition = media1.getTitle().compareToIgnoreCase(media2.getTitle());
		// 		int costCondition = Float.compare(media1.getCost(), media2.getCost());
		// 		int lengthCondition = Integer.compare(media1.getLength(), media2.getLength());
		// 		if (titleCondition != 0) {
		// 			return titleCondition;
		// 		} else {
		// 			if (costCondition != 0) {
		// 				return costCondition;
		// 			} else {
		// 				return lengthCondition;
		// 			}
		// 		}
		// 	}
		// };

		final Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
			public int compare(Media media1, Media media2) {
				int titleCondition = media1.getTitle().compareToIgnoreCase(media2.getTitle());
				int costCondition = Float.compare(media1.getCost(), media2.getCost());
				if (titleCondition != 0) {
					return titleCondition;
				} else {
					return costCondition;
				}
			}
		};

        Collections.sort(this.itemsOrdered, COMPARE_BY_TITLE_COST);
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + "$" + this.totalCost());
		System.out.println("***************************************************");
		System.out.println("\n");
    }

}
