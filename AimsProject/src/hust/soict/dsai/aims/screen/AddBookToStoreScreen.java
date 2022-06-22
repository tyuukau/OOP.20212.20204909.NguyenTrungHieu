package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    
    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
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

        west.add(new Label("Author (Seperated by ;)"));
        JTextField authorField = new JTextField(20);
        west.add(authorField);

        west.add(new Label("Content"));
        JTextField contentField = new JTextField(20);	
        west.add(contentField);

        JButton confirmAdd = new JButton("Confirm");
        confirmAdd.addActionListener(e -> {

            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            ArrayList<String> authors = new ArrayList<String>(Arrays.asList(authorField.getText().split(";")));
            String content = contentField.getText();

            Book book = new Book(title, category, cost);
            for (String authorName : authors) {
                book.addAuthor(authorName);
            }
            book.setProcessContent(content);
            store.addMedia(book);

        });
        west.add(confirmAdd);

		return west;
    }

}
