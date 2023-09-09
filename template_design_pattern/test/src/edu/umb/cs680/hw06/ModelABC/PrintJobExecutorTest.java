package edu.umb.cs680.hw06.ModelABC;

import edu.umb.cs680.hw06.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobExecutorTest {

    private static SecurityContext context;
    private static PrintJobExecutor executor;

    @BeforeAll
    public static void initialise() {
        context = new SecurityContext(new User());
        executor = new PrintJobExecutor();
    }

    @Test
    public void doAuthentication() {
        executor.doAuthentication(new EncryptedString(), context);
        assertTrue(context.getState() instanceof LoggedIn);
    }

    @Test
    public void failedAuthentication() {
        try{
            executor.executeFail(new PrintJob() {
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
            System.out.println("Caught Exception thrown by 'Do Auth' and 'Execute' caught it");
        }
    }


}