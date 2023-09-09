package edu.umb.cs680.hw15.fs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComparatorsTest {
    public static FileSystem fileSystem;

    @BeforeAll
    static void provisionFileSystem() {
        fileSystem = TextFixture.provisionFileSystem();
    }

    @Test
    void getAlphabeticalComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirectories().getFirst().getChildren();
        Collections.sort(toBeSortedList, (fileSystem1, fileSystem2) -> fileSystem1.getName().compareTo(fileSystem2.getName()));
        assertEquals("Apps, bin, d, e, home", toBeSortedList.get(0).getName() + ", " +
                toBeSortedList.get(1).getName() + ", " +
                toBeSortedList.get(2).getName()+ ", " +
                toBeSortedList.get(3).getName()+ ", " +
                toBeSortedList.get(4).getName());

    }

    @Test
    void getCreationTimeComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirectories().getFirst().getChildren();
        Collections.sort(toBeSortedList, (fileSystem1, fileSystem2) -> (fileSystem1.getCreationTime().compareTo(fileSystem2.getCreationTime())));
        assertEquals("Apps, bin, home, d, e", toBeSortedList.get(0).getName() + ", " +
                toBeSortedList.get(1).getName() + ", " +
                toBeSortedList.get(2).getName()+ ", " +
                toBeSortedList.get(3).getName()+ ", " +
                toBeSortedList.get(4).getName());

    }

    @Test
    void getReverseAlphabeticalComparator() {
        LinkedList<FSElement> toBeSortedList;
        toBeSortedList = fileSystem.getRootDirectories().getFirst().getChildren();
        Collections.sort(toBeSortedList, (fileSystem1, fileSystem2) -> -1*(fileSystem1.getName().compareTo(fileSystem2.getName())));
        assertEquals("home, e, d, bin, Apps", toBeSortedList.get(0).getName() + ", " +
                toBeSortedList.get(1).getName() + ", " +
                toBeSortedList.get(2).getName()+ ", " +
                toBeSortedList.get(3).getName()+ ", " +
                toBeSortedList.get(4).getName());

    }


}