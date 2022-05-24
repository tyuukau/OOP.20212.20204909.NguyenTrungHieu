package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;


public class Aims {
    
    private static Scanner scan = new Scanner(System.in);
	private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {

        //Create a new cart
        Cart anOrder = new Cart();

        //Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        //Print total cost of the items in the cart
        System.out.println("Total Cost is: " + anOrder.totalCost());
        
        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.println("Total Cost is: " + anOrder.totalCost());

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc[] dvdList = {dvd4, dvd5};
        anOrder.addDigitalVideoDisc(dvdList);

        //Start program
        showMenu();
    }

    public static void showMenu() {

		System.out.println("AIMS:\n"
                         + "--------------------------------\n"
                         + "1. View store\n" //storeMenu()
                         + "2. Update store\n" //updateStoreMenu()
                         + "3. See current cart\n" //cartMenu()
                         + "0. Exit\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1-2-3");
				
		int choice = scan.nextInt();
		scan.nextLine();
		while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}

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

    public static void storeMenu() {
		System.out.println("Options: \n"
		                 + "--------------------------------\n"              
                         + "1. See a DVD's details\n" //seeDetails()                  
                         + "2. Add a DVD to cart\n" //addToCart()                
                         + "3. See current cart\n" //cartMenu() 
                         + "0. Back\n"+ "--------------------------------\n"
                         + "Please choose a number: 0-1-2-3");
		
		int choice = scan.nextInt();
		scan.nextLine();
		while (choice != 0 && choice != 1 && choice != 2 && choice != 3) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}

