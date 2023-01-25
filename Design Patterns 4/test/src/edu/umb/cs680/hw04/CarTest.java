package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private String[] carToStringArray(Car car_1) {
        var variable1= String.valueOf(car_1.Yeargett());
        String[] value1 = new String[]{car_1.Makegett(), car_1.Modelgett(), variable1};
        return value1;
    }

    @Test
    void VerifyCarEqualityWithMakeModelYear() {

        String[] expected_value;
        expected_value= new String[]{"Toyota", "RAV8", "2018"};
        Car actual_value = new Car("Toyota", "RAV8", 2018, 12, 3000);
        assertArrayEquals(expected_value, carToStringArray(actual_value));
    }
}