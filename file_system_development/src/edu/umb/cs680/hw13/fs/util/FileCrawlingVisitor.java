package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSElement;
import edu.umb.cs680.hw13.fs.File;
import edu.umb.cs680.hw13.fs.Link;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class FileCrawlingVisitor implements FSVisitor {

    private LinkedList<File> files = new LinkedList<>();

    @Override
    public void visit(Link link) { }

    @Override
    public void visit(Directory dir) { }

    @Override
    public void visit(File file) { files.add(file); }

    public LinkedList<File> getFiles() { return files; }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator) {
        LinkedList<File> files = getFiles();
        Collections.sort(files, comparator);
        return files;
    }
}
