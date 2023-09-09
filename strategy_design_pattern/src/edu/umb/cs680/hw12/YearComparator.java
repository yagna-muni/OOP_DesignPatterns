package edu.umb.cs680.hw12;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        int YearDiff = car1.getCarYear() - car2.getCarYear();
        return YearDiff;
    }
}
