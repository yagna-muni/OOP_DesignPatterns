package edu.umb.cs680.hw10;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import edu.umb.cs680.hw10.fs.*;


import edu.umb.cs680.hw10.fs.util.CountingVisitor;
import edu.umb.cs680.hw10.fs.util.CrawlingVisitor;
import org.junit.jupiter.api.Test;

public class SecurityTest {
	FileSystem fs = FileSystem.getFileSystem();
    
    Directory root = new Directory(null, "Root", LocalDateTime.now());
    Directory home = new Directory(root, "home", LocalDateTime.now());
    File file = new File(home, "a.html", 10, LocalDateTime.now());
    File file1 = new File(home, "b.html", 15, LocalDateTime.now());
    File file2 = new File(home, "abc.txt", 20, LocalDateTime.now());
    
    Link link = new Link(root, "d", LocalDateTime.now(), null);
    Link link2 = new Link(root, "d and a.html link", LocalDateTime.now(),file);

    @Test
    public void SecurityContextTest() {
	    SecurityContext ctx = new SecurityContext(new User());
	    ctx.login(new EncryptedString());
	    CountingVisitor visitor = new CountingVisitor("a.html");
    	root.accept(visitor,ctx);
		assertEquals(2, visitor.getDirNum());
	    ctx.logout();
	    CrawlingVisitor visitor1 = new CrawlingVisitor("a.html");
	    
	    root.accept(visitor1, ctx);
	    assertEquals(new LinkedList<File>(), visitor1.getFiles());
	    
    }
}
