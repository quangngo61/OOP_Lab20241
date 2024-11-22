package hust.soict.dsai.test.disc;

import hust.soict.dsai.disc.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
//		swap(jungleDVD, cinderellaDVD);
//		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//		System.out.println("cinderealle dvd title: " + cinderellaDVD.getTitle());
////		
//		changeTitle(jungleDVD, cinderellaDVD.getTitle());
//		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
//		
        DigitalVideoDisc[] dvds = {jungleDVD, cinderellaDVD};
        correctswap(dvds);
        System.out.println("jungle dvd title: " + dvds[0].getTitle());
        System.out.println("cinderella dvd title: " + dvds[1].getTitle());
	}

	private static void changeTitle(DigitalVideoDisc dvd, String title) {
		// TODO Auto-generated method stub
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
		
	}

	private static void swap(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	//correct swap
	private static void correctswap(DigitalVideoDisc[] dvds) {
        // Swap the two objects inside the array
        DigitalVideoDisc temp = dvds[0];
        dvds[0] = dvds[1];
        dvds[1] = temp;
    }
}
