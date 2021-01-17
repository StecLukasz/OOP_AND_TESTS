package edu.lust.sda.multithreaging.basics;

import static edu.lust.sda.multithreaging.ThreadColor.*;

public class MainThread {
    public static void main(String[] args) {

        /**Kolejnośc działania wątków, a co z tym związane
         * kolejność wyświetlania na ekranie jest nieokreślona
         * */

        System.out.println(ANSI_PURPLE + "Main Thread in action!");

        /**Metoda start powołuje nowy wątek, zapewnia zasoby czasu procesora i pamięc
         * jak wszystko jest gotowe to uruchamia run już w osobnym wątku
         * metoda start nie powinna zawierać kodu użytkowanika*/
        OtherThread otherThread = new OtherThread();
        otherThread.setName("=== Nowy zajefajny wątek ===");
        //zawsze metoda start do uruchamiania wątków
        otherThread.start();
        /**
         * Metoda run
         * zawiera kod do wywołania w osobnym wątku
         * sama nie powoluje watku, jestli zostanie wywołana bez osobnego wątku to tez sie wykona
         * */
//        otherThread.run();

        //uruchomenie wątku z klasy implementującej Runnable
        Thread runnableSample = new Thread(new RunnableSample());
        runnableSample.start();

        //jednorazowa akcja do wykonania w osobnym wątku = na klasie anonimowej
        /**Klasa anonimowa to taka konstrukcja gdzie tworzymy nowy obiekt
         * nie nadając mu nazwy - czli obiekt jest i działa,
         * ale ponieważ nie ma nazwy to nie można isę do niego odnieść,
         * nie da się go znaleźć, więc jest na jednorazowe akcje typu
         * "odpal i zapomnij"
         * */
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Annonymous class can run thread too!");
            }
        }
                .start();

        //przerwanie wątku
//        otherThread.interrupt();

        //łączenie wątków metodą join
        //nadpiszemy (jednorazowo) istniejący kod RunnableSample
        runnableSample = new Thread(new RunnableSample()){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Overwritten RunnableSample working!!");
                try {
                    /**
                     * join powoduje że runnableSample zatrzymuje się i czeka aż otherThread
                     *skończy swoje działanie i dopiero później kontynuuje
                     *
                     * przykład z generowanie raportu do pliku:
                     * runnableSample zapusuje do pliku nagłówek i dane, nagłówek jest znany
                     * a dane są obliczane przez otherThread
                     * runnableSample robi plik i zapisuje nagłówek i czeka aż dostanie dane z otherThread
                     * żeby uzupełnić plik
                     * */
                    otherThread.join();
                    System.out.println(ANSI_RED+ "Nadpisany wątek pracuje, bo tamten skończył!");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "Przerrrrrrrrrrwany wątek RunnableSample :(");
                }
            }
        };
        runnableSample.start();

        System.out.println(ANSI_PURPLE + "End of main thread");
    }
}
