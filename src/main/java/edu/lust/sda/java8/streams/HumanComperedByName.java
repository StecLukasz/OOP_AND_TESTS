package edu.lust.sda.java8.streams;

import java.util.Comparator;

public class HumanComperedByName implements Comparator<Human> {
    @Override // implementujemy Alt+Insert i override
    public int compare(Human human1, Human human2) {

        return human1.getName().compareTo(human2.getName()); // imie jest porównywane przez to compareTo
    }
}
