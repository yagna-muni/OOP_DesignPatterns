package edu.umb.cs680.hw12;

import java.util.Comparator;
import java.util.LinkedList;

public class Car {
	private String maker;
	private String model;
	private int mileage, year;
	private float price;
	private int dominationCount;
	
	

	public Car(String maker, String model, int year, int mileage, float price) {
		this.maker = maker;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
	}

	public Car() {
	}

	public String getMaker() {
		return this.maker;
	}

	public String getModel() {
		return this.model;
	}

	public int getMileage() {
		return this.mileage;
	}

	public int getYear() {
		return this.year;
	}

	public double getPrice() {
		return this.price;
	}
	
	public void setDominationCount(LinkedList<Car> cars) {
		for (Car car : cars) {
			
			if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
					&& (car.getYear() <= this.getYear()) && (car.getPrice() > this.getPrice()) || (car.getMileage() > this.getMileage())
					|| (car.getYear() < this.getYear())) {
				dominationCount++;
		    }
		}	
	}
	
	public int getDominationCount() {
		return dominationCount;
	}
	public static void main(String args[]) {
		LinkedList<Car> cars = new LinkedList<>();
		Car car1 = new Car("Benz", "classic", 2005, 25364, 2450);
		Car car2 = new Car("Honda", "CT", 2001, 3553, 3540);
		Car car3 = new Car("Ferrari", "F350", 2008, 56234, 4635);
		Car car4 = new Car("Benz", "E-class", 1995, 62453, 1250);
		
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
	}
}
