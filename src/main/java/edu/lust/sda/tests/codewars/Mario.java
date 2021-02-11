package edu.lust.sda.tests.codewars;

public class Mario {
    public static int[] pipeFix(int[] numbers) {
        int max=0;
        int min=numbers[0];
        for (int i=0;i< numbers.length;i++){
            max = Math.max(numbers[i],max);
            min = Math.min(numbers[i],min);
        }
        int wTab = max-min+1;
        int[] tab = new int[wTab];
        for (int i =0;i<tab.length;i++){
            tab[i] = min+i;
        }
        return tab;
    }
}
