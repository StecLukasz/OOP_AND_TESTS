package edu.lust.sda.tests.codewars;

public class Sequence {
    public static void main(String[] args) {

        for (int i : reverse(5)) {
            System.out.print(i);
        }

    }

    public static int[] reverse(int n) {
        //your code
        int[] tab = new int[n];
        for (int i = 1; i <= n; i++) {
            tab[i-1] = i;
        }
        int[] tabrev = new int[tab.length];
        for (int i = 0; i < tab.length; i++) {
            tabrev[i] = tab[n - i-1];
        }
        return tabrev;
    }
}
