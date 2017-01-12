/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_poo;


import exceptions.CompetitionNotFoundException;
import java.io.IOException;
import tp_poo.ServiceManager.FootballContract;

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
        
        
        String url = "http://api.football-data.org/v1/competitions/";
        String apiKey = "4a0fdab1682e4d1384b8262f7e02d641";
        
        
        //WebServiceConnection webServiceConnection = new WebServiceConnection(apiKey);
        //String Json_competitions = webServiceConnection.getContent(url);
        
        //System.out.println(Json_competitions);
        
        
        //FootballContract competition1 = new FootballContract(url, apiKey);
        //String resultado = competition1.getCompetition(424);
        
        FootballContract football_data = new FootballContract(url, apiKey);
        
        //String result2 = football_data.getAllCompetitions();
        //System.out.println(result2);
        
        String result = football_data.getCompetition(439);
        System.out.println("\n Competition: " +result);
        
        String resultTeam = football_data.getTeams(439);
        System.out.println("\n Team: " +resultTeam);
        
        
        
    }
    
}
