public class DigitalVideoDisc {
    
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

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

    public DigitalVideoDisc(String title) {
        this.title = title;
    }


    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }


    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }
    

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

}
