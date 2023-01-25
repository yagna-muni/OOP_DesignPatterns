package edu.umb.cs680.hw06.SecurityCxt;

public class LoggedIn implements State {
    public static LoggedIn InstanceIdOfLogin = null;
    public SecurityContext securityContext = null;
    public LoggedIn(SecurityContext securityContext){
        this.securityContext = securityContext;
    }

    public static LoggedIn getInstance(SecurityContext securityContext){
        if(InstanceIdOfLogin == null) {
            InstanceIdOfLogin = new LoggedIn(securityContext);
            return InstanceIdOfLogin; }
        else return InstanceIdOfLogin;
    }

    public State login(EncryptedString encryptedPassword, boolean result) {
        if(!securityContext.isLoginActive()){
            securityContext.changeState(LoggedOut.getInstance(securityContext));
            securityContext.login(encryptedPassword, result);
            securityContext.loginActive = true;
        }
        return InstanceIdOfLogin;
    }

    public State logout() {
        securityContext.changeState(LoggedOut.getInstance(securityContext));
        securityContext.loginActive = false;
        return InstanceIdOfLogin;
    }
}

