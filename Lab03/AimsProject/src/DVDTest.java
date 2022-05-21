public class DVDTest {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		System.out.println(DVDUtils.compareByCost(dvd1, dvd2));
        System.out.println(DVDUtils.compareByCost(dvd2, dvd2));
        System.out.println(DVDUtils.compareByCost(dvd2, dvd1));
        System.out.println(DVDUtils.compareByTitle(dvd1, dvd5));
        System.out.println(DVDUtils.compareByTitle(dvd4, dvd4));
        System.out.println(DVDUtils.compareByTitle(dvd4, dvd3));

		
		DigitalVideoDisc [] list_dvd = {dvd1, dvd2, dvd3, dvd4, dvd5};
		DigitalVideoDisc [] sorted = DVDUtils.sortByCost(list_dvd);
		System.out.println("Sort by cost: ");
		for (int i = 0; i< sorted.length; i++) {
			System.out.println(sorted[i].toString());
		}
		
        DigitalVideoDisc [] list_dvd_1 = {dvd3, dvd5, dvd4, dvd1, dvd2};
		sorted = DVDUtils.sortByTitle(list_dvd_1);
		System.out.println("Sort by title: ");
		for (int i = 0; i< sorted.length; i++) {
			System.out.println(sorted[i].toString());
		}

	}

}
