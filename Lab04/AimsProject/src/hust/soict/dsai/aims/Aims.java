package hust.soict.dsai.aims;

import java.util.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.*;

public class Aims {

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See the details of a media");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void updateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	public static void seeDiscDetail() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add this disc to cart");
		System.out.println("2. Play this disc");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void seeBookDetail() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add this book to cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1");
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f);
		CompactDisc cd1 = new CompactDisc("Hehe", "Alternative", "Toandz", 29.95f, "Toanverydz");
		Book b1 = new Book("Book1", "Cat1", 59.95f);
		
		store.addMedia(dvd1);
		store.addMedia(cd1);
		store.addMedia(b1);
		
        Scanner keyboard = new Scanner(System.in);
        
        loop_menu: while(true) {
	        showMenu();
	        int input_1 = Integer.parseInt(keyboard.nextLine());
	        switch(input_1) {
	        case 1: 
	        	loop_store_menu: while(true) {
		    		store.displayItemsInStore();
		        	storeMenu();
		        	int input_2 = Integer.parseInt(keyboard.nextLine());
		        	switch(input_2) {
		        	case 1:
			        	System.out.println("Type in the ordinal number of the media you'd like to see the detail of:");
			        	int input_3 = Integer.parseInt(keyboard.nextLine());
			        	
			        	Media media_1 = store.getItemsInStore().get(input_3 - 1);
			        	System.out.println("Detail of media: ");
			        	System.out.println(media_1);
			        	
			        	if ((store.getItemsInStore().get(input_3 - 1) instanceof DigitalVideoDisc) || (store.getItemsInStore().get(input_3 - 1) instanceof CompactDisc)) {
			        		loop_disc_detail: while(true) {
			        		seeDiscDetail();
			            	int input_4 = Integer.parseInt(keyboard.nextLine());
			            	switch(input_4) {
			            	case 1:
			            		cart.addMedia(media_1);
			            		break;
			            	case 2:
			            		if ((store.getItemsInStore().get(input_3 - 1) instanceof DigitalVideoDisc) ) {
			                		DigitalVideoDisc DVD = (DigitalVideoDisc) media_1;
			            			DVD.play();
			            		}
			            		else {
			                		CompactDisc CD = (CompactDisc) media_1;
			                		CD.play();
			            		}
			            		break;
			            	case 0:
			            		break loop_disc_detail;
				        	default:
				        		System.out.println("No such choice");
				        		break;
			            	}
			        		}
			        	}
			        	else {
			        		loop_book_detail: while(true) {
			        		seeBookDetail();
			            	int input_5 = Integer.parseInt(keyboard.nextLine());
			            	switch(input_5) {
			            	case 1:
			            		cart.addMedia(media_1);
			            		break;
			            	case 0:
			            		break loop_book_detail;
				        	default:
				        		System.out.println("No such choice");
				        		break;
			            	}
			        		}
			        	}
			        	break;
		        	case 2:
		        		System.out.println("Type in the title of the media that you want to add to the cart: ");
		            	String titleAddToCart = keyboard.nextLine();

		            	boolean state_2 = false;
		            	for (Media media : store.getItemsInStore()) {

		            		if (media.getTitle().equals(titleAddToCart)) {
		            			cart.addMedia(media);
		            			state_2 = true;
		            			if (media instanceof DigitalVideoDisc) {
		            				int count = 0;
		            				for (Media mediaInCart : cart.getItemsOrdered()) {
		            					if (mediaInCart instanceof DigitalVideoDisc) {
		            						count++;
		            					}
		            				}
		            				System.out.println("The current number of DVD(s) in cart is: " + Integer.toString(count));	
		                		}
		            		}
		            	}
		            	if (state_2 == false) {
		            		System.out.println("No media found.");
		            	}
		            	break;
		        	case 3:
		        		System.out.println("Type in the title of the media that you want to play: ");
		            	String titlePlay = keyboard.nextLine();
		            	
		            	boolean state_3 = false;
		            	for (Media media : store.getItemsInStore()) {
		            		if (media.getTitle().equals(titlePlay)) {
		                		if (media instanceof DigitalVideoDisc) {
		                    		DigitalVideoDisc DVD = (DigitalVideoDisc) media;
		                			DVD.play();
		                		}
		                		else if (media instanceof CompactDisc){
		                    		CompactDisc CD = (CompactDisc) media;
		                    		CD.play();
		                		}
		                		else {
		                			System.out.println("Book can't be played");
		                		}
		            			state_3 = true;
		            		}
		            	}
		            	if (state_3 == false) {
		            		System.out.println("No media found.");
		            	}
		            	break;
		        	case 4:
			        	loop_cart: while(true) {
				        	cart.print();
				        	cartMenu();
				        	int input_7 = Integer.parseInt(keyboard.nextLine());
				        	switch(input_7) {
				        	case 1:
				        		loop_cart_filter: while(true) {
					        		System.out.println("Options: ");
					        		System.out.println("--------------------------------");
					        		System.out.println("1. Filter by ID");
					        		System.out.println("2. Filter by title");
					        		System.out.println("0. Exit");
					        		System.out.println("--------------------------------");
					        		System.out.println("Please choose a number: 0-1-2");
					            	int input_8 = Integer.parseInt(keyboard.nextLine());
					            	switch (input_8) {
					            	case 1:
					            		System.out.println("Type in int to filter by id: ");
					                	int idFilter = Integer.parseInt(keyboard.nextLine());
					//                	cart.filterById();
					                	break;
					            	case 2:
					            		System.out.println("Type in string to filter by title:");
					            		String titleFilter = keyboard.nextLine();
					//            		cart.filterByTitle(titleFilter);
					            		break;
					            	case 0:
					            		break loop_cart_filter;
						        	default:
						        		System.out.println("No such choice");
						        		break;
					            	}
				        		}
				        		break;
				        	case 2:
				        		loop_cart_sort: while(true) {
					        		System.out.println("Options: ");
					        		System.out.println("--------------------------------");
					        		System.out.println("1. Sort by title");
					        		System.out.println("2. Sort by cost");
					        		System.out.println("0. Exit");
					        		System.out.println("--------------------------------");
					        		System.out.println("Please choose a number: 0-1-2");
					            	int input_9 = Integer.parseInt(keyboard.nextLine());
					            	switch (input_9) {
					            	case 1:
					            		cart.sortMediaListByTitleThenCost();
					            		break;
					            	case 2:
					            		cart.sortMediaListByCostThenTitle();
					            		break;
					            	case 0:
					            		break loop_cart_sort;
						        	default:
						        		System.out.println("No such choice");
						        		break;
					            	}
				        		}
				        		break;
				        	case 3:
				        		cart.print();
				        		System.out.println("Type in the ordinal number of the media that you want to remove from cart: ");
				            	int input_10 = Integer.parseInt(keyboard.nextLine());
				            	Media media_3 = store.getItemsInStore().get(input_10 - 1);
				            	cart.removeMedia(media_3);
				            	break;
				        	case 4:
				        		cart.print();
				        		System.out.println("Type in the ordinal number of the media that you want to remove from cart: ");
				            	int input_11 = Integer.parseInt(keyboard.nextLine());
				            	Media media_4 = store.getItemsInStore().get(input_11 - 1);
				            	if (media_4 instanceof DigitalVideoDisc) {
				            		DigitalVideoDisc DVD = (DigitalVideoDisc) media_4;
				        			DVD.play();
				        		}
				        		else if (media_4 instanceof CompactDisc){
				            		CompactDisc CD = (CompactDisc) media_4;
				            		CD.play();
				        		}
				        		else {
				        			System.out.println("Book can't be played");
				        		}
				            	break;
				        	case 5:
				        		cart.print();
				        		System.out.println("Order has been created.");
				        		cart = new Cart();
				        		break;
				        	case 0:
				        		break loop_cart;
				        	default:
				        		System.out.println("No such choice");
				        		break;
				        	}
			        	}
		        		break;
		        	case 0:
		        		break loop_store_menu;
		        	default:
		        		System.out.println("No such choice");
		        		break;
		        	}
	        	}
	        	break;
	        case 2:
	        	loop_update_store: while(true) {
		        	updateStore();
		        	int input_12 = Integer.parseInt(keyboard.nextLine());
		        	switch (input_12) {
		        	case 1:
		        		loop_add_media: while(true) {
			        		System.out.println("Choose the type of the media you want to add or exit: ");
			        		System.out.println("--------------------------------");
			        		System.out.println("1. DVD");
			        		System.out.println("2. CD");
			        		System.out.println("3. Book");
			        		System.out.println("0. Exit");
			        		System.out.println("--------------------------------");
			        		System.out.println("Please choose a number: 0-1-2-3");            	
			        		int type = Integer.parseInt(keyboard.nextLine());
			            	System.out.println("Type in the title of the media you'd like to add to the store:");
			            	String title = keyboard.nextLine();
			            	System.out.println("Type in the category of the media you'd like to add to the store:");
			            	String category = keyboard.nextLine();
			            	System.out.println("Type in the cost of the media you'd like to add to the store:");
			            	float cost = (float) Double.parseDouble(keyboard.nextLine());
			            	
			            	switch (type) {
			            	case 1:
			            		DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
			            		store.addMedia(dvd);
			            		break;
			            	case 2:
			                   	System.out.println("Type in the director of the media you'd like to add to the store:");
			                	String director = keyboard.nextLine();
			                	System.out.println("Type in the artist of the media you'd like to add to the store:");
			                	String artist = keyboard.nextLine();
			            		CompactDisc cd = new CompactDisc(title, category, director, cost, artist);
			            		store.addMedia(cd);
			            		break;
			            	case 3:
			            		Book book = new Book(title, category, cost);
			            		store.addMedia(book);
			            		break;
			            	case 0:
			            		break loop_add_media;
				        	default:
				        		System.out.println("No such choice");
				        		break;
			            	}
		        		}
		        		break;
		        	case 2:
		            	System.out.println("Type in the ordinal number of the media you'd like to remove from the store:");
		            	int input_13 = Integer.parseInt(keyboard.nextLine());
		            	Media media = store.getItemsInStore().get(input_13 - 1);
		            	store.removeMedia(media);
		            	break;
		        	case 0:
		        		break loop_update_store;
		        	default:
		        		System.out.println("No such choice");
		        		break;
		        	}
	        	}
	        case 3:
	        	loop_cart: while(true) {
		        	cart.print();
		        	cartMenu();
		        	int input_14 = Integer.parseInt(keyboard.nextLine());
		        	switch(input_14) {
		        	case 1:
		        		loop_cart_filter: while(true) {
			        		System.out.println("Options: ");
			        		System.out.println("--------------------------------");
			        		System.out.println("1. Filter by ID");
			        		System.out.println("2. Filter by title");
			        		System.out.println("0. Exit");
			        		System.out.println("--------------------------------");
			        		System.out.println("Please choose a number: 0-1-2");
			            	int input_15 = Integer.parseInt(keyboard.nextLine());
			            	switch (input_15) {
			            	case 1:
			            		System.out.println("Type in int to filter by id: ");
			                	int idFilter = Integer.parseInt(keyboard.nextLine());
			//                	cart.filterById();
			                	break;
			            	case 2:
			            		System.out.println("Type in string to filter by title:");
			            		String titleFilter = keyboard.nextLine();
			//            		cart.filterByTitle(titleFilter);
			            		break;
			            	case 0:
			            		break loop_cart_filter;
				        	default:
				        		System.out.println("No such choice");
				        		break;
			            	}
		        		}
		        		break;
		        	case 2:
		        		loop_cart_sort: while(true) {
			        		System.out.println("Options: ");
			        		System.out.println("--------------------------------");
			        		System.out.println("1. Sort by title");
			        		System.out.println("2. Sort by cost");
			        		System.out.println("0. Exit");
			        		System.out.println("--------------------------------");
			        		System.out.println("Please choose a number: 0-1-2");
			            	int input_17 = Integer.parseInt(keyboard.nextLine());
			            	switch (input_17) {
			            	case 1:
			            		cart.sortMediaListByTitleThenCost();
			            		break;
			            	case 2:
			            		cart.sortMediaListByCostThenTitle();
			            		break;
			            	case 0:
			            		break loop_cart_sort;
				        	default:
				        		System.out.println("No such choice");
				        		break;
			            	}
		        		}
		        		break;
		        	case 3:
		        		cart.print();
		        		System.out.println("Type in the ordinal number of the media that you want to remove from cart: ");
		            	int input_18 = Integer.parseInt(keyboard.nextLine());
		            	Media media_3 = store.getItemsInStore().get(input_18 - 1);
		            	cart.removeMedia(media_3);
		            	break;
		        	case 4:
		        		cart.print();
		        		System.out.println("Type in the ordinal number of the media that you want to remove from cart: ");
		            	int input_19 = Integer.parseInt(keyboard.nextLine());
		            	Media media_4 = store.getItemsInStore().get(input_19 - 1);
		            	if (media_4 instanceof DigitalVideoDisc) {
		            		DigitalVideoDisc DVD = (DigitalVideoDisc) media_4;
		        			DVD.play();
		        		}
		        		else if (media_4 instanceof CompactDisc){
		            		CompactDisc CD = (CompactDisc) media_4;
		            		CD.play();
		        		}
		        		else {
		        			System.out.println("Book can't be played");
		        		}
		            	break;
		        	case 5:
		        		cart.print();
		        		System.out.println("Order has been created.");
		        		cart = new Cart();
		        		break;
		        	case 0:
		        		break loop_cart;
		        	default:
		        		System.out.println("No such choice");
		        		break;
		        	}
	        	}
	        	break;
	        case 0:
	        	break loop_menu;
        	default:
        		System.out.println("No such choice");
        		break;
	        }
		}
	}
}
