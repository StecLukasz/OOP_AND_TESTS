package edu.lust.sda.generics.withBounduaries;

import edu.lust.sda.generics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * League<T> oznacza że do klasy będzie przykazany jakiś obiekt o nieokreślonym na ten moment typie
 *
 * */

public class League<T extends Team>{
    private String leagueName;
    private List<T> teams; // obiekt o typie przekazanym do klasy - OK

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.teams = new ArrayList<>();
    }

    /**
     * Metoda bez problemu przejmuje generywczny typ rozszerzający Team - OK
     * */
    public boolean addTeam(T team){
        if (!teams.contains(team)){
            return teams.add(team);
        }
        return false;
    }

    /**
     * metoda nie wymusza już rzutowania bo wiadomo że "pochodna" klasy Team
     * będzie miała możlowość sortowania, i dosep do metod getName i getPoints
     *
     * teraz metoda jest OK -  jeśli mamy typ generyczny z ograniczeniem
     * */

    public void printTable(){

        Collections.sort(teams);
        System.out.println(leagueName+" table:");
        //analogicznie poniżej, typ T niekoniecznie ma metody getName() i getPionts()
        //dlatego konieczne jest określenie tego przed kompilacją
        teams.forEach(x-> System.out.println(x.getName()+" "+x.getPoints()));
    }

}
