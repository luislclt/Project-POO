package tp_poo;


import exceptions.CompetitionNotFoundException;
import interfaces.Competition;
import interfaces.CompetitionContract;
import interfaces.Fixture;
import interfaces.FixtureContract;
import interfaces.LeagueTableContract;
import interfaces.Management.CompetitionManagement;
import interfaces.Management.CompetitionManagementContract;
import interfaces.Management.FixtureManagement;
import interfaces.Management.FixtureManagementContract;
import interfaces.Management.PlayerManagement;
import interfaces.Management.PlayerManagementContract;
import interfaces.Management.TeamManagement;
import interfaces.Management.TeamManagementContract;
import interfaces.MappingJSONToClasses;
import interfaces.MappingJsonToClasses;
import interfaces.Player;
import interfaces.PlayerContract;
import interfaces.StatusGame;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
        /*
        int[] ints = new int[2];
        ints[0] = 439;
        ints[1] = 436;
        
        String Json_Competitions = football_data.getCompetitions(ints);
        
        //System.out.println("\n Result Competitions String: "+ Json_Competitions);
        
        MappingJsonToClasses mappingCompetitions1 = new MappingJSONToClasses(url, apiKey);
        
        CompetitionManagementContract competitionsResult1 = mappingCompetitions1.StringToCompetitions(Json_Competitions);
        
        //System.out.println("\n Result Competitions 1: "+competitionsResult1.toString());
        */
        /*
            Save & Read files
        */
        
        //CompetitionManagementContract competitions1 = null; // so para testar  remover
        
        // Teste Write Object to a file //  implements java.io.Serializable
        /*
        File fileToWrite = new File("SaveCompetitions.txt");
        
        ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream(fileToWrite));
        
        //Student james = new Student();
        //out.writeObject(james);
        
        out.writeObject(competitionsResult1); // cria de JsonCompetitions assima
        
        System.out.println(" Store the competitions1 in file called " + fileToWrite.getName());
        */
        
        
        // Teste Read Object from file ///
        
        File fileToRead = new File("SaveCompetitions.txt");
        
        ObjectInputStream in = new ObjectInputStream( 
                new FileInputStream(fileToRead));
        
        CompetitionManagement competitionsFile = (CompetitionManagement)in.readObject(); 
        
        System.out.println("\n Result Competitions 1 FROM the file:  "+fileToRead.getName() +"\n\n "+competitionsFile.toString());
        
        
        
        
        /*
            Obeter uma listagem de todos os jogadores de uma determinada equipa numa determidada época
        */
        /*
        String teamName = "FC Porto";
        int epoca = 2016;
        
        CompetitionManagement competitions1 = competitionsFile;
        
        Team teamResult = null;
        
        for (int i = 0; i < competitions1.size(); i++) {
            
            Competition competition = (Competition) competitions1.getObject(i);
            
            if(competition.getYear() == epoca){
                
                TeamManagement teams = (TeamManagement) competition.getTeams();
                
                for (int j = 0; j < teams.size(); j++) {
                    
                    Team team = (Team) teams.getObject(j);
                    
                    if(team.getName().equalsIgnoreCase(teamName)){
                        
                        teamResult = team;
                        
                    }
                }
            }
        }
        
        if(teamResult != null ) System.out.println("\n Lista todos os jogadores da equipa: "+teamName+ "  da época: "+epoca+" \n "+ teamResult);
        else System.out.println("\n Não foi encontrada correspondencia -->  equipa: "+teamName+ "  da época: "+epoca+"");
        */
        
        /*
            Visualizar os jogos agendados/terminados para um determindado intervalo de datas numa determinada época e num determinado campeonato.
        
            No caso de jogos terminados pretende-se saber o resultado final desses jogos
        */
        /*
        //String competitionName = "Primeira Liga 2016/17";
        String competitionName = "Primera Division 2016/17";
        int epoca2 = 2016;
        // int year, int month, int dayOfMonth, int hour, int minute, int second
        LocalDateTime dateInicio = LocalDateTime.of(2016, 1, 1, 0, 0, 0);
        
        LocalDateTime dateFim = LocalDateTime.of(2017, 12, 31, 0, 0, 0);
        
        System.out.println("\n Apresentar competitionName: "+competitionName+"  epoca: "+epoca2 +"    Mostrar DataInicio: "+dateInicio + "  Mostrar DataFim: "+dateFim);
        
        
        CompetitionManagement competitions2 = competitionsFile;
        
        Fixture fixtureResult = null;
        
        for (int i = 0; i < competitions2.size(); i++) {
            
            Competition competition = (Competition) competitions2.getObject(i);
            
            if(competition.getYear() == epoca2 && competition.getCaption().equalsIgnoreCase(competitionName)){
                
                FixtureManagement fixtures = (FixtureManagement) competition.getFixture();
                
                for (int j = 0; j < fixtures.size(); j++) {
                    
                    Fixture fixture = (Fixture) fixtures.getObject(j);
                    
                    if( fixture.getDate().isAfter(dateInicio) && fixture.getDate().isBefore(dateFim) ){
                        
                        if(fixture.getStatus().equals(StatusGame.FINISHED) || fixture.getStatus().equals(StatusGame.TIMED)){
                            
                            fixtureResult = fixture;
                            
                            if(fixtureResult.getStatus().equals(StatusGame.FINISHED)){

                                System.out.println("\n Fixture Status: "+fixtureResult.getStatusGame() +"  HomeTeamName: "+fixtureResult.getHomeTeamName().getName() +"  AwayTeamName: "+ fixtureResult.getAwayTeamName().getName() 
                                        + " "+fixtureResult.getResult());

                            }else{
                                
                                System.out.println("\n Fixture "+fixtureResult);
                                
                            }
                        }
                    }
                }
            }
        }
        
        if(fixtureResult == null ) System.out.println("\n Não foi encontrada correspondencia -->  competitionName: "+competitionName+"  epoca: "+epoca2 +"    Mostrar DataInicio: "+dateInicio + "  Mostrar DataFim: "+dateFim);
        */
        
        
        /*
            Obter uma listagem dos jogadores mais valiosos de um determinado campeonato, ordenada por ordem crescente pelo seu valor de mercado
        */
        /*
        String competitionName3 = "Primeira Liga 2016/17";
        
        CompetitionManagement competitions3 = competitionsFile;
        
        
        Competition ResultCompetition = null;
        
        for (int i = 0; i < competitions3.size(); i++) {
            
            Competition competition = (Competition) competitions3.getObject(i);
            
            if(competition.getCaption().equalsIgnoreCase(competitionName3)){
                
                ResultCompetition = competition;
            }
        }
        
        if(ResultCompetition != null){
            
            TeamManagement teams = (TeamManagement) ResultCompetition.getTeams();
            int countTotalPlayers = 0;
            for (int i = 0; i < teams.size(); i++) {
                
                Team team = (Team) teams.getObject(i);
                PlayerManagement players = (PlayerManagement) team.getPlayers();
                if(players != null) countTotalPlayers += players.size();
            }
            
            //System.out.println("\n\n countTotalPlayers: "+countTotalPlayers);
            
            PlayerManagement ResultPlayers = new PlayerManagement(countTotalPlayers+1);
            
            for (int i = 0; i < teams.size(); i++) { // procura em todas as teams
                
                Team team = (Team) teams.getObject(i);
                PlayerManagement players = (PlayerManagement) team.getPlayers();
                
                if(players != null){
                    
                    for (int j = 0; j < players.size(); j++) { // adiciona player a player > 1 a 1

                        Player player = (Player) players.getObject(j);

                        ResultPlayers.addObject(player);
                    }
                }
            }
            
            ResultPlayers.sort();
            System.out.println("\n\n Listagem players por Valuemarket: \n"+ResultPlayers);
            
        }else{
            System.out.println("Não foi encontrada correspondencia -->  competitionName: "+competitionName3);
        }
        
        */
        
        
        
        
    }
    
}
