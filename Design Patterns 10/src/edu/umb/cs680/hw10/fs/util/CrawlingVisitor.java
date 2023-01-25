package edu.umb.cs680.hw10.fs.util;

import java.util.LinkedList;

import edu.umb.cs680.hw10.fs.Directory;
import edu.umb.cs680.hw10.fs.File;
import edu.umb.cs680.hw10.fs.Link;

public class CrawlingVisitor implements FSVisitor{
	private LinkedList<File> files = new LinkedList<File>();
	private String fileName = "";

    public CrawlingVisitor(String file) {
		// TODO Auto-generated constructor stub
    	this.fileName = file;
	}

	public void visit(Link link) { }

    public void visit(Directory dir) { }

    public void visit(File file) {
    	if(file.getName().equals(fileName)){
    		files.add(file);
    	}
    }

    public LinkedList<File> getFiles() {
        return files;
    }

}
