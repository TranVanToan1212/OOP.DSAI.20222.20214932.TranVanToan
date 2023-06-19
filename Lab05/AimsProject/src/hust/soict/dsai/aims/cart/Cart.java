package hust.soict.dsai.aims.cart;

import java.util.*;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	public String addMedia(Media media) throws LimitExceededException, IllegalArgumentException {	
		try {
			if (itemsOrdered.contains(media)) {
				throw new IllegalArgumentException("ERROR: Media has already been added to cart.");
			}
			else {
				try {
					if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {	
						itemsOrdered.add(media);
						return "Media added to cart successfully";
					}
					else {
						throw new LimitExceededException("ERROR: The number of medias has reached its limit.");
					} 
				}
				catch (LimitExceededException e) {
					return "Cart's capacity reached its limit.";
				}
			}
		}
		catch (IllegalArgumentException e){
			return "Media has already been added to cart";
		}
	}
	public String removeMedia(Media media) throws IllegalArgumentException {
		try {
			if (!(itemsOrdered.contains(media))) {
				throw new IllegalArgumentException("ERROR: Media has not been added to cart");
			}
			else {
				itemsOrdered.remove(media);
				return "Media removed from cart successfully";
			}
		}
		catch (IllegalArgumentException e) {
			return "Media has not been added to cart";
		}
	}
	
	public double totalCost() {
		
		float total = 0;
		
		if (itemsOrdered.size() >= 1) {
			for (int i = 0; i < itemsOrdered.size(); i++) {
				total += itemsOrdered.get(i).getCost();
			}
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
	
	public void reset() {
		itemsOrdered = FXCollections.observableArrayList();
	}
	
    public void sortMediaListByTitleThenCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title, and then by cost");
    }
    public void sortMediaListByCostThenTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost, and then by title");
    }
    public ObservableList<Media> getItemsOrdered() {
    	return itemsOrdered;
    }
}
