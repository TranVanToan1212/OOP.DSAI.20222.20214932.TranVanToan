package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.lang.Math;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	public int compare(Media m1, Media m2) {
		if (m1.getTitle().compareTo(m2.getTitle()) != 0) {
			return m1.getTitle().compareTo(m2.getTitle());
		}
		return (int) Math.signum(m1.getCost() - m2.getCost());
	}
}