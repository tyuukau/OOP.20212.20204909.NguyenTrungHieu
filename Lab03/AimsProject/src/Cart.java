import java.util.ArrayList;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();

    private int qtyOrdered = 0;

    public int addDigitalVideoDisc(DigitalVideoDisc disc) {
        int numberOfAddedDiscs = 1;
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full.");
        // If the item is not allowed to be duplicated
        // } else if (this.itemsOrdered.contains(disc)) {
        //     System.out.printf("'%s' is already in the cart.", disc.getTitle());
        } else {
            this.itemsOrdered.add(disc);
            this.qtyOrdered += numberOfAddedDiscs;
            System.out.printf("One (1) disc, '%s', has been added to the cart.", disc.getTitle());
        }
        return numberOfAddedDiscs;
    }

    
}
