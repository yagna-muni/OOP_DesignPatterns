package edu.umb.cs680.hw05;

public interface State{
    public State login(String encryptedPassword);
    public State logout();
}

