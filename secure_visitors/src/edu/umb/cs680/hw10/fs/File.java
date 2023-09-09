package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.securityContext.SecurityContext;
import edu.umb.cs680.hw10.fs.util.FSVisitor;

import javax.security.auth.login.LoginException;
import java.time.LocalDateTime;

public class File extends FSElement {

    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public void accept(FSVisitor v, SecurityContext ctx) throws LoginException {
        if (ctx.isActive()) {
            v.visit(this);
        } else {
            System.out.println("Login First!");
        }
    }
}
