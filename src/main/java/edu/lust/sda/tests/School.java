package edu.lust.sda.tests;

import java.util.Arrays;

public class School{

    public static int getAverage(int[] marks){
        int oceny = 0;
        for (int i=0;i< marks.length;i++){
            oceny+=marks[i];
        }
        oceny=oceny/marks.length;
        Math.floor(oceny);

        return oceny;
    }

}