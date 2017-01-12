/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_poo.ServiceManager;

import exceptions.CompetitionNotFoundException;
import exceptions.WebServiceConnectionError;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import serviceManager.FootballBaseContract;
import serviceManager.FootballQueriesContract;
import serviceManager.WebServiceConnection;

/**
 *
 * @author LCLT
 */
public class webServiceConnection implements FootballBaseContract, FootballQueriesContract{
    
    String URL; //= "http://api.football-data.org/v1/competitions/";
    String apiKey; // = "4a0fdab1682e4d1384b8262f7e02d641";
    String Json_competitions;

    public webServiceConnection(String link, String apiKey) {
        this.URL = link;
        this.apiKey = apiKey;
        
        WebServiceConnection webServiceConnection = new WebServiceConnection(this.apiKey);
        try {
            this.Json_competitions = webServiceConnection.getContent(this.URL);
        } catch (IOException ex) {
            Logger.getLogger(webServiceConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String getURLConnection(String link) {
        
        String JSON_String;
        
        WebServiceConnection webServiceConnection = new WebServiceConnection(this.apiKey);
        try {
            JSON_String = webServiceConnection.getContent(link);
            return JSON_String;
        } catch (IOException ex) {
            Logger.getLogger(webServiceConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Invalido";
    }
    
    public String getLink() {
        return URL;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getAllCompetitions() {
        return Json_competitions;
    }

    
    @Override
    public String getCompetition(int i) throws CompetitionNotFoundException, WebServiceConnectionError {
        // int i = id Competition
        
        //JSONObject json_Competitions = new JSONObject(); // instancia jsonCompetitions convertendo da String do webService
        //json_Competitions.put("competitions", Json_competitions); // jsonCompetitions recebe todo
        //JSONParser competitions_parser = new JSONParser();
            
        JSONParser jsonParser = new JSONParser();
            
        try{
            //JSONObject object_Competitions = (JSONObject) competitions_parser.parse(json_Competitions.toJSONString()); 
            //JSONArray arrayCompetitions = (JSONArray) object_Competitions.get(Json_competitions);
            
            Object object = jsonParser.parse(Json_competitions);
            JSONArray arrayCompetitions = (JSONArray) object;
            
            //System.out.println(arrayCompetitions.get(0).toString());
            
            for(int aux=0; aux<arrayCompetitions.size(); aux++){
                
                JSONObject competition = (JSONObject) arrayCompetitions.get(aux); // position aux 
                if(competition.get("id").toString().equals(String.valueOf(i))){
                    /*
                    String id = competition.get("id").toString();
                    String username = competition.get("caption").toString();
                    String league = competition.get("league").toString();
                    String year = competition.get("year").toString();
                    String teamLink = competition.get("_links").toString();
                    System.out.println("\n Teste return WebService .getCompetition(id): " +id +"\t" +username +"\t" +league +"\t" +year +"\n\t" +teamLink);
                    */
                    //return (String) arrayCompetitions.get(aux);
                    return (String) competition.toString();
                }
            }
            
            // Fim Codigo Object e Array //
        } catch ( ParseException ex) {
            Logger.getLogger(webServiceConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Invalido";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCompetitions(int[] ints) throws CompetitionNotFoundException, WebServiceConnectionError {
        // int[] ints = ids competitions
        
        
        
        return "[i]";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getTeams(int i) throws CompetitionNotFoundException, WebServiceConnectionError {
        
        
        
        String string_Link = null;
        String string_Team = null;
        String string_href = null;
        
        String Link_Team = null;
        
        JSONParser jsonParser = new JSONParser();
        
        try{
            
            Object object = jsonParser.parse(Json_competitions);
            JSONArray arrayCompetitions = (JSONArray) object;
            
            for(int aux=0; aux<arrayCompetitions.size(); aux++){
                
                JSONObject competition = (JSONObject) arrayCompetitions.get(aux); // position aux 
                if(competition.get("id").toString().equals(String.valueOf(i))){
                    /*
                    String id = competition.get("id").toString();
                    String username = competition.get("caption").toString();
                    String league = competition.get("league").toString();
                    String year = competition.get("year").toString();
                    System.out.println("\n Teste return WebService .getCompetition(id): " +id +"\t" +username +"\t" +league +"\t" +year );
                    */
                    // Procura apenas pelo "_Links"
                    JSONParser jsonParser_links = new JSONParser();
                    try{
                    Object object_links = jsonParser_links.parse(competition.toString());
                    JSONObject Json_object_links = (JSONObject) object_links;
                    
                    string_Link = Json_object_links.get("_links").toString();
                    //System.out.println("\n _links:\n" +string_Link);
                    } catch ( ParseException ex) {
                        Logger.getLogger(webServiceConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    // Procura apenas pelo "teams"
                    JSONParser jsonParser_teams = new JSONParser();
                    try{
                    Object object_teams = jsonParser_teams.parse(string_Link);
                    JSONObject Json_object_teams = (JSONObject) object_teams;
                    
                    string_Team = Json_object_teams.get("teams").toString();
                    //System.out.println("\n teams:\n" +string_Team);
                    
                    } catch ( ParseException ex) {
                        Logger.getLogger(webServiceConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    // Procura apenas pelo "href"
                    JSONParser jsonParser_href = new JSONParser();
                    try{
                    Object object_href = jsonParser_href.parse(string_Team);
                    JSONObject Json_object_href = (JSONObject) object_href;
                    
                    string_href = Json_object_href.get("href").toString();
                    //System.out.println("\n href = " +string_href);
                    
                    } catch ( ParseException ex) {
                        Logger.getLogger(webServiceConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // link pagina a pesquisar pela teams
                    
                    Link_Team = getURLConnection(string_href); // String da Team Selecionada
                    
                    return (String) Link_Team;
                }
            }
            
        } catch ( ParseException ex) {
            Logger.getLogger(webServiceConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Invalido";
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLeagueTable(int i) throws CompetitionNotFoundException, WebServiceConnectionError {
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFixtures(int i) throws CompetitionNotFoundException, WebServiceConnectionError {
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPlayers(int i) throws CompetitionNotFoundException, WebServiceConnectionError {
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}