package edu.lust.sda.tests.zadaniadomowe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class JakisGostek{

    public static void main(String[] args) {

        KlientBanku jakisGostek = new KlientBanku("Jan","Kowalski",2132,"jedno");
        BankZHajsem santander = new BankZHajsem("Santander", "Lista");
        KontoWBanku konto = new KontoWBanku("Oszczędnościowe",100000,1245965548);

        System.out.print(jakisGostek.getImie()+" ");
        System.out.print(jakisGostek.getNazwisko()+" ");
        System.out.print(jakisGostek.getNumerKlienta()+" ");
        System.out.print(jakisGostek.getListaRachunków()+" ");
        System.out.print(santander.getNazwaBanku()+" ");
        System.out.print(santander.getListaKlientów()+" ");
        System.out.print(konto.getTypKonta()+" ");
        System.out.print(konto.getStanKonta()+" ");
        System.out.print(konto.getNumerRachunku()+" ");
        System.out.println();
        System.out.println("=================");



        // zrobić 3 internejfsy ktore pobierane są do jednego i później zaciaane przez klienta, ktory ma wystwietlac wszystkie dane.




    }
}
