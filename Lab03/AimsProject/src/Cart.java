import java.util.ArrayList;
import java.util.Collections;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();

    private int qtyOrdered = 0;

    public int addDigitalVideoDisc(DigitalVideoDisc disc) {
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

    public int addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
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

    public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
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

    public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
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
    
    public float totalCost() {
		float cost = 0.0f;
		for (DigitalVideoDisc disc: itemsOrdered) {
			cost += disc.getCost();
		}
		return cost;
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

    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, DVDUtils.DVDTitleComparator);
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
        Collections.sort(this.itemsOrdered, DVDUtils.DVDCostComparator);
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items  (Sorted by Cost):");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(Integer.toString(i+1) + "." + "\t" + this.itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + "$" + this.totalCost());
		System.out.println("***************************************************");
		System.out.println("\n");
    }

    public void print() {
        Collections.sort(this.itemsOrdered, DVDUtils.DVDTitleCostLengthComparator);
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
