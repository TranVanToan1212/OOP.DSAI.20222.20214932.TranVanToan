package hust.soict.dsai.aims.media;

import java.text.*;
import java.util.Date;

public class DigitalVideoDisc extends Disc implements Playable{

	private int id;
	private static int nbDigitalVideoDiscs = 0;
	
	public String getDetail() {
		return "DVD - " + this.title + " - " 
				+ this.category + " - " 
				+ this.director + " - " 
				+ Integer.toString(this.length) + ": "
				+ Float.toString(this.cost) + " $";
	}

	public boolean search(String inputTitle) {
		String[] splitArr = this.title.split(" ",0);
		for (String word : splitArr) {
			if (word.toLowerCase().equals(inputTitle.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	public boolean search(int inputId) {
		if (this.id == inputId) {
			return true;
		}
		else {
			return false;
		}
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, cost);
		this.length = length;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	public String toString() {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "DVD: " + title + "\n" 
				+ "ID: " + Integer.toString(id) + "\n"
				+ "Category: " + this.category + "\n" 
				+ "Cost: " + Float.toString(this.cost) + " $\n"
				+ "Date Added: " + formatter.format(dateAdded) + "\n";
	}
}
