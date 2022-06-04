package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        //Create a new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Trek");
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Harry Potter", "Fantasy", 30.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Harry Potter", "Fantasy", 32.99f);
        DigitalVideoDisc[] dvdList = {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6};

        cart.addDVD(dvdList);

        //Test the searchByID method
        cart.searchByID(1);

        //Test the sortByCost method
        cart.sortByCost();
        
        //Test the sortByTitle method
        cart.sortByTitle();

        //Test the print method
        cart.print();
    }
}