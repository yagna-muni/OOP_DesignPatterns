package edu.umb.cs680.hw10.fs.securityContext;

import edu.umb.cs680.hw10.fs.securityContext.EncryptedString;

public interface State{
    public State login(EncryptedString pwd);
    public State logout();
}

