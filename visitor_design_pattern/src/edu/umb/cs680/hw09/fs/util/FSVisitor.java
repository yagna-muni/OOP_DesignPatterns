package edu.umb.cs680.hw09.fs.util;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import edu.umb.cs680.hw09.fs.Link;

public interface FSVisitor {
    void visit(Link link);
    void visit(Directory dir);
    void visit(File file);
}
