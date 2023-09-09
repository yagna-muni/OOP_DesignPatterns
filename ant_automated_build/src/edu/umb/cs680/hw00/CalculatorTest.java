package edu.umb.cs680.hw00;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void MultiplicationTest() {
        float ExpectedDigit = 6;
        Calculator Calcy = new Calculator();
        assertEquals(ExpectedDigit, Calcy.multiply(3, 2));
    }

    @Test
    void MultiplyNegativeValues() {
        float AnticipatedValue =45;
        Calculator Calcy = new Calculator();
        float TrueValue = Calcy.multiply(-9, -5);
        assertEquals(AnticipatedValue, TrueValue);
    }

    @Test
    void TestDivison() {
        float ExpectedValue = 4;
        Calculator Calcy = new Calculator();
        assertEquals(ExpectedValue, Calcy.divide(20, 5));
        assertNotEquals(10, Calcy.divide(100, 9));
    }

    @Test
    void ObjectNotNulltest() {
        Calculator Calcy = new Calculator();
        assertNotNull(Calcy);
    }

    @Test
    void DivisionbyZero() {
        try {
            Calculator Calcy = new Calculator();
            Calcy.divide(26, 0);
            fail("Cannot Divide by Zero test case: Failed");
        } catch (IllegalArgumentException exception) {
            assertTrue(exception.getMessage().contains("division by zero"));
            System.out.println("Division by Zero test case: Passed");
        }
    }

}