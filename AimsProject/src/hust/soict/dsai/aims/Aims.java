package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
// import hust.soict.dsai.aims.memory.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Aims {
    
    private static Scanner scanner = new Scanner(System.in);
	private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) throws Exception {

        // Start the MemoryDaemon
        // Thread dt = new Thread(new MemoryDaemon(), "My Daemon Thread");
        // dt.setDaemon(true);
        // dt.start();

		// Add media to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);

		Track track1 = new Track("Bruh1", 13);
		Track track2 = new Track("Bruh2", 21);
		Track track3 = new Track("Bruh3", 0);
		Track track4 = new Track("Bruh5", -100);

		CompactDisc cd1 = new CompactDisc("Allstars", "Yes", "Smash Mouth", "Dunno", 69.420f);
		ArrayList<Track> trackToAdd = new ArrayList<Track>();
		Collections.addAll(trackToAdd, track1, track2);
        for (Track track : trackToAdd) {
            try {
                cd1.addTrack(track);
            } catch (IllegalItemException ex) {
                System.err.println(ex.getMessage());
            }
        }

		CompactDisc cd2 = new CompactDisc("Nostars", "No", "Bruh Mouth", "Dunno", 80.420f);
        trackToAdd = new ArrayList<Track>();
		Collections.addAll(trackToAdd, track1, track2, track3);
        for (Track track : trackToAdd) {
            try {
                cd2.addTrack(track);
            } catch (IllegalItemException ex) {
                System.err.println(ex.getMessage());
            }
        }

		CompactDisc cd3 = new CompactDisc("Whatsapp", "Uh uh", "No Mouth", "Szeczyszka", 1.420f);
        trackToAdd = new ArrayList<Track>();
		Collections.addAll(trackToAdd, track1, track4);
        for (Track track : trackToAdd) {
            try {
                cd3.addTrack(track);
            } catch (IllegalItemException ex) {
                System.err.println(ex.getMessage());
            }
        }

        Book book = new Book("Harry Potter", "Fantasy", 30.00f);
		try {
			book.addAuthor("Rowling");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
        try {
			book.addAuthor("Rowling");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		book.setProcessContent("There were Mr. and Mrs. Dursley of number four, Privet Drive. They were proud to say that they were perfectly normal, thank you very much.");

        // Try adding Media
		ArrayList<Media> mediaToAdd = new ArrayList<Media>();
		Collections.addAll(mediaToAdd, dvd1, dvd2, dvd3, dvd4, dvd5, cd1, cd2, cd3, book, dvd3, dvd4, dvd5, dvd2);
		for (Media media : mediaToAdd) {
			try {
				store.addMedia(media);
			} catch (IllegalItemException ex) {
				System.err.println(ex.getMessage());
			}
		}
    
        // Start program
        showMenu();
    }

    public static void showMenu() throws Exception {
		System.out.println("AIMS:\n"
                         + "--------------------------------\n"
                         + "1. View store\n" // storeMenu()
                         + "2. Update store\n" // updateStoreMenu()
                         + "3. See current cart\n" // cartMenu()
                         + "0. Exit\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1-2-3");
				
		int choice = getChoice(3);

        switch (choice) {
            case 1:
                store.print();
                storeMenu();
                break;
            case 2:
                updateStoreMenu();
                break;
            case 3:
                cartMenu();
                break;
            case 0:
                System.out.println("Thank you for using our service. We hope to see you again.");
			    System.exit(0);
                break;
            default:
                break;
        }
	}

    public static void storeMenu() throws Exception {
		System.out.println("Options: \n"
		                 + "--------------------------------\n"              
                         + "1. See a Media's details\n" // seeDetailsMenu()                  
                         + "2. Add a Media to cart\n" // addToCart()                
                         + "3. See current cart\n" // cartMenu()
                         + "4. Play a Media\n" // playMedia() 
                         + "0. Back\n"+ "--------------------------------\n"
                         + "Please choose a number: 0-1-2-3-4");
		
		int choice = getChoice(4);

        switch (choice) {
            case 1:
                System.out.println("Please enter the title of the media you want to see details of: ");
                String title = scanner.nextLine();
                Media media = store.searchMedia(title);
                // Invalid name
                while (media == null) {
                    System.out.println("Please enter a valid product name.");
                    title = scanner.nextLine();
                    media = store.searchMedia(title);
                }
                seeDetailsMenu(media);
                break;
            case 2:
                addToCart();
                break;
            case 3:
                cartMenu();
                break;
            case 4:
                playMedia(store);
                storeMenu();
            case 0:
                showMenu();
                break;
        }
    }

    public static void updateStoreMenu() throws Exception {
        System.out.println("Options: \n"
		                 + "--------------------------------\n"
		                 + "1. Add media to the store\n" // addToStoreMenu()
		                 + "2. Remove media from the store\n" // removeFromStore()
		                 + "0. Exit\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1-2\n");
		
        int choice = getChoice(2);

        switch (choice) {
            case 1:
                addToStoreMenu();
                break;
            case 2:
                removeFromStore();
                break;
            case 0:
                showMenu();
                break;
            default:
                break;
        }
    }

    public static void cartMenu() throws Exception {
        cart.print();

		System.out.println("Options:\n"
                         + "--------------------------------\n"
                         + "1. Filter Media in cart\n" // filterCartMenu()
                         + "2. Sort Media in cart\n" // sortCartMenu()
                         + "3. Remove Media from cart\n" // removeFromCart()
                         + "4. Play a Media\n" // playMedia()
                         + "5. Place order\n" // placeOrder()
                         + "0. Back\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1-2-3-4-5");
		
        int choice = getChoice(5);

        switch (choice) {
            case 1:
                filterCartMenu();
                break;
            case 2:
                sortCartMenu();
                break;
            case 3:
                removeFromCart();
                break;
            case 4:
                playMedia(cart);
                break;
            case 5:
                placeOrder();
                break;            
            case 0:
                showMenu();
                break;
        }
    }

    public static void seeDetailsMenu(Media media) throws Exception {
        if (media instanceof Playable) {
            System.out.println("\t" + media.toString());
            System.out.println("\tDate added: " + media.getDateAdded());
            System.out.println("Options: \n"
                             + "--------------------------------\n"
                             + "1. Add this product to cart\n"
                             + "2. Play this Media\n"
                             + "0. Exit\n"
                             + "--------------------------------\n"
                             + "Please choose a number: 0-1");
    
            int choice = getChoice(2);
    
            if (choice == 1) {
                cart.addMedia(media);
                System.out.println("Enter any key to continue");
                scanner.nextLine();
                storeMenu();
            } else if (choice == 2) {
                try {
                    ((Playable)media).play();
                } catch (PlayerException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
                }    
                System.out.println("Enter any key to return");
                scanner.nextLine();
                seeDetailsMenu(media);
            } else if (choice == 0) {
                storeMenu();
            }  
        } else {
            System.out.println("\t" + media.toString());
            System.out.println("\tDate added: " + media.getDateAdded());
            System.out.println("Options: \n"
                             + "--------------------------------\n"
                             + "1. Add this product to cart\n"
                             + "0. Exit\n"
                             + "--------------------------------\n"
                             + "Please choose a number: 0-1");
    
            int choice = getChoice(1);
    
            if (choice == 1) {
                cart.addMedia(media);
                System.out.println("Enter any key to continue");
                scanner.nextLine();
                storeMenu();
            } else if (choice == 0) {
                storeMenu();
            }  
        }
    }

    public static void addToCart() throws Exception {
        System.out.println("Please enter the title of the media you want to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.searchMedia(title);
        // Invalid name
        while (media == null) {
            System.out.println("Please enter a valid product name.");
            title = scanner.nextLine();
            media = store.searchMedia(title);
        }
        cart.addMedia(media);
        System.out.println("Total number of media in cart: " + cart.getSize());
        System.out.println("Enter any key to continue");
        scanner.nextLine();
        storeMenu();
    }

    public static void addToStoreMenu() throws Exception {
        System.out.println("Options:\n"
                         + "--------------------------------\n"
                         + "1. Add a new CD\n" // addMedia()
                         + "2. Add a new DVD\n" // addMedia()
                         + "3. Add a new Book\n" // addMedia()
                         + "0. Back\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1-2-3");

        int choice = getChoice(3);

        switch (choice) {
            case 1:
                System.out.println("Please enter the information of the new CD");
                System.out.println("Title: ");
                String title = scanner.nextLine();
                System.out.println("Category: ");
                String category = scanner.nextLine();
                System.out.println("Artist: ");
                String artist = scanner.nextLine();
                System.out.println("Director: ");
                String director = scanner.nextLine();
                System.out.println("Price: ");
                float price = Float.parseFloat(scanner.nextLine());
                store.addMedia(new CompactDisc(title, category, artist, director, price));
                System.out.println("CD added. Enter any key to continue");
                scanner.nextLine();
                updateStoreMenu();
                break;
            case 2:
                System.out.println("Please enter the information of the new DVD");
                System.out.println("Title: ");
                title = scanner.nextLine();
                System.out.println("Category: ");
                category = scanner.nextLine();
                System.out.println("Director: ");
                director = scanner.nextLine();
                System.out.println("Length: ");
                int length = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Price: ");
                price = Float.parseFloat(scanner.nextLine());
                store.addMedia(new DigitalVideoDisc(title, category, director, length, price));
                System.out.println("DVD added. Enter any key to continue");
                scanner.nextLine();
                updateStoreMenu();
                break;
            case 3:
                System.out.println("Please enter the information of the new book");
                System.out.println("Title: ");
                title = scanner.nextLine();
                System.out.println("Category: ");
                category = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Price: ");
                price = Float.parseFloat(scanner.nextLine());
                store.addMedia(new Book(title, category, price));
                System.out.println("Book added. Enter any key to continue");
                scanner.nextLine();
                updateStoreMenu();
                break;
            case 0:
                updateStoreMenu();
                break;
            default:
                break;
        }
    }

    public static void removeFromStore() throws Exception {
		store.print();
		System.out.println("Please enter the title of the media you want to remove: ");
		String title = scanner.nextLine();
		Media media = store.searchMedia(title);
        // Invalid name
        while (media == null) {
			System.out.println("Please enter a valid product name.");
			title = scanner.nextLine();
			media = store.searchMedia(title);
		}
		store.removeMedia(media);
		System.out.println("Enter any key to continue");
		scanner.nextLine();
		updateStoreMenu();
    }

    public static void filterCartMenu() throws Exception {
        System.out.println("Options: \n"
                         + "--------------------------------\n"
		                 + "1. Filter by ID\n"
                         + "2. Filter by title\n"
                         + "0. Back\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1-2");
		
        int choice = getChoice(2);

		
		switch (choice) {
            case 1:
                System.out.println("Please enter ID number");
                int id = scanner.nextInt();
                scanner.nextLine();
                cart.filterCart(id);
                System.out.println("Enter any key to continue");
                scanner.nextLine();
                cartMenu();
                break;
            case 2:
                System.out.println("Please enter keyword");
                String keyword = scanner.nextLine();
                cart.filterCart(keyword);
                System.out.println("Enter any key to continue");
                scanner.nextLine();
                cartMenu();
                break;
            case 0:
                cartMenu();
                break;
            default:
                break;
        }
    }

    public static void sortCartMenu() throws Exception {
		System.out.println("Options: \n" 
                         + "--------------------------------\n"
                         + "1. Sort by title\n"
                         + "2. Sort by cost\n"
                         + "0. Back\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1-2\n");
		
        int choice = getChoice(2);

        switch (choice) {
            case 1:
                cart.sortByTitle();
                System.out.println("Enter any key to continue");
                scanner.nextLine();
                cartMenu();
                break;
            case 2:
                cart.sortByCost();
                System.out.println("Enter any key to continue");
                scanner.nextLine();
                cartMenu();
                break;
            case 0:
                cartMenu();
                break;
            default:
                break;
        }
    }

    public static void removeFromCart() throws Exception {
        System.out.println("Please enter the title of the media you want to remove: ");
        String title = scanner.nextLine();
        Media media = store.searchMedia(title);
        // Invalid name
        while (media == null) {
            System.out.println("Please enter a valid product name.");
            title = scanner.nextLine();
            media = cart.searchMedia(title);
        }
        cart.removeMedia(media);
        System.out.println("Media removed. Enter any key to continue");
        scanner.nextLine();
        cartMenu();
    }

    public static void placeOrder() throws Exception {
        if (cart.getSize() == 0) {
            System.out.println("You cannot place an empty order\n");
            cartMenu();
        } else {
            cart.print();
            Media luckyItem = cart.getALuckyItem();
            if (luckyItem != null) {
                System.out.println("\t" + "(!) A lucky item:\n\n" + 
                                   "\t" + luckyItem.toString() + "\n\n" +
                                   "\t" + "New total cost: $" + (cart.totalCost() - luckyItem.getCost()) + "\n\n" +
                                   "\t" + "Your order has been created.");
            }
            cart = new Cart();
            showMenu();
        }
    }

    public static void playMedia(Object o) throws Exception {
        System.out.println("Please enter the title of the media you want to play: ");
		String title = scanner.nextLine();

        Media media = null;

        if (o instanceof Cart) {
            Cart o_cart = (Cart) o;
            media = o_cart.searchMedia(title);
            // Invalid name
            while (media == null) {
                System.out.println("Please enter a valid product name.");
                title = scanner.nextLine();
                media = o_cart.searchMedia(title);
            }
        } else if (o instanceof Store) {
            Store o_store = (Store) o;
            media = o_store.searchMedia(title);
            // Invalid name
            while (media == null) {
                System.out.println("Please enter a valid product name.");
                title = scanner.nextLine();
                media = o_store.searchMedia(title);
            }
        }

        if (media instanceof Playable) {
            System.out.println("\t" + media.toString());
            System.out.println("\tDate added: " + media.getDateAdded());
            try {
                ((Playable)media).play();
            } catch (PlayerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Media is found but it is not of a playable type.");
        }

        System.out.println("Enter any key to continue");
		scanner.nextLine();
    }

    private static int getChoice(int max) throws Exception {
        Integer input = scanner.nextInt();
		scanner.nextLine();
        ArrayList<Integer> choices = new ArrayList<Integer>();
        for (int i = 0; i < (max + 1); i++) {
            choices.add(Integer.valueOf(i));
        }
		while (!choices.contains(input)) {
			System.out.println("Please choose a valid number.");
			input = scanner.nextInt();
			scanner.nextLine();
		}
        return input;
    }

}