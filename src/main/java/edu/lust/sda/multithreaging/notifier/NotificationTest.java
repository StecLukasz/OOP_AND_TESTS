package edu.lust.sda.multithreaging.notifier;

public class NotificationTest {
    public static void main(String[] args) {
        Message message = new Message();

        //przy wątkach pamiętamy że nadpisujemy metodę run()
        //ale wątek uruchamaiamy metodą start

        /**
        * każdy z wątków ma własny stos, ale korzystają ze wspólnej sterty pamięci
         *
         *
        * Na stosie odkłada się zmienne lokalne (int, double, char[], short, long)
        * Na stercie odkłada się wszelkie obiekty (w naszym przykladzie Message)
         * Na stercie będą też obiekty typu Integer, Double, Long ... czyli Wrappery
         * czyli obiekt klasy Message jest WSPÓLNY dla wątków Reader i Writer
         *
         *
         * String nie jest odkładany na wspólnej stercie
         * Ma on dedykowany obszar pamięci zwany StringPool
         *
         * */
        (new Thread(new Writer(message))).start(); // anonimowe wywowałenie wątku na klasie Writer

        //jawne wywołanie wątku
        Thread readerThread = new Thread(new Reader(message));
        readerThread.start();


    }
}
