package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media {

    private String title;
    private String category;
    private float cost;

    private LocalDate dateAdded;
    private int id;
    private static int nbMedia = 0;

    public final static Comparator<Media> COMPARE_BY_TITLE = new Comparator<Media>() {
        public int compare(Media media1, Media media2) {
            return media1.getTitle().compareToIgnoreCase(media2.getTitle());
        }
    };

    public final static Comparator<Media> COMPARE_BY_COST = new Comparator<Media>() {
        public int compare(Media media1, Media media2) {
            return Float.compare(media2.getCost(), media2.getCost());
        }
    };

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

    public int getID() {
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

}
