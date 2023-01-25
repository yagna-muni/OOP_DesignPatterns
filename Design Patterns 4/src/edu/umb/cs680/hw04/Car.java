package edu.umb.cs680.hw04;

public class Car {
        private String make, model;
        private float price;
        private int mileage, year;

        public Car(String make, String model,int year,int mileage, float price) {
            this.make = make;
            this.model = model;
            this.mileage = mileage;
            this.year = year;
            this.price = price;
        }

//    Getter Methods

        public String Makegett() {
            return this.make;
        }

        public String Modelgett() {
            return this.model;
        }

        public int Mileagegett() {
            return this.mileage;
        }

        public int Yeargett() {
            return this.year;
        }

        public float Pricegett() {
            return this.price;
        }

    public static void main(String[] args) {
        Car benzz= new Car("bmw","amg",2018,15,15000);
    }

//        public static void main(String[] args) {
//            CarClass Soumya =
//                    new CarClass("Ford", "Mustang", 8, 2022, 45000);
//
//            System.out.println("Soumya's Car Model: " + Soumya.Model() + "\n" +
//                    "Soumya's Car Company: " + Soumya.Make() );
}
