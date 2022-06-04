package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
    
    private String director;
    private int length;

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

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }
    

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String toString() {
        return(String.format("DVD - [%s] - [%s] - [%s] - [%d]: $%f",
                             this.getTitle(), 
                             this.getCategory(), 
                             this.getDirector(), 
                             this.getLength(),
                             this.getCost()));
    }

}
