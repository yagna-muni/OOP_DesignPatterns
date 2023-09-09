package edu.umb.cs680.hw09.fs;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem thisInstance;
    LinkedList<Directory> rootDirectories = new LinkedList<>();

    public static FileSystem getFileSystem() {
        if(thisInstance == null) {
            thisInstance = new FileSystem();
        }
        return thisInstance;
    }

    public LinkedList<Directory> getRootDirectories() {
        return this.rootDirectories;
    }

    public void appendRootDir(Directory dir){
        this.rootDirectories.add(dir);
    }

    public void clearRootDir() {
        rootDirectories.clear();
    }

    public static void main(String[] args) {

    }
}
