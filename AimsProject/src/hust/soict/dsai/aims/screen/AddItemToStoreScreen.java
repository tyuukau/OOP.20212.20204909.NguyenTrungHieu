package hust.soict.dsai.aims.screen;

import java.awt.*;
import javax.swing.*;

import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {

	Store store;
	
	public AddItemToStoreScreen(Store store) {
        
		this.store = store;
		
        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createWest(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(450, 300);
		setLocationRelativeTo(null);
        setVisible(true);

	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu updateStore = new JMenu("Update Store");

		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(e -> {
			new AddBookToStoreScreen(store);
			dispose();
		});
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(e -> {
			new AddCDToStoreScreen(store);
			dispose();
		});		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(e -> {
			new AddDVDToStoreScreen(store);
			dispose();
		});
		
        updateStore.add(addBook);
        updateStore.add(addDVD);
		updateStore.add(addCD);

		JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
			new StoreManagerScreen(store);
			dispose();
		});

		JMenuItem logOut = new JMenuItem("Log out");
		logOut.addActionListener(e -> {
			new LoginScreen(store);
			dispose();
		});

		menu.add(updateStore);
		menu.add(viewStore);
        menu.add(logOut);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}

    abstract JPanel createWest();

}
