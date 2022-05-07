import java.util.ArrayList;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();

    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is already full.");
        } else if (this.itemsOrdered.contains(disc)) {
            System.out.printf("'%s' is already in the cart.", disc.getTitle);
        } else {
            this.itemsOrdered.add(disc);
            this.qtyOrdered += 1;
            System.out.printf("One (1) disc, '%s' has been added to the cart.", disc.getTitle);
        }
    }

}
