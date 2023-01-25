package edu.umb.cs680.hw13.comparators;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;

//import edu.umb.cs680.hw13.fs.FSElement;

public class TimeStampComparator implements Comparator<FSElement> {
	public int compare(FSElement e1, FSElement e2) {
        return e1.getCreationTime().compareTo(e2.getCreationTime());
    }
}
