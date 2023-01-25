package edu.umb.cs680.hw06.ModelXYZ;

import edu.umb.cs680.hw06.SecurityCxt.*;

import java.awt.*;

public class PrinterJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrinterJobExecutor {
    @Override
    protected void doAuthentication(EncryptedString encryptedString, SecurityContext context, boolean result) { }

    @Override
    protected void doAccessControl()  { }

    @Override
    protected void doPrint() { System.out.println("Print from XYZ"); }

    @Override
    protected void doErrorHandling() { }

    public static void main(String[] args) {

    }
}
