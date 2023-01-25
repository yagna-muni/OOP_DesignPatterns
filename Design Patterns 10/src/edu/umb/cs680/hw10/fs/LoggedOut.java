package edu.umb.cs680.hw10.fs;

public class LoggedOut implements State {
	//Implement as singleton class
	private static LoggedOut loggedoutInstance = null;

    private SecurityContext ctx;

    public LoggedOut(SecurityContext ctx) {
        this.ctx=ctx;
    }

    public static LoggedOut getInstance()
    {
        if (loggedoutInstance == null)
            loggedoutInstance = new LoggedOut(new SecurityContext(new User()));
  
        return loggedoutInstance;
    }

	@Override
    public State login(EncryptedString pwd) {
        if (Authenticator.authenticate(this.ctx,pwd)) {
        	this.ctx.changeState(new LoggedIn(ctx));
        }
        else{
            //auth error handling
            System.out.println("auth error handling");
        }        
        return ctx.getState();
    }

    @Override
    public State logout() {
        return new LoggedOut(this.ctx);
    }

    
}
