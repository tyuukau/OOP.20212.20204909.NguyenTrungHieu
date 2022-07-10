package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.*;

public class TestMediaEquals {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("C", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("B", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("B", "Animation", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd4 = null;
        String dvd5 = "21";
        Book dvd6 = new Book("B", "Science Fiction", 24.95f);
        String dvd7 = null;
        
        System.out.println(dvd2.equals(dvd1)); 
        System.out.println(dvd2.equals(dvd2));
        System.out.println(dvd2.equals(dvd3));
        System.out.println(dvd2.equals(dvd4));
        System.out.println(dvd2.equals(dvd5));
        System.out.println(dvd2.equals(dvd6));
        System.out.println(dvd2.equals(dvd7));

    }
}
