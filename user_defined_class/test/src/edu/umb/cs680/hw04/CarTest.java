package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private String[] carToStringArray(Car carInfo) {
        String[] carDetails = {
            carInfo.getCarMake(),
            carInfo.getCarModel(),
            String.valueOf(carInfo.getCarYear())
        };
        return carDetails;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        Car romeosActual = new Car("Toyota","RAV4", 10, 2018, 28000);
        String[] romeosExpected = {"Toyota", "RAV4", "2018"};

        assertArrayEquals(romeosExpected, carToStringArray(romeosActual) );
    }

    @Test
    public void verifyEquality() {
        Car myCarDetails = new Car("Skoda","Rapid Elegance Plus", 22, 2015, 1298000 );
        Car actualCarArray = new Car("Skoda","Rapid Elegance Plus", 22, 2015, 1298000);
        try {
            assertSame(myCarDetails, actualCarArray);
            fail();
        }
        catch (AssertionFailedError error) {
            assertTrue(error.toString().contains("AssertionFailedError"));
        }
    }

}