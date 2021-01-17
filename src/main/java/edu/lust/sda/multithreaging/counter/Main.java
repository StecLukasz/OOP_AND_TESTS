package edu.lust.sda.multithreaging.counter;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Counter counter2 = new Counter();

        Threadcounter threadcounter1 = new Threadcounter(counter);
        Threadcounter threadcounter2 = new Threadcounter(counter2);
        threadcounter1.setName("Thread1");
        threadcounter2.setName("Thread2");

        threadcounter1.start();
        threadcounter2.start();
    }
}
