package hust.soict.dsai.aims.media;

import java.util.*;
import java.text.*;

public class Book extends Media{
	
	private int id;
	private List<String> authors = new ArrayList<String>();
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void addAuthor(String authorName) throws IllegalArgumentException {
		try {
			if (authors.contains(authorName)) {
				throw new IllegalArgumentException("ERROR: The author has already been added");
			}
			else {
				authors.add(authorName);
				System.out.println("Author added successfully");
			}
		}
		catch (IllegalArgumentException e){
			System.out.println("The author has already been added");
		}
	}
	public void removeAuthor(String authorName) throws IllegalArgumentException {
		try {
			if (!(authors.contains(authorName))) {
				throw new IllegalArgumentException("ERROR: The author has not been added");
			}
			else {
				authors.remove(authorName);
				System.out.println("Author removed successfully");
			}
		}
		catch (IllegalArgumentException e){
			System.out.println("The author has not been added");
		}
	}
	public String toString() {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "Book: " + title + "\n" 
				+ "ID: " + Integer.toString(id) + "\n"
				+ "Category: " + this.category + "\n" 
				+ "Cost: " + Float.toString(this.cost) + " $\n"
				+ "Date Added: " + formatter.format(dateAdded) + "\n"
				+ "Author(s): " + String.join(", ", authors) + "\n";
	}
}
