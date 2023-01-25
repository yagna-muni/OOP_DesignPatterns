package edu.umb.cs680.hw13.comparators;

import java.util.Comparator;

import edu.umb.cs680.hw13.fs.FSElement;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
	public int compare(FSElement e1, FSElement e2) {
        return -1*(e1.getName().compareTo(e2.getName()));
    }
}
