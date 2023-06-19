package hust.soict.dsai.aims.media;

import java.util.*;

public abstract class Media {
	
	protected String title;
	protected String category;
	protected float cost;
	protected Date dateAdded;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
			new MediaComparatorByCostTitle();
	
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) throws IllegalArgumentException {
		try {
			if (cost >= 0) { 
				this.cost = cost;
			}
			else {
				throw new IllegalArgumentException("ERROR: Cost cannot be negative");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println("Cost cannot be negative");
		}
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Media() {
		super();
	}
	public Media(String title) {
		super();
		this.title = title;
	}
	public Media(String title, String category, float cost) throws IllegalArgumentException {
		super();
		this.title = title;
		this.category = category;
		try {
			if (cost >= 0) { 
				this.cost = cost;
			}
			else {
				throw new IllegalArgumentException("ERROR: Cost cannot be negative");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println("Cost cannot be negative");
		}
	}
	public boolean equals(Object obj) throws NullPointerException, ClassCastException {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			try {
				if (obj == null) {
					throw new NullPointerException("ERROR: Object is null");
				}
				else {
					throw new ClassCastException("ERROR: Class cast exception");
				}
			}
			catch (NullPointerException | ClassCastException enc) {
				return false;
			}
		}
		Media media = (Media) obj;
		return title.equals(media.title);
	}
}
