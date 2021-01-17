package edu.lust.sda.multithreaging.counter;

import static edu.lust.sda.multithreaging.ThreadColor.*;

public class Counter {
    private int i;

    public void performCountdown() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "Thread1":
                color = ANSI_CYAN;
                break;
            case "Thread2":
                color = ANSI_PURPLE;
                break;
            default:
                color = ANSI_GREEN;
        }
        /**
         * kod zadeklarowany jako synchronized musi bsię
         * w całości wykonać dla jednego wątku i dopiero później inny wątek
         * może zaczać wykonywa ten sam kawałek kodu dla siebie
         *
         * */
//        synchronized (this) {
            doRealCountdown(color);
//        }
    }

//    private synchronized void doRealCountdown(String color) {
    private  void doRealCountdown(String color) {
        for (i=10;i>0;i--){
            System.out.println(color+Thread.currentThread().getName()+ " i="+i);
        }
    }
}
