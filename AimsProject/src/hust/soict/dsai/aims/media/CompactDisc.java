package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.*;

public class CompactDisc extends Disc {
    
    private String artist;
	private List<Track> tracks = new ArrayList<Track>();

    public void play() throws PlayerException {
        System.out.println("Playing CD: " + this.getTitle());
		if (this.getLength() <= 0) {
			throw new PlayerException("Cannot play CD: " + this.getTitle() + ". Length is less than 0.");
		} else {
			for (Track track : this.tracks) {
				try {
					track.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
    }  

	public void addTrack(Track track) throws IllegalItemException {
		if (this.tracks.contains(track)) {
			throw new IllegalItemException("The track " + track.getTitle() + " is already in the tracklist of " + this.getTitle());
		} else {
			this.tracks.add(track);
			System.out.println("The track " + track.getTitle() + " has been added to the tracklist of " + this.getTitle());
		}
	}
	
	public void removeTrack(Track track) throws IllegalItemException {
		if (this.tracks.remove(track)) {
			throw new IllegalItemException("The track " + track.getTitle() + " has been removed from the tracklist of " + this.getTitle());
		} else {
			System.out.println("The track " + track.getTitle() + " is not in the tracklist of " + this.getTitle());
		}
	}

    public String toString() {
		String trackOutput = "";
		for (Track track : this.tracks) {
			trackOutput += ("\t\t" + track.toString() + "\n");
		}
        return(String.format("[$%f]:\n" + 
                             "\tCD\n" +
                             "\tTitle: %s\n" +
                             "\tCategory: %s\n" +
                             "\tDirector: %s\n" +
							 "\tArtist: %s\n" +
                             "\tLength: %s\n" +
							 "\tTrack:\n" +
							 "%s\n"
                             ,
                             this.getCost(),
                             this.getTitle(), 
                             this.getCategory(),
                             this.getDirector(),
							 this.artist,
                             this.getLength(),
							 trackOutput));
    }
	
	public int getLength() {
		int totalLength = 0;
		for (Track track: this.tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}

    public CompactDisc(String title) {
		super(title);
	}

    public CompactDisc(String title, String category) {
		super(title, category);
	}

    public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

    public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}

    public CompactDisc(String title, String category, String artist, String director, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
	}
	
}
