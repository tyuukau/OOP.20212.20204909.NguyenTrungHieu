import java.time.LocalDate;
public class DigitalVideoDisc {
    
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private LocalDate dateAdded;
	private int id;
	private static int nbDigitalVideoDiscs = 0;

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
        return(String.format("DVD - [%s] - [%s] - [%s] - [%d]: %f$",
                             this.getTitle(), 
                             this.getCategory(), 
                             this.getDirector(), 
                             this.getLength(),
                             this.getCost()));
    }

}
