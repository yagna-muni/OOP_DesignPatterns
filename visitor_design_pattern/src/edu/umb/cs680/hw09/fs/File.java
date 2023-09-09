package edu.umb.cs680.hw09.fs;

import edu.umb.cs680.hw09.fs.util.FSVisitor;

import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public void accept(FSVisitor v) {v.visit(this); }
}
