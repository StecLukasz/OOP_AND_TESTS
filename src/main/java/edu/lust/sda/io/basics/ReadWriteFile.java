package edu.lust.sda.io.basics;

import java.io.*;
import java.util.Scanner;

public class ReadWriteFile {
    public static void main(String[] args) {
        String firstFile = "FirstFile.txt";
        String secondFile = "SecondFile.txt";
        ReadWriteFile readWriteFile = new ReadWriteFile();
        //FileReader i FileWriter można używać do zapisywania / odczytywania neiewielkich
        //plików - max np. 1000 linii
        //bo one działają w tym samym wątku co główny program
        //więc mogą zablokować możliwość korzystania z innych opcji
        //dodatkowo wynojuą bezpośrednio operację zapisu i odczytu
//        readWriteFile.simpleWriteToFile(firstFile, true);// zapis do pliku
//        readWriteFile.simpleReadFromFile(firstFile);// odczyt z pliku w konsoli
        //-----------------------------------------
        readWriteFile.writeFileWithBuffer(secondFile, true);
        readWriteFile.readWithBuffer(secondFile+true);

    }
    public void simpleWriteToFile(String filename, boolean append){
        //try-with-resources
        //wprowadzane w javie7
        //FileWriter czyli "zapisywacz do pliku" - dostępny od początku JAvy
        // do try-with-resources można wrzucić obiekty klas
        // które spełniają interfejs AutoCloseable albo Closeable
        try (FileWriter writer = new FileWriter(filename, append)) {
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
        System.out.println("Koniec odczytywania pliku");
    }
    public void writeFileWithBuffer(String filename, boolean append){
        try{
            /**
             * Buffered podowuje ze zapis następuje napierw do miejsca
             * w pamięci zwanego buforem a dopiero jak bufor się przepełni
             * (albo wszystko zostanie zapisane)  to następuje większy zapis
             * do pliku - dużej ilości danych a nie znak po znaku
             * */
            System.out.println("Początek zapisu do pliku z buforem");
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append));
            writer.write("Buffered FirstLine\n");
            writer.write("Buffered SecondLine\n");
            writer.write("Buffered ThirdLine\n");
            writer.close();
        }catch (IOException e){
            System.out.println("Błąd zapisu pliku");
        }
        System.out.println("Koniec zapisu do pliku z buforem");
    }

    public  void readWithBuffer(String filename){
        String input;
        System.out.println("Zaczynamy odczyt z pliku z buforowaniem");
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            while ((input = reader.readLine()) != null){
                System.out.println(input);
            }
        }catch (FileNotFoundException e){
            System.out.println("Pliku nie znaleziono");
        }catch (IOException e){
            System.out.println("Inny błąd IO");
        }
        System.out.println("Koniec odczytu pliku z buforowaniem");
    }
}
