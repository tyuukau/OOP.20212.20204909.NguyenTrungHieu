package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;

public class BookTest {

    public static void main(String[] args) {

        Book book = new Book("Harry Potter", "Fantasy", 30.00f);

        book.addAuthor("Rowling");
        book.addAuthor("J.K.");
        book.addAuthor("NguyenTRungHIEU");
        book.addAuthor("NGUYENTrungHIEU");
        book.removeAuthor("NGUyenTRUnghIEU");
        book.removeAuthor("NgUyEnTrUnGhIeU");

        book.setProcessContent("There were Mr. and Mrs. Dursley of number four, Privet Drive. They were proud to say that they were perfectly normal, thank you very much.");

        System.out.println(book.toString());

    }
    
}
