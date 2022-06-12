package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorCostTitle implements Comparator<Media> {

    public int compare(Media m1, Media m2) {
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        return costComparison != 0 ? costComparison : titleComparison;
    }

}
