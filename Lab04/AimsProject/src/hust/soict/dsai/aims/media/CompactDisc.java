package hust.soict.dsai.aims.media;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String category, String director, float cost, String artist) {
		super(title, category, director, cost);
		this.artist = artist;
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	}
	
	public CompactDisc(String title, String category, String director,int length, float cost, String artist, List<Track> tracks) {
		super(title, category, director, cost);
		this.artist = artist;
		this.length = length;
		this.tracks = tracks;
    	Date dateAdded = new Date();
    	this.dateAdded = dateAdded;
	} 
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("The track has already been added");
		}
		else {
			tracks.add(track);
			System.out.println("Track added successfully");
		}
	}
	public void removeTrack(Track track) {
		if (!(tracks.contains(track))) {
			System.out.println("The track has not been added");
		}
		else {
			tracks.remove(track);
			System.out.println("Track removed successfully");
		}
	}
	public int getLength() {
		int Length = 0;
		for (int i = 1; i < tracks.size() + 1; i++) {
			Length += tracks.get(i).getLength();
		}
		return Length;
	}
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		
		for (int i = 1; i < tracks.size() + 1; i++) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("Track length: " + this.getLength());
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
