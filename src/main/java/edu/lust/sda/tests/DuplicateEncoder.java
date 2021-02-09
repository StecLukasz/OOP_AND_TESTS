package edu.lust.sda.tests;


import java.util.Arrays;

public class DuplicateEncoder {
    public static void main(String[] args) {

        System.out.println(encode("dupaa"));



    }

    static String encode(String word) {
        word = word.toLowerCase();
        char[] tab = word.toCharArray();
        char zam = 0;
        String word2 = "";
        for(int i=0;i<tab.length;i++){
            int pozycja = 0;
            for (int q=0;q<tab.length;q++){
                if (tab[i]==tab[q]){
                    pozycja++;
                    if(pozycja==2){
                        word2+=")";
                        break;
                    }
                }
            }
            if (pozycja==1){
                word2+="(";}
        }
        return word2;
    }
}
