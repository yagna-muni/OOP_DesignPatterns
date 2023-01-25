package edu.umb.cs680.hw15.fs;

import java.time.LocalDateTime;

import edu.umb.cs680.hw15.fs.FSElement;
import edu.umb.cs680.hw15.fs.util.FSVisitor;

public class File extends FSElement {
    public File(Directory parentDir, String name, int size, LocalDateTime creationTime) {
        super(parentDir, name, size, creationTime);
    }; 
    public boolean isDirectory() {
        return false;
    }
    public boolean isFile() {
        return true;
    }
    protected void accept(FSVisitor v) {
        v.visit(this);
    }
}
