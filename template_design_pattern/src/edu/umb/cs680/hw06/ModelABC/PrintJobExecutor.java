package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw06.*;

import java.awt.*;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor {
    private boolean isActive = false;

    @Override
    protected void doAuthentication(EncryptedString password, SecurityContext context) throws RuntimeException {
        context.login(password);
        if(context.getState() instanceof  LoggedIn)
            isActive = true;
        else {
            throw new RuntimeException("Authentication Failure: Login Failed");
        }
    }

    protected void doAuthenticationFail(EncryptedString password, SecurityContext context) throws RuntimeException {
        context.loginFail(password);
        if(context.getState() instanceof  LoggedIn)
            isActive = true;
        else {
            throw new RuntimeException("Authentication Failure: Login Failed");
        }
    }

    @Override
    protected void doAccessControl()  {

    }

    @Override
    public void doPrint() {
        if(isActive)
            System.out.println("Print Job from ABC");
        else
            System.out.println("Please login to print");
    }

    @Override
    protected void doErrorHandling() {

    }

    public static void main(String[] args) throws Throwable {

        try{
            SecurityContext context = new SecurityContext(new User());
            PrintJobExecutor jobExecutor = new PrintJobExecutor();
            System.out.print("The print Job from ABC after Authentication is: ");
            jobExecutor.execute(new PrintJob() {
                @Override
                public Graphics getGraphics() {
                    return null;
                }

                @Override
                public Dimension getPageDimension() {
                    return null;
                }

                @Override
                public int getPageResolution() {
                    return 0;
                }

                @Override
                public boolean lastPageFirst() {
                    return false;
                }

                @Override
                public void end() {

                }
            }, new EncryptedString(), context);
        }
        catch (RuntimeException exception) {
            System.out.println("Execute Job Failure");
        }

        try{
            SecurityContext context = new SecurityContext(new User());
            PrintJobExecutor jobExecutor = new PrintJobExecutor();
            System.out.print("\nThe Case for Failed Authentication: ");
            jobExecutor.executeFail(new PrintJob() {
                @Override
                public Graphics getGraphics() {
                    return null;
                }

                @Override
                public Dimension getPageDimension() {
                    return null;
                }

                @Override
                public int getPageResolution() {
                    return 0;
                }

                @Override
                public boolean lastPageFirst() {
                    return false;
                }

                @Override
                public void end() {

                }
            }, new EncryptedString(), context);
        }
        catch (RuntimeException exception) {
            System.out.println("Re-thrown exception caught: Caught the Authentication Failure Exception");
        }

    }
}
