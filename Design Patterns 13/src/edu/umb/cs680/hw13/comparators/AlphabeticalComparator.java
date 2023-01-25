package edu.umb.cs680.hw13.comparators;

import java.util.Comparator;

import edu.umb.cs680.hw13.fs.FSElement;

public class AlphabeticalComparator implements Comparator<FSElement> {
    public int compare(FSElement e1, FSElement e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
