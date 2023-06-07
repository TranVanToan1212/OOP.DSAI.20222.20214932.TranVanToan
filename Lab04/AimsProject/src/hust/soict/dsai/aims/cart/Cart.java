package hust.soict.dsai.aims.cart;

import java.util.*;

import hust.soict.dsai.aims.media.*;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			System.out.println("The media has already been added");
		}
		else {
			itemsOrdered.add(media);
			System.out.println("Media added successfully");
		}
	}
	public void removeMedia(Media media) {
		if (!(itemsOrdered.contains(media))) {
			System.out.println("The media has not been added");
		}
		else {
			itemsOrdered.remove(media);
			System.out.println("Media removed successfully");
		}
	}
	
	public double totalCost() {
		
		float total = 0;
		
		for (int i = 0; i < itemsOrdered.size(); i++) {
			total += itemsOrdered.get(i).getCost();
		}
		
		return(total);
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		if (itemsOrdered.size() != 0) {
			for (int i = 1; i < itemsOrdered.size() + 1; i++) {
				System.out.println(Integer.toString(i) + ". " + itemsOrdered.get(i - 1));
			}
		}
		System.out.println("Total cost: " +Double.toString(totalCost()));
		System.out.println("**************************************************");
	}
//	public void search(int input) {
//		boolean state = false;
//		System.out.println("Result for \"" + input + "\" :");
//		for (Media media: itemsOrdered) {
//			if (media.search(input) == true) {
//				System.out.println(media);
//			}
//		}
//		if (state == false) {
//			System.out.println("No DVD found.");
//		}
//	}
//	
//	public void search(String input) {
//		String[] inputSplit = input.split(" ",0);
//		boolean state = false;
//		System.out.println("Result for \"" + input + "\" :");
//		for (Media media: itemsOrdered) {
//			for (String word: inputSplit) {
//				if(media.search(word) == true) {
//					System.out.println(media);
//					state = true;
//				}
//			}
//		}
//		if (state == false) {
//			System.out.println("No DVD found.");
//		}
//	}
	
    public void sortMediaListByTitleThenCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title, and then by cost");
    }
    public void sortMediaListByCostThenTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost, and then by title");
    }
    public List<Media> getItemsOrdered() {
    	return itemsOrdered;
    }
}
