package edu.umb.cs680.hw07;



import java.time.LocalDateTime;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DirectoryTest {
	Directory root = new Directory(null, "root", LocalDateTime.now());
	
	Directory Apps = new Directory(root, "Apps", LocalDateTime.now());
	File xfile = new File(Apps, "x", 10, LocalDateTime.now());
    File yfile = new File(Apps, "y", 15, LocalDateTime.now());
	
	Directory lib = new Directory(root, "lib", LocalDateTime.now());
	File zfile = new File(lib, "z", 10, LocalDateTime.now());
	
	Directory home = new Directory(root, "home", LocalDateTime.now());
	File dfile = new File(home, "d", 10, LocalDateTime.now());
    Directory code = new Directory(home, "code", LocalDateTime.now());
    File afile = new File(code, "a", 10, LocalDateTime.now());
    File bfile = new File(code, "b", 15, LocalDateTime.now());
    File cfile = new File(code, "c", 20, LocalDateTime.now());
	private String[] dirToStringArray(Directory d){
		String[] dirInfo;
		if(d.getParent() != null) {
			dirInfo = new String[]{d.getName(), ""+d.getTotalSize(), d.getParent().getName()};
		} else {
			dirInfo = new String[]{d.getName(), ""+d.getTotalSize(), null};
		}
		return dirInfo; 
	}
	@Test
	public void verifyDirectoryEqualityRoot(){
		String[] expected = {"root", 90+"", null};
		assertArrayEquals(expected, dirToStringArray(root)); 
	}
	@Test
	public void verifyDirectoryEqualityHome (){ 
		String[] expected = {"home", 55+"", "root"};
		assertArrayEquals(expected, dirToStringArray(home));
	}
}
