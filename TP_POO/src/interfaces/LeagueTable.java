package interfaces;

import interfaces.Management.PlayerManagement;
import interfaces.Management.StandingsManagement;
import interfaces.Management.StandingsManagementContract;
import interfaces.Management.TeamManagement;

/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public class LeagueTable implements LeagueTableContract{
    
    //private final String URL;
    //private final String apiKey;
    
    //private final String Json_LeagueTable;
    
    private final String leagueCaption;
    private final int matchday;
    private final StandingsManagementContract standing; 
    
    public LeagueTable(String leagueCaption, int matchday, StandingsManagementContract standing) {
        this.leagueCaption = leagueCaption;
        this.matchday = matchday;
        this.standing = standing;
    }
    
    
    @Override
    public PlayerContract getMostValuedPlayer() {
        
        //Team team;
        //team.getMostValuePlayer()
                
        ///StandingsManagementContract standings1.standing;
        
        TeamManagement teamManagement1 = (TeamManagement) standing.getObject(0);
        
        
        String nameTeam1 = standing.getTeam(leagueCaption)
        teamManagement1.getTeam(leagueCaption);
        
        
        //PlayerManagement playerManagement = (PlayerManagement) getPlayers();
        
        PlayerContract player1 = (PlayerContract) playerManagement.getObject(0);
        
        for(int i=1; i< playerManagement.size(); i++){
            
            PlayerContract player2 = (PlayerContract) playerManagement.getObject(i);
            if(player2.compareTo(player1) > 0 ){
                player1 = player2;
            }
        }
        
        return player1;
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLeagueCaption() {
        
        return this.leagueCaption;
    }

    @Override
    public StandingsManagementContract getStandings() {
        
        return this.standing;
    }

    @Override
    public String toString() {
        return "LeagueTable{" + " leagueCaption = " + leagueCaption + ", matchday = " + matchday + ", standing = " + standing + '}';
    }
    
}
