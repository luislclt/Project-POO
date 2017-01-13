package tp_poo;


import exceptions.CompetitionNotFoundException;
import java.io.IOException;
import tp_poo.ServiceManager.Football;

/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public class TP_POO {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws exceptions.CompetitionNotFoundException
     */
    public static void main(String[] args) throws IOException, CompetitionNotFoundException {
        
        
        String url = "http://api.football-data.org/v1/";
        String apiKey = "4a0fdab1682e4d1384b8262f7e02d641";
        
        
        //WebServiceConnection webServiceConnection = new WebServiceConnection(apiKey);
        //String Json_competitions = webServiceConnection.getContent(url);
        
        //System.out.println(Json_competitions);
        
        //FootballContract competition1 = new Football(url, apiKey);
        //String resultado = competition1.getCompetition(424);
        
        Football football_data = new Football(url, apiKey);
        
        //String result2 = football_data.getAllCompetitions();
        //System.out.println(result2);
        
        String result = football_data.getCompetition(439);
        System.out.println("\n Competition: " +result);
        
        String resultTeam = football_data.getTeams(495);
        System.out.println("\n Team: " +resultTeam);
        
        String resultleagueTable = football_data.getLeagueTable(439);
        System.out.println("\n LeagueTable: " +resultleagueTable);
        
        String resultFixtures = football_data.getFixtures(439);
        System.out.println("\n Fixtures: " +resultFixtures);
        
        String resultPlayersTeams = football_data.getPlayers(495);
        System.out.println("\n players from Team ["+495+"]: " +resultPlayersTeams);
        
        
        //String StringPlayerJSON = "{\"name\":\"Héldon\",\"position\":\"Secondary Striker\",\"jerseyNumber\":24,\"dateOfBirth\":\"1988-11-14\",\"nationality\":\"Cape Verde\",\"contractUntil\":\"2017-06-30\",\"marketValue\":\"1,750,000 €\"}";
        //System.out.println("\n STRING PLAYER: "+StringPlayerJSON);
        
        //Player testePlayer = new Player(StringPlayerJSON);
        //System.out.println(" Player RESULT: \n "+ testePlayer.toString());
        
        //String StringPlayerJSON2 = "{\"name\":\"Filipe Augusto\",\"position\":\"Defensive Midfield\",\"jerseyNumber\":5,\"dateOfBirth\":\"1993-08-12\",\"nationality\":\"Brazil\",\"contractUntil\":\"2017-06-30\",\"marketValue\":\"1,500,000 €\"}";
        //System.out.println("\n STRING PLAYER 2: "+StringPlayerJSON2);
        
        //Player testePlayer2 = new Player(StringPlayerJSON2);
        //System.out.println("\n Player RESULT 2: "+testePlayer2.toString());
        
        
        //System.out.println("\n getNationality: "+testePlayer.getNationality().toString());
        
        //PlayerCompareTo teste = new PlayerCompareTo(testePlayer.getMarketValue());
        
        //int resultados = testePlayer2.compareTo(teste);
        //System.out.println("\n toComparation: " + resultados);
        
        
    }
    
}
