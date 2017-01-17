package tp_poo;


import exceptions.CompetitionNotFoundException;
import interfaces.Competition;
import interfaces.CompetitionContract;
import interfaces.FixtureContract;
import interfaces.LeagueTableContract;
import interfaces.Management.CompetitionManagement;
import interfaces.Management.CompetitionManagementContract;
import interfaces.Management.FixtureManagementContract;
import interfaces.Management.PlayerManagementContract;
import interfaces.Management.TeamManagement;
import interfaces.Management.TeamManagementContract;
import interfaces.MappingJSONToClasses;
import interfaces.MappingJsonToClasses;
import interfaces.Team;
import interfaces.TeamContract;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
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
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, CompetitionNotFoundException, ClassNotFoundException {
        
        
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
        /*
        String result = football_data.getCompetition(439);
        System.out.println("\n Competition: " +result);
        
        String resultTeam = football_data.getTeams(439);
        System.out.println("\n Team: " +resultTeam);
        
        String resultleagueTable = football_data.getLeagueTable(439);
        System.out.println("\n LeagueTable: " +resultleagueTable);
        
        String resultFixtures = football_data.getFixtures(439);
        System.out.println("\n Fixtures: " +resultFixtures);
        
        String resultPlayersTeams = football_data.getPlayers(495);
        System.out.println("\n players from Team 495: " +resultPlayersTeams);
        */
        
        //Team team = new Team("nome", "Code", "15,000,000");
        //team
        
        
        //Competition comp = new Competition(url, apiKey,439);
        //System.out.println("\n Competition: "+comp.toString());
                
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
        
        
        // Teste Criar competition 1
        
        /*
        String Jon_Competition = football_data.getCompetition(439);
        
        MappingJsonToClasses mappingCompetition1 = new MappingJSONToClasses(url, apiKey);
        
        CompetitionContract competitionObject =  mappingCompetition1.StringToCompetition(Jon_Competition);
        
        System.out.println("\n\n Teste competitionObject: "+ competitionObject.toString());
        
        CompetitionManagementContract competitionManagement = new CompetitionManagement();
        
        competitionManagement.addObject(competitionObject);
        
        System.out.println("\n Result CompetitionManagement: "+competitionManagement.toString());
        
        */
        // Teste Criar Teams 1
        /*
        String Json_Team = football_data.getTeams(439); // recebe varias Teams
        
        //System.out.println("\n Json_Team "+Json_Team);
        
        MappingJsonToClasses mappingTeam1 = new MappingJSONToClasses(url, apiKey);
        
        TeamManagementContract teamManagement1 = mappingTeam1.StringToTeams(Json_Team); // retornar coleção de equipas (players de cada equipa)
        
        System.out.println("\n Result TeamManagement 1: "+teamManagement1.toString());
        */
        
        // Teste Criar Player 1
        /*
        String Json_Team = football_data.getTeam(495); // apenas recebe uma Team
        
        System.out.println("\n Json_Team -> "+Json_Team);
        MappingJsonToClasses mappingPlayers1 = new MappingJSONToClasses(url, apiKey);
        
        PlayerManagementContract playerManagement1 = mappingPlayers1.getPlayersFromTeam(Json_Team); // funciona direito
        
        System.out.println("\n Result PlayerManagement 1: \n"+playerManagement1.toString());
        */
        
        // Teste Criar LeagueTable 1
        /*
        String Json_LeagueTable = football_data.getLeagueTable(439); // Json_LeagueTable
        
        //String Json_Team = football_data.getTeam(495); // recebe apenas uma equipa
        
        String Json_Teams = football_data.getTeams(439); // recebe varias equipas
        
        MappingJSONToClasses mappingLeagueTable1 = new MappingJSONToClasses(url, apiKey);
        
        //TeamContract Object_Team = mappingLeagueTable1.StringToTeams(Json_Team);
        
        TeamManagementContract teams = mappingLeagueTable1.StringToTeams(Json_Teams);
        
        //System.out.println("\n Criar teamManagement --> para enviar para as comparação entre StringToLeagueTable(teamManagement, Json_LeagueTable)");
        
        //TeamManagement teamManagement1 = new TeamManagement(1);
        //teamManagement1.addObject(Object_Team);
        
        //Object objectTeamManagement = new Object(teamManagement1);
        
        //TeamManagementContract teamManagement = new TeamManagement();
        //teamManagement.addObject(Object_Team);
       
        System.out.println("\n teamManagemet Crete MAIN: "+teams.toString());
        
        //TeamManagementContract teamManagement = mappingLeagueTable1.StringToTeams(Json_Team);
        
        LeagueTableContract leagueTable1 = mappingLeagueTable1.StringToLeagueTable(teams, Json_LeagueTable);
        System.out.println("\n\n \t Result \n  LeagueTable: "+leagueTable1.toString());
        
        //System.out.println("\n Result LeagueTable: "+leagueTable1.toString());
        */
        
        // teste Criar Fixtures 1
        /*
        String Json_Fixture = football_data.getFixtures(439);
        
        String Json_Teams = football_data.getTeams(439); // recebe varias equipas
        
        MappingJsonToClasses mappingFixture1 = new MappingJSONToClasses(url, apiKey);
        
        TeamManagementContract teams = mappingFixture1.StringToTeams(Json_Teams);
        
        FixtureManagementContract fixtures1 = mappingFixture1.StringToFixtures(teams, Json_Fixture);
        
        System.out.println("\n Resultado Fixtures: "+fixtures1.toString());
        */
        
        // Teste Criar Competition 1
        /*
        String Json_Competition = football_data.getCompetition(439);
        
        MappingJsonToClasses mappingCompetition1 = new MappingJSONToClasses(url, apiKey);
        
        CompetitionContract competition1 = mappingCompetition1.StringToCompetition(Json_Competition);
        
        System.out.println("\n Result Competition 1: "+competition1.toString());
        */
        
        // Teste Criar Competitions 1 ssssss
        
        int[] ints = new int[2];
        ints[0] = 439;
        ints[1] = 436;
        
        String Json_Competitions = football_data.getCompetitions(ints);
        
        //System.out.println("\n Result Competitions String: "+ Json_Competitions);
        
        MappingJsonToClasses mappingCompetitions1 = new MappingJSONToClasses(url, apiKey);
        
        CompetitionManagementContract competitions1 = mappingCompetitions1.StringToCompetitions(Json_Competitions);
        
        System.out.println("\n Result Competitions 1: "+competitions1.toString());
        
        
        
        
        //CompetitionManagementContract competitions1 = null; // so para testar  remover
        
        // Teste Write Object to a file //  implements java.io.Serializable
        
        if(new Scanner(new FileReader("test.txt")) == null){
            
            File file = new File("test.txt");
        }else{
            
            //File file = File("test.txt");
            Scanner file = new Scanner(new FileReader("test.txt"));
            
        }
        
        
        ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream(file));
        
        //Student james = new Student();
        //out.writeObject(james);
        
        out.writeObject(competitions1); // cria de JsonCompetitions assima
        
        System.out.println(" Store the competitions1 in file called " + file.getName());
        
        
        
        // Teste Read Object from file ///
        
        ObjectInputStream in = new ObjectInputStream( 
                new FileInputStream(file));
        
        CompetitionManagement competitionsFile = (CompetitionManagement)in.readObject(); 
        
        
        System.out.println("\n Result Competitions 1 FROM the file:  "+file.getName() +"\n\n "+competitionsFile.toString());
        
        
        
        
        
    }
    
}
