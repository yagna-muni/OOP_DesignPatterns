package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SecurityContextTest {

    @Test
    void check1()
    {
        SecurityContext ctx = new SecurityContext(new User());
        assertTrue(ctx.Stateget() instanceof LoggedOut);
    }

    @Test
    void check2()
    {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.login(new EncryptedString());
        assertTrue(ctx.Stateget() instanceof LoggedIn);

    }

    @Test
    void falsetest()
    {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.login(new EncryptedString());
        assertTrue(ctx.Stateget() instanceof  LoggedIn);

    }

    @Test
    void falsetedst()
    {
        SecurityContext ctx = new SecurityContext(new User());
        ctx.logout();
        assertTrue(ctx.Stateget() instanceof  LoggedOut);

    }



}