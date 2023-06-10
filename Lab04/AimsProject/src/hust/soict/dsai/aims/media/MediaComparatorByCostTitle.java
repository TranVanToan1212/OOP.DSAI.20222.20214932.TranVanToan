package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.lang.Math;

public class MediaComparatorByCostTitle implements Comparator<Media>{
	public int compare(Media m1, Media m2) {
		if (m1.getCost() - m2.getCost() != 0) {
			return (int) Math.signum(m1.getCost() - m2.getCost());
		}
		return m1.getTitle().compareTo(m2.getTitle());
	}
}
