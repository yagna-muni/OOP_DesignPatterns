package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LinkTest {
    FileSystem fs = FileSystem.getFileSystem();

    Directory root = new Directory(null, "root", LocalDateTime.now());

    Directory Apps = new Directory(root, "Apps", LocalDateTime.now());
    File xfile = new File(Apps, "x", 10, LocalDateTime.now());




    Directory bin = new Directory(root, "lib", LocalDateTime.now());
    File yfile = new File(Apps, "y", 15, LocalDateTime.now());

    Directory home = new Directory(root, "home", LocalDateTime.now());
    Directory pictures = new Directory(home, "pictures", LocalDateTime.now());
    File afile = new File(pictures, "a", 10, LocalDateTime.now());
    File bfile = new File(pictures, "b", 10, LocalDateTime.now());
    File cfile = new File(home, "c", 10, LocalDateTime.now());


    Link link = new Link(root, "d", LocalDateTime.now(), pictures);
    Link link2 = new Link(root, "e", LocalDateTime.now(), xfile);

    @Test
    public void verifyLink(){
        assertEquals("root", link.getParent().getName());
    }

    @Test
    public void verifyLinks(){
        assertEquals("x", link2.getTarget().getName());
    }


}
