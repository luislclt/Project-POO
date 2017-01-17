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

    /**
     * Método responsável por retornar os golos da equipa da casa
     * @return os golos da equipa da casa
     */
    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    /**
     * Método responsável por retornar os golos da equipa de fora
     * @return os golos da equipa de fora
     */
    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    /**
     * Método responsável por retornar os golos ao intervalo
     * @return os golos ao intervalo
     */
    public HalfTime getHalfTime() {
        return halfTime;
    }

    /**
     * Método responsável por retornar a String do resultado dos jogos
     * @return a String do resultado dos jogos
     */
    @Override
    public String toString() {
        return "ResultGame{" + " goalsHomeTeam = " + goalsHomeTeam + ", goalsAwayTeam = " + goalsAwayTeam + ", halfTime = " + halfTime + " }";
    }
    
    
    
    
}
