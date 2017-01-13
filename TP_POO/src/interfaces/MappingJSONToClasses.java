package interfaces;

import interfaces.Management.CompetitionManagementContract;
import interfaces.Management.FixtureManagementContract;
import interfaces.Management.PlayerManagementContract;
import interfaces.Management.TeamManagementContract;

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
    
    private final String Json_String;
    
    /*
    * Constructor recebe uma String de Json
    * @param String Json_String
    */
    public MappingJSONToClasses(String Json_String) {
        this.Json_String = Json_String;
    }
    
    /*
    * Método responsável por retornar uma competição 
    * tendo por base uma string em formato JSON
    * @param String content
    * return competições
    */
    @Override
    public CompetitionManagementContract StringToCompetitions(String arg0) {
        
        int id;
        String caption;
        String league;
        String year;
        int currentMatchday;
        int numberOfMatchdays;
        int numberOfTeams;
        int numberOfGames;
        String lastUpdated;
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    * Método responsável por retornar uma liga 
    * tendo por base uma coleção de equipas e uma string em formato JSON
    * @param TeamManagementContract teams
    * @param String content
    * return liga
    */
    @Override
    public LeagueTableContract StringToLeagueTable(TeamManagementContract arg0, String arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    * Método responsável por retornar uma coleção de equipas 
    * tendo por base uma string em formato JSON
    * @param String content
    * return coleção de equipas
    */
    @Override
    public TeamManagementContract StringToTeams(String arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    * Método responsável por retornar uma uma coleção de jogadores 
    * tendo por base uma string em formato JSON
    * @param String content
    * return coleção de jogadores
    */
    @Override
    public PlayerManagementContract getPlayersFromTeam(String arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
