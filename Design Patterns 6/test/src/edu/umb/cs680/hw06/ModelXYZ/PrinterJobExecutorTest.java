package edu.umb.cs680.hw06.ModelXYZ;

import edu.umb.cs680.hw06.ModelABC.PrinterJobExecutor;
import edu.umb.cs680.hw06.SecurityCxt.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterJobExecutorTest {

    @Test
    public void doPrintWithoutAuthentication() {
        SecurityContext ctx = new SecurityContext(new User());
        edu.umb.cs680.hw06.ModelXYZ.PrinterJobExecutor exe = new edu.umb.cs680.hw06.ModelXYZ.PrinterJobExecutor();

        try {
            exe.doPrint();
            exe.execute(new String(), new EncryptedString(), ctx, true);
            assertTrue(ctx.getState() instanceof LoggedOut);
        } catch (Throwable e) {
            System.out.println("Exception rethrowed caught");
        }
    }

}