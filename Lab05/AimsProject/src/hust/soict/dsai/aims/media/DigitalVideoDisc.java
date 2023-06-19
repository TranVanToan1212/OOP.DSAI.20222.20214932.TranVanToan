package hust.soict.dsai.aims.media;

import java.text.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.screen.ExceptionDialog;

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
		super(title);
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
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
		super(title, category, director, length, cost);
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	}
//	public void play() {
//		System.out.println("Playing DVD: " + this.getTitle());
//		System.out.println("DVD length: " + this.getLength());
//	}
	
	public ArrayList<String> playToString() {
		ArrayList<String> output = new ArrayList<String>();
		
		output.add("Playing DVD: " + this.getTitle());
		output.add("DVD length: " + Integer.toString(this.getLength()));
		return output;	
	}
	
	public void play() throws PlayerException {
		try {
			if (this.getLength() > 0) {
				JDialog playDialog = new JDialog(new JFrame(), "Media Player");
				
				String playLabelText = "<html>";
				for(String label: playToString()) {
					playLabelText += label;
					playLabelText += "<br>";
				}
				playLabelText += "<html>";
				
				JLabel playLabel = new JLabel(playLabelText, SwingConstants.CENTER);
				playDialog.add(playLabel);
				playDialog.setLocation(200,200);
				playDialog.pack();
				playDialog.setVisible(true);
			}
			else {
				System.err.println();
				throw new PlayerException("ERROR: DVD length is non-posiive!");
			}
		}
		catch (PlayerException e){
			Exception ee = e;
			ExceptionDialog ed = new ExceptionDialog(ee);
			ed.getDialog();
		}
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
