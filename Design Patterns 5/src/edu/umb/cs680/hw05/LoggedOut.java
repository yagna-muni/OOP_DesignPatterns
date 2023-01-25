package edu.umb.cs680.hw05;

public class LoggedOut implements State{
    SecurityContext ct;

    public LoggedOut(SecurityContext ct){
        this.ct = ct;
    };

    public void logout(){

    }
    public void login(EncryptedString pcode){
        if (Authenticator.authenticate(this.ct, pcode)){
            ct.Statechange(new LoggedIn(this.ct));
        }
        else{
            System.out.println("failed");
        }
    }
}
