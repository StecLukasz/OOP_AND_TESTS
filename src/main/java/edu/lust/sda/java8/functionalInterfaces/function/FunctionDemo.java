package edu.lust.sda.java8.functionalInterfaces.function;

import edu.lust.sda.java8.Car;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Car familyCar = new Car("Ford SMax", "1.6");
        Car sportCar = new Car("Kia Stinger", "3.0");
        Car volvoCar = new Car("Volvo S90", "2.0");

        /**
         * Fuction przyjmuje obiekt i zwraca inny obiekt
         * */
        Function<Car,String> getEngineOfCar = x -> x.getEngine();
        Function<Car, String> nameUpperCar = x-> x.getName().toUpperCase();


        System.out.println("===========");
        System.out.println(getEngineOfCar.apply(familyCar));
        System.out.println(getEngineOfCar.apply(volvoCar));
        System.out.println(getEngineOfCar.apply(sportCar));
        System.out.println("===========");
        System.out.println(nameUpperCar.apply(sportCar));
        System.out.println("===========");

        Function<Car,Car> upgradeCar = car -> {return new Car(car.getName()+" upgraded", car.getEngine()+" TURBO");
        };

        Car newCar = upgradeCar.apply(sportCar);
        System.out.println("===========");
        System.out.println(newCar);

    }
}
