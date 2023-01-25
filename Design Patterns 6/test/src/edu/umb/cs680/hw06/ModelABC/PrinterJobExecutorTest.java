package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw06.SecurityCxt.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrinterJobExecutorTest {
    private static SecurityContext ctx;
    private static edu.umb.cs680.hw06.ModelABC.PrinterJobExecutor exe;
    @BeforeAll
    public static void startof() {
        ctx = new SecurityContext(new User());
        exe = new PrinterJobExecutor();
    }

    @Test
    public void doAuthentication() {
        exe.doAuthentication(new EncryptedString(), ctx, true);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }
}