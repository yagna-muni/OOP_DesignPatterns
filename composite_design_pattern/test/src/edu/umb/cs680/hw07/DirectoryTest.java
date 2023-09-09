package edu.umb.cs680.hw07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    protected static FileSystem fileSystem;

    @BeforeAll
    static void initiateFileSystem() {
        fileSystem = TestFixture.provisionFileSystem();
    }

    @Test
    void isDirectoryOrNot() {
        assertTrue(fileSystem.getRootDirectories().getFirst().getSubDirectories().get(0).isDirectory());
    }

    @Test
    void getChildrenForHomeDirectory() {
        LinkedList<FSElement> children;
        children = fileSystem.getRootDirectories().getFirst().getSubDirectories().get(2).getChildren();
        // Children for Home - 2 Directories: code, file -> Expected: 2
        assertEquals(2,children.size());
    }

    @Test
    void appendChildAlphaForLibDirectory() {
        Directory directory = new Directory(null, "alpha", 5, LocalDateTime.now());
        Directory libDir = fileSystem.getRootDirectories().getFirst().getSubDirectories().get(1);
        libDir.appendChild(directory);
        String Expected = "alpha";
        assertEquals(Expected, libDir.getChildren().getLast().getName());
    }

    @Test
    void getTotalSize() {
        assertEquals(765, fileSystem.getRootDirectories().get(0).getTotalSize());
    }

    @Test
    void countChildrenForCodeDirectory() {
        assertEquals(3, fileSystem.getRootDirectories().getFirst().getSubDirectories().getLast().getSubDirectories().getFirst().countChildren());
    }

    @Test
    void getSubDirectoriesForHomeDirectory() {
        assertEquals(1, fileSystem.getRootDirectories().getFirst().getSubDirectories().getLast().getSubDirectories().size());
    }

    @Test
    void getFilesOfAppsDirectory() {
        Directory apps = fileSystem.getRootDirectories().getFirst().getSubDirectories().getFirst();
        assertEquals(2,apps.getFiles().size());
    }

    @AfterAll
    static void killFileSystem() {
        fileSystem = null;
    }
}