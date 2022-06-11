package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.*;

public class TestMediaCompareTo {

    public static void main(String[] args) {

        //Media objects
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("C", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("B", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("B", "Animation", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("D", "Animation", 18.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("A", "Animation", 21.99f);


        //New collection
        Collection<Media> collection = new ArrayList<Media>();

        // Add the DVD objects to the ArrayList 
        collection.add(dvd1); 
        collection.add(dvd2);
        collection.add(dvd3);
        collection.add(dvd4); 
        collection.add(dvd5); 
        
        // Iterate through the ArrayList and output their titles (unsorted order) 

        System.out.println ("-------------------------------------");
        System.out.println ("The DVDs currently in the order are: ");

        for (Media media : collection) {
            System.out.println(media.getTitle() + " " + media.getCategory());
        }
        
        // Sort the collection of DVDs - based on the compareTo() method 
        Collections.sort((List<Media>)collection); 
        
        // Iterate through the ArrayList and output their titles in sorted order 

        System.out.println ("-------------------------------------");
        System.out.println ("The DVDs in the sorted order are: ");

        for (Media media : collection) {
            System.out.println(media.getTitle() + " " + media.getCategory());
        }

        System.out.println ("-------------------------------------");

    }
}
