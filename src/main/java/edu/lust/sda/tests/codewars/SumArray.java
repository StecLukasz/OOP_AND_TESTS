package edu.lust.sda.tests.codewars;

import java.util.Arrays;

public class SumArray {

    public static double sum(double[] numbers) {

        double suma=0;
        for (int i=0;i< numbers.length;i++){
            suma+=numbers[i];
        }
        return suma;
//        return Arrays.stream(numbers).sum(); // druga metoda zliczania sumy
    }
}
