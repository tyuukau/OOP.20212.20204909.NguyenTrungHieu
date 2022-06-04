package hust.soict.dsai.aims.cart;

import java.util.Comparator;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();

    private int qtyOrdered = 0;

    public int addDVD(DigitalVideoDisc disc) {
        int numberOfAddedDiscs = 0;
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full. No disc was added.%n");
        // If the item is not allowed to be duplicated
        // } else if (this.itemsOrdered.contains(disc)) {
        //     System.out.printf("'%s' is already in the cart. No disc was added.%n", disc.getTitle());
        } else {
            this.itemsOrdered.add(disc);
            numberOfAddedDiscs = 1;
            this.qtyOrdered += numberOfAddedDiscs;
            System.out.printf("%d disc, '%s', has been added to the cart.%n", numberOfAddedDiscs, disc.getTitle());
        }
        return numberOfAddedDiscs;
    }

    public int addDVD(DigitalVideoDisc [] dvdList) {
        int numberOfAddedDiscs = 0;
        for (DigitalVideoDisc disc: dvdList) {
            if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered.add(disc);
                numberOfAddedDiscs += 1;
                this.qtyOrdered += 1;
                System.out.printf("1 disc, '%s', has been added to the cart.%n", disc.getTitle());
            } else {
                System.out.println("The cart is already full. No disc was added.");
                break;
            }
        }
        System.out.printf("In total, %d disc(s) have been added to the cart.%n", numberOfAddedDiscs);
        return numberOfAddedDiscs;
    }

    //arbitrary number of objects
    // public int addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
    //     int numberOfAddedDiscs = 0;
    //     for (DigitalVideoDisc disc: dvdList) {
    //         if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
    //             this.itemsOrdered.add(disc);
    //             numberOfAddedDiscs += 1;
    //             this.qtyOrdered += 1;
    //             System.out.printf("1 disc, '%s', has been added to the cart.%n", disc.getTitle());
    //         } else {
    //             System.out.println("The cart is already full. No disc was added.");
    //             break;
    //         }
    //     }
    //     System.out.printf("In total, %d disc(s) have been added to the cart.%n", numberOfAddedDiscs);
    //     return numberOfAddedDiscs;
    // }

    public int addDVD(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        int numberOfAddedDiscs = 0;
        DigitalVideoDisc[] dvdList = {dvd1, dvd2};
        for (DigitalVideoDisc disc: dvdList) {
            if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered.add(disc);
                numberOfAddedDiscs += 1;
                this.qtyOrdered += 1;
                System.out.printf("1 disc, '%s', has been added to the cart.%n", disc.getTitle());
            } else {
                System.out.println("The cart is already full. No disc was added.");
                break;
            }
        }
        System.out.printf("In total, %d disc(s) have been added to the cart.%n", numberOfAddedDiscs);
        return numberOfAddedDiscs;
    }

    public int removeDVD(DigitalVideoDisc disc) {
        int numberOfRemovedDiscs = 0;
        for (DigitalVideoDisc discFromCart : this.itemsOrdered) {
            if (discFromCart.getTitle() == disc.getTitle()) {
                this.itemsOrdered.remove(discFromCart);
                numberOfRemovedDiscs += 1;
                this.qtyOrdered -= numberOfRemovedDiscs;
                System.out.printf("1 disc, '%s', has been removed the cart.%n", disc.getTitle());
                break;
            }
        }
        if (numberOfRemovedDiscs == 0) {
            System.out.printf("The disc '%s' was not found in the cart.%n", disc.getTitle());
        }
        System.out.printf("In total, %d disc(s) have been removed to the cart.%n", numberOfRemovedDiscs);
        return numberOfRemovedDiscs;
    }

	public DigitalVideoDisc searchDVD(String title) {
		for (DigitalVideoDisc medium : this.itemsOrdered) {
			if (medium.isMatch(title)) {
				return medium;
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
        for (DigitalVideoDisc disc : this.itemsOrdered) {
            if (disc.isMatch(title)) {
                System.out.println(disc.toString());
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
        Collections.sort(this.itemsOrdered, DigitalVideoDisc.COMPARE_BY_TITLE);
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
        Collections.sort(this.itemsOrdered, DigitalVideoDisc.COMPARE_BY_COST);
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
		for (DigitalVideoDisc disc: itemsOrdered) {
			cost += disc.getCost();
		}
		return cost;
	}

    public int getSize() {
        return this.itemsOrdered.size();
    }

    public void print() {
	    final Comparator<DigitalVideoDisc> COMPARE_BY_TITLE_COST_LENGTH = new Comparator<DigitalVideoDisc>() {
			public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
				int titleCondition = disc1.getTitle().compareToIgnoreCase(disc2.getTitle());
				int costCondition = Float.compare(disc1.getCost(), disc2.getCost());
				int lengthCondition = Integer.compare(disc1.getLength(), disc2.getLength());
				if (titleCondition != 0) {
					return titleCondition;
				} else {
					if (costCondition != 0) {
						return costCondition;
					} else {
						return lengthCondition;
					}
				}
			}
		};

        Collections.sort(this.itemsOrdered, COMPARE_BY_TITLE_COST_LENGTH);
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
