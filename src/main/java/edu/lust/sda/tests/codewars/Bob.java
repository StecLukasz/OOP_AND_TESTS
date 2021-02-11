package edu.lust.sda.tests.codewars;

public class Bob {
    public static int enough(int cap, int on, int wait){
        // your code here
        int ludzie=0;
        if (cap>=on+wait){
            return 0;
        }else{
            ludzie=wait+on;
        }
        return ludzie-cap;
    }
}
