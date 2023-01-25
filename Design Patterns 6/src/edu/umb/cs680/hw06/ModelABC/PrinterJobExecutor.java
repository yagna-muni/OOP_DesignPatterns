package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw06.SecurityCxt.*;

import java.awt.*;

public class PrinterJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrinterJobExecutor {
    boolean loginState = false;

    @Override
    protected void doAuthentication(EncryptedString encryptedString, SecurityContext context, boolean result) throws RuntimeException {
        context.login(encryptedString, result);
        if(context.getState() instanceof LoggedIn) loginState = true;
        else {
            throw new RuntimeException("Auth Fail");
        }
    }

    @Override
    protected void doAccessControl()  { }

    @Override
    public void doPrint() {
        if(loginState == true) System.out.println("The printer job executed from printer: ABC"); }

    @Override
    protected void doErrorHandling() { }

    public static void main(String[] args) throws Throwable{

    }
}
