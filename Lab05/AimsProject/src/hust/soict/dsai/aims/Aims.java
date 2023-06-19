package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.*;

public class Aims {
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Some guy", 100, 19.95f);
		CompactDisc cd1 = new CompactDisc("Hehe", "Alternative", "Toandz", 29.95f, "Toanverydz");
		Book b1 = new Book("Book1", "Cat1", 59.95f);
		
		store.addMedia(dvd1);
		store.addMedia(cd1);
		store.addMedia(b1);
		
		new StoreScreen(store, cart);
		
//		new CartScreen(cart, store);
	}
}
