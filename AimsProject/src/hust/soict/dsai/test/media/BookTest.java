package hust.soict.dsai.test.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Book;

public class BookTest {

    public static void main(String[] args) {

        Book book = new Book("Harry Potter", "Fantasy", 30.00f);

        ArrayList<String> authorsToAdd = new ArrayList<String>();
        authorsToAdd.add("Rowling");
        authorsToAdd.add("J.K.");
        authorsToAdd.add("NguyenTRungHIEU");
        authorsToAdd.add("NGUyenTRUnghIEU");

        ArrayList<String> authorsToRemove = new ArrayList<String>();
        authorsToRemove.add("NGUyenTRUnghIEU");
        authorsToRemove.add("NgUyEnTrUnGhIeU");

        for (String author : authorsToAdd) {
            try {
                book.addAuthor(author);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        for (String author : authorsToRemove) {
            try {
                book.removeAuthor(author);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        book.setProcessContent("There were Mr. and Mrs. Dursley of number four, Privet Drive. They were proud to say that they were perfectly normal, thank you very much.");

        System.out.println(book.toString());

    }
    
}
