package edu.lust.sda.multithreaging.basics;

import static edu.lust.sda.multithreaging.ThreadColor.ANSI_BLUE;

/**
 * jak klasa rozszerza Thread to można ją odpalać jako osobny wątek*/
public class OtherThread extends Thread {


    @Override
    public void run() {
    // tu należy dać kod do wywołania w osobnym wątku
        System.out.println(ANSI_BLUE + "Other thread in action");

        System.out.println(ANSI_BLUE+currentThread().getName());

        try {
            sleep(4000);
            System.out.println(ANSI_BLUE + "Enough sleeping, back to work");
        } catch (InterruptedException e) {
            // w wyjątku może być przerwanie i jakiś komunikat tak jak niżej, a nie musi być to e.cośtam
            System.out.println(ANSI_BLUE + "I couldn't sleep enough, interrupted!");
        }
    }
}
