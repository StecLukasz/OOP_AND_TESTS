package edu.lust.sda.multithreaging.basics;

import static edu.lust.sda.multithreaging.ThreadColor.ANSI_RED;

public class RunnableSample implements Runnable{

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Runnabble sample working as well!");
    }
}