        switch (choice) {
            case 1:
                System.out.println("Please enter the title of the media you want to see details of: ");
                String title = scan.nextLine();
                DigitalVideoDisc disc = store.searchDVD(title);

                while (disc == null) {
                    System.out.println("Please enter a valid product name.");
                    title = scan.nextLine();
                    disc = store.searchDVD(title);
                }

                seeDetailsMenu(disc);
                break;
            case 2:
                addToCart();
                break;
            case 3:
                cart.print();
                cartMenu();
                break;
            case 0:
                showMenu();
                break;
        }
    }

    public static void updateStoreMenu() {
        System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add media to the store"); //addToStoreMenu()
		System.out.println("2. Remove media from the store"); //removeFromStoreMenu()
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int choice = scan.nextInt();
		scan.nextLine();
		while (choice != 0 && choice != 1 && choice != 2) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}

        switch (choice) {
            case 1:
                addToStoreMenu();
                break;
            case 2:
                removeFromStoreMenu();
                break;
            case 0:
                showMenu();
                break;
            default:
                break;
        }
    }

    public static void cartMenu() {
		System.out.println("Options:\n"
                         + "--------------------------------\n"
                         + "1. Filter DVDs in cart\n" //filterCartMenu()
                         + "2. Sort DVDs in cart\n" //sortCartMenu()
                         + "3. Remove DVDs from cart\n" //removeFromCart()
                         + "4. Place order\n" //placeOrder()
                         + "0. Back\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1-2-3-4");
		
		int choice = scan.nextInt();
		scan.nextLine();
		while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}

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
                placeOrder();
                break;            
            case 0:
                showMenu();;
                break;
        }

    }

    public static void seeDetailsMenu(DigitalVideoDisc disc) {
        System.out.println("\t" + disc.toString());
        System.out.println("\tDate added: " + disc.getDateAdded());
        System.out.println("Options: \n"
                         + "--------------------------------\n"
                         + "1. Add this product to cart\n"
                         + "0. Exit\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1");

        int choice = scan.nextInt();
        scan.nextLine();
        while (choice != 0 && choice != 1) {
            System.out.println("Please enter a valid number.");
            choice = scan.nextInt();
            scan.nextLine();
        }

        if (choice == 1) {
            cart.addDigitalVideoDisc(disc);
            System.out.println("Enter any key to continue");
            scan.nextLine();
            storeMenu();
        } else if (choice == 0) {
            storeMenu();
        }     
    }

    public static void addToCart() {
        System.out.println("Please enter the title of the media you want to add to cart: ");
        String title = scan.nextLine();
        DigitalVideoDisc disc = store.searchDVD(title);
        
        //Invalid name
        while (disc == null) {
            System.out.println("Please enter a valid product name.");
            title = scan.nextLine();
            disc = store.searchDVD(title);
        }
        
        cart.addDigitalVideoDisc(disc);
        System.out.println("Total number of media in cart: " + cart.getSize());	//DVDs?
        System.out.println("Enter any key to continue");
        scan.nextLine();
        storeMenu();
    }

    public static void addToStoreMenu() {
        System.out.println("Options:\n"
                         + "--------------------------------\n"
                         + "1. Add a new DVD\n" //addDVD()
                         + "0. Back\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1");

        int choice = scan.nextInt();
        scan.nextLine();
        while (choice != 0 && choice != 1) {
            System.out.println("Please choose a valid number.");
            choice = scan.nextInt();
            scan.nextLine();
        }

        switch (choice) {
            case 1:
                System.out.println("Please enter the information of the new DVD");
                System.out.println("Title: ");
                String title = scan.nextLine();
                System.out.println("Category: ");
                String category = scan.nextLine();
                System.out.println("Director: ");
                String director = scan.nextLine();
                System.out.println("Length: ");
                int length = scan.nextInt();
                scan.nextLine();
                System.out.println("Price: ");
                float price = Float.parseFloat(scan.nextLine());
                store.addDVD(new DigitalVideoDisc(title, category, director, length, price));
                System.out.println("DVD added. Enter any key to continue");
                scan.nextLine();
                updateStoreMenu();
                break;
            case 0:
                updateStoreMenu();
                break;
            default:
                break;
        }
    }

    public static void removeFromStoreMenu() {
		store.print();
		
		System.out.println("Please enter the title of the media you want to remove: ");
		String title = scan.nextLine();
		DigitalVideoDisc disc = store.searchDVD(title);

        while (disc == null) {
			System.out.println("Please enter a valid product name.");
			title = scan.nextLine();
			disc = store.searchDVD(title);
		}

		store.removeDVD(disc);
		System.out.println("Enter any key to continue");
		scan.nextLine();
		updateStoreMenu();
    }

    public static void filterCartMenu() {
        System.out.println("Options: \n"
                         + "--------------------------------\n"
		                 + "1. Filter by ID\n"
                         + "2. Filter by title\n"
                         + "0. Back\n"
                         + "--------------------------------\n"
                         + "Please choose a number: 0-1-2");
		
		int choice = scan.nextInt();
		scan.nextLine();
		while (choice != 0 && choice != 1 && choice != 2) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}
		
		switch (choice) {
            case 1:
                System.out.println("Please enter ID number");
                int id = scan.nextInt();
                scan.nextLine();
                cart.filterCart(id);
                System.out.println("Enter any key to continue");
                scan.nextLine();
                cartMenu();
                break;
            case 2:
                System.out.println("Please enter keyword");
                String keyword = scan.nextLine();
                cart.filterCart(keyword);
                System.out.println("Enter any key to continue");
                scan.nextLine();
                cartMenu();
                break;
            case 0:
                cartMenu();
                break;
            default:
                break;
        }
    }

    public static void sortCartMenu() {
		System.out.println("Options: " 
                         + "--------------------------------"
                         + "1. Sort by title"
                         + "2. Sort by cost"
                         + "0. Back"
                         + "--------------------------------"
                         + "Please choose a number: 0-1-2");
		
		int choice = scan.nextInt();
		scan.nextLine();
		while (choice != 0 && choice != 1 && choice != 2) {
			System.out.println("Please choose a valid number.");
			choice = scan.nextInt();
			scan.nextLine();
		}

        switch (choice) {
            case 1:
                cart.sortByTitle();
                System.out.println("Your cart has been sorted by title\n");
                cart.print();
                System.out.println("Enter any key to continue");
                scan.nextLine();
                cartMenu();
                break;
            case 2:
                cart.sortByCost();
                System.out.println("Your cart has been sorted by cost\n");
                cart.print();
                System.out.println("Enter any key to continue");
                scan.nextLine();
                cartMenu();
                break;
            case 0:
                cartMenu();
                break;
            default:
                break;
        }
    }

    public static void removeFromCart() {
        System.out.println("Please enter the title of the media you want to remove: ");
        String title = scan.nextLine();
        DigitalVideoDisc disc = store.searchDVD(title);

        while (disc == null) {
            System.out.println("Please enter a valid product name.");
            title = scan.nextLine();
            disc = cart.searchDVD(title);
        }

        cart.removeDigitalVideoDisc(disc);
        System.out.println("Disc removed. Enter any key to continue");
        scan.nextLine();
        cartMenu();
    }

    public static void placeOrder() {
        if (cart.getSize() == 0) {
            System.out.println("You cannot place an empty order\n");
            cartMenu();
        } else {
            cart = new Cart();
            System.out.println("Your order has been placed\n");
            showMenu();
        }
    }

}