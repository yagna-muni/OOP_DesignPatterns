package edu.umb.cs680.hw10.fs;

public class LoggedIn implements State {
	//Implement as singleton class
	private static LoggedIn loggedInInstance = null;

    private SecurityContext ctx;

    public LoggedIn(SecurityContext ctx) {
        this.ctx=ctx;
    }

    public static LoggedIn getInstance()
    {
        if (loggedInInstance == null)
            loggedInInstance = new LoggedIn(new SecurityContext(new User()));
  
        return loggedInInstance;
    }

	@Override
	public State logout() {
		// TODO Auto-generated method stub
		ctx.changeState(new LoggedOut(this.ctx));
		return new LoggedOut(this.ctx);
		
	}
	
	@Override
	public State login(EncryptedString pwd) {
		// TODO Auto-generated method stub
		if ( !ctx.isActive() ){
			ctx.changeState( new LoggedOut(this.ctx));
			ctx.login(pwd);
			}
		return new LoggedIn(ctx);
	}

    
}

