package edu.umb.cs680.hw10.fs.securityContext;

import edu.umb.cs680.hw10.fs.securityContext.EncryptedString;

public class LoggedIn implements State {
    public static LoggedIn logInInstance = null;
    public SecurityContext securityContext = null;

    public LoggedIn(SecurityContext securityContext){
        this.securityContext = securityContext;
    }

    public static LoggedIn getInstance(SecurityContext securityContext){
        if(logInInstance == null){
            logInInstance = new LoggedIn(securityContext);
        }
        return logInInstance;
    }

    public State login(EncryptedString pwd) {
        if(!securityContext.isActive()){
            securityContext.changeState(LoggedOut.getInstance(securityContext));
            securityContext.login(pwd);
            securityContext.isActive = true;
        }
        return logInInstance;
    }

    public State logout() {
        securityContext.changeState(LoggedOut.getInstance(securityContext));
        securityContext.isActive = false;
        return logInInstance;
    }
}

