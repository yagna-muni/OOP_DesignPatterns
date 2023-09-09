package edu.umb.cs680.hw06.PrintingFramework;

import edu.umb.cs680.hw06.EncryptedString;
import edu.umb.cs680.hw06.SecurityContext;
import edu.umb.cs680.hw06.User;

import java.awt.*;

public class PrintJobExecutor {
    public void execute(PrintJob printJob, EncryptedString password, SecurityContext context) throws Throwable{
        try{
            doAuthentication(password, context);
            doAccessControl();
            doPrint();
        }
        catch (RuntimeException exception){
            doErrorHandling();
            throw exception;
        }
    }

    public void executeFail(PrintJob printJob, EncryptedString password, SecurityContext context) throws Throwable{
        try{
            doAuthenticationFail(password, context);
            doAccessControl();
            doPrint();
        }
        catch (RuntimeException exception){
            doErrorHandling();
            throw exception;
        }
    }

    protected void doAuthentication(EncryptedString password, SecurityContext context) throws RuntimeException{

    }

    protected void doAuthenticationFail(EncryptedString password, SecurityContext context) throws RuntimeException{

    }

    protected void doAccessControl()  {

    }

    protected void doPrint() {

    }

    protected void doErrorHandling() {
        System.out.println("Handled the Exception");
    }

    public static void main(String[] args) throws Throwable {

    }
}
