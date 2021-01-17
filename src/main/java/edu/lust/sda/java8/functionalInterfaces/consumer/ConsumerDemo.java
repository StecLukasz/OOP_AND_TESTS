package edu.lust.sda.java8.functionalInterfaces.consumer;

import edu.lust.sda.java8.Car;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {

        Car sportCar = new Car("Porshe 911", "5.0");
        Car familyCar = new Car("Volvo S90", "2.0");

        /**
         * Consumer jako parametr przyjmuje obiekt
         * wykonuje jakieś działanie
         * i nic nie zwraca
         * */
        Consumer<Car> printCarMark = (car) -> {
            System.out.println("Printing car's mark for " + car.getName());
            System.out.println(car.getName().substring(0, car.getName().indexOf(" ")));
        };

        Consumer<Car> printCarInfoNoSpaces = car ->{
            System.out.println(car.getName().replaceAll(" ", "") + car.getEngine().replaceAll(" ", ""));
        };

        printCarMark.accept(sportCar);
        printCarMark.accept(familyCar);

        printCarInfoNoSpaces.accept(sportCar);

        System.out.println("Sout jest consumerem, nie wsprost ale z uwagi na spsób działania na pewno");
    }
}
