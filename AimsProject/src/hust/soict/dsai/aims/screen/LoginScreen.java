package hust.soict.dsai.aims.screen;

import java.awt.*;
import javax.swing.*;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class LoginScreen extends JFrame {
    
    private Store store;

    public static void main(String[] args) {
		// Test
		Store myStore = new Store();

		// Create DVDs
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars 2", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars 3", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);

        Track track1 = new Track("Bruh1", 13);
		Track track2 = new Track("Bruh2", 21);
		Track track3 = new Track("Bruh3");
		CompactDisc cd1 = new CompactDisc("Allstars", "Yes", "Smash Mouth", "Dunno", 69.420f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		CompactDisc cd2 = new CompactDisc("Allstars 2", "Yes", "Smash Mouth", "Dunno", 69.420f);
		cd2.addTrack(track1);
		cd2.addTrack(track3);
		cd2.addTrack(track2);

        Book book = new Book("Harry Potter", "Fantasy", 30.00f);
        book.addAuthor("Rowling");
        book.setProcessContent("There were Mr. and Mrs. Dursley of number four, Privet Drive. They were proud to say that they were perfectly normal, thank you very much.");

        // Try adding DVDs
		myStore.addMedia(dvd2);
		myStore.addMedia(dvd1);
		myStore.addMedia(dvd3);
		myStore.addMedia(cd1);
		myStore.addMedia(cd2);
		myStore.addMedia(book);
		myStore.addMedia(dvd4);
		myStore.addMedia(dvd5);
		myStore.addMedia(dvd6);

        new LoginScreen(myStore);
    }

    public LoginScreen(Store store) { 
        this.store = store; 
        Container cp = getContentPane(); 
        
        JRadioButton customerBtn = new JRadioButton("Customer"); 
        JRadioButton managerBtn = new JRadioButton("Store Manager"); 
        customerBtn.setBounds(140,40,120,30); 
        managerBtn.setBounds(140,90,200,30); 
        
        ButtonGroup bg = new ButtonGroup(); 
        bg.add(customerBtn); 
        bg.add(managerBtn); 
        customerBtn.setSelected(true); 
        
        JButton loginBtn = new JButton( "Login"); 
        loginBtn.setBounds (140,140,120,30); 
        loginBtn.addActionListener(e -> { 
            if (managerBtn.isSelected()) { 
                new StoreManagerScreen(store);
                dispose(); 
            }
        });
        
        cp.add(customerBtn); 
        cp.add(managerBtn); 
        cp.add(loginBtn); 
        
        setTitle("Login"); 
        setSize(400, 250); 
        
        setLayout(null); 
        setLocationRelativeTo(null); 
        setVisible(true);
    }

}
