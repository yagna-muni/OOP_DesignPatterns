package edu.umb.cs680.hw07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    private static FileSystem fileSystem;

    @BeforeAll
    static void initiateFileSystem() {
        fileSystem =TestFixture.provisionFileSystem();
    }

    @Test
    void checkFileSystemSingletonOrNot() {
        FileSystem fileSystem1 = FileSystem.getFileSystem();
        FileSystem fileSystem2 = FileSystem.getFileSystem();
        assertEquals(fileSystem1.hashCode(), fileSystem2.hashCode());
    }

    @Test
    void verifyRootDirectoriesEqualityFileSystem(){
        FileSystem fs = new FileSystem();
        Directory test = new Directory(null, "test", 0, LocalDateTime.now());
        fs.appendRootDir(test);
        LinkedList<FSElement> expected = new LinkedList<>();
        expected.add(fs.getRootDirectories().getFirst());
        assertEquals(expected.getFirst(),fs.getRootDirectories().getFirst());
    }

    @Test
    void getRootDirs() {
        assertEquals("Apps", fileSystem.getRootDirectories().getFirst().getSubDirectories().get(0).getName());
    }

    @Test
    void appendRootDirectory() {
        Directory testRoot = new Directory(null, "testRoot", 0, LocalDateTime.of(2022, 10, 24, 02, 20));
        fileSystem.appendRootDir(testRoot);
        assertEquals("testRoot", fileSystem.getRootDirectories().get(1).getName());
    }

    @AfterAll
    static void killFileSystem() {
        fileSystem = null;
    }
}