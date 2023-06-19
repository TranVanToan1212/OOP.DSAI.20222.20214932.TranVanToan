package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.screen.ExceptionDialog;

public class Track {

	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track() {
		super();
	}
	
	public Track(String title) {
		super();
		this.title = title;
	}
	
	public Track(String title, int length) throws IllegalArgumentException  {
		super();
		this.title = title;
		if (length <= 0) {
			throw new IllegalArgumentException("Disc length must be positive");
		}
		else {
			this.length = length;
		}
	}
	public void play() throws PlayerException {
		try {
			if (this.getLength() <= 0) {
				System.out.println("Playing Track: " + this.getTitle());
				System.out.println("Track length: " + this.getLength());
			}
			else {
				System.err.println();
				throw new PlayerException("ERROR: Track length is non-posiive!");
			}
		}
		catch (PlayerException e) {
			Exception ee = e;
			ExceptionDialog ed = new ExceptionDialog(ee);
			ed.getDialog();
		}
	}
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Track track = (Track) obj;
		return title.equals(track.title) && (length == track.length);
	}
}
