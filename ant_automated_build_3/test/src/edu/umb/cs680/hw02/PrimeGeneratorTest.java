package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    void getPrimes70to80() {
        PrimeGenerator PG = new PrimeGenerator(70,80);
        PG.generatePrimes();

        LinkedList<Long> PrimeNumbers = new LinkedList<Long>();
        PrimeNumbers.add(71L);
        PrimeNumbers.add(73L);
        PrimeNumbers.add(79L);

        assertEquals(PrimeNumbers, PG.getPrimes());
    }

    @Test
    void getSizeofPrimes() {
        PrimeGenerator PG = new PrimeGenerator(20,200);
        PG.generatePrimes();
        assertTrue(PG.getPrimes().size() == 38);
    }

    @Test
    void isNumberEvenAndPrime() { // Positive testing
        PrimeGenerator PG = new PrimeGenerator(1, 100);
        // Is Even
        assertTrue(PG.isEven(6));
        assertFalse(PG.isEven(7));
        // Is Prime
        assertTrue(PG.isPrime(5));
        assertFalse(PG.isPrime(6));

        System.out.println("Even or Prime test case : Passed");
    }

    @Test
    void CheckFromLessThanTo() {    // Negative Testing
        long FromValue = 100, ToValue = 5;
        try {
            PrimeGenerator PrimeDigits = new PrimeGenerator(FromValue, ToValue);
            fail("Test for From > To : Failed");
        }
        catch (RuntimeException exception) {
            assertEquals("Wrong input values: from="+ FromValue+" to=" + ToValue, exception.getMessage());
        }
    }

    @Test
    void SameFromAndTo(){
        long FromValue = 60, ToValue = 60;
        assertThrows(RuntimeException.class, () -> new PrimeGenerator(FromValue, ToValue) );
    }

    @Test
    void NegativeFromValue() {
        long FromValue = -10, ToValue = 5;
        try {
            PrimeGenerator PG = new PrimeGenerator(FromValue, ToValue);
            fail();
        }
        catch (RuntimeException exception) {
            assertTrue(exception.getMessage().contains("Wrong input values"));
        }
    }

}