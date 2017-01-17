package interfaces;

/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public class ResultGame implements java.io.Serializable{
    
    private final int goalsHomeTeam;
    private final int goalsAwayTeam;
    private final HalfTime halfTime;

    public ResultGame(int goalsHomeTeam, int goalsAwayTeam, HalfTime halfTime) {
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
        this.halfTime = halfTime;
    }

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public HalfTime getHalfTime() {
        return halfTime;
    }

    @Override
    public String toString() {
        return "ResultGame{" + " goalsHomeTeam = " + goalsHomeTeam + ", goalsAwayTeam = " + goalsAwayTeam + ", halfTime = " + halfTime + " }";
    }
    
    
    
    
}
