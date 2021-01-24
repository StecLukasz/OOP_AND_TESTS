package edu.lust.sda.io.basics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteFile {
    public static void main(String[] args) {
        String firstFile = "FirstFile.txt";
        ReadWriteFile readWriteFile = new ReadWriteFile();
//        readWriteFile.simpleWriteToFile(firstFile);
        readWriteFile.simpleReadFromFile(firstFile);
    }
    public void simpleWriteToFile(String filename){
        //try-with-resources
        //wprowadzane w javie7
        //FileWriter czyli "zapisywacz do pliku" - dostępny od początku JAvy
        // do try-with-resources można wrzucić obiekty klas
        // które spełniają interfejs AutoCloseable albo Closeable
        try (FileWriter writer = new FileWriter(filename)) {
            System.out.println("Zapisujemy do pliku" +filename);
            //writer.write realizuje zapis do pliku
            writer.write("Linia pierwsza\n");
            writer.write("Linia druga\n");
            writer.write("Linia trzecia\n");

            //try-with-resources sam zadba o wywołanie metody writer.close();
        }catch (IOException e){
            System.out.println("Błąd przy zapisywaniu pliku");
        }
        System.out.println("koniec zapisywania do pliku");
    }
    public void simpleReadFromFile(String filename){
        try {
            //odczytywacz pliku -FileReader
           FileReader fileReader = new FileReader(filename);
            Scanner scanner = new Scanner(fileReader);
            //określamy jaki będzie znak końca linii
            scanner.useDelimiter("\n");
            System.out.println("Reading from file " + filename);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            //ponieważ nie mamy tu try-witch-resources, to musimy sami zamknąć zasoby
            scanner.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("koniec odczytywania pliku");
    }
}
