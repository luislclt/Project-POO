/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import interfaces.Management.FixtureManagementContract;
import interfaces.Management.TeamManagementContract;

/**
 *
 * @author tania
 */
public class Competition implements CompetitionContract{
    
    //private String URL;
    //private String apiKey;
    
    //private String Json_Competitions;
    private FixtureManagementContract fixtures; // pedidio no impelements javaDoc
    private LeagueTableContract leagueTable; // pedidio no impelements javaDoc
    private TeamManagementContract teams; // pedidio no impelements javaDoc
    private int id; // pedidio no impelements javaDoc
    private int year; // pedidio no impelements javaDoc
    
    private String caption;
    private int currentMatchday;
    private int numberOfMatchdays;
    private int numberOfTeams;
    private int numberOfGames;
    private String lastUpdated;

    public Competition(FixtureManagementContract fixtures, LeagueTableContract leagueTable, TeamManagementContract teams, int id, int year) {
        this.fixtures = fixtures;
        this.leagueTable = leagueTable;
        this.teams = teams;
        this.id = id;
        this.year = year;
    }

    public Competition(FixtureManagementContract fixtures, LeagueTableContract leagueTable, TeamManagementContract teams, int id, int year, String caption, int currentMatchday, int numberOfMatchdays, int numberOfTeams, int numberOfGames, String lastUpdated) {
        this.fixtures = fixtures;
        this.leagueTable = leagueTable;
        this.teams = teams;
        this.id = id;
        this.year = year;
        this.caption = caption;
        this.currentMatchday = currentMatchday;
        this.numberOfMatchdays = numberOfMatchdays;
        this.numberOfTeams = numberOfTeams;
        this.numberOfGames = numberOfGames;
        this.lastUpdated = lastUpdated;
    }
    
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public LeagueTableContract getLeague() {
        
        return this.leagueTable;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public FixtureManagementContract getFixture() {
        return this.fixtures;
    }

    @Override
    public TeamManagementContract getTeams() {
        return this.teams;
    }

    public String getCaption() {
        return this.caption;
    }

    public int getCurrentMatchday() {
        return this.currentMatchday;
    }

    public int getNumberOfMatchdays() {
        return this.numberOfMatchdays;
    }

    public int getNumberOfTeams() {
        return this.numberOfTeams;
    }

    public int getNumberOfGames() {
        return this.numberOfGames;
    }

    public String getLastUpdated() {
        return this.lastUpdated;
    }
    
    @Override
    public String toString() {
        return "Competition{" + " id = " + id + ", year = " + year + ", caption = " + caption + ", currentMatchday = " + currentMatchday + ", numberOfMatchdays = " + numberOfMatchdays + ", numberOfTeams = " + numberOfTeams + ", numberOfGames = " + numberOfGames + ", lastUpdated = " + lastUpdated + "\n fixtures = " + fixtures + "\n leagueTable = " + leagueTable + "\n teams = " + teams + " \n }";
    }
    
    
    
}
