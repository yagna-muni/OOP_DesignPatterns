package edu.umb.cs680.hw12;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        int PriceDiff =  (int) (car1.getCarPrice() - car2.getCarPrice());
        return PriceDiff;
    }
}
