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
    
    private final String Json_LeagueTable;

    public LeagueTable(String Json_LeagueTable) {
        
        this.Json_LeagueTable = Json_LeagueTable;
    }
    
    @Override
    public PlayerContract getMostValuedPlayer() {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLeagueCaption() {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StandingsManagementContract getStandings() {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "LeagueTable{" + "Json_LeagueTable=" + Json_LeagueTable + '}';
    }
    
    
    
}
