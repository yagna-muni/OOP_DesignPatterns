package edu.umb.cs680.hw10.fs;

public class SecurityContext{
	State state;

	public SecurityContext(User user) {
		// TODO Auto-generated constructor stub
		this.state = new LoggedOut(this);
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		if(this.state instanceof LoggedIn)
			return true;
		return false;
	}

	public void changeState(State newState) {
		
		// TODO Auto-generated method stub
		this.state = newState;
		
	}

	public boolean login(EncryptedString pwd) {
		// TODO Auto-generated method stub
		this.state.login(pwd);
		if(this.state instanceof LoggedIn) 
			return true;
		return false;
	}

	public void logout() {
		// TODO Auto-generated method stub
		this.state.logout();
	}

	public State getState() {
		// TODO Auto-generated method stub
		return this.state;
	}
	
	public static void main(String args[]) {
		
	}

}
