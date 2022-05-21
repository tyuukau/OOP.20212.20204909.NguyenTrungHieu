import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class DVDUtils {
    
    public static int compareByCost(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        return Float.compare(disc1.getCost(), disc2.getCost());
    }
    
    public static int compareByTitle(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        return disc1.getTitle().compareToIgnoreCase(disc2.getTitle());
    }
  
    public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc ... discs) {
        ArrayList<DigitalVideoDisc> digitalVideoDiscs = new ArrayList<DigitalVideoDisc>();
        for (DigitalVideoDisc disc: discs) {
            digitalVideoDiscs.add(disc);
        }
        Collections.sort(digitalVideoDiscs, DVDCostComparator);
        DigitalVideoDisc[] result = digitalVideoDiscs.toArray(new DigitalVideoDisc[digitalVideoDiscs.size()]);
        return result;
    }
    
    public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc ... discs) {
        ArrayList<DigitalVideoDisc> digitalVideoDiscs = new ArrayList<DigitalVideoDisc>();
        for (DigitalVideoDisc disc: discs) {
            digitalVideoDiscs.add(disc);
        }
        Collections.sort(digitalVideoDiscs, DVDTitleComparator);
        DigitalVideoDisc[] result = digitalVideoDiscs.toArray(new DigitalVideoDisc[digitalVideoDiscs.size()]);
        return result;
    }

    final static Comparator<DigitalVideoDisc> DVDTitleComparator = new Comparator<DigitalVideoDisc>() {
        public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
            return disc1.getTitle().compareToIgnoreCase(disc2.getTitle());
        }
    };

    final static Comparator<DigitalVideoDisc> DVDCostComparator = new Comparator<DigitalVideoDisc>() {
        public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
            return Float.compare(disc1.getCost(), disc2.getCost());
        }
    };
}