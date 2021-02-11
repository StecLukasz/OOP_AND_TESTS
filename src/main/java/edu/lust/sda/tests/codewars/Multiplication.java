package edu.lust.sda.tests.codewars;

public class Multiplication {
    public static String multiTable(int num) {

        int[] tab=new int[10];
        for (int i=0;i<10;i++){
            tab[i]=i+1;
        }
        String wynik ="";
        for (int i=0;i<10;i++){
            wynik+=tab[i]+" * "+num+" = "+tab[i]*num+"\n";
        }
        return wynik.trim();
        // good luck

//        return IntStream.rangeClosed(1, 10)
//                .mapToObj(i -> i + " * " + num + " = " + i * num)
//                .collect(Collectors.joining("\n"));
    }
}
