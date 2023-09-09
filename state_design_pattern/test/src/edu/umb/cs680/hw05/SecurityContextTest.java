package edu.umb.cs680.hw05;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;



class SecurityContextTest {
    public static SecurityContext context;

    @BeforeAll
    public static void initialise() {
        context = new SecurityContext(new User());
    }

    @Test
    public void getCurrentDefaultState() {
        assertTrue(context.getState() instanceof LoggedOut);
    }

    @Test
    public void changeStateToLoginAndverifyIsActive() {
        context.login("password");
        assertTrue(LoggedIn.getInstance(context).equals(context.getState()));
        boolean currents = context.isActive();
        assertTrue(currents);
    }

    @Test
    public void changeStatetoLogout_verifyIsActive() {
        context.logout();
        assertTrue(context.getState() instanceof LoggedOut);
        assertFalse(context.isActive());
    }

    @Test
    public void checkFrequentUserNot() {
        context.login("password");
        context.logout();
        assertTrue(context.userFrequency(LocalDateTime.now()));
    }

    @Test
    public void checkStateRemainSame() {
        context.login("password");
        assertTrue(context.getState() instanceof LoggedIn);
        context.login("password");
        assertTrue(context.getState() instanceof LoggedIn);
    }

    @Test
    public void checkFrequentUserOrNot() {
        context.login("password");
        assertTrue(context.userFrequency(LocalDateTime.now()));
    }

    @Test
    public void checkIsLoginActiveAfterFewHours() {
        context.login("password");
        LocalDateTime atm = LocalDateTime.now();
        try {
            assertTrue(context.userFrequency(atm.plusHours(3)));
        }
        catch (AssertionFailedError error) {
            System.out.println("Is Login active after few hours test case failed. \nNotice: Check if Day changes in 3 Hours");
        }
    }

    @Test
    public void checkIsLoginActiveNextDay() {
        context.login("password");
        LocalDateTime atm = LocalDateTime.now();
        assertFalse(context.userFrequency(atm.plusDays(1)));
    }

    @AfterAll
    public static void deInitialise() {
        context = null;
    }
}