package interfaces;

import static interfaces.StatusGame.StringToStatusGame;
import java.time.LocalDateTime;
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
public class Fixture implements FixtureContract, java.io.Serializable{
    
    
    private final LocalDateTime date;
    private final Status Status; // StatusGame
    private final int matchday;
    private final String homeTeamName;
    private final String awayTeamName;
    private final TeamContract homeTeam;
    private final TeamContract awayTeam;
    
    private final ResultGame result;
    private final Odds odds;

    /**
     * Contrutor Fixture
     * @param date
     * @param Status
     * @param matchday
     * @param homeTeamName
     * @param awayTeamName
     * @param homeTeam
     * @param awayTeam
     * @param result
     * @param odds 
     */
    public Fixture(LocalDateTime date, Status Status, int matchday, String homeTeamName, String awayTeamName, TeamContract homeTeam, TeamContract awayTeam, ResultGame result, Odds odds) {
        this.date = date;
        this.Status = Status;
        this.matchday = matchday;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.result = result;
        this.odds = odds;
    }
    
    /**
     * Método responsável por retornar a data do jogo
     * @return LocalDateTime
     */
    @Override
    public LocalDateTime getDate() {
        return this.date;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável por retornar o status do jogo
     * @return Status
     */
    @Override
    public Status getStatus() {
        return this.Status;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável por retornar o nome da equipa que joga em casa (no seu estádio)
     * @return TeamContract
     */
    @Override
    public TeamContract getHomeTeamName() {
        
        return this.homeTeam;
        //return (TeamContract) (Object) this.homeTeamName;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável por retornar o nome da equipa que joga fora de casa (fora do seu estádio)
     * @return TeamContract
     */
    @Override
    public TeamContract getAwayTeamName() {
        return this.awayTeam;
        //return (TeamContract) (Object) this.awayTeamName;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
    * Método responsável por retornar o número total de golos da equipa da casa
    * @return numero golos
    */
    @Override
    public int getTotalGoalsHomeTeam() {
        return this.result.getGoalsHomeTeam();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
    * Método responsável por retornar o número total de golos da equipa que joga fora de casa
     * @return numero golos
    */
    @Override
    public int getTotalGoalsAwayTeam() {
        return this.result.getGoalsAwayTeam();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por retornar HomeTeam
     * @return TeamContract
     */
    public TeamContract getHomeTeam() {
        return homeTeam;
    }

    /**
     * Método responsável por retornar AwayTeam
     * @return TeamContract
     */
    public TeamContract getAwayTeam() {
        return awayTeam;
    }
    
    /**
     * Método responsável por retornar o MatchDay
     * @return numero
     */
    public int getMatchday() {
        return this.matchday;
    }

    /**
     * Método responsável por retornar o resultado do jogo
     * @return ResultGame
     */
    public ResultGame getResult() {
        return this.result;
    }

    /**
     * Método responsável por retornar as Odds
     * @return Odds
     */
    public Odds getOdds() {
        return this.odds;
    }
    
    /**
     * Método responsável por retornar o StatusGame em formato String
     * @return String Status
     */
    public String getStatusGame(){
        
        return StringToStatusGame((StatusGame)this.Status);
    }
    
    /**
     * Método que imprime o jogo
     * @return retorna a String 
     */
    @Override
    public String toString() {
        return "Fixture{ " + " date = " + date + ", Status = " + getStatusGame() + ", matchday = " + matchday + ", homeTeamName = " + homeTeamName + ", awayTeamName = " + awayTeamName + ", result = " + result + ", odds = " + odds + " }";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.date);
        hash = 71 * hash + Objects.hashCode(this.Status);
        hash = 71 * hash + this.matchday;
        hash = 71 * hash + Objects.hashCode(this.homeTeamName);
        hash = 71 * hash + Objects.hashCode(this.awayTeamName);
        hash = 71 * hash + Objects.hashCode(this.homeTeam);
        hash = 71 * hash + Objects.hashCode(this.awayTeam);
        hash = 71 * hash + Objects.hashCode(this.result);
        hash = 71 * hash + Objects.hashCode(this.odds);
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
        final Fixture other = (Fixture) obj;
        if (this.matchday != other.matchday) {
            return false;
        }
        if (!Objects.equals(this.homeTeamName, other.homeTeamName)) {
            return false;
        }
        if (!Objects.equals(this.awayTeamName, other.awayTeamName)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (this.Status != other.Status) {
            return false;
        }
        if (!Objects.equals(this.homeTeam, other.homeTeam)) {
            return false;
        }
        if (!Objects.equals(this.awayTeam, other.awayTeam)) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        if (!Objects.equals(this.odds, other.odds)) {
            return false;
        }
        return true;
    }
    
    
}
