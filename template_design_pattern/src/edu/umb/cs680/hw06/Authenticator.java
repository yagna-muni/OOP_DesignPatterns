package edu.umb.cs680.hw06;


public class Authenticator {
    public static boolean authenticate(SecurityContext securityContext, EncryptedString password) {
        return true;
    }

    public static boolean authenticateFail(SecurityContext securityContext, EncryptedString password) {
        return false;
    }
}


