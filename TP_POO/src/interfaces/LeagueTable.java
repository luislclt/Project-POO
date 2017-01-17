package interfaces;

import interfaces.Management.StandingsManagementContract;
import java.util.Objects;
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
    
    private final String leagueCaption;
    private final int matchday;
    private final StandingsManagementContract standing; 
    
    /**
     * Contrutor da leagueTable
     * @param leagueCaption
     * @param matchday
     * @param standing 
     */
    public LeagueTable(String leagueCaption, int matchday, StandingsManagementContract standing) {
        this.leagueCaption = leagueCaption;
        this.matchday = matchday;
        this.standing = standing;
    }
    
    /**
     * Método responsável por retornar o jogador mais valioso de uma determinada liga
     * numa determinada competição e para uma determinada época/ano
     * @return 
     */
    @Override
    public PlayerContract getMostValuedPlayer() {
        
        
        /*
        TeamContract team = null;
        
        for (int i = 0; i < this.size(); i++) {
            
            team = (TeamContract) this.getObject(i);
            //System.out.println("\n --> this.getObject(i) TeamContract team name"+team.getName());
            if(team.getName().equals(arg0)){
                //System.out.println("\n TeamManagement --> getTeam("+arg0+" ) --> retorno TeamContract -> nameTeam : "+team.getName());
                return team;
            }
        }*/
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Método responsável por retornar a descrição da liga
     * @return String nome liga
     */
    @Override
    public String getLeagueCaption() {
        
        return this.leagueCaption;
    }
    
    /**
     * Método responsável por retornar a classificação de uma coleção de equipas
     * @return coleção de equipas
     */
    @Override
    public StandingsManagementContract getStandings() {
        
        return this.standing;
    }
    
    /**
     * metedo responsavel por listar a leagueTable 
     * liga
     * @return 
     */
    
    @Override
    public String toString() {
        return "LeagueTable{" + " leagueCaption = " + leagueCaption + ", matchday = " + matchday + ", standing = " + standing + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.leagueCaption);
        hash = 71 * hash + this.matchday;
        hash = 71 * hash + Objects.hashCode(this.standing);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LeagueTable other = (LeagueTable) obj;
        if (this.matchday != other.matchday) {
            return false;
        }
        if (!Objects.equals(this.leagueCaption, other.leagueCaption)) {
            return false;
        }
        if (!Objects.equals(this.standing, other.standing)) {
            return false;
        }
        return true;
    }
    
    
    
}
