/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import interfaces.Management.StandingsManagementContract;

/**
 *
 * @author LCLT
 */
public class LeagueTable implements LeagueTableContract{
    
    //private final String URL;
    //private final String apiKey;
    
    //private final String Json_LeagueTable;
    
    private String leagueCaption;
    private int matchday;
    private StandingsManagementContract standing; //18
    
    

    public LeagueTable(String leagueCaption, int matchday, StandingsManagementContract standing) {
        this.leagueCaption = leagueCaption;
        this.matchday = matchday;
        this.standing = standing;
    }

    
    
    @Override
    public PlayerContract getMostValuedPlayer() {
        
        
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
        return "LeagueTable{" + "leagueCaption = " + leagueCaption + ", matchday = " + matchday + ", standing = " + standing + '}';
    }
    
}
