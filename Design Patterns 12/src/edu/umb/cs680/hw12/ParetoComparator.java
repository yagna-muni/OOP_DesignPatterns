package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car>{
	public int compare(Car c1, Car c2) {
        int priceComparision = new PriceComparator().compare(c1, c2);
        if (priceComparision == 0) {
        	int yearComparision = new YearComparator().compare(c1, c2);
        	if(yearComparision == 0) {
        		return (new MileageComparator().compare(c1, c2));
        	}
        	else {
        		return yearComparision;
        	}
        } else {
            return priceComparision;
        }
    }

}
