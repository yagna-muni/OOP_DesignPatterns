package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;

import edu.umb.cs680.hw13.fs.Directory;
import edu.umb.cs680.hw13.fs.FSElement;
import edu.umb.cs680.hw13.fs.File;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.comparators.AlphabeticalComparator;



public class AlphabeticalComparatorTest {
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
	public void alphabeticalcomparatortest() {
		LinkedList<FSElement> linkedlist = new LinkedList<>();
	    linkedlist.add(root);
	    linkedlist.add(home);
	    linkedlist.add(afile);
	    
		Collections.sort(linkedlist, new AlphabeticalComparator());
		
		LinkedList<FSElement> expected = new LinkedList<>();
		expected.add(afile);
		expected.add(home);
		expected.add(root);
		
		assertEquals(expected,linkedlist);
		
		
		
	}
}
