package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // swap(jungleDVD, cinderellaDVD);
        // System.out.println("jungle dvd title: "+ jungleDVD. getTitle());
        // System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        // changeTitle(jungleDVD, cinderellaDVD.getTitle());
        // System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        
		DigitalVideoDiscWrapper jungleDVDWrapper = new DigitalVideoDiscWrapper(jungleDVD);
		DigitalVideoDiscWrapper cinderellaDVDWrapper = new DigitalVideoDiscWrapper(cinderellaDVD);
		swap(jungleDVDWrapper, cinderellaDVDWrapper);
		System.out.println("jungle dvd title: " + jungleDVDWrapper.disc.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVDWrapper.disc.getTitle());
    }
    // public static void swap(Object O1, Object O2) {
    //     Object tmp = O1;
    //     O1 = O2;
    //     O2 = tmp;
    // }
    // public static void changeTitle(DigitalVideoDisc dvd, String title) {
    //     String oldTitle = dvd.getTitle();
    //     dvd.setTitle(title);
    //     dvd= new DigitalVideoDisc(oldTitle);
    // }

    public static void swap(DigitalVideoDiscWrapper w1, DigitalVideoDiscWrapper w2) {
		DigitalVideoDisc temp = w1.disc;
		w1.disc = w2.disc;
		w2.disc = temp;
	}

}

class DigitalVideoDiscWrapper {
    DigitalVideoDisc disc;
    // Constructor
    DigitalVideoDiscWrapper(DigitalVideoDisc disc) { 
        this.disc = disc; 
    }
}