package edu.umb.cs680.hw13.comparators;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement fsElement00, FSElement fsElement01) {
        return fsElement00.getName().compareTo(fsElement01.getName());
    }
}
