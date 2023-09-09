package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.FileSystem;
import edu.umb.cs680.hw09.fs.util.TextFixture;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingVisitorTest {

    public static FileSystem fileSystem;

    @BeforeAll
    static void provisionFileSystem() {
        fileSystem = TextFixture.provisionFileSystem();
    }

    @Test
    void getLinkCountInFileSystem() {

        CountingVisitor visitor = new CountingVisitor();
        fileSystem.getRootDirectories().getFirst().accept(visitor);
        assertEquals(2, visitor.getLinkNumber());
    }

    @Test
    void getDirectoryCountInFileSystem() {
        CountingVisitor visitor = new CountingVisitor();
        fileSystem.getRootDirectories().getFirst().accept(visitor);
        assertEquals(5, visitor.getDirNumber());
    }

}