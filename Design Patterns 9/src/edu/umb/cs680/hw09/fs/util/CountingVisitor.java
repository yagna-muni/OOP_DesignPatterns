package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;

public class CountingVisitor implements FSVisitor{
	private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;
    private String fileName = "";

    public CountingVisitor(String file) {
		// TODO Auto-generated constructor stub
    	this.fileName = file;
	}

	public void visit(Link link) {
        linkNum++;
    }

    public void visit(Directory dir) {
        dirNum++;
    }

    public void visit(File file) {
        fileNum++;
    }

    public int getDirNum() {
        return dirNum;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getLinkNum() {
        return linkNum;
    }
}
