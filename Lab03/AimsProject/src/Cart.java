
import java.util.*;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[0];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		List<DigitalVideoDisc> itemsList = 
				new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsOrdered));
		
		if (itemsList.contains(disc)) {
			System.out.println("The disc has been added");
		}
		else if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
		else {
			itemsList.add(disc);
			itemsOrdered = itemsList.toArray(itemsOrdered);
			
			qtyOrdered += 1;
			
			System.out.println("Item successfully added to cart");
			
			if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
				System.out.println("The cart is almost full");
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		List<DigitalVideoDisc> addtoItemsList = 
				new ArrayList<DigitalVideoDisc>(Arrays.asList(dvdList));
		
		int expectedQtyOrdered = qtyOrdered + addtoItemsList.size();
		
		if (expectedQtyOrdered <= 20) {
			
			List<DigitalVideoDisc> itemsList = 
					new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsOrdered));
			
			itemsList.addAll(addtoItemsList);
			System.out.println("Items successfully added to cart");
			
			if (expectedQtyOrdered == 20) {
				System.out.println("The cart is full");
			}
			else if (expectedQtyOrdered == 19) {
				System.out.println("The cart is almost full");
			}
			
			for (int i = 0; i < addtoItemsList.size()) {
				if(itemsList.contain(addtoItemsList.get(i))) {
					continue;
				}
				else {
					itemsList.add(addtoItemsList.get(i));
					qtyOrdered += 1;
				}
			}
		}
		else {
			System.out.println("Exceeded cart's capacity");
		}	
	}
		
	public void addDigitalVideoDisc(DigitalVideoDisc ... dvdList) {

		List<DigitalVideoDisc> addtoItemsList = 
				new ArrayList<DigitalVideoDisc>(Arrays.asList(dvdList));
		
		int expectedQtyOrdered = qtyOrdered + addtoItemsList.size();
		
		if (expectedQtyOrdered <= 20) {
			
			List<DigitalVideoDisc> itemsList = 
					new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsOrdered));
			
			itemsList.addAll(addtoItemsList);
			System.out.println("Items successfully added to cart");
			
			if (expectedQtyOrdered == 20) {
				System.out.println("The cart is full");
			}
			else if (expectedQtyOrdered == 19) {
				System.out.println("The cart is almost full");
			}
			
			for (int i = 0; i < addtoItemsList.size()) {
				if(itemsList.contain(addtoItemsList.get(i))) {
					continue;
				}
				else {
					itemsList.add(addtoItemsList.get(i));
					qtyOrdered += 1;
				}
			}
		}
		else {
			System.out.println("Exceeded cart's capacity");
		}	
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		List<DigitalVideoDisc> itemsList = 
				new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsOrdered));
		
		if (itemsList.contains(dvd1)) {
			System.out.println("dvd1 has been added");
		}
		else if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
		else {
			itemsList.add(dvd1);
			itemsOrdered = itemsList.toArray(itemsOrdered);
			
			qtyOrdered += 1;
			
			System.out.println("Item successfully added to cart");
			
			if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
				System.out.println("The cart is almost full");
			}
		}
		
		if (itemsList.contains(dvd2)) {
			System.out.println("dvd1 has been added");
		}
		else if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
		else {
			itemsList.add(dvd2);
			itemsOrdered = itemsList.toArray(itemsOrdered);
			
			qtyOrdered += 1;
			
			System.out.println("Item successfully added to cart");
			
			if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
				System.out.println("The cart is almost full");
			}
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		List<DigitalVideoDisc> itemsList = 
				new ArrayList<DigitalVideoDisc>(Arrays.asList(itemsOrdered));
		itemsList.remove(disc);
		itemsOrdered = new DigitalVideoDisc[itemsList.size()];
		itemsOrdered = itemsList.toArray(itemsOrdered);
		
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
