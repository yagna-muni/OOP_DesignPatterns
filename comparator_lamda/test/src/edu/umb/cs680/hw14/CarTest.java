package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CarTest {

    private static ArrayList<Car> ownedCar = new ArrayList<>();

    @BeforeAll
    public static void manufactureCars() {
        Car Casper = new Car("Skoda", "Rapid", 18, 2015, 25000);
        Car Sirius = new Car("Nissan", "Micra", 20, 2012, 14000);
        Car Miller = new Car("Honda", "City", 17, 2014, 29000);
        Car Edmunds = new Car("Toyota", "Innova", 9, 2011, 26000);
        Car Gargantua = new Car("Ford", "Raptor", 6, 2018, 35000);

        ownedCar.add(Casper);
        ownedCar.add(Sirius);
        ownedCar.add(Miller);
        ownedCar.add(Edmunds);
        ownedCar.add(Gargantua);

    }

    @Test
    void checkPareToLEComparatorComparing() {
        Collections.sort(ownedCar, Comparator.comparing((Vehicles) -> (Vehicles.getDominationCount()), Comparator.reverseOrder()));
        assertEquals("Micra, Rapid, City, Innova, Raptor", ownedCar.get(0).getCarModel() + ", " +
                ownedCar.get(1).getCarModel() + ", " +
                ownedCar.get(2).getCarModel() + ", " +
                ownedCar.get(3).getCarModel() + ", " +
                ownedCar.get(4).getCarModel());
    }

    @Test
    void checkMileageLEComparator() {
        Collections.sort(ownedCar, (Vehicle1, Vehicle2) -> Vehicle2.getCarMileage()-Vehicle1.getCarMileage());
        assertEquals("Micra, Rapid, City, Innova, Raptor", ownedCar.get(0).getCarModel() + ", " +
                ownedCar.get(1).getCarModel() + ", " +
                ownedCar.get(2).getCarModel() + ", " +
                ownedCar.get(3).getCarModel() + ", " +
                ownedCar.get(4).getCarModel());
    }

    @Test
    void checkPriceLEComparator() {
        Collections.sort(ownedCar, (Vehicle1, Vehicle2) -> (int) (Vehicle2.getCarPrice()-Vehicle1.getCarPrice()));
        assertEquals("Raptor, City, Innova, Rapid, Micra", ownedCar.get(0).getCarModel() + ", " +
                ownedCar.get(1).getCarModel() + ", " +
                ownedCar.get(2).getCarModel() + ", " +
                ownedCar.get(3).getCarModel() + ", " +
                ownedCar.get(4).getCarModel());
    }

    @Test
    void checkYearToLEComparatorComparingInNaturalOrder() {
        Collections.sort(ownedCar, Comparator.comparing((Vehicles) -> (Vehicles.getCarYear()), Comparator.naturalOrder()));
        assertEquals("Innova, Micra, City, Rapid, Raptor", ownedCar.get(0).getCarModel() + ", " +
                ownedCar.get(1).getCarModel() + ", " +
                ownedCar.get(2).getCarModel() + ", " +
                ownedCar.get(3).getCarModel() + ", " +
                ownedCar.get(4).getCarModel());
    }

}