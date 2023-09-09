package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.comparators.AlphabeticalComparator;
import edu.umb.cs680.hw13.comparators.ReverseAlphabeticalComparator;
import edu.umb.cs680.hw13.comparators.SizeComparator;
import edu.umb.cs680.hw13.comparators.TimestampComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FSElementTest {

    public static FileSystem fileSystem;

    @BeforeAll
    static void provisionFileSystem() {
        fileSystem = TextFixture.provisionFileSystem();
    }

    @Test
    void getAlphabeticalComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirectories().getFirst().getChildren(new AlphabeticalComparator());
        assertEquals("Apps, bin, d, e, home", toBeSortedList.get(0).getName() + ", " +
                        toBeSortedList.get(1).getName() + ", " +
                        toBeSortedList.get(2).getName()+ ", " +
                        toBeSortedList.get(3).getName()+ ", " +
                        toBeSortedList.get(4).getName());

    }

    @Test
    void getReverseAlphabeticalComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirectories().getFirst().getChildren(new ReverseAlphabeticalComparator());
        assertEquals("home, e, d, bin, Apps", toBeSortedList.get(0).getName() + ", " +
                toBeSortedList.get(1).getName() + ", " +
                toBeSortedList.get(2).getName()+ ", " +
                toBeSortedList.get(3).getName()+ ", " +
                toBeSortedList.get(4).getName());

    }

    @Test
    void getSizeComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirectories().getFirst().getSubDirectories().get(2).getSubDirectories().get(0).getChildren(new SizeComparator());
        assertEquals("c, b, a", toBeSortedList.get(0).getName() + ", " +
                toBeSortedList.get(1).getName() + ", " +
                toBeSortedList.get(2).getName());

    }

    @Test
    void getTimeStampComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirectories().getFirst().getChildren(new TimestampComparator());
        assertEquals("Apps, bin, home, d, e", toBeSortedList.get(0).getName() + ", " +
                toBeSortedList.get(1).getName() + ", " +
                toBeSortedList.get(2).getName()+ ", " +
                toBeSortedList.get(3).getName()+ ", " +
                toBeSortedList.get(4).getName());

    }

}