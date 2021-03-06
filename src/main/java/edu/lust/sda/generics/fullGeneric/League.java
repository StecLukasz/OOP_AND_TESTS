package edu.lust.sda.generics.fullGeneric;

import edu.lust.sda.generics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * League<T> oznacza że do klasy będzie przykazany jakiś obiekt o nieokreślonym na ten moment typie
 * */

public class League {
    private String leagueName;
    private List<Team> teams; // obiekt o typie przekazanym do klasy - OK

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.teams = new ArrayList<>();
    }

    /**
     * Metoda bez problemu przejmuje generywczny(czyli nieokreślony typ) - OK
     * */
    public boolean addTeam(Team team){
        if (!teams.contains(team)){
            return teams.add(team);
        }
        return false;
    }

    /**
     * metoda wymusza rzutowanie generycznego - NOT OK
     * metoda nie nadaje się do klasy generycznej
     * */

    public void printTable(){
        // musimy rzytować bo kompilator nie wie czy typ T da sie sortować,
//        a klasa Team implementuje Comparable więc wiadomo że się da
        Collections.sort((List<Team>) teams);
        System.out.println(leagueName+" table:");
        //analogicznie poniżej, typ T niekoniecznie ma metody getName() i getPionts()
        //dlatego konieczne jest określenie tego przed kompilacją
        teams.forEach(x-> System.out.println(((Team)x).getName()+" "+((Team)x).getPoints()));
    }

}
