package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.util.FSVisitor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {


    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    private LinkedList<FSElement> childrenList = new LinkedList<>();

//    public LinkedList<FSElement> getChildren() {
//        return this.childrenList;
//    }

    public void appendChild(FSElement appendChild) {
        this.childrenList.add(appendChild);
    }

    public int countChildren() {
        return this.childrenList.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDirs = new LinkedList<>();

        for (FSElement checkSubDirs: this.childrenList){
            if(checkSubDirs.isDirectory() == true) subDirs.add((Directory) checkSubDirs);
        }

        return  subDirs;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();

        for(FSElement checkFiles: this.childrenList){
            if(checkFiles.isFile() == true) files.add((File) checkFiles);
        }

        return files;
    }

    public int getTotalSize() {
        int fileSum = getFiles().stream().mapToInt(f->f.getSize()).sum();
        int dirSum = getSubDirectories().stream().mapToInt(d->d.getTotalSize()).sum();
        return fileSum + dirSum + this.getSize();
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for(FSElement e:childrenList) {
            e.accept(v);
        }
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator) {
        Collections.sort(this.childrenList, comparator);
        return this.childrenList;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        LinkedList<Directory> subDirectories = getSubDirectories();
        Collections.sort(this.childrenList, comparator);
        return subDirectories;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator) {
        LinkedList<File> files = getFiles();
        Collections.sort(files, comparator);
        return files;
    }
}
