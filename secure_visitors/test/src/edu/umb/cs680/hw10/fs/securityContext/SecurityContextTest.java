package edu.umb.cs680.hw10.fs.securityContext;

import edu.umb.cs680.hw10.fs.FileSystem;
import edu.umb.cs680.hw10.fs.util.CountingVisitor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.LoginException;

import static org.junit.jupiter.api.Assertions.*;

class SecurityContextTest {

    public static FileSystem fileSystem;

    @BeforeAll
    static void provisionFileSystem() {
        fileSystem = TextFixture.provisionFileSystem();
    }

    @Test
    void getLinkCountInFileSystem() {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.login(new EncryptedString());
        CountingVisitor visitor = new CountingVisitor();
        try {
            fileSystem.getRootDirectories().getFirst().accept(visitor, ctx);
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
        assertEquals(2, visitor.getLinkNumber());
    }

    @Test
    void getDirectoryCountInFileSystem() {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.login(new EncryptedString());
        CountingVisitor visitor = new CountingVisitor();
        try {
            fileSystem.getRootDirectories().getFirst().accept(visitor, ctx);
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
        assertEquals(5, visitor.getDirNumber());
    }

    @Test
    void TestSecurityForFileSystem() {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.login(new EncryptedString());
        CountingVisitor visitor = new CountingVisitor();
        try {
            fileSystem.getRootDirectories().getFirst().getChildren().getFirst().accept(visitor, ctx);
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }
        assertTrue(ctx.getState() instanceof LoggedIn);
        ctx.logout();
    }

    @Test
    void TestSecurityForFileSystems() throws LoginException {
        SecurityContext ctx = new SecurityContext(new User());
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

    @Test
    void changeState() {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.login(new EncryptedString());
        ctx.changeState(LoggedOut.getInstance(new SecurityContext(new User())));
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

    @AfterAll
    static void killFileSystem() {
        fileSystem = null;
    }

}