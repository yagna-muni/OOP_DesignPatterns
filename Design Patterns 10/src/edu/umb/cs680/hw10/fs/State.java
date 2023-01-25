package edu.umb.cs680.hw10.fs;

public interface State {

	State logout();

	State login(EncryptedString pwd) ;


}
