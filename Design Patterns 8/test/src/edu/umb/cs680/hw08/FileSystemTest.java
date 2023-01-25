package edu.umb.cs680.hw08;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class FileSystemTest {
    Directory root = new Directory(null, "root", LocalDateTime.now());

    Directory Apps = new Directory(root, "Apps", LocalDateTime.now());
    File xfile = new File(Apps, "x", 10, LocalDateTime.now());
    File yfile = new File(Apps, "y", 15, LocalDateTime.now());

    Directory lib = new Directory(root, "lib", LocalDateTime.now());
    File zfile = new File(lib, "z", 10, LocalDateTime.now());

    Directory home = new Directory(root, "home", LocalDateTime.now());
    File dfile = new File(home, "d", 10, LocalDateTime.now());
    Directory code = new Directory(home, "code", LocalDateTime.now());
    File afile = new File(code, "a", 10, LocalDateTime.now());
    File bfile = new File(code, "b", 15, LocalDateTime.now());
    File cfile = new File(code, "c", 20, LocalDateTime.now());

    @Test
    public void verifyRootDirectoriesEqualityFS(){
        FileSystem fs = FileSystem.getFileSystem();
        fs.appendRootDirectory(root);
        LinkedList<Directory> expected = new LinkedList<>();
        expected.add(root);
        assertEquals(expected, fs.getRootDirs());
    }
}
