package edu.lust.sda.java8.streams;

public enum Gender {
    WOMAN(1,"K","W","kobieta"),
    MAN(2,"M","M","mężczyzna");

    private int index;
    private String shortcutPL;
    private String shortcutEn;
    private String tranlationPl;


    Gender(int index, String shortcutPL, String shortcutEn, String tranlationPl) {
        this.index = index;
        this.shortcutPL = shortcutPL;
        this.shortcutEn = shortcutEn;
        this.tranlationPl = tranlationPl;
    }

    public int getIndex() {
        return index;
    }

    public String getShortcutPL() {
        return shortcutPL;
    }

    public String getShortcutEn() {
        return shortcutEn;
    }

    public String getTranlationPl() {
        return tranlationPl;
    }

    // znajdziemy płeć na podstawie przekazanego skrótu
    //czyli do metody przekażemy "M" a zwróci nam element MAN
    public static Gender getByShortcutPl(String shortcutPL){
        for (Gender gender : Gender.values()) {
            if (shortcutPL.equals(gender.getShortcutPL())){
                return gender;
            }
        }
        return null;
    }

}
