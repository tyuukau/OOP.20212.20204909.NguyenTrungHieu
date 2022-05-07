import java.util.ArrayList;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();

    private int qtyOrdered = 0;

    public int addDigitalVideoDisc(DigitalVideoDisc disc) {
        int numberOfAddedDiscs = 0;
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full. No disc was added.%n");
        // If the item is not allowed to be duplicated
        } else if (this.itemsOrdered.contains(disc)) {
            System.out.printf("'%s' is already in the cart. No disc was added.%n", disc.getTitle());
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
        for (DigitalVideoDisc dvd : dvdList) {
            if (this.qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered.add(dvd);
                numberOfAddedDiscs += 1;
                this.qtyOrdered += 1;
                System.out.printf("1 disc, '%s', has been added to the cart.%n", dvd.getTitle());
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
            if (disc.getTitle() == discFromCart.getTitle()) {
                this.itemsOrdered.remove(disc);
                numberOfRemovedDiscs = 1;
                this.qtyOrdered -= numberOfRemovedDiscs;
                System.out.printf("%d disc, '%s', has been removed the cart.%n", numberOfRemovedDiscs, disc.getTitle());
                break;
            }
        }
        if (numberOfRemovedDiscs == 0) {
            System.out.printf("The disc '%s' was not found in the cart.%n", disc.getTitle());
        }
        return numberOfRemovedDiscs;
    }
    
    public float totalCost() {
		float cost = 0.0f;
		for (DigitalVideoDisc disc: itemsOrdered) {
			cost += disc.getCost();
		}
		return cost;
	}
}
