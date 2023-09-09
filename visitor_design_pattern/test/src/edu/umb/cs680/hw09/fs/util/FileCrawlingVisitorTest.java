package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileCrawlingVisitorTest {

    public static FileSystem fileSystem;

    @BeforeAll
    static void provisionFileSystem() {
        fileSystem = TextFixture.provisionFileSystem();
    }

    @Test
    void getLinkCountInFileSystem() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        fileSystem.getRootDirectories().getFirst().accept(visitor);
        assertEquals(visitor.getFiles().size(), 5);
    }

}