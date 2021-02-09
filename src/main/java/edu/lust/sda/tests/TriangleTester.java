package edu.lust.sda.tests;

class TriangleTester {
    int a;
    int b;
    int c;

    public static boolean isTriangle(int a, int b, int c) {

        if (a + b > c && a + c > b && b + c > a) {
            return true;
        } else {
            return false;
        }
    }
}
