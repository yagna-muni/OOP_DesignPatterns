package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import edu.umb.cs680.hw15.fs.Directory;
import edu.umb.cs680.hw15.fs.FSElement;
import edu.umb.cs680.hw15.fs.File;
import org.junit.jupiter.api.Test;


public class ComparatorsTest {
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
	    
	  //Alphabetical sorting using LE
	  		Collections.sort(linkedlist, (fs1,fs2)->fs1.getName().compareTo(fs2.getName()));
		
		LinkedList<FSElement> expected = new LinkedList<>();
		expected.add(afile);
		expected.add(home);
		expected.add(root);
		
		assertEquals(expected,linkedlist);
	}
	@Test
	public void reversealphabeticalcomparatortest() {
		LinkedList<FSElement> linkedlist = new LinkedList<>();
	    linkedlist.add(root);
	    linkedlist.add(home);
	    linkedlist.add(afile);
	  		
	  		//Reverse Alphabetical sorting using LE
	  		Collections.sort(linkedlist, (fs1,fs2)->-1*(fs1.getName().compareTo(fs2.getName())));
		
		LinkedList<FSElement> expected = new LinkedList<>();
		expected.add(root);
		expected.add(home);
		expected.add(afile);
		
		assertEquals(expected,linkedlist);
	}
	
	@Test
	public void timestampcomparatortest() {
		LinkedList<FSElement> linkedlist = new LinkedList<>();
	    linkedlist.add(bfile);
	    linkedlist.add(home);
	    linkedlist.add(afile);
	  		
	  		//TimeStamp sorting using LE
	  		Collections.sort(linkedlist, (fs1,fs2)->fs1.getCreationTime().compareTo(fs2.getCreationTime()));
		
		LinkedList<FSElement> expected = new LinkedList<>();
		expected.add(bfile);
		expected.add(home);
		expected.add(afile);
		
		assertEquals(expected.get(0).getName()+","+expected.get(1).getName()+","+expected.get(2).getName(),linkedlist.get(2).getName()+","+linkedlist.get(0).getName()+","+linkedlist.get(1).getName());
	}
}
