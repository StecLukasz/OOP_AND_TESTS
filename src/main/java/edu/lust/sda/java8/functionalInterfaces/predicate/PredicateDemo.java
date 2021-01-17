package edu.lust.sda.java8.functionalInterfaces.predicate;

import edu.lust.sda.java8.Car;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Car familyCar = new Car("Ford SMax", "1.6");
        Car sportCar = new Car("Kia Stinger", "3.0");
        Car volvoCar = new Car("Volvo S90", "2.0");

        /**
         * Predykat służy do testowania warunku
         * przyjmuje obiekt, zwraca boolean
         * */
        Predicate<Car> isSmallEngine = x -> x.getEngine().compareTo("2.0") < 0;
        Predicate<Car> isFord = a -> a.getName().startsWith("Ford");

        if (isFord.test(sportCar)){
            System.out.println(sportCar);
        }else{
            System.out.println("To auto nie jest Fordem");
        }
        System.out.println("================");
        printCar(familyCar,isSmallEngine);
        printCar(sportCar,isSmallEngine);
        printCar(sportCar, isFord);
    }

    private static void printCar(Car car, Predicate<Car> condition){
        if(condition.test(car)){
            System.out.println(" Otrzymano: "+ car.getName() + " "+ car.getEngine());
        }
    }
}
