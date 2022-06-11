package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorTitleCost implements Comparator<Media> {

	public int compare(Media m1, Media m2) {
		int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        return titleComparison != 0 ? titleComparison : costComparison;
	}

}
