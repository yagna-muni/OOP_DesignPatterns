package edu.umb.cs680.hw06.ModelXYZ;

import edu.umb.cs680.hw06.EncryptedString;
import edu.umb.cs680.hw06.SecurityContext;
import edu.umb.cs680.hw06.User;

import java.awt.*;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor {
    @Override
    protected void doAuthentication(EncryptedString password, SecurityContext context) {

    }

    @Override
    protected void doAuthenticationFail(EncryptedString password, SecurityContext context) {

    }

    @Override
    protected void doAccessControl()  {

    }

    @Override
    protected void doPrint() {
        System.out.println("Print Job from XYZ");

    }

    @Override
    protected void doErrorHandling() {

    }

    public static void main(String[] args) {
        try{
            SecurityContext context = new SecurityContext(new User());
            edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor jobExecutor = new edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor();
            System.out.print("\nThe print Job from ABC without Authentication is: ");
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
        catch (Throwable exception) {
            System.out.println("Execute Job Failure");
        }

    }
}
