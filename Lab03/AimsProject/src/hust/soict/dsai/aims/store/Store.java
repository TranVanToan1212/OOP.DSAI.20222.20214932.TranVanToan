package hust.soict.dsai.aims.store;

import java.util.*;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[0];
	
	public void addDVD(DigitalVideoDisc disc) {
		List<DigitalVideoDisc> itemsInStoreList = 
				new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsInStore));
		
		if (itemsInStoreList.contains(disc)) {
			System.out.println("The disc has already been added");
		}
		else {
			itemsInStoreList.add(disc);
			itemsInStore = itemsInStoreList.toArray(itemsInStore);
			System.out.println("Disc added successfully");
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		List<DigitalVideoDisc> itemsInStoreList = 
				new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsInStore));
		itemsInStoreList.remove(disc);
		itemsInStore = new DigitalVideoDisc[itemsInStoreList.size()];
		itemsInStore = itemsInStoreList.toArray(itemsInStore);		
		System.out.println("Disc removed successfully");	
	}
}

