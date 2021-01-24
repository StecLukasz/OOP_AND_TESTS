package edu.lust.sda.tests.zadaniadomowe;

public class KontoWBanku {

    private String typKonta;
    private Integer stanKonta;
    private long numerRachunku;

    public KontoWBanku() {
    }
    public void setTypKonta(String typKonta) {
        this.typKonta = typKonta;
    }
    public void setStanKonta(Integer stanKonta) {
        this.stanKonta = stanKonta;
    }
    public void setNumerRachunku(Integer numerRachunku) {
        this.numerRachunku = numerRachunku;
    }
    public String getTypKonta() {
        return typKonta;
    }
    public Integer getStanKonta() {
        return stanKonta;
    }
    public long getNumerRachunku() {
        return numerRachunku;
    }
    public KontoWBanku(String typKonta, Integer stanKonta, long numerRachunku) {
        this.typKonta = typKonta;
        this.stanKonta = stanKonta;
        this.numerRachunku = numerRachunku;
    }


}
