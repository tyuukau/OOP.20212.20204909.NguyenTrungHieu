package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
    
    public AddDVDToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
    }

    JPanel createBody() {
        JPanel west = new JPanel();	
        west.setLayout(new GridLayout(0, 2, 4, 4));

        west.add(new Label("Title"));
        JTextField titleField = new JTextField(20);	
        west.add(titleField);

        west.add(new Label("Category"));
        JTextField categoryField = new JTextField(20);	
        west.add(categoryField);

        west.add(new Label("Cost"));
        JTextField costField = new JTextField(20);	
        west.add(costField);

        west.add(new Label("Director"));
        JTextField directorField = new JTextField(20);
        west.add(directorField);

        west.add(new Label("Length"));
        JTextField lengthField = new JTextField(20);	
        west.add(lengthField);

        JButton confirmAdd = new JButton("Confirm");
        confirmAdd.addActionListener(e -> {

            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());

            DigitalVideoDisc disc = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(disc);

        });
        west.add(confirmAdd);

		return west;
    };

}
