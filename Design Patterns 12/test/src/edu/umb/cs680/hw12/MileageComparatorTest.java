package edu.umb.cs680.hw12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class MileageComparatorTest {

	@Test
	public void mileagecomparatortest() {
		LinkedList<Car> cars = new LinkedList<>();
		Car car1 = new Car("Benz", "classic", 2005, 25364, 2450);
		Car car2 = new Car("Honda", "CT", 2001, 3553, 3540);
		Car car3 = new Car("Ferrari", "F350", 2008, 56234, 4635);
		Car car4 = new Car("Benz", "E-class", 1995, 62453, 1250);
		
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car4);
		expected.add(car3);
		expected.add(car1);
		expected.add(car2);
		
		Collections.sort(cars,new MileageComparator());
		
		assertEquals(expected,cars);
		
		
		
	}
}
