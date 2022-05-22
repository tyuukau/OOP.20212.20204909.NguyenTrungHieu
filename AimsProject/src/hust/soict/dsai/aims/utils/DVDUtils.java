package hust.soict.dsai.aims.utils;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.Comparator;
import java.util.Arrays;

public class DVDUtils {
    
    public static int compareByCost(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        return Float.compare(disc1.getCost(), disc2.getCost());
    }
    
    public static int compareByTitle(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        return disc1.getTitle().compareToIgnoreCase(disc2.getTitle());
    }
  
    public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc ... discs) {
        Arrays.sort(discs, DVDCostComparator);
        return discs;
    }
    
    public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc ... discs) {
        Arrays.sort(discs, DVDTitleComparator);
        return discs;
    }

    public final static Comparator<DigitalVideoDisc> DVDTitleComparator = new Comparator<DigitalVideoDisc>() {
        public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
            return disc1.getTitle().compareToIgnoreCase(disc2.getTitle());
        }
    };

    public final static Comparator<DigitalVideoDisc> DVDCostComparator = new Comparator<DigitalVideoDisc>() {
        public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
            return Float.compare(disc1.getCost(), disc2.getCost());
        }
    };

    public final static Comparator<DigitalVideoDisc> DVDTitleCostLengthComparator = new Comparator<DigitalVideoDisc>() {
        public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
            int titleCondition = disc1.getTitle().compareToIgnoreCase(disc2.getTitle());
            int costCondition = Float.compare(disc1.getCost(), disc2.getCost());
            int lengthCondition = Integer.compare(disc1.getLength(), disc2.getLength());
            if (titleCondition != 0) {
                return titleCondition;
            } else {
                if (costCondition != 0) {
                    return costCondition;
                } else {
                    return lengthCondition;
                }
            }
        }
    };
}