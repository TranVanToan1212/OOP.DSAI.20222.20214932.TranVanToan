
import java.util.*;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[0];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		List<DigitalVideoDisc> itemslist = 
				new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsOrdered));
		
		if (itemslist.contains(disc)) {
			System.out.println("The disc has been added");
		}
		else if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
		else {
			itemslist.add(disc);
			itemsOrdered = itemslist.toArray(itemsOrdered);
			
			qtyOrdered += 1;
			
			System.out.println("Item successfully added to cart");
			
			if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
				System.out.println("The cart is almost full");
			}
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		List<DigitalVideoDisc> itemslist = 
				new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsOrdered));
		itemslist.remove(disc);
		itemsOrdered = new DigitalVideoDisc[itemslist.size()];
		itemsOrdered = itemslist.toArray(itemsOrdered);
		
		qtyOrdered -= 1;
		
		System.out.println("Item successfully removed from cart");
	}
	
	public double totalCost() {
		
		float total = 0;
		
		for (int i = 0; i < itemsOrdered.length; i++) {
			total += itemsOrdered[i].getCost();
		}
		
		return(total);
	}
	
	
	
}
