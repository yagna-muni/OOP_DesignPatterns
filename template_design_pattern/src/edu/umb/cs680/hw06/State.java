package edu.umb.cs680.hw06;

public interface State{
    public State login(EncryptedString password);
    public State logout();
    public State loginFail(EncryptedString password);
}

