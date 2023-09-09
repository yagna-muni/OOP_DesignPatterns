package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.FileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FileSearchVisitorTest {

    public static FileSystem fileSystem;

    @BeforeAll
    static void provisionFileSystem() {
        fileSystem = TextFixture.provisionFileSystem();
    }

    @Test
    void getLinkCountInFileSystem() {
        FileSearchVisitor visitor = new FileSearchVisitor("x");
        fileSystem.getRootDirectories().getFirst().accept(visitor);
        assertEquals(visitor.getFoundFiles().size(), 1);
    }


}