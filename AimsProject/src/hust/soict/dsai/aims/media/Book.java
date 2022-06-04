package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book {

	private int id;
    private String title;
    private String category;
    private float cost;
	private List<String> authors = new ArrayList<String>();


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return this.cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

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

	// public Book(String title, String category, float cost) {
	// 	this.title = title;
    //     this.category = category;
    //     this.cost = cost;
	// }

	// public Book(String title, String category) {
	// 	this.title = title;
    //     this.category = category;
	// }

	// public Book(String title) {
	// 	this.title = title;
	// }

    // public Book() {
    //
    // }

}
