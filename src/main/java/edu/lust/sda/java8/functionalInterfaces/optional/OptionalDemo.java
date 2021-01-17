package edu.lust.sda.java8.functionalInterfaces.optional;

import edu.lust.sda.java8.Car;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Car familyCar = new Car("Ford SMax", "1.6");
        Car sportCar = new Car("Kia Stinger", "3.0");
        Car volvoCar = new Car("Volvo S90", "2.0");
        Car unknownCar = null;

        /**
         * Optional jest to kontener na obiety lub opakowanie na obiekt
         * Może być ten obiekt pusty
         * */

        //pusty kontener na obiekt
        Optional<Car> carOptional = Optional.empty();

        //kontener z zawartością
        //metoda .of tworzy optionala i wymaga żeby zawartosć w nim była
        Optional<Car> carOptionalFilled = Optional.of(familyCar);

        //metoda .ofNullable tworzy optionala i dopuszcza pustą zawartość
        Optional<Car> optionalCarNullable = Optional.ofNullable(sportCar);

        Optional<Car> optionaOnUnknown = Optional.ofNullable(unknownCar);



        //przed optionalem
        if (volvoCar==null){
            //coś zrobi
        }
        // po wprowadzeniu optionala
        //iff sprawdza czy zbiór jest pusty czy zawiera jakieś pliki

        if (carOptionalFilled.isPresent()){
            //metoda get wyciąga właściwy obiekt z optionala
            Car weKnowYouAreInThere = carOptionalFilled.get();
            System.out.println(carOptionalFilled.get());
        }

        if (optionaOnUnknown.isEmpty()){
            System.out.println("Tutaj nie ma nic, zbiór pusty");
        }



    }
}
