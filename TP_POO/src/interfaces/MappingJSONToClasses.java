package interfaces;

import interfaces.Management.CompetitionManagementContract;
import interfaces.Management.FixtureManagement;
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
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        System.out.println("\n Retorno null --> MappingJsonToClasses --> StringToCompetitions");
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
        
        String string_Link;
        String string_teams_link;
        String string_href_teams;
        
        String string_fixtures_link;
        String string_href_fixtures;
        
        String string_leagueTable_link;
        String string_href_leagueTable;
        
        JSONParser jsonParser = new JSONParser();
        try{
            
            JSONObject object = (JSONObject) jsonParser.parse(arg0); // Json_Player contem a string das competitions
            
            //this.fixtures = new Fixtures(connection.getFixtures(id)); // pedidio no impelements javaDoc
            //this.leagueTable = new LeagueTable(connection.getLeagueTable(id)); // pedidio no impelements javaDoc
            //this.teams = (TeamManagementContract) new Team(connection.getTeams(id)); // pedidio no impelements javaDoc
            
            // Procura apenas pelo "_Links"
                JSONParser jsonParser_links = new JSONParser();

                Object object_links = jsonParser_links.parse(object.toString());
                JSONObject Json_object_links = (JSONObject) object_links;

                string_Link = Json_object_links.get("_links").toString();
                //System.out.println(" StringToCompetition _links: " +string_Link);

                // Procura apenas pelo "team"
                JSONParser jsonParser_team = new JSONParser();

                Object object_teams = jsonParser_team.parse(string_Link);
                JSONObject Json_object_teams = (JSONObject) object_teams;

                string_teams_link = Json_object_teams.get("teams").toString();
                //System.out.println(" StringToCompetition teams: " +string_teams_link);

                // Procura apenas pelo "href"
                JSONParser jsonParser_href_teams = new JSONParser();

                Object object_href_teams = jsonParser_href_teams.parse(string_teams_link);
                JSONObject Json_object_href_teams = (JSONObject) object_href_teams;

                string_href_teams = Json_object_href_teams.get("href").toString();
                //System.out.println(" StringToCompetition href teams = " +string_href_teams);
                
                // Procura apenas pelo "fixtures"
                JSONParser jsonParser_fixtures = new JSONParser();

                Object object_fixtures = jsonParser_fixtures.parse(string_Link);
                JSONObject Json_object_fixtures = (JSONObject) object_fixtures;

                string_fixtures_link = Json_object_fixtures.get("fixtures").toString();
                //System.out.println(" StringToCompetition fixtures: " +string_fixtures_link);

                // Procura apenas pelo "href" fixtures
                JSONParser jsonParser_href_fixtures = new JSONParser();

                Object object_href_fixtures = jsonParser_href_fixtures.parse(string_fixtures_link);
                JSONObject Json_object_href_fixtures = (JSONObject) object_href_fixtures;

                string_href_fixtures = Json_object_href_fixtures.get("href").toString();
                System.out.println(" StringToCompetition href fixtures = " +string_href_fixtures);
                
                // Procura apenas pelo "leagueTable"
                JSONParser jsonParser_leagueTable = new JSONParser();

                Object object_leagueTable = jsonParser_leagueTable.parse(string_Link);
                JSONObject Json_object_leagueTable = (JSONObject) object_leagueTable;

                string_leagueTable_link = Json_object_leagueTable.get("leagueTable").toString();
                //System.out.println(" StringToCompetition leagueTable: " +string_leagueTable_link);

                // Procura apenas pelo "href" leagueTable
                JSONParser jsonParser_href_leagueTable = new JSONParser();

                Object object_href_leagueTable = jsonParser_href_leagueTable.parse(string_leagueTable_link);
                JSONObject Json_object_href_leagueTable = (JSONObject) object_href_leagueTable;

                string_href_leagueTable = Json_object_href_leagueTable.get("href").toString();
                //System.out.println(" StringToCompetition href leagueTable = " +string_href_leagueTable);
                
                // WebConnections
                WebServiceConnection conection = new WebServiceConnection(apiKey);
                
                String team_content = conection.getContent(string_href_teams);
                teams = StringToTeams(team_content); // Team guardada do Standing[0] array
                //System.out.println("\n \t Recebe a team do StringToCompetition");
                
                System.out.println("\n Mostra Teams da Competition: "+teams.toString());
                
                
                String fixtures_content = conection.getContent(string_href_fixtures);
                //fixtures = StringToFixtures(teams, fixtures_content);
                //System.out.println("\n \t Recebe a fixtures do StringToCompetition");
                
                String leagueTable_content = conection.getContent(string_href_leagueTable);
                leagueTable = StringToLeagueTable(teams, leagueTable_content);
                //System.out.println("\n \t Recebe a leagueTable do StringToCompetition");
                
            //String string_id = object.get("id").toString();
            //id = Integer.parseInt(string_id); // pedidio no impelements javaDoc
            Object object_id = object.get("id");
            if(null == object_id){
                id = 0;
            }else{
                id = Integer.parseInt(object_id.toString());
            }
            
            //String string_year = object.get("year").toString();
            //year = Integer.parseInt(string_year); // pedidio no impelements javaDoc
            Object object_year = object.get("year");
            if(null == object_year){
                year = 0;
            }else{
                year = Integer.parseInt(object_year.toString());
            }
            
            //caption = object.get("caption").toString();
            Object object_caption = object.get("caption");
            if(null == object_caption){
                caption = "null";
            }else{
                caption = object_caption.toString();
            }
            
            //String string_currentMatchday = object.get("currentMatchday").toString();
            //currentMatchday = Integer.parseInt(string_currentMatchday);
            Object object_currentMatchday = object.get("currentMatchday");
            if(null == object_currentMatchday){
                currentMatchday = 0;
            }else{
                currentMatchday = Integer.parseInt(object_currentMatchday.toString());
            }
            
            //String string_numberOfMatchdays = object.get("numberOfMatchdays").toString();
            //numberOfMatchdays = Integer.parseInt(string_numberOfMatchdays);
            Object object_numberOfMatchdays = object.get("numberOfMatchdays");
            if(null == object_numberOfMatchdays){
                numberOfMatchdays = 0;
            }else{
                numberOfMatchdays = Integer.parseInt(object_numberOfMatchdays.toString());
            }
            
            //String string_numberOfTeams = object.get("numberOfTeams").toString();
            //numberOfTeams = Integer.parseInt(string_numberOfTeams);
            Object object_numberOfTeams = object.get("numberOfTeams");
            if(null == object_numberOfTeams){
                numberOfTeams = 0;
            }else{
                numberOfTeams = Integer.parseInt(object_numberOfTeams.toString());
            }
            
            //String string_numberOfGames = object.get("numberOfGames").toString();
            //numberOfGames = Integer.parseInt(string_numberOfGames);
            Object object_numberOfGames = object.get("numberOfGames");
            if(null == object_numberOfGames){
                numberOfGames = 0;
            }else{
                numberOfGames = Integer.parseInt(object_numberOfGames.toString());
            }
                
            //lastUpdated = object.get("lastUpdated").toString();   
            Object object_lastUpdated = object.get("lastUpdated");
            if(null == object_lastUpdated){
                lastUpdated = "null";
            }else{
                lastUpdated = object_lastUpdated.toString();
            }
               
            CompetitionContract competition1 = new Competition(fixtures, leagueTable, teams, id, year, caption, currentMatchday, numberOfMatchdays, numberOfTeams, numberOfGames, lastUpdated);
            
            return competition1;
            
        }catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> MappingJSONToClasses --> Competition");
            //Logger.getLogger(FootballContract.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("\n Erro IOException --> MappingJSONToClasses --> Competition");
            //Logger.getLogger(MappingJSONToClasses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("\n Retorno null --> MappingJsonToClasses --> StringToCompetition");
        //FixtureManagementContract fixtures, LeagueTableContract leagueTable, TeamManagementContract teams, int id, int year, String caption, int currentMatchday, int numberOfMatchdays, int numberOfTeams, int numberOfGames, String lastUpdated
        CompetitionContract competitionResult = new Competition(fixtures=null, leagueTable=null, teams=null, 0, 0, "null", 0, 0, 0, 0, "null");
        return competitionResult;
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
        StandingsManagementContract Standing = null;//getPlayersFromTeam(arg0); 
        
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
        
        StatisticsStanding home;
        StatisticsStanding away;
        
        int count = 0;
        
        String string_Link;
        String string_team;
        String string_href;
        
        JSONParser jsonParser_leagueTable = new JSONParser();
        
        try{
            
            //JSONObject object = (JSONObject) jsonParser_team.parse(arg0); //
            
            JSONObject leagueTable = (JSONObject) jsonParser_leagueTable.parse(arg1);
            
            //String string_count = team.get("count").toString();
            //count = Integer.parseInt(string_count);
            
            Object object_leagueCaption = leagueTable.get("leagueCaption");
            if(null == object_leagueCaption){
                leagueCaption = "null";
            }else{
                leagueCaption = object_leagueCaption.toString();
                //System.out.println("\n LeagueCaption: "+leagueCaption);
            }
                
            Object object_matchday = leagueTable.get("matchday");
            if(null == object_matchday){
                matchday = 0;
            }else{
                matchday = Integer.parseInt(object_matchday.toString());
            }
            
            JSONArray arrayLeagueTable = (JSONArray) leagueTable.get("standing");
            
            //System.out.println("\n\n\t Entra no StringToLeagueTable   --> count do arrayLeagueTable: "+arrayLeagueTable.size());
            
            Standing = new StandingsManagement(arrayLeagueTable.size()+1);
            
            for(int aux=0; aux<arrayLeagueTable.size(); aux++){
                
                JSONObject standing = (JSONObject) arrayLeagueTable.get(aux); // position aux 
                /*
                System.out.println("\n SantingArray aux:"+aux );
                
                if(aux == 10 || aux == 20 || aux == 28 || aux == 30){
                    System.out.println(" Thread.sleep(30 000)"); 
                    Thread.sleep(30000);//1337
                }*/
                
                // Procura apenas pelo "_Links"
                JSONParser jsonParser_links = new JSONParser();

                Object object_links = jsonParser_links.parse(standing.toString());
                JSONObject Json_object_links = (JSONObject) object_links;

                string_Link = Json_object_links.get("_links").toString();
                //System.out.println(" StringTostanding _links: " +string_Link);

                // Procura apenas pelo "team"
                JSONParser jsonParser_players = new JSONParser();

                Object object_players = jsonParser_players.parse(string_Link);
                JSONObject Json_object_players = (JSONObject) object_players;

                string_team = Json_object_players.get("team").toString();
                //System.out.println(" From StringToLeagueTable --> StringTostanding team: " +string_team);

                // Procura apenas pelo "href"
                JSONParser jsonParser_href = new JSONParser();

                Object object_href = jsonParser_href.parse(string_team);
                JSONObject Json_object_href = (JSONObject) object_href;

                string_href = Json_object_href.get("href").toString();
                System.out.println(" From StringToLeagueTable --> StringTostanding href = " +string_href);
                
                WebServiceConnection conection = new WebServiceConnection(apiKey);
                String team_content = conection.getContent(string_href);
                
                TeamContract team = StringToTeam(team_content); // Team guardada do Standing[0] array
                //System.out.println("\n \t Recebe a team do Standing --> OK");
                
                Object object_position = standing.get("position");
                if(null == object_position){
                    position = 0;
                }else{
                    position = Integer.parseInt(object_position.toString());
                }
                
                Object object_teamName = standing.get("teamName");
                if(null == object_teamName){
                    teamName = "null";
                }else{
                    teamName = object_teamName.toString();
                }
                
                Object object_crestURI = standing.get("crestURI");
                if(null == object_crestURI){
                    crestURI = "null";
                }else{
                    crestURI = object_crestURI.toString();
                }
                
                Object object_playedGames = standing.get("playedGames");
                if(null == object_playedGames){
                    playedGames = 0;
                }else{
                    playedGames = Integer.parseInt(object_playedGames.toString());
                }
                
                Object object_points = standing.get("points");
                if(null == object_points){
                    points = 0;
                }else{
                    points = Integer.parseInt(object_points.toString());
                }
                
                Object object_goals = standing.get("goals");
                if(null == object_goals){
                    goals_standing = 0;
                }else{
                    goals_standing = Integer.parseInt(object_goals.toString());
                }
                
                Object object_goalsAgainst = standing.get("goalsAgainst");
                if(null == object_goalsAgainst){
                    goalsAgainst_standing = 0;
                }else{
                    goalsAgainst_standing = Integer.parseInt(object_goalsAgainst.toString());
                }
                
                Object object_goalDifference = standing.get("goalDifference");
                if(null == object_goalDifference){
                    goalDifference_standing = 0;
                }else{
                    goalDifference_standing = Integer.parseInt(object_goalDifference.toString());
                }
                
                Object object_wins = standing.get("wins");
                if(null == object_wins){
                    wins_standing = 0;
                }else{
                    wins_standing = Integer.parseInt(object_wins.toString());
                }
                
                Object object_draws = standing.get("draws");
                if(null == object_draws){
                    draws_standing = 0;
                }else{
                    draws_standing = Integer.parseInt(object_draws.toString());
                }
                
                Object object_losses = standing.get("losses");
                if(null == object_losses){
                    losses_standing = 0;
                }else{
                    losses_standing = Integer.parseInt(object_losses.toString());
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
                //
                //  Lê no objecto Json "away"
                JSONObject object_away = (JSONObject) standing.get("away");
                
                Object object_goals_away = object_away.get("goals");
                if(null == object_goals_away){
                    goals_away = 0;
                }else{
                    goals_away = Integer.parseInt(object_goals_away.toString());
                }
                
                Object object_goalsAgainst_away = object_away.get("goalsAgainst");
                if(null == object_goalsAgainst_away){
                    goalsAgainst_away = 0;
                }else{
                    goalsAgainst_away = Integer.parseInt(object_goalsAgainst_away.toString());
                }
                                
                Object object_wins_away = object_away.get("wins");
                if(null == object_wins_away){
                    wins_away = 0;
                }else{
                    wins_away = Integer.parseInt(object_wins_away.toString());
                }
                
                Object object_draws_away = object_away.get("draws");
                if(null == object_draws_away){
                    draws_away = 0;
                }else{
                    draws_away = Integer.parseInt(object_draws_away.toString());
                }
                
                Object object_losses_away = object_away.get("losses");
                if(null == object_losses_away){
                    losses_away = 0;
                }else{
                    losses_away = Integer.parseInt(object_losses_away.toString());
                }
                // Cria o Objecto away
                away = new StatisticsStanding(goals_away, goalsAgainst_away, wins_away, draws_away, losses_away);
                
                StandingInterface standingArray = new Standing(position, teamName, crestURI, playedGames, points, goals_standing, goalsAgainst_standing, goalDifference_standing, wins_standing, draws_standing, losses_standing, home, away, team);
                Standing.addObject(standingArray);
                
                //System.out.println("\n Apresenta arg0 : "+arg0.toString());
                /*
                TeamManagement teamManagementCompara = (TeamManagement) arg0;
                
                //SArrays.sort(teamManagementCompara, teamManagementCompara, Arrays.ASCENDING);ystem.out.println("\n\n arg0 --> teamManagementCompara: "+teamManagementCompara.toString());
                
                for(int j=0; j<teamManagementCompara.size(); j++){
                    
                    Team teamCompara = (Team) teamManagementCompara.getObject(j);
                    
                    //System.out.println("\n teamCompara de .getObject("+j+"): "+teamCompara.toString());
                    //System.out.println("\n team do LeagueTable aux: "+aux+": "+team.toString());
                    
                    System.out.println("\n\n    Nomes a compara teamCompara(arg0).getname: "+teamCompara.getName() +" team.getname: "+team.getName());
                    
                    if(teamCompara.getName().equals(team.getName())){
                        count++;
                        System.out.println("\n   count incrementa: "+count);
                        
                    }else{
                        System.out.println("\n   count: "+count);
                    }
                }
                */
                
                //System.out.println("\n Finalza Santing aux:"+aux+" StandingArray --> Standing["+aux+"]: "+standingArray.toString());
                
            }// Percorre array standing  --> internamente guarda no construtor a team
            
            //TeamManagement teamManagementCompara = (TeamManagement) arg0;
            //if(count == teamManagementCompara.size()){
                
                //System.out.println("\n\n\t ENTRA no if count > 0 do StringToLeagueTable(TeamManagementContract arg0, String arg1)");
                
                LeagueTable leaguetable1 = new LeagueTable(leagueCaption, matchday, Standing);
                
                //System.out.println("leagueTable = "+leaguetable1.toString());
                
                return leaguetable1;
                
            //}
            
            //return teamManagement;
        }catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> MappingJSONToClasses --> LeagueTable || Team");
        } catch (IOException ex) {
            System.out.println("\n Erro IOException --> MappingJSONToClasses --> LeagueTable || Team");
        }
        
        System.out.println("\n Retorno null --> MappingJsonToClasses --> StringToLeagueTable");
        LeagueTable leaguetableresult = new LeagueTable("null", 0, Standing=null);
        return leaguetableresult;
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
        
        
        
        
        System.out.println("\n Retorno null --> MappingJsonToClasses --> StringToFixtures");
        
        FixtureManagementContract fixtureManagementResult = new FixtureManagement(null);
        return fixtureManagementResult;
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
        PlayerManagementContract Players = null;//getPlayersFromTeam(arg0); // pedidio no impelements javaDoc
        
        String shortName;
        String crestUrl;
        int count;
        
        String string_Link;
        String string_players;
        String string_href;
        
        TeamManagementContract teamManagement = null;
        
        
        JSONParser jsonParser_team = new JSONParser();
        
        try{
            
            JSONObject Json_object = (JSONObject) jsonParser_team.parse(arg0);
            
            //String string_count = Json_object.get("count").toString();
            //count = Integer.parseInt(string_count);
            Object object_count = Json_object.get("count");
            if(null == object_count){
                count = 0;
            }else{
                count = Integer.parseInt(object_count.toString());
            }
            //System.out.println("\n\n\t Entra no StringToTeams   --> count "+count);
            
            if(count != 0){
                teamManagement = new TeamManagement(count+1);
                
            }else{
                teamManagement = null;
                //System.out.println("\n teamManagement = null ");
            }
            
            JSONArray arrayTeams = (JSONArray) Json_object.get("teams");
            
            //System.out.println("\n count: "+count +"  arrayTeams Size: "+arrayTeams.size());
            
            for(int aux=0; aux<count; aux++){
                
                JSONObject team = (JSONObject) arrayTeams.get(aux); // position aux 
                
                //System.out.println("\n AUX: "+aux +" count: "+count);
                
                // Procura apenas pelo "_Links"
                JSONParser jsonParser_links = new JSONParser();

                Object object_links = jsonParser_links.parse(team.toString());
                JSONObject Json_object_links = (JSONObject) object_links;

                string_Link = Json_object_links.get("_links").toString();
                //System.out.println("\nStringToTeams _links:\n" +string_Link);

                // Procura apenas pelo "players"
                JSONParser jsonParser_players = new JSONParser();

                Object object_players = jsonParser_players.parse(string_Link);
                JSONObject Json_object_players = (JSONObject) object_players;

                string_players = Json_object_players.get("self").toString(); // players
                //System.out.println("\nStringToTeams self:\n" +string_players);

                // Procura apenas pelo "href"
                JSONParser jsonParser_href = new JSONParser();

                Object object_href = jsonParser_href.parse(string_players);
                JSONObject Json_object_href = (JSONObject) object_href;

                string_href = Json_object_href.get("href").toString(); // envia ex:v1/teams/496
                //System.out.println("\n StringToTeams href = " +string_href);
                
                WebServiceConnection conection = new WebServiceConnection(apiKey);
                String players_content = conection.getContent(string_href);
                
                Players = getPlayersFromTeam(players_content);
                
                //Players = new Players(connection.getPlayers(id)); // pedidio no impelements javaDoc
                //name = team.get("name").toString();
                Object object_name = team.get("name");
                if(null == object_name){
                    name = "null";
                }else{
                    name = object_name.toString();
                }
                
                //Code = team.get("code").toString();
                Object object_code = team.get("code");
                if(null == object_code){
                    Code = "null";
                }else{
                    Code = object_code.toString();
                }
                
                //SquadMarketValue = team.get("squadMarketValue").toString();
                Object object_squadMarketValue = team.get("squadMarketValue");
                if(null == object_squadMarketValue){
                    SquadMarketValue = "null";
                }else{
                    SquadMarketValue = object_squadMarketValue.toString();
                }
                
                //shortName = team.get("shortName").toString();
                Object object_shortName = team.get("shortName");
                if(null == object_shortName){
                    shortName = "null";
                }else{
                    shortName = object_shortName.toString();
                }
                
                //crestUrl = team.get("crestUrl").toString();
                Object object_crestUrl = team.get("crestUrl");
                if(null == object_crestUrl){
                    crestUrl = "null";
                }else{
                    crestUrl = object_crestUrl.toString();
                }
                
                TeamContract team1 = new Team(name, Code, SquadMarketValue, Players, shortName, crestUrl);
                
                if(teamManagement!= null) teamManagement.addObject(team1);
                //System.out.println("\n MappingJsonToClasses -->StringToTeam --> team adiciona FOR(aux)("+aux+") --> OK");
                
            }
            return teamManagement;
            
        }catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> MappingJSONToClasses --> Team");
        } catch (IOException ex) {
            System.out.println("\n Erro IOException --> MappingJSONToClasses --> Team");
        }
        System.out.println("\n Retorno null --> MappingJsonToClasses --> StringToTeams");
        TeamManagementContract teamResult = new TeamManagement(null);
        return teamResult;
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
    
        int count; // contador auxiliar
        PlayerManagementContract playerManagement = null;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth;
        Date contractUntil;
        
        String string_Link;
        String string_players;
        String string_href;
        
        
        JSONParser Json_Parser = new JSONParser();
        try{
            
            JSONObject Json_object_team = (JSONObject) Json_Parser.parse(arg0); 
            
            // Procura apenas pelo "_Links"
            JSONParser jsonParser_links = new JSONParser();

            Object object_links = jsonParser_links.parse(Json_object_team.toString());
            JSONObject Json_object_links = (JSONObject) object_links;

            string_Link = Json_object_links.get("_links").toString();
            //System.out.println("\nStringToTeams _links:\n" +string_Link);

            // Procura apenas pelo "players"
            JSONParser jsonParser_players = new JSONParser();

            Object object_players = jsonParser_players.parse(string_Link);
            JSONObject Json_object_players = (JSONObject) object_players;

            string_players = Json_object_players.get("players").toString();
            //System.out.println("\nStringToTeams players:\n" +string_players);

            // Procura apenas pelo "href"
            JSONParser jsonParser_href = new JSONParser();

            Object object_href = jsonParser_href.parse(string_players);
            JSONObject Json_object_href = (JSONObject) object_href;

            string_href = Json_object_href.get("href").toString();
            //System.out.println("\nStringToTeams href = " +string_href);

            WebServiceConnection conection = new WebServiceConnection(apiKey);
            String players_content = conection.getContent(string_href);
            
            JSONObject JSONObject_players = (JSONObject) Json_Parser.parse(players_content);
            
            //String string_count = Json_object.get("count").toString();
            //count = Integer.parseInt(string_count);
            Object object_count = JSONObject_players.get("count");
            if(null == object_count){
                count = 0;
            }else{
                count = Integer.parseInt(object_count.toString());
            }
            
            //System.out.println("\n count: "+count); 
            //System.out.println("\n\n\t Entra no getPlayersFromTeam   --> count "+count);
            if(count != 0){
                playerManagement = new PlayerManagement(count+1);
            }else playerManagement=null;
            
            JSONArray arrayPlayers = (JSONArray) JSONObject_players.get("players");
            //System.out.println("\n arrayplayers "+arrayPlayers.toString());
            
            for(int aux=0; aux<count; aux++){
                
                JSONObject player = (JSONObject) arrayPlayers.get(aux); // position aux 
                
                //name = player.get("name").toString();//.get("id").toString();
                Object object_name = player.get("name");
                if(null == object_name){
                    name = "null";
                }else{
                    name = object_name.toString();
                }
                
                //position = player.get("position").toString();
                Object object_position = player.get("position");
                if(null == object_position){
                    position = "null";
                }else{
                    position = object_position.toString();
                }
                
                //String string_dateOfBirth = player.get("dateOfBirth").toString();
                //dateOfBirth = dateFormat.parse(string_dateOfBirth.toString());
                Object object_dateOfBirth = player.get("dateOfBirth");
                if(null == object_dateOfBirth){
                    dateOfBirth = dateFormat.parse("0-0-0");
                }else{
                    //position = string_dateOfBirth.toString();
                    dateOfBirth = dateFormat.parse(object_dateOfBirth.toString());
                }
                
                String nationalityTemp = player.get("nationality").toString();
                nationality = new Nationality(nationalityTemp);
                Object object_nationality = player.get("nationality");
                if(null == object_nationality){
                    nationality = new Nationality("Not Found");
                }else{
                    nationality = new Nationality(object_nationality.toString());
                }
                
                
                //String string_contractUntil = player.get("contractUntil").toString();
                //contractUntil = dateFormat.parse(string_contractUntil);
                Object object_contractUntil = player.get("contractUntil");
                if(null == object_contractUntil){
                    contractUntil = dateFormat.parse("0-0-0");
                }else{
                    //position = string_dateOfBirth.toString();
                    contractUntil = dateFormat.parse(object_contractUntil.toString());
                }
                
                
                //marketValue = player.get("marketValue").toString();
                Object object_marketValue = player.get("marketValue");
                if(null == object_marketValue){
                    marketValue = "null";
                }else{
                    marketValue = object_marketValue.toString();
                }
                
                
                Object object_jerseyNumber = player.get("jerseyNumber");
                if(null == object_jerseyNumber){
                    jerseyNumber = 0;
                }else{
                    jerseyNumber = Integer.parseInt(object_jerseyNumber.toString());
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
                
                //System.out.println("\n Player --> getPlayerFromTeam: -> aux: "+aux+" -->  "+player1.toString());
                //System.out.println(" Player --> getPlayerFromTeam -> aux: "+aux+" --> OK \n");
            }
            
            return playerManagement;
            
        } catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> MappingJSONToClasses --> Player\n");
            
        } catch (java.text.ParseException ex) {
            System.out.println("\n Erro ParseException --> Assign_Data - DOB --> MappingJSONToClasses --> getPlayersFromTeam");
        } catch (IOException ex) {
            System.out.println("\n Erro IOException --> MappingJSONToClasses --> getPlayersFromTeam");
        }
        System.out.println("\n Retorno null --> MappingJsonToClasses --> GetPlayersFromTeam");
        PlayerManagementContract playerManagementResult = new PlayerManagement(null);
        return playerManagementResult;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        //int count;
        
        String string_Link;
        String string_players;
        String string_href;
        
        
        JSONParser jsonParser_team = new JSONParser();
        
        try{
            JSONObject team = (JSONObject) jsonParser_team.parse(content_team); //
            //System.out.println("\n\n\t Entra no StringToTeam   --> apenas recebe content_team");
            
            // Procura apenas pelo "_Links"
            string_Link = team.get("_links").toString();
            //System.out.println(" StringToTeam _links: " +string_Link);

            // Procura apenas pelo "players"
            JSONParser jsonParser_players = new JSONParser();

            Object object_players = jsonParser_players.parse(string_Link);
            JSONObject Json_object_players = (JSONObject) object_players;

            string_players = Json_object_players.get("self").toString();
            //System.out.println(" StringToTeam players: " +string_players);

            // Procura apenas pelo "href"
            JSONParser jsonParser_href = new JSONParser();

            Object object_href = jsonParser_href.parse(string_players);
            JSONObject Json_object_href = (JSONObject) object_href;

            string_href = Json_object_href.get("href").toString();
            //System.out.println(" StringToTeam href = " +string_href);

            WebServiceConnection conection = new WebServiceConnection(apiKey);
            String players_content = conection.getContent(string_href);

            Players = getPlayersFromTeam(players_content);
            
            //Code = team.get("code").toString();
            Object object_code = team.get("code");
            if(null == object_code){
                Code = "null";
            }else{
                Code = object_code.toString();
            }
            /*
            //String string_count = team.get("count").toString();
            //count = Integer.parseInt(string_count);
            Object object_count = team.get("count");
            if(null == object_count){
                count = 0;
            }else{
                count = Integer.parseInt(object_count.toString());
            }*/
            
            Object object_name = team.get("name");
            if(null == object_name){
                name = "null";
            }else{
                name = object_name.toString();
            }
                
            //SquadMarketValue = team.get("squadMarketValue").toString();
            Object object_squadMarketValue = team.get("squadMarketValue");
            if(null == object_squadMarketValue){
                SquadMarketValue = "null";
            }else{
                SquadMarketValue = object_squadMarketValue.toString();
            }
                
            //shortName = team.get("shortName").toString();
            Object object_shortName = team.get("shortName");
            if(null == object_shortName){
                shortName = "null";
            }else{
                shortName = object_shortName.toString();
            }
                
            //crestUrl = team.get("crestUrl").toString();
            Object object_crestUrl = team.get("crestUrl");
            if(null == object_crestUrl){
                crestUrl = "null";
            }else{
                crestUrl = object_crestUrl.toString();
            }
            
            TeamContract teamRetorno = new Team(name, Code, SquadMarketValue, Players, shortName, crestUrl);
            System.out.println("  MappingJsonToClasses --> StringToTeam(content_Team) --> "+teamRetorno.toString());
            return teamRetorno;
            
        }catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> MappingJSONToClasses --> StringToTeam");
        } catch (IOException ex) {
            System.out.println("\n Erro IOException --> MappingJSONToClasses --> StringToTeam");
        }
        
        System.out.println("\n Retorno null --> MappingJsonToClasses --> StringToTeam(content_Team)");
        TeamContract teamResult = new Team("null", "null", "null", Players=null, "null", "null");
        return teamResult;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }
    
}
