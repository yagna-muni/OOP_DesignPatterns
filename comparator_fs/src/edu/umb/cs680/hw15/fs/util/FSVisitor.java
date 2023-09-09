package edu.umb.cs680.hw15.fs.util;

import edu.umb.cs680.hw15.fs.Directory;
import edu.umb.cs680.hw15.fs.File;
import edu.umb.cs680.hw15.fs.Link;

public interface FSVisitor {
    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);
}
