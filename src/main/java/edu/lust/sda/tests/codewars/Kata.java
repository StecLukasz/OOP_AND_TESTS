package edu.lust.sda.tests.codewars;

import java.util.Arrays;

public class Kata {
    public static int nthPower(int[] array, int n) {

        return n >= array.length ? -1 : (int) Math.pow(array[n], n);
    }
}
