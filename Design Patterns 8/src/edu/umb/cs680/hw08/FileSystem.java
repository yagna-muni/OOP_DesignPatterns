package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

//Singleton class
public class FileSystem {

    private static FileSystem theInstance;
    private LinkedList<Directory> rootDirectories;
    private FileSystem() {
        this.rootDirectories = new LinkedList<Directory>();
    }; 

    public static FileSystem getFileSystem() {
        if (theInstance == null) {
            theInstance = new FileSystem();
        }
        return theInstance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirectories;
    }

    public void appendRootDirectory(Directory dir) {
        this.rootDirectories.add(dir);
        dir.parent = null;
    }

    public static void main(String args[]) {
        FileSystem fs = FileSystem.getFileSystem();
        
        Directory root = new Directory(null, "Root", LocalDateTime.now());
        Directory home = new Directory(root, "home", LocalDateTime.now());
        System.out.println("Is root a directory: "+root.isDirectory());
        File file = new File(home, "a.html", 10, LocalDateTime.now());
        System.out.println("Is a.html a directory: "+file.isDirectory());
        File file1 = new File(home, "b.html", 15, LocalDateTime.now());
        File file2 = new File(home, "abc.txt", 20, LocalDateTime.now());
        System.out.println("Size of root directory: "+root.getTotalSize());
        
        Link link = new Link(root, "d", LocalDateTime.now(), null);
        Link link2 = new Link(root, "d and a.html link", LocalDateTime.now(), file);
        
    }
}