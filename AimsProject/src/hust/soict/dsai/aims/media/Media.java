package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media implements Comparable<Media> {

    private String title;
    private String category;
    private float cost;

    private LocalDate dateAdded;
    private int id;
    private static int nbMedia = 0;

    public final static Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorTitleCost();
    public final static Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorCostTitle();

    public boolean isMatch(String title) {
        boolean check = false;
        String[] words = title.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            // You may want to check for a non-word character before blindly
            // performing a replacement
            // It may also be necessary to adjust the character class
            words[i] = words[i].toLowerCase().replaceAll("[^\\w]", "");
        }
        String thisTitle = this.getTitle().toLowerCase();
        for (String word : words) {
            if (thisTitle.contains(word)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public int compareTo(Media other) {
        try {
            int titleCondition = this.getTitle().compareToIgnoreCase(other.getTitle());
            int categoryCondition = this.getCategory().compareToIgnoreCase(other.getCategory());
            return titleCondition != 0 ? titleCondition : categoryCondition;
        } catch (NullPointerException e) {
            return 0;
        }
    }

	public boolean equals(Object other) {
        try {
            return (this.title.toLowerCase().equals(((Media)other).getTitle().toLowerCase()) && this.cost == ((Media)other).getCost());
        } catch (NullPointerException | ClassCastException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
	}

    public abstract String toString();

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public float getCost() {
        return this.cost;
    }

    public LocalDate getDateAdded() {
        return this.dateAdded;
    }

    public int getId() {
        return this.id;
    }

	public Media(String title) {
		super();
		this.title = title;
		this.id = nbMedia;
		nbMedia += 1;
        this.dateAdded = LocalDate.now();
	}

    public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;
		this.id = nbMedia;
		nbMedia += 1;
        this.dateAdded = LocalDate.now();
	}

    public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbMedia;
		nbMedia += 1;
        this.dateAdded = LocalDate.now();
	}
	
}
