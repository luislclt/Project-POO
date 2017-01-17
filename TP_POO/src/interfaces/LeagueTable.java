package interfaces;

import interfaces.Management.StandingsManagement;
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
public class LeagueTable implements LeagueTableContract, java.io.Serializable{
    
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
     * Método responsável por retornar o jogador mais valioso de uma determinada liga numa determinada competição e para uma determinada época/ano
     * @return jogador
     */
    @Override
    public PlayerContract getMostValuedPlayer() {
        
        
        PlayerContract player1 = null;
        
        StandingsManagement standings = (StandingsManagement) this.getStandings();
        
        Standing standing1 = (Standing) standings.getObject(0); // procura no primeiro standing da liga

        Team team1 = (Team) standing1.getTeam(); // procura em cada team do primeiro standing1

        player1 = team1.getMostValuePlayer(); // guarda em player1 o player MostValuePlayer da team1 para comparar com as restantes equipas dos outros standings

        
        for (int i = 1; i < standings.size(); i++) { // procura nos restantes standings
            
            Standing standing2 = (Standing) standings.getObject(i); // procura em cada standing2 da liga restante
            
            Team team2 = (Team) standing2.getTeam(); // procura em cada team de cada standing2
            
            PlayerContract player2 = team2.getMostValuePlayer(); // guarda em player2 o player MostValuePlayer da team2 para comparar com as restantes equipas
            
            if(player2.compareTo(player1) > 0){
                player1 = player2;
            }
        }
        
        return player1; // retorna o jogador MostValuePlayer da liga
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * Método responsável por listar a leagueTable 
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
