package edu.lust.sda.tests.codewars;

public class Alphabet {

    public static String position(char alphabet){
        for(int i = 'a'; i <= 'z'; i++){
            if(i == alphabet) {
                return "Position of alphabet: " + (i - 96);
            }
        }
        return "";
    }
}
