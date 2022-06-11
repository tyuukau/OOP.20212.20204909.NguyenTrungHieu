package hust.soict.dsai.aims.utils;

import java.util.Arrays;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class DVDUtils {
    
    public static int compareByCost(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        return Float.compare(disc1.getCost(), disc2.getCost());
    }
    
    public static int compareByTitle(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        return disc1.getTitle().compareToIgnoreCase(disc2.getTitle());
    }
  
    public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc ... discs) {
        Arrays.sort(discs, DigitalVideoDisc.COMPARE_BY_COST_TITLE);
        return discs;
    }
    
    public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc ... discs) {
        Arrays.sort(discs, DigitalVideoDisc.COMPARE_BY_TITLE_COST);
        return discs;
    }

}