package edu.lust.sda.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReadWriteFileNIO {
    /**
     * NIO używa wielowątkowości
     * pozwala na operację na plikach w tle
     * z jednoczesnym realizowaniem w innych operacji w programi
     *
     *
     * */

    public static void main(String[] args) {
        ReadWriteFileNIO readWriteFileNIO = new ReadWriteFileNIO();
        String filename = "NIOFile.txt";

        try {
            readWriteFileNIO.simpleWriteToFile(filename);
            readWriteFileNIO.simpleReadFromFile(filename);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd");
        }
    }
    public void simpleWriteToFile(String filename) throws IOException {
        System.out.println("Początek zapisu do pliku");
        Files.writeString(Paths.get(filename),"FirstLine");
        Files.writeString(Paths.get(filename),"\nSecondLine", StandardOpenOption.APPEND);
        Files.writeString(Paths.get(filename),"\nThirdLine",StandardOpenOption.APPEND);
        System.out.println("Koniec zapisu do pliku");
    }

    public void simpleReadFromFile(String filename) throws IOException{
        List<String> filecontent;
        System.out.println("Odczyt z pliku");
        filecontent = Files.readAllLines(Paths.get(filename));
        filecontent.forEach(System.out::println);
        System.out.println("Koniec odczytu z pliku");
    }
}
