package edu.lust.sda.java8.lambdas;

public class LambdaMnozenie {

    public static void main(String[] args) {

        IntMultiplication multi = (a,b)-> a*b;
        System.out.println("=============");
        System.out.println("Testing another method");
        System.out.println(multi.multiply(12, 4));

    }

}
