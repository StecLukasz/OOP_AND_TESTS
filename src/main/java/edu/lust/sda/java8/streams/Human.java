package edu.lust.sda.java8.streams;

public class Human implements Comparable<Human> {
    private String name;
    private String surname;
    private int age;
    private Gender gender;


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
    public boolean isOver20AndGenderMan(){
        return age>20 && "M".equals(getGender().getShortcutPL());
    }


    public Human(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Human(String name, String surname, int age, String genderShortcutPL) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = Gender.getByShortcutPl(genderShortcutPL);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender=" + gender.getTranlationPl() +
                '}';
    }

    @Override
    public int compareTo(Human o) {
        return surname.compareTo(o.getSurname());

    }






}
