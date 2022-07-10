package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.*;

public class DigitalVideoDisc extends Disc {

    public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("Cannot play DVD: " + this.getTitle() + ". Length is less than 0.");
		}
    }       

    public String toString() {
        return(String.format("[$%f]:\n" + 
                             "\tDVD\n" +
                             "\tTitle: %s\n" +
                             "\tCategory: %s\n" +
                             "\tDirector: %s\n" +
                             "\tLength: %s\n"
                             ,
                             this.getCost(),
                             this.getTitle(), 
                             this.getCategory(),
                             this.getDirector(),
                             this.getLength()));
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
