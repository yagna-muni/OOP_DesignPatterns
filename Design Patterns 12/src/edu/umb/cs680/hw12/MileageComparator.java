package edu.umb.cs680.hw12;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car>{
	public int compare(Car car1, Car car2){
		int x = car2.getMileage()-car1.getMileage();
		return x;
	}
}
