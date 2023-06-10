package hust.soict.dsai.aims.store;

import java.util.*;

import hust.soict.dsai.aims.media.*;

public class Store {
private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			System.out.println("The media has already been added");
		}
		else {
			itemsInStore.add(media);
			System.out.println("Media added successfully");
		}
	}
	public void removeMedia(Media media) {
		if (!(itemsInStore.contains(media))) {
			System.out.println("The media has not been added");
		}
		else {
			itemsInStore.remove(media);
			System.out.println("Media removed successfully");
		}
	}
	public void displayItemsInStore() {
		int i = 0;
		System.out.println("Item(s) in store: \n");
		for (Media media : itemsInStore) {
			i++;
			System.out.println(Integer.toString(i) + ". \n" + media);
		}
	}
	public List<Media> getItemsInStore() {
		return itemsInStore;
	}
}

