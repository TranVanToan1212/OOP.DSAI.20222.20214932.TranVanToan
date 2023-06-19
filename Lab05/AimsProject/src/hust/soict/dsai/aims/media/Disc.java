package hust.soict.dsai.aims.media;

public class Disc extends Media{
	
	protected int length;
	protected String director;
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	public Disc(String title) {
		super(title);
	}
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;
	}
	public Disc(String title, String category, String director, int length, float cost) throws IllegalArgumentException {
		super(title, category, cost);
		this.director = director;
		if (length <= 0) {
			throw new IllegalArgumentException("Disc length must be positive");
		}
		else {
			this.length = length;
		}
	}
}
