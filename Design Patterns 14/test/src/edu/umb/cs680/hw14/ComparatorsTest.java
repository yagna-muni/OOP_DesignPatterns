package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import edu.umb.cs680.hw14.Car;


public class ComparatorsTest {
	@Test
	public void yearcomparatortest() {
		LinkedList<Car> cars = new LinkedList<>();
		Car car1 = new Car("Benz", "classic", 2005, 25364, 2450);
		Car car2 = new Car("Honda", "CT", 2001, 3553, 3540);
		Car car3 = new Car("Ferrari", "F350", 2008, 56234, 4635);
		Car car4 = new Car("Benz", "E-class", 1995, 62453, 1250);
		
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		
		
		
		Collections.sort(cars, (c1,c2)->c2.getMileage()-c1.getMileage());
		LinkedList<Car> expectedM = new LinkedList<>();
		expectedM.add(car4);
		expectedM.add(car3);
		expectedM.add(car1);
		expectedM.add(car2);
		assertEquals(expectedM,cars);
		
		Collections.sort(cars, (c1,c2)->(int)(c2.getPrice()-c1.getPrice()));
		LinkedList<Car> expectedP = new LinkedList<>();
		expectedP.add(car3);
		expectedP.add(car2);
		expectedP.add(car1);
		expectedP.add(car4);
		
		assertEquals(expectedP,cars);
		
		Collections.sort(cars, (c1,c2)->c2.getYear()-c1.getYear());
		LinkedList<Car> expectedY = new LinkedList<>();
		expectedY.add(car3);
		expectedY.add(car1);
		expectedY.add(car2);
		expectedY.add(car4);
		assertEquals(expectedY,cars);
		
		Collections.sort(cars, Comparator.comparing((Car c)->c.getPrice())
				.thenComparing((Car c)->c.getMileage())
				.thenComparing((Car c)->c.getYear())
				);
		
		LinkedList<Car> expected = new LinkedList<>();
		expected.add(car4);
		expected.add(car1);
		expected.add(car2);
		expected.add(car3);
		
		
		assertEquals(expected,cars);
		
		
		
	}
}
