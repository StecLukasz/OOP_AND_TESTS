package edu.lust.sda.generics.withBounduaries;

import edu.lust.sda.generics.FootballTeam;
import edu.lust.sda.generics.Team;
import edu.lust.sda.generics.TeamLevel;
import edu.lust.sda.generics.VolleyballTeam;

public class LeagueMain {
    public static void main(String[] args) {

        League<FootballTeam> league= new League("Primiera Division");

        FootballTeam  team1 = new FootballTeam("FC Barcelona", TeamLevel.PROFESSIONAL);
        FootballTeam  team2 = new FootballTeam("Atletico de Madrid", TeamLevel.PROFESSIONAL);
        FootballTeam  team3 = new FootballTeam("Real Madrid CF", TeamLevel.PROFESSIONAL);
        FootballTeam  team4 = new FootballTeam("Valencia CF", TeamLevel.PROFESSIONAL);

        team1.setPoints(20);
        team2.setPoints(25);
        team3.setPoints(28);
        team4.setPoints(29);
        league.addTeam((FootballTeam) team1);
        league.addTeam((FootballTeam) team2);
        league.addTeam((FootballTeam) team3);
        league.addTeam((FootballTeam) team4);
        league.printTable();
        System.out.println("= = = = = = = = = = = = = = = = ");

        VolleyballTeam team5 = new VolleyballTeam("Asseco Resovia",TeamLevel.PROFESSIONAL);
        team5.setPoints(27);
        //nie zadziałą bo team5 jest typu VolleyballTeam
//        league.addTeam((FootballTeam) team5);
//        league.printTable();
//
//        Team team6 = new VolleyballTeam("Zaksa",TeamLevel.PROFESSIONAL);
//        team6.setPoints(35);
//        league.addTeam((FootballTeam) team6); // kompiluje się ale wywali błąd przy wykonaku programu




    }
}
