package tp_poo.ServiceManager;

import exceptions.CompetitionNotFoundException;
import exceptions.WebServiceConnectionError;
import java.io.IOException;
import java.net.MalformedURLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import serviceManager.WebServiceConnection;

/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public class Football implements serviceManager.FootballQueriesContract, java.io.Serializable{
    
    private String URL; 
    private String apiKey;
    private String Json_Competitions;
    
    /*
    * Construtor que permite a instaciação da classe
    * @param link url da pagina
    * @param apiKey utilizada para a conecção
    */
    public Football(String link, String apiKey) {
        this.URL = link;
        this.apiKey = apiKey;
        
        
        WebServiceConnection webServiceConnection = new WebServiceConnection(this.apiKey);
        try {
            this.Json_Competitions = webServiceConnection.getContent(this.URL+"/competitions");
            
        } catch (MalformedURLException ex1){
            System.out.println("\n Erro MalformedURLException Constructor\n");
            //Logger.getLogger(Football.class.getName()).log(Level.SEVERE, null, ex2);
        
        } catch (IOException ex2) {
            System.out.println("\n Erro IOExecption Constructor\n ");
            //Logger.getLogger(Football.class.getName()).log(Level.SEVERE, null, ex1);
            
        }
        
    }
    
    /**
     * Método responsável por fazer a conexão ao URL
     * @param link
     * @return string em formato JSON
     */
    public String getURLConnection(String link) {
        
        String JSON_String;
        
        WebServiceConnection webServiceConnection = new WebServiceConnection(this.apiKey);
        try {
            JSON_String = webServiceConnection.getContent(link);
            return JSON_String;
        
        } catch (MalformedURLException ex1){
            System.out.println("\n Erro MalformedURLException getURLConnection\n");
            //Logger.getLogger(Football.class.getName()).log(Level.SEVERE, null, ex2);
        
        } catch (IOException ex2) {
            System.out.println("\n Erro IOExecption getURLConnection\n");
            //Logger.getLogger(Football.class.getName()).log(Level.SEVERE, null, ex1);
            
        }
        
        return null;
    }
    
    /**
     * Método responsável por retornar o link
     * @return URL
     */
    public String getLink() {
        return URL;
    }

    /**
     * Método responsável por retornar a apiKey
     * @return apiKey
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Método responsável por retornar todas as competições
     * @return coleção de competições
     */
    public String getAllCompetitions() {
        
        return this.Json_Competitions = getURLConnection(this.URL+"competitions/");
    }
    
    /**
     * Método responsável por retornar a String num formato JSON, com a Competição dado o seu identificador
     * @param i  - o identificador da Competição
     * @return String em formato JSON com a resposta do serviço
     * @throws CompetitionNotFoundException - Excepção que sinaliza que determinado identificador não existe na coleção de competições
     * @throws WebServiceConnectionError - Excepção que representa a falha de ligação ao serviço
     */
    @Override
    public String getCompetition(int i) throws CompetitionNotFoundException, WebServiceConnectionError {
           
        String JSON_Competition = getURLConnection(this.URL+"competitions/"+i);
        
        return JSON_Competition;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por retornar a String num formato JSON, com as Competições dado um conjunto de identificadores
     * @param ints - um conjunto de identificadores da Competição
     * @return String em formato JSON com a resposta do serviço
     * @throws CompetitionNotFoundException - Excepção que sinaliza que determinado identificador não existe na coleção de competições
     * @throws WebServiceConnectionError - Excepção que representa a falha de ligação ao serviço
     */
    @Override
    public String getCompetitions(int[] ints) throws CompetitionNotFoundException, WebServiceConnectionError {
        
        
        String JSON_Competitions = "[";
        String[] JSON_Array_Competitions = new String[ints.length];
        
        for (int i = 0; i < ints.length; i++) {
            
            String JSON_Competition = getCompetition(ints[i]);
            JSON_Array_Competitions[i] = JSON_Competition;
        }
        
        for (int i = 0; i < ints.length; i++) {
            
            JSON_Competitions = JSON_Competitions + JSON_Array_Competitions[i];
            if(i < ints.length-1) JSON_Competitions = JSON_Competitions + ", ";
            else if(i == ints.length-1) JSON_Competitions = JSON_Competitions + " ]";
        }
        
        return JSON_Competitions;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por retornar a String num formato JSON, com os jogos dado o identificador da Competição
     * @param competitionId - o identificador da Competição
     * @return String em formato JSON com a resposta do serviço
     * @throws CompetitionNotFoundException - Excepção que sinaliza que determinado identificador não existe na coleção de competições
     * @throws WebServiceConnectionError - Excepção que representa a falha de ligação ao serviço
     */
    @Override
    public String getFixtures(int competitionId) throws CompetitionNotFoundException, WebServiceConnectionError {
        
        String JSON_Fixtures = getURLConnection(this.URL+"competitions/");
        
        String string_Link;
        String string_Fixtures;
        String string_href;
        
        String Link_Fixtures;
        
        JSONParser jsonParser = new JSONParser();
        
        try{
            
            Object object = jsonParser.parse(JSON_Fixtures);
            JSONArray arrayCompetitions = (JSONArray) object;
            
            for(int aux=0; aux<arrayCompetitions.size(); aux++){
                
                JSONObject competition = (JSONObject) arrayCompetitions.get(aux); // position aux 
                if(competition.get("id").toString().equals(String.valueOf(competitionId))){
                    
                    // Procura apenas pelo "_Links"
                    JSONParser jsonParser_links = new JSONParser();
                    Object object_links = jsonParser_links.parse(competition.toString());
                    JSONObject Json_object_links = (JSONObject) object_links;
                    
                    string_Link = Json_object_links.get("_links").toString();
                    //System.out.println("\n _links:\n" +string_Link);
                    
                    // Procura apenas pelo "Fixtures"
                    JSONParser jsonParser_Fixtures = new JSONParser();
                    
                    Object object_Fixtures = jsonParser_Fixtures.parse(string_Link);
                    JSONObject Json_object_Fixtures = (JSONObject) object_Fixtures;
                    
                    string_Fixtures = Json_object_Fixtures.get("fixtures").toString();
                    //System.out.println("\n Fixtures:\n" +string_Fixtures);
                    
                    // Procura apenas pelo "href"
                    JSONParser jsonParser_href = new JSONParser();
                    
                    Object object_href = jsonParser_href.parse(string_Fixtures);
                    JSONObject Json_object_href = (JSONObject) object_href;
                    
                    string_href = Json_object_href.get("href").toString();
                    //System.out.println("\n href = " +string_href);

                    // link pagina a pesquisar pela teams

                    Link_Fixtures = getURLConnection(string_href); // String da Team Selecionada

                    return (String) Link_Fixtures;
                }
            }
            
        } catch ( ParseException ex) {
            System.out.println("\n Erro ParseException\n");
            //Logger.getLogger(Football.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por retornar a String num formato JSON, com a liga dado o identificador da Competição
     * @param competitionId - o identificador da Competição
     * @return String em formato JSON com a resposta do serviço
     * @throws CompetitionNotFoundException - Excepção que sinaliza que determinado identificador não existe na coleção de competições
     * @throws WebServiceConnectionError - Excepção que representa a falha de ligação ao serviço
     */
    @Override
    public String getLeagueTable(int competitionId) throws CompetitionNotFoundException, WebServiceConnectionError {
        
        String JSON_LeagueTable = getURLConnection(this.URL+"competitions/");
        
        String string_Link;
        String string_leagueTable;
        String string_href;
        
        String Link_leagueTable;
        
        JSONParser jsonParser = new JSONParser();
        
        try{
            
            Object object = jsonParser.parse(JSON_LeagueTable);
            JSONArray arrayCompetitions = (JSONArray) object;
            
            for(int aux=0; aux<arrayCompetitions.size(); aux++){
                
                JSONObject competition = (JSONObject) arrayCompetitions.get(aux); // position aux 
                if(competition.get("id").toString().equals(String.valueOf(competitionId))){
                    
                    // Procura apenas pelo "_Links"
                    JSONParser jsonParser_links = new JSONParser();
                    Object object_links = jsonParser_links.parse(competition.toString());
                    JSONObject Json_object_links = (JSONObject) object_links;
                    
                    string_Link = Json_object_links.get("_links").toString();
                    //System.out.println("\n _links:\n" +string_Link);
                    
                    // Procura apenas pelo "leagueTable"
                    JSONParser jsonParser_leagueTable = new JSONParser();
                    
                    Object object_leagueTable = jsonParser_leagueTable.parse(string_Link);
                    JSONObject Json_object_leagueTable = (JSONObject) object_leagueTable;
                    
                    string_leagueTable = Json_object_leagueTable.get("leagueTable").toString();
                    //System.out.println("\n leagueTable:\n" +string_leagueTable);
                    
                    // Procura apenas pelo "href"
                    JSONParser jsonParser_href = new JSONParser();
                    
                    Object object_href = jsonParser_href.parse(string_leagueTable);
                    JSONObject Json_object_href = (JSONObject) object_href;
                    
                    string_href = Json_object_href.get("href").toString();
                    //System.out.println("\n href = " +string_href);
                    
                    // link pagina a pesquisar pela teams
                    Link_leagueTable = getURLConnection(string_href); // String da Team Selecionada
                    
                    return (String) Link_leagueTable;
                }
            }
            
        } catch ( ParseException ex) {
            System.out.println("\n Erro ParseException\n");
            //Logger.getLogger(Football.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por retornar a String num formato JSON, com os jogadores dado o código da equipa
     * @param teamId - o código da equipa
     * @return String em formato JSON com a resposta do serviço
     * @throws CompetitionNotFoundException - Excepção que sinaliza que determinado identificador não existe na coleção de competições
     * @throws WebServiceConnectionError - Excepção que representa a falha de ligação ao serviço
     */
    @Override
    public String getPlayers(int teamId) throws CompetitionNotFoundException, WebServiceConnectionError {
        
        String JSON_Players = getURLConnection(this.URL+"teams/"+teamId+"/players");
        return JSON_Players;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por retornar a String num formato JSON, com as equipas dado o identificador da Competição
     * @param i - o identificador da Competição
     * @return String em formato JSON com a resposta do serviço
     * @throws CompetitionNotFoundException - Excepção que sinaliza que determinado identificador não existe na coleção de competições
     * @throws WebServiceConnectionError - Excepção que representa a falha de ligação ao serviço
     */
    @Override
    public String getTeams(int i) throws CompetitionNotFoundException, WebServiceConnectionError {
        
        //String JSON_Teams = getURLConnection(this.URL+"teams/"+i);
        String JSON_Teams = getURLConnection(this.URL+"competitions/"+i+"/teams");
        //System.out.println("\n URL: " +this.URL+"competitions/"+i+"/teams");
        
        return JSON_Teams;
    }
    
    /**
    * Método responsável por retornar a String num formato JSON, com a equipa dado o identificador da equipa
    * @param idTeam - o identificador da equipa
    *
    */
    public String getTeam(int idTeam) throws CompetitionNotFoundException, WebServiceConnectionError {
        
        //String JSON_Teams = getURLConnection(this.URL+"teams/"+i);
        String JSON_Teams = getURLConnection(this.URL+"teams/"+idTeam+"/");
        
        return JSON_Teams;
    }
    
}
