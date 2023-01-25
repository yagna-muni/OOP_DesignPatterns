package edu.umb.cs680.hw06.SecurityCxt;

public class LoggedOut implements State {
    public static LoggedOut InstanceIDLogOut = null;
    public SecurityContext securityContext = null;

    public LoggedOut(SecurityContext securityContext){
        this.securityContext = securityContext;
    }

    public static LoggedOut getInstance(SecurityContext securityContext){
        if(InstanceIDLogOut == null){
            InstanceIDLogOut = new LoggedOut(securityContext);
            return InstanceIDLogOut;
        }
        else return InstanceIDLogOut;
    }

    public State login(EncryptedString encryptedPassword, boolean result) {
        if (Authenticator.authenticate(securityContext, encryptedPassword, result)) {
            securityContext.changeState(LoggedIn.getInstance(securityContext));
        }
        return InstanceIDLogOut;
    }

    public State logout() {
        securityContext.loginActive = false;
        return InstanceIDLogOut;
    }
}
