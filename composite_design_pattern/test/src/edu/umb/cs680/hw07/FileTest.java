package edu.umb.cs680.hw07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    public static FileSystem fileSystem;

    @BeforeAll
    static void initiateFileSystem() {
        fileSystem = TestFixture.provisionFileSystem();
    }

    @Test
    void checkIfZisDirectory() {
        assertFalse(fileSystem.getRootDirectories().getFirst().getSubDirectories().get(1).getChildren().getFirst().isDirectory());
    }

    @Test
    void checkIfLibIsFile() {
        assertFalse(fileSystem.getRootDirectories().getFirst().getSubDirectories().get(1).isFile());
        assertTrue(fileSystem.getRootDirectories().getFirst().getSubDirectories().get(1).getChildren().getFirst().isFile());
    }

    @AfterAll
    static void killFileSystem() {
        fileSystem = null;
    }
}
