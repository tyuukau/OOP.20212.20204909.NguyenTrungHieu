package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.exception.*;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
    
    public AddCDToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
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

        west.add(new Label("Artist"));
        JTextField artistField = new JTextField(20);	
        west.add(artistField);

        west.add(new Label("Director"));
        JTextField directorField = new JTextField(20);
        west.add(directorField);

        west.add(new Label("Track ('name:length'), seperated by ;"));
        JTextField trackField = new JTextField(20);
        west.add(trackField);

        JButton confirmAdd = new JButton("Confirm");
        confirmAdd.addActionListener(e -> {

            String title = titleField.getText();
            String category = categoryField.getText();
            String artist = artistField.getText();
            String director = directorField.getText();
            float cost = Float.parseFloat(costField.getText());
            ArrayList<String> tracks = new ArrayList<String>(Arrays.asList(trackField.getText().split(";")));

            CompactDisc disc = new CompactDisc(title, category, artist, director, cost);
            for (String trackInfo : tracks) {
                ArrayList<String> trackInfoList = new ArrayList<String>(Arrays.asList(trackInfo.split(":")));
                String trackTitle = trackInfoList.get(0).trim();
                int trackLength = Integer.parseInt(trackInfoList.get(1));
                Track track = new Track(trackTitle, trackLength);
                try {
                    disc.addTrack(track);
                } catch (IllegalItemException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            try {
                store.addMedia(disc);
                JOptionPane.showMessageDialog(null, disc.getTitle() + " was added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalItemException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
            }

        });
        west.add(confirmAdd);

		return west;
    };

}
