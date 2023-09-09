package edu.umb.cs680.hw06.ModelXYZ;

import edu.umb.cs680.hw06.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ScheduledExecutorService;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {
    private static SecurityContext context;
    private static edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor executor;

    @BeforeAll
    public static void initialise() {
        context = new SecurityContext(new User());
        executor = new PrintJobExecutor();
    }

    @Test
    public void doAuthentication() {
        executor.doAuthentication(new EncryptedString(), context);
        assertTrue(context.getState() instanceof LoggedOut);
    }

}