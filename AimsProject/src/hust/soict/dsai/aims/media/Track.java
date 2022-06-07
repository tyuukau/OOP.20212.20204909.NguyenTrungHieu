package hust.soict.dsai.aims.media;

public class Track implements Playable {

	private String title;
	private int length;

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
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
