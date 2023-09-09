package edu.umb.cs680.hw04;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;

    public Car(String make, String model, int mileage, int year, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
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

    public static void main(String[] args) {
        Car Casper = new Car("Skoda", "Rapid", 18, 2015, 25000);
        Car Sirius = new Car("Nissan", "Micra", 20, 2012, 14000);

        System.out.println("Casper Car Name: " + Casper.getCarModel());
        System.out.println("Sirius Car Mileage: " + Sirius.getCarMileage());
    }


}
