package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.*;

public class Track implements Playable {

	private String title;
	private int length;

    public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		} else {
			throw new PlayerException("Cannot play track: " + this.getTitle() + ". Length is less than 0.");
		}
    }  
	
	public String toString() {
		return (this.getTitle() + ", Length: " + this.getLength());
	}

	public boolean equals(Object track) {
		if (track instanceof Track) {
			Track that = (Track) track;
			return (this.title.equalsIgnoreCase(that.getTitle()) && this.length == that.length);
		} else {
			return false;
		}
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

    public Track(String title) {
		super();
		this.title = title;
	}

    public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
}
