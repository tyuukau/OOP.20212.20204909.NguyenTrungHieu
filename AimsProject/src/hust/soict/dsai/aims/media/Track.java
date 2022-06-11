package hust.soict.dsai.aims.media;

public class Track implements Playable {

	private String title;
	private int length;

    public void play() {
		if (this.getLength() > 0) {
			System.out.println("Playing track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
		} else {
			System.out.println("Cannot play track: " + this.getTitle() + ". Length is less than 0.");
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
