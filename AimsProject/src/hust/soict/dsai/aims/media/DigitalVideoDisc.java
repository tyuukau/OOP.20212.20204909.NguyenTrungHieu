package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

public class DigitalVideoDisc {
    
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private LocalDate dateAdded;
	private int id;
	private static int nbDigitalVideoDiscs = 0;

    public final static Comparator<DigitalVideoDisc> COMPARE_BY_TITLE = new Comparator<DigitalVideoDisc>() {
        public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
            return disc1.getTitle().compareToIgnoreCase(disc2.getTitle());
        }
    };

    public final static Comparator<DigitalVideoDisc> COMPARE_BY_COST = new Comparator<DigitalVideoDisc>() {
        public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
            return Float.compare(disc1.getCost(), disc2.getCost());
        }
    };

    /**
     * @return String return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return String return the category
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * @return String return the director
     */
    public String getDirector() {
        return this.director;
    }

    /**
     * @return int return the length
     */
    public int getLength() {
        return this.length;
    }

    /**
     * @return float return the cost
     */
    public float getCost() {
        return this.cost;
    }

    /**
     * @return LocalDate return the dateAdded
     */
    public LocalDate getDateAdded() {
        return this.dateAdded;
    }

    /**
     * @return int return the length
     */
    public int getID() {
        return this.id;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        this.dateAdded = LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
    }


    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.dateAdded = LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
    }


    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.dateAdded = LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
    }
    

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.dateAdded = LocalDate.now();
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
    }


    public String toString() {
        return(String.format("DVD - [%s] - [%s] - [%s] - [%d]: $%f",
                             this.getTitle(), 
                             this.getCategory(), 
                             this.getDirector(), 
                             this.getLength(),
                             this.getCost()));
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
        String thisTitle = this.title.toLowerCase();
        for (String word : words) {
            if (thisTitle.contains(word)) {
                check = true;
                break;
            }
        }
        return check;
    }

}
