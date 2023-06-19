package hust.soict.dsai.aims.media;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.screen.ExceptionDialog;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String category, String director, float cost, String artist) {
		super(title, category, director, cost);
		this.artist = artist;
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost, String artist, List<Track> tracks) {
		super(title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	} 
	
	public void addTrack(Track track) throws IllegalArgumentException{
		try {
			if (tracks.contains(track)) {
				throw new IllegalArgumentException("ERROR: The track has already been added");
			}
			else {
				tracks.add(track);
				System.out.println("Track added successfully");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println("The track has not been added");
		}

	}
	public void removeTrack(Track track) throws IllegalArgumentException{
		try {
			if (!(tracks.contains(track))) {
				throw new IllegalArgumentException("ERROR: The track has not been added");
			}
			else {
				tracks.remove(track);
				System.out.println("Track removed successfully");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println("The track has not been added");
		}
	}
	public int getLength() {
		int Length = 0;
		for (int i = 0; i < tracks.size(); i++) {
			Length += tracks.get(i).getLength();
		}
		return Length;
	}
//	public void play() {
//		System.out.println("Playing CD: " + this.getTitle());
//		
//		for (int i = 1; i < tracks.size() + 1; i++) {
//			System.out.println("Playing Track: " + this.getTitle());
//			System.out.println("Track length: " + this.getLength());
//		}
//	}
	
	public ArrayList<String> playToString() {
		ArrayList<String> output = new ArrayList<String>();
		
		output.add("Playing CD: " + this.getTitle());
		output.add("Number of tracks: " + Integer.toString(this.tracks.size()));
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
				
				int count = 0;
				Iterator<Track> iter = tracks.iterator();
				Track nextTrack; 
				JDialog playDialogTrack = new JDialog(new JFrame(), "Media Player");;
				String playLabelTextTrack = "<html>Track " + Integer.toString(count) + ": playing...<html>";;
				JLabel playLabelTrack = new JLabel(playLabelTextTrack, SwingConstants.CENTER);;
				while(iter.hasNext()) {
					nextTrack = (Track) iter.next();
					playDialog.remove(playLabelTrack);
					playDialogTrack.dispose();
					try {
						nextTrack.play();
						count += 1;
						
						playDialogTrack = new JDialog(new JFrame(), "Media Player");
						
						playLabelTextTrack = "<html>Track " + Integer.toString(count) + ": playing...<html>";
						
						playLabelTrack = new JLabel(playLabelTextTrack, SwingConstants.CENTER);
						playDialog.add(playLabelTrack);
						playDialog.setLocation(200,200);
						playDialog.pack();
						playDialog.setVisible(true);
					}
					catch (PlayerException e) {
						Exception ee = e;
						ExceptionDialog ed = new ExceptionDialog(ee);
						ed.getDialog();
					}
				}
			}
			else {
				throw new PlayerException("ERROR: CD length is non-positive!");
			}
		}
		catch (PlayerException e) {
			Exception ee = e;
			ExceptionDialog ed = new ExceptionDialog(ee);
			ed.getDialog();
		}
	}

	public String toString() {
		List<String> trackList = new ArrayList<String>();
		for (Track track : tracks) {
			trackList.add(track.getTitle() + ": " + track.getLength());
		}
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "CD: " + title + "\n" 
				+ "Category: " + this.category + "\n" 
				+ "Cost: " + Float.toString(this.cost) + " $\n"
				+ "Date Added: " + formatter.format(dateAdded) + "\n"
				+ "Artist(s): " + artist + "\n"
				+ "Track(s) (Title: Length): " + String.join(", ", trackList) + "\n";
	}
}
