package edu.umb.cs680.hw13.comparators;

import edu.umb.cs680.hw13.fs.FSElement;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement fsElement00, FSElement fsElement01) {
        return -1*(fsElement00.getName().compareTo(fsElement01.getName()));
    }
}
