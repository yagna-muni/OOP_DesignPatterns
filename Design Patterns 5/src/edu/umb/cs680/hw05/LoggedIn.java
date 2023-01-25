package edu.umb.cs680.hw05;

public class LoggedIn
        implements State {
    SecurityContext seccon;

    public LoggedIn(SecurityContext seccon1) {
        this.seccon = seccon1;
    }

    public void login(EncryptedString password) {
        if (seccon.isActive()) {
            seccon.Statechange(new LoggedOut(this.seccon));
            seccon.login(password);
        }}

    public void logout () {
            this.seccon.Statechange(new LoggedOut(this.seccon));
        }

    }



