package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
		
//		Object tmp = o1;
//		o1 = o2;
//		o2 = tmp;
		
		String tmpTitle = o1.getTitle();
		String tmpCategory = o1.getCategory();
		String tmpDirector = o1.getDirector();
		int tmpLength = o1.getLength();
		float tmpCost = o1.getCost();
		
		o1.setTitle(o2.getTitle());
		o2.setTitle(tmpTitle);
		
		o1.setCategory(o2.getCategory());
		o2.setCategory(tmpCategory);
		
		o1.setDirector(o2.getDirector());
		o2.setDirector(tmpDirector);
		
		o1.setLength(o2.getLength());
		o2.setLength(tmpLength);
		
		o1.setCost(o2.getCost());
		o2.setCost(tmpCost);
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
