package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    void check_getInstance_notNull() {
        assertNotNull(Singleton.getInstance());
    }

    @Test
    void check_getInstance_return_same() {
        assertEquals(Singleton.getInstance(), Singleton.getInstance());
    }

    @Test
    void check_getInstance_multi_hashCode() {
        assertEquals(Singleton.getInstance().hashCode(), Singleton.getInstance().hashCode());
    }

    @Test
    void check_getInstance_assertSame() {
        assertSame(Singleton.getInstance(), Singleton.getInstance());
    }
}