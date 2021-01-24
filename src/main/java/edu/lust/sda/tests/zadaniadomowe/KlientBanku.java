package edu.lust.sda.tests.zadaniadomowe;

public class KlientBanku {

    private String imie;
    private String nazwisko;
    private Integer numerKlienta;
    private String listaRachunków;



    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Integer getNumerKlienta() {
        return numerKlienta;
    }

    public void setNumerKlienta(Integer numerKlienta) {
        this.numerKlienta = numerKlienta;
    }

    public String getListaRachunków() {
        return listaRachunków;
    }

    public void setListaRachunków(String listaRachunków) {
        this.listaRachunków = listaRachunków;
    }

    public KlientBanku(String imie, String nazwisko, Integer numerKlienta, String listaRachunków) {

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerKlienta = numerKlienta;
        this.listaRachunków = listaRachunków;
    }

}
