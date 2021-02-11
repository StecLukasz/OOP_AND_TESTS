package edu.lust.sda.tests.codewars;

public class Reversed {

    public static String solution(String str) {
        // Your code here...
        String newWord="";
        char[] tab = str.toCharArray();
        for (int i=tab.length-1;i<=0;i--){
            newWord+=tab[i];
        }

        return newWord;
//        return new StringBuilder(str).reverse().toString(); // stream ze stringbuilderem
    }

}
