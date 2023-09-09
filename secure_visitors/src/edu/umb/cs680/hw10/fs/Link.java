package edu.umb.cs680.hw10.fs;

import edu.umb.cs680.hw10.fs.securityContext.SecurityContext;
import edu.umb.cs680.hw10.fs.util.FSVisitor;

import javax.security.auth.login.LoginException;
import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
    }

    public boolean isDirectory() {
        return false;
    }

    public boolean isFile() {
        return false;
    }

    public boolean isLink() {
        return true;
    }

    public FSElement getTarget() {
        return this.target;
    }

    @Override
    public void accept(FSVisitor v, SecurityContext ctx) throws LoginException{
        if (ctx.isActive()) {
            v.visit(this);
        } else {
            System.out.println("Login First!");
        }
    }
}
