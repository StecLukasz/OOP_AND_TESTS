package edu.lust.sda.tests;
/**
 * String -  wykorzystuje obszar pamieci StringPool, nie podlega niszczeniu przezz GC
 *
 * StringBuilder -  do aplikacji jednowątkowych, szybszy od String Buffera
 * */
public class Units {

    // pierwsza metoda
    public char[] eveyNthChar(char[] sourceArray, int n) {

        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }
        int returnedLength = sourceArray.length / n;
        char[] resultArray = new char[returnedLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            resultArray[index] = sourceArray[i];
            index++;
        }
        return resultArray;
    }

    // druga metoda
    public String removePairs(String source) {
        if (source.length() < 2) {
            return source;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] string = source.toCharArray();
        for (int i = 0; i < string.length - 1; i++) {
            System.out.println(string[i]);
            if (string[i] != string[i + 1]) {
                stringBuilder.append(string[i]);
            }
        }
        System.out.println(string[string.length - 1]);
        stringBuilder.append(string[string.length - 1]);

        return stringBuilder.toString();
    }
}
