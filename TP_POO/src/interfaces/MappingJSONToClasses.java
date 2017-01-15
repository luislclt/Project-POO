package interfaces;

import interfaces.Management.CompetitionManagementContract;
import interfaces.Management.FixtureManagementContract;
import interfaces.Management.PlayerManagement;
import interfaces.Management.PlayerManagementContract;
import interfaces.Management.StandingsManagement;
import interfaces.Management.StandingsManagementContract;
import interfaces.Management.TeamManagement;
import interfaces.Management.TeamManagementContract;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class MappingJSONToClasses implements MappingJsonToClasses{
    
    private final String URL;
    private final String apiKey;
    
    /*
    * Constructor recebe uma String URL e String apiKey
    * @param String URL
    * @param String apiKey
    */
    public MappingJSONToClasses(String URL, String apiKey) {
        this.URL = URL;
        this.apiKey = apiKey;
    }
    
    
    /*
    * Método responsável por retornar uma competição 
    * tendo por base uma string em formato JSON
    * @param String content
    * return competições
    */
    @Override
    public CompetitionManagementContract StringToCompetitions(String arg0) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    * Método responsável por retornar uma coleção de competições 
    * tendo por base uma string em formato JSON
    * @param String content
    * return coleção de jogadores
    */
    @Override
    public CompetitionContract StringToCompetition(String arg0) {
        
        FixtureManagementContract fixtures = null; // pedidio no impelements javaDoc
        LeagueTableContract leagueTable = null; // pedidio no impelements javaDoc
        TeamManagementContract teams = null; // pedidio no impelements javaDoc
        int id; // pedidio no impelements javaDoc
        int year; // pedidio no impelements javaDoc
        String caption;
        int currentMatchday;
        int numberOfMatchdays;
        int numberOfTeams;
        int numberOfGames;
        String lastUpdated;
        
        
        JSONParser jsonParser = new JSONParser();
        try{
            
            JSONObject object = (JSONObject) jsonParser.parse(arg0); // Json_Player contem a string das competitions
            
            //this.fixtures = new Fixtures(connection.getFixtures(id)); // pedidio no impelements javaDoc
            //this.leagueTable = new LeagueTable(connection.getLeagueTable(id)); // pedidio no impelements javaDoc
            //this.teams = (TeamManagementContract) new Team(connection.getTeams(id)); // pedidio no impelements javaDoc
            
            String string_id = object.get("id").toString();
            id = Integer.parseInt(string_id); // pedidio no impelements javaDoc
            
            String string_year = object.get("year").toString();
            year = Integer.parseInt(string_year); // pedidio no impelements javaDoc
    
            caption = object.get("caption").toString();
            
            String string_currentMatchday = object.get("currentMatchday").toString();
            currentMatchday = Integer.parseInt(string_currentMatchday);
            
            String string_numberOfMatchdays = object.get("numberOfMatchdays").toString();
            numberOfMatchdays = Integer.parseInt(string_numberOfMatchdays);
            
            String string_numberOfTeams = object.get("numberOfTeams").toString();
            numberOfTeams = Integer.parseInt(string_numberOfTeams);
            
            String string_numberOfGames = object.get("numberOfGames").toString();
            numberOfGames = Integer.parseInt(string_numberOfGames);
            
            lastUpdated = object.get("lastUpdated").toString();
            
            CompetitionContract competition1 = new Competition(fixtures, leagueTable, teams, id, year, caption, currentMatchday, numberOfMatchdays, numberOfTeams, numberOfGames, lastUpdated);
            
            return competition1;
            
        }catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> MappingJSONToClasses --> Competition");
            //Logger.getLogger(FootballContract.class.getName()).log(Level.SEVERE, null, ex);
        } /*catch (CompetitionNotFoundException ex) {
            System.out.println("\n Erro CompetitionNotFoundException --> Competition");
            //Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WebServiceConnectionError ex) {
            System.out.println("\n Erro WebServiceConnectionError --> Competition");
            //Logger.getLogger(Competition.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    * Método responsável por retornar uma liga 
    * tendo por base uma coleção de equipas e uma string em formato JSON
    * @param TeamManagementContract teams
    * @param String content competitions/<competitionId>/leagueTable
    * return liga
    */
    @Override
    public LeagueTableContract StringToLeagueTable(TeamManagementContract arg0, String arg1) {
        
        String leagueCaption; 
        int matchday; 
        StandingsManagementContract Standing;//getPlayersFromTeam(arg0); 
        
        int position;
        String teamName;
        String crestURI;
        int playedGames;
        int points;
        
        int goals_standing;
        int goalsAgainst_standing;
        int goalDifference_standing;
        int wins_standing;
        int draws_standing;
        int losses_standing;
        
        int goals_home;
        int goalsAgainst_home;
        int wins_home;
        int draws_home;
        int losses_home;
        
        int goals_away;
        int goalsAgainst_away;
        int wins_away;
        int draws_away;
        int losses_away;
        /*
        int goals;
        int goalsAgainst;
        int wins;
        int draws;
        int losses;
        */
        StatisticsStanding home;
        StatisticsStanding away;
        
        int count = 0;
        
        String string_Link;
        String string_players;
        String string_href;
        
        JSONParser jsonParser_leagueTable = new JSONParser();
        
        try{
            
            //JSONObject object = (JSONObject) jsonParser_team.parse(arg0); //
            
            JSONObject leagueTable = (JSONObject) jsonParser_leagueTable.parse(arg1);
            
            //String string_count = team.get("count").toString();
            //count = Integer.parseInt(string_count);
            
            Object string_leagueCaption = leagueTable.get("leagueCaption");
            if(null == string_leagueCaption){
                leagueCaption = "null";
            }else{
                leagueCaption = string_leagueCaption.toString();
            }
                
            Object string_matchday = leagueTable.get("matchday");
            if(null == string_matchday){
                matchday = 0;
            }else{
                matchday = Integer.parseInt(string_matchday.toString());
            }
            
            JSONArray arrayLeagueTable = (JSONArray) leagueTable.get("standing");
            
            System.out.println("\n\n\t Entra no StringToLeagueTable   --> count do arrayLeagueTable: "+arrayLeagueTable.size());
            
            Standing = new StandingsManagement(arrayLeagueTable.size());
            
            for(int aux=0; aux<arrayLeagueTable.size(); aux++){
                
                JSONObject standing = (JSONObject) arrayLeagueTable.get(aux); // position aux 
                
                System.out.println("\n AUX: "+aux);
                
                // Procura apenas pelo "_Links"
                JSONParser jsonParser_links = new JSONParser();

                Object object_links = jsonParser_links.parse(standing.toString());
                JSONObject Json_object_links = (JSONObject) object_links;

                string_Link = Json_object_links.get("_links").toString();
                System.out.println("\nStringToTeam _links:\n" +string_Link);

                // Procura apenas pelo "team"
                JSONParser jsonParser_players = new JSONParser();

                Object object_players = jsonParser_players.parse(string_Link);
                JSONObject Json_object_players = (JSONObject) object_players;

                string_players = Json_object_players.get("team").toString();
                System.out.println("\nStringToTeam team:\n" +string_players);

                // Procura apenas pelo "href"
                JSONParser jsonParser_href = new JSONParser();

                Object object_href = jsonParser_href.parse(string_players);
                JSONObject Json_object_href = (JSONObject) object_href;

                string_href = Json_object_href.get("href").toString();
                System.out.println("\nStringToTeam href = " +string_href);
                
                WebServiceConnection conection = new WebServiceConnection(apiKey);
                String team_content = conection.getContent(string_href);
                
                TeamContract team = StringToTeam(team_content); // Team guardada do Standing[0] array
                
                Object string_position = standing.get("position");
                if(null == string_position){
                    position = 0;
                }else{
                    position = Integer.parseInt(string_position.toString());
                }
                
                Object string_teamName = standing.get("teamName");
                if(null == string_teamName){
                    teamName = "null";
                }else{
                    teamName = string_teamName.toString();
                }
                
                Object string_crestURI = standing.get("crestURI");
                if(null == string_crestURI){
                    crestURI = "null";
                }else{
                    crestURI = string_crestURI.toString();
                }
                
                Object string_playedGames = standing.get("playedGames");
                if(null == string_playedGames){
                    playedGames = 0;
                }else{
                    playedGames = Integer.parseInt(string_playedGames.toString());
                }
                
                Object string_points = standing.get("points");
                if(null == string_points){
                    points = 0;
                }else{
                    points = Integer.parseInt(string_points.toString());
                }
                
                Object string_goals = standing.get("goals");
                if(null == string_goals){
                    goals_standing = 0;
                }else{
                    goals_standing = Integer.parseInt(string_goals.toString());
                }
                
                Object string_goalsAgainst = standing.get("goalsAgainst");
                if(null == string_goalsAgainst){
                    goalsAgainst_standing = 0;
                }else{
                    goalsAgainst_standing = Integer.parseInt(string_goalsAgainst.toString());
                }
                
                Object string_goalDifference = standing.get("goalDifference");
                if(null == string_goalDifference){
                    goalDifference_standing = 0;
                }else{
                    goalDifference_standing = Integer.parseInt(string_goalDifference.toString());
                }
                
                Object string_wins = standing.get("wins");
                if(null == string_wins){
                    wins_standing = 0;
                }else{
                    wins_standing = Integer.parseInt(string_wins.toString());
                }
                
                Object string_draws = standing.get("draws");
                if(null == string_draws){
                    draws_standing = 0;
                }else{
                    draws_standing = Integer.parseInt(string_draws.toString());
                }
                
                Object string_losses = standing.get("losses");
                if(null == string_losses){
                    losses_standing = 0;
                }else{
                    losses_standing = Integer.parseInt(string_losses.toString());
                }
                //
                //  Lê no objecto Json "home"
                //
                JSONObject object_home = (JSONObject) standing.get("home");
                
                Object object_goals_home = object_home.get("goals");
                if(null == object_goals_home){
                    goals_home = 0;
                }else{
                    goals_home = Integer.parseInt(object_goals_home.toString());
                }
                
                Object object_goalsAgainst_home = object_home.get("goalsAgainst");
                if(null == object_goalsAgainst_home){
                    goalsAgainst_home = 0;
                }else{
                    goalsAgainst_home = Integer.parseInt(object_goalsAgainst_home.toString());
                }
                                
                Object object_wins_home = object_home.get("wins");
                if(null == object_wins_home){
                    wins_home = 0;
                }else{
                    wins_home= Integer.parseInt(object_wins_home.toString());
                }
                
                Object object_draws_home = object_home.get("draws");
                if(null == object_draws_home){
                    draws_home = 0;
                }else{
                    draws_home = Integer.parseInt(object_draws_home.toString());
                }
                
                Object object_losses_home = object_home.get("losses");
                if(null == object_losses_home){
                    losses_home = 0;
                }else{
                    losses_home = Integer.parseInt(object_losses_home.toString());
                }
                
                //
                // Cria o Objecto home
                
                home = new StatisticsStanding(goals_home, goalsAgainst_home, wins_home, draws_home, losses_home);
                
                //  Lê no objecto Json "away"
                //
                JSONObject object_away = (JSONObject) standing.get("away");
                
                Object object_goals_away = object_home.get("goals");
                if(null == object_goals_away){
                    goals_away = 0;
                }else{
                    goals_away = Integer.parseInt(object_goals_away.toString());
                }
                
                Object object_goalsAgainst_away = object_home.get("goalsAgainst");
                if(null == object_goalsAgainst_away){
                    goalsAgainst_away = 0;
                }else{
                    goalsAgainst_away = Integer.parseInt(object_goalsAgainst_away.toString());
                }
                                
                Object object_wins_away = object_home.get("wins");
                if(null == object_wins_away){
                    wins_away = 0;
                }else{
                    wins_away = Integer.parseInt(object_wins_away.toString());
                }
                
                Object object_draws_away = object_home.get("draws");
                if(null == object_draws_away){
                    draws_away = 0;
                }else{
                    draws_away = Integer.parseInt(object_draws_away.toString());
                }
                
                Object object_losses_away = object_home.get("losses");
                if(null == object_losses_away){
                    losses_away = 0;
                }else{
                    losses_away = Integer.parseInt(object_losses_away.toString());
                }
                // Cria o Objecto away
                //
                away = new StatisticsStanding(goals_away, goalsAgainst_away, wins_away, draws_away, losses_away);
                
                StandingInterface standingArray = new Standing(position, teamName, crestURI, playedGames, points, goals_standing, goalsAgainst_standing, goalDifference_standing, wins_standing, draws_standing, losses_standing, home, away, team);
                
                Standing.addObject(standingArray);
                
                //TeamManagementContract arg0
                if(arg0.equals(team)){
                    count++;
                }
                
            }// Percorre array standing  --> internamente guarda no construtor a team
            
            if(count > 0){
                
                System.out.println("\n\n\t ENTRA no if count > 0 do StringToLeagueTable(TeamManagementContract arg0, String arg1)");
                
                LeagueTable leaguetable1 = new LeagueTable(leagueCaption, matchday, Standing);
            
                return leaguetable1;
                
            }else{
                
                System.out.println("\n\n\t ENTRA no >  ELSE  <   (null) -->    count > 0");
                
                //LeagueTable leaguetable = new LeagueTable(null, 0, null);
                
                return null;
                
            } 
            
            //return teamManagement;
        }catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> MappingJSONToClasses --> LeagueTable || Team");
        } catch (IOException ex) {
            System.out.println("\n Erro IOException --> MappingJSONToClasses --> LeagueTable || Team");
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    * Método responsável por retornar uma coleção de jogos 
    * tendo por base uma coleção de equipas e uma string em formato JSON
    * @param TeamManagementeContract teams
    * @param String content
    * return coleção de jogos
    */
    @Override
    public FixtureManagementContract StringToFixtures(TeamManagementContract arg0, String arg1) {
        
        
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /*
    * Método responsável por retornar uma equipa
    * tendo por base uma string em formato JSON
    * @param String content_team
    * return equipa
    */
    public TeamContract StringToTeam(String content_team){
        
        String name; 
        String Code; 
        String SquadMarketValue; 
        PlayerManagementContract Players;//getPlayersFromTeam(arg0);
        
        String shortName;
        String crestUrl;
        int count;
        
        String string_Link;
        String string_players;
        String string_href;
        
        JSONParser jsonParser_team = new JSONParser();
        
        try{
            
            JSONObject team = (JSONObject) jsonParser_team.parse(content_team); //
            
            System.out.println("\n\n\t Entra no StringToTeam   --> apenas recebe content_team");
            
            //Code = team.get("code").toString();
            Object string_code = team.get("code");
            if(null == string_code){
                Code = "null";
            }else{
                Code = string_code.toString();
            }
            
            //String string_count = team.get("count").toString();
            //count = Integer.parseInt(string_count);
            Object string_count = team.get("count");
            if(null == string_count){
                count = 0;
            }else{
                count = Integer.parseInt(string_count.toString());
            }
            
            Object string_name = team.get("name");
            if(null == string_name){
                name = "null";
            }else{
                name = string_name.toString();
            }
                
            //SquadMarketValue = team.get("squadMarketValue").toString();
            Object string_squadMarketValue = team.get("squadMarketValue");
            if(null == string_squadMarketValue){
                SquadMarketValue = "null";
            }else{
                SquadMarketValue = string_squadMarketValue.toString();
            }
                
            //shortName = team.get("shortName").toString();
            Object string_shortName = team.get("shortName");
            if(null == string_shortName){
                shortName = "null";
            }else{
                shortName = string_shortName.toString();
            }
                
            //crestUrl = team.get("crestUrl").toString();
            Object string_crestUrl = team.get("crestUrl");
            if(null == string_crestUrl){
                crestUrl = "null";
            }else{
                crestUrl = string_crestUrl.toString();
            }
            
                // Procura apenas pelo "_Links"
                JSONParser jsonParser_links = new JSONParser();

                Object object_links = jsonParser_links.parse(team.toString());
                JSONObject Json_object_links = (JSONObject) object_links;

                string_Link = Json_object_links.get("_links").toString();
                System.out.println("\nStringToTeam _links:\n" +string_Link);

                // Procura apenas pelo "players"
                JSONParser jsonParser_players = new JSONParser();

                Object object_players = jsonParser_players.parse(string_Link);
                JSONObject Json_object_players = (JSONObject) object_players;

                string_players = Json_object_players.get("players").toString();
                System.out.println("\nStringToTeam players:\n" +string_players);

                // Procura apenas pelo "href"
                JSONParser jsonParser_href = new JSONParser();

                Object object_href = jsonParser_href.parse(string_players);
                JSONObject Json_object_href = (JSONObject) object_href;

                string_href = Json_object_href.get("href").toString();
                System.out.println("\nStringToTeam href = " +string_href);
                
                WebServiceConnection conection = new WebServiceConnection(apiKey);
                String players_content = conection.getContent(string_href);
                
                Players = getPlayersFromTeam(players_content);
                
                
                TeamContract teamRetorno = new Team(name, Code, SquadMarketValue, Players, shortName, crestUrl);
                
            
            return teamRetorno;
            
        }catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> MappingJSONToClasses --> Team");
        } catch (IOException ex) {
            System.out.println("\n Erro IOException --> MappingJSONToClasses --> Team");
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }
    
    
    
    /*
    * Método responsável por retornar uma coleção de equipas 
    * tendo por base uma string em formato JSON
    * @param String content
    * return coleção de equipas
    */
    @Override
    public TeamManagementContract StringToTeams(String arg0) {
        
        String name; // pedidio no impelements javaDoc
        String Code; // pedidio no impelements javaDoc
        String SquadMarketValue; // pedidio no impelements javaDoc
        PlayerManagementContract Players;//getPlayersFromTeam(arg0); // pedidio no impelements javaDoc
        
        String shortName;
        String crestUrl;
        int count;
        
        String string_Link;
        String string_players;
        String string_href;
        
        JSONParser jsonParser_team = new JSONParser();
        
        try{
            
            //JSONObject object = (JSONObject) jsonParser_team.parse(arg0); //
            
            JSONObject Json_object = (JSONObject) jsonParser_team.parse(arg0);
            
            String string_count = Json_object.get("count").toString();
            count = Integer.parseInt(string_count);
            
            System.out.println("\n\n\t Entra no StringToTeams   --> count "+count);
            
            TeamManagementContract teamManagement = new TeamManagement(count+1);
            
            JSONArray arrayTeams = (JSONArray) Json_object.get("teams");
            
            for(int aux=0; aux<count; aux++){
                
                JSONObject team = (JSONObject) arrayTeams.get(aux); // position aux 
                
                System.out.println("\n AUX: "+aux +" count: "+count);
                
                // Procura apenas pelo "_Links"
                JSONParser jsonParser_links = new JSONParser();

                Object object_links = jsonParser_links.parse(team.toString());
                JSONObject Json_object_links = (JSONObject) object_links;

                string_Link = Json_object_links.get("_links").toString();
                System.out.println("\nStringToTeams _links:\n" +string_Link);

                // Procura apenas pelo "players"
                JSONParser jsonParser_players = new JSONParser();

                Object object_players = jsonParser_players.parse(string_Link);
                JSONObject Json_object_players = (JSONObject) object_players;

                string_players = Json_object_players.get("players").toString();
                System.out.println("\nStringToTeams players:\n" +string_players);

                // Procura apenas pelo "href"
                JSONParser jsonParser_href = new JSONParser();

                Object object_href = jsonParser_href.parse(string_players);
                JSONObject Json_object_href = (JSONObject) object_href;

                string_href = Json_object_href.get("href").toString();
                System.out.println("\nStringToTeams href = " +string_href);
                
                WebServiceConnection conection = new WebServiceConnection(apiKey);
                String players_content = conection.getContent(string_href);
                
                Players = getPlayersFromTeam(players_content);
                
                
                //Players = new Players(connection.getPlayers(id)); // pedidio no impelements javaDoc
                //name = team.get("name").toString();
                Object string_name = team.get("name");
                if(null == string_name){
                    name = "null";
                }else{
                    name = string_name.toString();
                }
                
                //Code = team.get("code").toString();
                Object string_code = team.get("code");
                if(null == string_code){
                    Code = "null";
                }else{
                    Code = string_code.toString();
                }
                
                //SquadMarketValue = team.get("squadMarketValue").toString();
                Object string_squadMarketValue = team.get("squadMarketValue");
                if(null == string_squadMarketValue){
                    SquadMarketValue = "null";
                }else{
                    SquadMarketValue = string_squadMarketValue.toString();
                }
                
                //shortName = team.get("shortName").toString();
                Object string_shortName = team.get("shortName");
                if(null == string_shortName){
                    shortName = "null";
                }else{
                    shortName = string_shortName.toString();
                }
                
                //crestUrl = team.get("crestUrl").toString();
                Object string_crestUrl = team.get("crestUrl");
                if(null == string_crestUrl){
                    crestUrl = "null";
                }else{
                    crestUrl = string_crestUrl.toString();
                }
                
                TeamContract team1 = new Team(name, Code, SquadMarketValue, Players, shortName, crestUrl);
                
                teamManagement.addObject(team1);
                
            }
            return teamManagement;
            
        }catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> MappingJSONToClasses --> Team");
        } catch (IOException ex) {
            System.out.println("\n Erro IOException --> MappingJSONToClasses --> Team");
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    * Método responsável por retornar uma uma coleção de jogadores 
    * tendo por base uma string em formato JSON
    * @param String content de team
    * return coleção de jogadores
    */
    @Override
    public PlayerManagementContract getPlayersFromTeam(String arg0) {
        
        String name; // pedidio no impelements javaDoc
        String position; // pedidio no impelements javaDoc
        int jerseyNumber; // pedidio no impelements javaDoc
        NationalityContract nationality; // pedidio no impelements javaDoc
        String marketValue; // pedidio no impelements javaDoc
        int age; // pedidio no impelements javaDoc
    
        int count;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth;
        Date contractUntil;
        
        String string_Link;
        String string_players;
        String string_href;
        
        
        JSONParser jsonParser = new JSONParser();
        try{
            
            JSONObject Json_object_team = (JSONObject) jsonParser.parse(arg0); 
            
            //JSONObject Json_object = (JSONObject) jsonParser.parse(players_content);
            JSONObject Json_object = (JSONObject) jsonParser.parse(Json_object_team.toString());
            
            String string_count = Json_object.get("count").toString();
            count = Integer.parseInt(string_count);
            
            System.out.println("\n\n\t Entra no getPlayersFromTeam   --> count "+count);
            
            PlayerManagementContract playerManagement = new PlayerManagement(count);
            
            JSONArray arrayPlayers = (JSONArray) Json_object.get("players");
            
            for(int aux=0; aux<count; aux++){
                
                JSONObject player = (JSONObject) arrayPlayers.get(aux); // position aux 
                
                //name = player.get("name").toString();//.get("id").toString();
                Object string_name = player.get("name");
                if(null == string_name){
                    name = "null";
                }else{
                    name = string_name.toString();
                }
                
                //position = player.get("position").toString();
                Object string_position = player.get("position");
                if(null == string_position){
                    position = "null";
                }else{
                    position = string_position.toString();
                }
                
                //String string_dateOfBirth = player.get("dateOfBirth").toString();
                //dateOfBirth = dateFormat.parse(string_dateOfBirth.toString());
                Object string_dateOfBirth = player.get("dateOfBirth");
                if(null == string_dateOfBirth){
                    dateOfBirth = dateFormat.parse("0-0-0");
                }else{
                    //position = string_dateOfBirth.toString();
                    dateOfBirth = dateFormat.parse(string_dateOfBirth.toString());
                }
                

                String nationalityTemp = player.get("nationality").toString();
                nationality = new Nationality(nationalityTemp);
                Object string_nationality = player.get("nationality");
                if(null == string_nationality){
                    nationality = new Nationality("Not Found");
                }else{
                    nationality = new Nationality(string_nationality.toString());
                }
                
                
                //String string_contractUntil = player.get("contractUntil").toString();
                //contractUntil = dateFormat.parse(string_contractUntil);
                Object string_contractUntil = player.get("contractUntil");
                if(null == string_contractUntil){
                    contractUntil = dateFormat.parse("0-0-0");
                }else{
                    //position = string_dateOfBirth.toString();
                    contractUntil = dateFormat.parse(string_contractUntil.toString());
                }
                
                
                //marketValue = player.get("marketValue").toString();
                Object string_marketValue = player.get("marketValue");
                if(null == string_marketValue){
                    marketValue = "null";
                }else{
                    marketValue = string_marketValue.toString();
                }
                
                
                Object string_jerseyNumber = player.get("jerseyNumber");
                if(null == string_jerseyNumber){
                    jerseyNumber = 0;
                }else{
                    jerseyNumber = Integer.parseInt(string_jerseyNumber.toString());
                }
                
                // Calcular idade player
                Calendar dateOfDOB = Calendar.getInstance();
                dateOfDOB.setTime(dateOfBirth);

                Calendar CurrentDate = Calendar.getInstance();
                CurrentDate.setTime(new Date()); // Today

                //System.out.println("  AGE: "+ (CurrentDate.get(Calendar.YEAR) - dateofDOB.get(Calendar.YEAR)) );
                age = (CurrentDate.get(Calendar.YEAR) - dateOfDOB.get(Calendar.YEAR));
                // end calcular idade player
                
                Player player1 = new Player(name, position, jerseyNumber, nationality, marketValue, age, dateOfBirth, contractUntil);
                
                playerManagement.addObject(player1);
                
                System.out.println("\n Player --> getPlayerFromTeam: \n"+player1.toString());
                
            }
            
            return playerManagement;
            
        } catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> MappingJSONToClasses --> Player\n");
            
        } catch (java.text.ParseException ex) {
            System.out.println("\n Erro ParseException --> Assign_Data - DOB --> MappingJSONToClasses --> Player\n");
        }
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
