package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SingletonTest {
    @Test
    void notnullchecking(){
        assertNotNull(Single.getInstance());
    }

    @Test
    void sameobjcheck(){
        Single s1= Single.getInstance();
        Single s2=Single.getInstance();
        assertSame(s1,s2);
        assertEquals(s1.hashCode(),s2.hashCode());
    }

}