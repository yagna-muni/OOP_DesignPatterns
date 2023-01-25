package edu.umb.cs680.hw09;



import java.time.LocalDateTime;
import java.util.LinkedList;

import edu.umb.cs680.hw09.fs.Directory;
import edu.umb.cs680.hw09.fs.File;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.fs.util.CrawlingVisitor;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarwlingVisitorTest {
	Directory root = new Directory(null, "root", LocalDateTime.now());
	
	Directory Apps = new Directory(root, "Apps", LocalDateTime.now());
	File xfile = new File(Apps, "a", 10, LocalDateTime.now());
    File yfile = new File(Apps, "y", 15, LocalDateTime.now());
	
	Directory lib = new Directory(root, "lib", LocalDateTime.now());
	File zfile = new File(lib, "z", 10, LocalDateTime.now());
	
	Directory home = new Directory(root, "home", LocalDateTime.now());
	File dfile = new File(home, "d", 10, LocalDateTime.now());
    Directory code = new Directory(home, "code", LocalDateTime.now());
    File afile = new File(code, "a", 10, LocalDateTime.now());
    File bfile = new File(code, "b", 15, LocalDateTime.now());
    File cfile = new File(code, "c", 20, LocalDateTime.now());
    
    @Test
	public void verifyCrawlingVisitor(){
    	CrawlingVisitor visitor = new CrawlingVisitor("b");
        root.accept(visitor);
        LinkedList<File> expected = new LinkedList<>();
        expected.add(bfile);
		assertEquals(expected, visitor.getFiles());
	}
}
