/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class StatisticsStanding implements java.io.Serializable{
    private final int goals;
    private final int goalsAgainst;
    private final int wins;
    private final int draws;
    private final int losses;

    /**
     * metedo construtor de StatisticsStanding da equipa
     * @param goals
     * @param goalsAgainst
     * @param wins
     * @param draws
     * @param losses 
     */
    public StatisticsStanding(int goals, int goalsAgainst, int wins, int draws, int losses) {
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    /**
     * Método responsável por retornar o número de golos
     * @return o número de golos
     */
    public int getGoals() {
        return goals;
    }

    /**
     * Método responsável por retornar o número de golo sofridos sa equipa adversária
     * @return o número de golos
     */
    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    /**
     * Método responsável por retornar o número de vitórias da equipa
     * @return o número de vitórias
     */
    public int getWins() {
        return wins;
    }

    /**
     * Método responsável por retornar o número de impates
     * @return o número de impates
     */
    public int getDraws() {
        return draws;
    }

    /**
     * Método responsável por retornar o número de derrotas
     * @return o número de derrotas
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Método responsável por retornar a String dos golos das equipas
     * @return a String dos golos das equipas
     */
    @Override
    public String toString() {
        return  " goals = " + goals + ", goalsAgainst = " + goalsAgainst + ", wins = " + wins + ", draws = " + draws + ", losses = " + losses;
    }
    
    
    
}
