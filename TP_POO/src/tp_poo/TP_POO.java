/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_poo;

import exceptions.CompetitionNotFoundException;
import exceptions.WebServiceConnectionError;
import java.io.IOException;
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
public class TP_POO {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        
        //getContent(java.lang.String link);
        java.lang.String link = "football-data.org";
        java.lang.String apiKey = "4a0fdab1682e4d1384b8262f7e02d641";
        
        //WebServiceConnection(java.lang.String 4a0fdab1682e4d1384b8262f7e02d641);
        WebServiceConnection webServiceConnection1 = new WebServiceConnection(apiKey);
        
        //webServiceConnection1.getContent(link);
        String content = webServiceConnection1.getContent(link);
        
        
        
        //webServiceConnection1.getContent(link) throws java.net.MalformedURLException, java.io.IOException
        
        //int competitionId = 439;
        //java.lang.String getCompetition(competitionId) throws CompetitionNotFoundException, WebServiceConnectionError

        
        
    }
    
}
