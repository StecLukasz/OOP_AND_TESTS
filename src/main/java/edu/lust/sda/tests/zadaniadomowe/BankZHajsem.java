package edu.lust.sda.tests.zadaniadomowe;

import java.util.ArrayList;
import java.util.HashMap;

public class BankZHajsem {

    public BankZHajsem(String nazwaBanku, String listaKlientów) {
        this.nazwaBanku = nazwaBanku;
        this.listaKlientów = listaKlientów;
    }

    private String nazwaBanku;
    private String listaKlientów;

    public String getNazwaBanku() {
        return nazwaBanku;
    }
    public void setNazwaBanku(String nazwaBanku) {
        this.nazwaBanku = nazwaBanku;
    }
    public String getListaKlientów() {
        return listaKlientów;
    }
    public void setListaKlientów(String listaKlientów) {
        this.listaKlientów = listaKlientów;
    }

}
