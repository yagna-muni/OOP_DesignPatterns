package edu.umb.cs680.hw08;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {
    public static FileSystem fileSystem;

    @BeforeAll
    static void provisionFileSystem() {
        fileSystem = TextFixture.provisionFileSystem();
    }

    @Test
    public void verifyDLinkReturnPictures(){
        Link dLink = (Link) fileSystem.getRootDirectories().getFirst().getChildren().get(3);
        assertEquals("pictures", dLink.getTarget().getName());
    }

    @Test
    public void checkIfELinkIsFile() {
        Link eLink = (Link) fileSystem.getRootDirectories().getLast().getChildren().getLast();
        assertTrue(eLink.getTarget().isFile());
    }

    @Test
    public void isLink() {
        Link eLink = (Link) fileSystem.getRootDirectories().getLast().getChildren().getLast();
        assertTrue(((Link) fileSystem.getRootDirectories().getLast().getChildren().getLast()).isLink());
    }

    @AfterAll
    static void killFileSystem() {
        fileSystem = null;
    }
}