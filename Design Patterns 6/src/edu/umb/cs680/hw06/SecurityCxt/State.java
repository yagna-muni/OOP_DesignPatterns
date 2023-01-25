package edu.umb.cs680.hw06.SecurityCxt;

public interface State{
    public State login(EncryptedString encryptedPassword, boolean result);
    public State logout();
}

