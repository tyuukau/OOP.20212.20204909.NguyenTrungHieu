package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {

    public void play() {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		} else {
			System.out.println("Cannot play DVD: " + this.getTitle() + ". Length is less than 0.");
		}
    }       
    
    public String toString() {
        return(String.format("DVD - [%s] - [%s] - [%s] - [%d]: $%f",
                             this.getTitle(), 
                             this.getCategory(), 
                             this.getDirector(), 
                             this.getLength(),
                             this.getCost()));
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
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

}