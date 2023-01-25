package edu.umb.cs680.hw06.PrintingFramework;

import edu.umb.cs680.hw06.SecurityCxt.*;

public class PrinterJobExecutor {
    public void execute(String printJob, EncryptedString password, SecurityContext context, boolean result) throws Throwable{
        try{
            doAuthentication(password, context, result);
        }
        catch (RuntimeException exception){
            doErrorHandling();
            throw exception;
        }

        doAccessControl();
        doPrint();
    }

    public void executeFail(String printerJob, EncryptedString password, SecurityContext context, boolean result) throws Throwable{
        try{
            doAuthenticationFail(password, context, result);
        }
        catch (RuntimeException exception){
            doErrorHandling();
            throw exception;
        }

        doAccessControl();
        doPrint();
    }

    protected void doAuthentication(EncryptedString password, SecurityContext context, boolean result) throws RuntimeException{ }

    protected void doAuthenticationFail(EncryptedString password, SecurityContext context, boolean result) throws RuntimeException{ }

    protected void doAccessControl()  { }

    protected void doPrint() { }

    protected void doErrorHandling() { }

    public static void main(String[] args) throws Throwable{

    }
}