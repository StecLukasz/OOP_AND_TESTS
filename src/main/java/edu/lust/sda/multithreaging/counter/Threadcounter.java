package edu.lust.sda.multithreaging.counter;

public class Threadcounter extends Thread {
    private Counter counter;

    public Threadcounter(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.performCountdown();
    }
}
