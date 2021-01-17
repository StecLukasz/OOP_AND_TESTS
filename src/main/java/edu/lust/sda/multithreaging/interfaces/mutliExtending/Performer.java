package edu.lust.sda.multithreaging.interfaces.mutliExtending;


/**
 * Interfejs, w przeciwieństwie do klasy
 * może rozszerzać wiecej niż jeden interfejs
 * */
public interface Performer extends Worker,Trainer{
    void perform();

}
