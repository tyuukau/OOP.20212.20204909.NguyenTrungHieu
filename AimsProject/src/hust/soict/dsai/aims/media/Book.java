package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	public void addAuthor(String authorName) {
        if (!this.authors.stream().anyMatch(authorName::equalsIgnoreCase)) {
            this.authors.add(authorName);
            System.out.println(authorName + " has been added to the " + this.getTitle() + " list of authors.");
        } else {
            System.out.println(authorName + " is already in the list of authors of " + this.getTitle() + ".");
        }
	}
	
	public void removeAuthor(String authorName) {
        if (this.authors.stream().anyMatch(authorName::equalsIgnoreCase)) {
            this.authors.removeIf(author -> author.equalsIgnoreCase(authorName));
            System.out.println(authorName + " has been removed from the " + this.getTitle() + " list of authors.");
        } else {
            System.out.println(authorName + " is not in the list of authors of " + this.getTitle() + ".");
        }
	}

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

}
