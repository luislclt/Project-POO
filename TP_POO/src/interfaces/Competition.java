/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import exceptions.CompetitionNotFoundException;
import exceptions.WebServiceConnectionError;
import interfaces.Management.FixtureManagementContract;
import interfaces.Management.TeamManagementContract;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tp_poo.ServiceManager.Football;

/**
 *
 * @author tania
 */
public class Competition implements CompetitionContract{
    
    private String URL;
    private String apiKey;
    
    private String Json_Competitions;
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
    
    
    /*
    * Constructor Competition recebe String Url, apiKey e o idCompetition
    * @param String url
    * @param String apiKey
    * @param int id da competição
    */
    public Competition(String TMPUrl, String TMPapiKey, int id) {
        
        this.URL = TMPUrl;
        this.apiKey = TMPapiKey;
        
        Football connection = new Football(URL, apiKey); // é necessario este construtor para poder receber os links href
        
        try {
            this.Json_Competitions = connection.getCompetition(id);
        } catch (CompetitionNotFoundException ex) {
            System.out.println("\n Erro CompetitionNotFoundException --> Competition");
            //Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WebServiceConnectionError ex) {
            System.out.println("\n Erro WebServiceConnectionError --> Competition");
            //Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JSONParser jsonParser = new JSONParser();
        try{
            
            JSONObject object = (JSONObject) jsonParser.parse(this.Json_Competitions); // Json_Player contem a string das competitions
            
            //this.fixtures = new Fixtures(connection.getFixtures(id)); // pedidio no impelements javaDoc
            this.leagueTable = new LeagueTable(connection.getLeagueTable(id)); // pedidio no impelements javaDoc
            //this.teams = (TeamManagementContract) new Team(connection.getTeams(id)); // pedidio no impelements javaDoc
            
            String string_id = object.get("id").toString();
            this.id = Integer.parseInt(string_id); // pedidio no impelements javaDoc
            
            String string_year = object.get("year").toString();
            this.year = Integer.parseInt(string_year); // pedidio no impelements javaDoc
    
            this.caption = object.get("caption").toString();
            
            String string_currentMatchday = object.get("currentMatchday").toString();
            this.currentMatchday = Integer.parseInt(string_currentMatchday);
            
            String string_numberOfMatchdays = object.get("numberOfMatchdays").toString();
            this.numberOfMatchdays = Integer.parseInt(string_numberOfMatchdays);
            
            String string_numberOfTeams = object.get("numberOfTeams").toString();
            this.numberOfTeams = Integer.parseInt(string_numberOfTeams);
            
            String string_numberOfGames = object.get("numberOfGames").toString();
            this.numberOfGames = Integer.parseInt(string_numberOfGames);
            
            this.lastUpdated = object.get("lastUpdated").toString();
            
            
        }catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> Competition");
            //Logger.getLogger(FootballContract.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CompetitionNotFoundException ex) {
            System.out.println("\n Erro CompetitionNotFoundException --> Competition");
            //Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WebServiceConnectionError ex) {
            System.out.println("\n Erro WebServiceConnectionError --> Competition");
            //Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String getJson_Competitions() {
        return this.Json_Competitions;
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
        return "Competition{" + "\n fixtures=" + fixtures + "\n leagueTable=" + leagueTable + "\n teams=" + teams + "\n id=" + id + ", year=" + year + ", caption=" + caption + ", currentMatchday=" + currentMatchday + ", numberOfMatchdays=" + numberOfMatchdays + ", numberOfTeams=" + numberOfTeams + ", numberOfGames=" + numberOfGames + ", lastUpdated=" + lastUpdated + "\n}";
    }
    
    
    
}
