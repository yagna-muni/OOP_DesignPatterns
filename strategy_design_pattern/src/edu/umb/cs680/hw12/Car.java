package edu.umb.cs680.hw12;

import java.util.ArrayList;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;
    private int dominationCount;

    public Car(String make, String model, int mileage, int year, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public void setDominationCount(ArrayList<Car> cars) {

        for(Car vehicle: cars) {
            if((this.getCarYear() > vehicle.getCarYear() || this.getCarPrice() < vehicle.getCarPrice() || this.getCarMileage() < vehicle.getCarMileage()) &&
                    this.getCarPrice() <= vehicle.getCarPrice() &&
                    this.getCarMileage() <= vehicle.getCarMileage() &&
                    this.getCarYear() >= vehicle.getCarYear()
                     )
            { dominationCount++; }
        }
    }

//    Getter Methods

    public String getCarMake() {
        return make;
    }

    public String getCarModel() {
        return model;
    }

    public int getCarMileage() {
        return mileage;
    }

    public int getCarYear() {
        return year;
    }

    public float getCarPrice() {
        return price;
    }

    // setter

    public String setCarMake() {
        return this.make = make;
    }

    public String setCarModel() {
        return this.model = model;
    }

    public int setCarMileage() {
        return this.mileage =  mileage;
    }

    public int setCarYear() {
        return this.year = year;
    }

    public float setCarPrice() {
        return this.price = price;
    }

    public static void main(String[] args) {

    }


}