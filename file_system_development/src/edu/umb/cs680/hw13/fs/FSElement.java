package edu.umb.cs680.hw13.fs;

import edu.umb.cs680.hw13.fs.util.FSVisitor;

import java.time.LocalDateTime;

public abstract class FSElement {
    private Directory parent;
    private String name;
    private int size;
    private LocalDateTime creationTime;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public Directory getParent() {
        return this.parent; // a change done
    }

    public void setParent(Directory parent){
        this.parent = parent;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public abstract boolean isDirectory();
    public abstract boolean isFile();

    public void accept(FSVisitor visitor) {
    }
}
