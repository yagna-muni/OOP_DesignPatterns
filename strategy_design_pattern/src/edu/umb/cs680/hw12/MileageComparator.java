package edu.umb.cs680.hw12;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        int MileageDiff = car1.getCarMileage() - car2.getCarMileage();
        return MileageDiff;
    }
}
