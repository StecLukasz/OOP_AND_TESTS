package edu.lust.sda.java8.functionalInterfaces.supplier;

import edu.lust.sda.java8.Car;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {

        Car familyCar =  new Car("Ford Smax", "3.0");

        /**
         * Supplier dostarcza obiekt jak trzeba,
         * czyli przy wywowałniu a nie w momencie wpisania w kodzie
         * */

        //lambda z returnem i nawiasami klamrowymi
        Supplier<Car> sportCar = () -> {return new Car("Ford Mustang GT", "5.0");};

        //lambda bez returna i nawiasó klamrowych
        Supplier<Car> vanCar = () -> new Car("VW Transporter", "2.5");

        System.out.println(sportCar.get());
        System.out.println("===============");

        System.out.println("Auto sportowe: ");
        System.out.println(carInfo(sportCar));
        System.out.println("===============");
        System.out.println("Auto dostawcze: ");
        System.out.println(carInfo(vanCar));
        System.out.println("===============");
    }

    public static String carInfo(Supplier<Car> carToCheck){
        Car passedCar = carToCheck.get();
        return new StringBuilder(passedCar.getName())
                .append(" ")
                .append(passedCar.getEngine())
                .toString();

    }
}
