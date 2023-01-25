package edu.umb.cs680.hw00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void multiply5by2() {
        Calculator SC= new Calculator();
        float predicted=10;
        float actual=SC.multiply(5,2);
        assertEquals(predicted,actual);
    }

    @Test
    void divide5by2() {
        Calculator Sc =new Calculator();
        float predicted=2.5F;
        float actual= Sc.divide(5.0f,2.0f);
        assertTrue(predicted==actual);

    }

    @Test
    void divisionwidzero() {
        Calculator SC= new Calculator();
        try{
            SC.divide(5,0);
            fail("division by zero");
        }
        catch(IllegalArgumentException wow){
            assertEquals("division by zero", wow.getMessage());
        }
    }
}