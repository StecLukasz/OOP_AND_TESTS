package edu.lust.sda.tests;

public class CharProblem {
    public static int howOld(final String herOld) {

        //your code here, return correct age as int ; )

        return Character.getNumericValue(herOld.charAt(0));
//    return herOld.toString().subSequence("1","9");
    }
}