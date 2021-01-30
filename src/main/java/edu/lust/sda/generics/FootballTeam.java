package edu.lust.sda.generics;

public class FootballTeam extends Team{
    private TeamLevel teamLevel;

    public FootballTeam(String name, TeamLevel teamLevel) {
    //this(name) sięga do innego kostruktora tej samej klasy
        super(name);
        this.teamLevel = teamLevel;
    }
    public FootballTeam(String name){
        //super(name) siega do konstruktora klasy którą rozszerzamy
        super(name);
    }


}
