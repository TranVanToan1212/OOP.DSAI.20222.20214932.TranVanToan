package hust.soict.dsai.aims.store;

import java.util.*;

import hust.soict.dsai.aims.media.*;
import java.beans.*;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	
	public String addMedia(Media media) {
		if (itemsInStore.contains(media)) {
			return "The media has already been added";
		}
		else {
			ArrayList<Media> oldItemsInStore = new ArrayList<Media>(itemsInStore); 
			itemsInStore.add(media);
			pcs.firePropertyChange("itemsInStore", oldItemsInStore, itemsInStore);
			return "Media added successfully";
		}
	}
	public String removeMedia(Media media) {
		if (!(itemsInStore.contains(media))) {
			return "The media has not been added";
		}
		else {
			ArrayList<Media> oldItemsInStore = new ArrayList<Media>(itemsInStore); 
			itemsInStore.remove(media);
			pcs.firePropertyChange("itemsInStore", oldItemsInStore, itemsInStore);

			return "Media removed successfully";
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
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
	
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}

