package edu.umb.cs680.hw12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

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
    void checkPriceComparator() {
        Collections.sort(ownedCar, new PriceComparator());
            assertEquals("Micra, Rapid, Innova, City, Raptor", ownedCar.get(0).getCarModel() + ", " +
                    ownedCar.get(1).getCarModel() + ", " +
                    ownedCar.get(2).getCarModel() + ", " +
                    ownedCar.get(3).getCarModel() + ", " +
                    ownedCar.get(4).getCarModel());
    }

    @Test
    void checkYearComparator() {
        Collections.sort(ownedCar, new YearComparator());
        assertEquals("Innova, Micra, City, Rapid, Raptor", ownedCar.get(0).getCarModel() + ", " +
                ownedCar.get(1).getCarModel() + ", " +
                ownedCar.get(2).getCarModel() + ", " +
                ownedCar.get(3).getCarModel() + ", " +
                ownedCar.get(4).getCarModel());
    }

    @Test
    void checkMileageComparator() {
        Collections.sort(ownedCar, new MileageComparator());
        assertEquals("Raptor, Innova, City, Rapid, Micra", ownedCar.get(0).getCarModel() + ", " +
                ownedCar.get(1).getCarModel() + ", " +
                ownedCar.get(2).getCarModel() + ", " +
                ownedCar.get(3).getCarModel() + ", " +
                ownedCar.get(4).getCarModel());
    }

    @Test
    void checkParetoComparator() {
        Collections.sort(ownedCar, new ParetoComparator());
        assertEquals("Innova, Micra, City, Rapid, Raptor", ownedCar.get(0).getCarModel() + ", " +
                ownedCar.get(1).getCarModel() + ", " +
                ownedCar.get(2).getCarModel() + ", " +
                ownedCar.get(3).getCarModel() + ", " +
                ownedCar.get(4).getCarModel());
    }
}