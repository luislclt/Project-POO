/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author LCLT
 */
public class StatisticsStanding {
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
     * Metedo responsavel por retornar o número de golos
     * @return numero golos
     */
    public int getGoals() {
        return goals;
    }

    /**
     * Metedo responsavel por retornar o numero de golo against a equipa adversaria
     * @return numero golos
     */
    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    /**
     * Metedo responsavel por retornar o numero de vitórias da equipa
     * @return numero vitórias
     */
    public int getWins() {
        return wins;
    }

    /**
     * Metedo responsavel por retornar o número de impates
     * @return numero impates
     */
    public int getDraws() {
        return draws;
    }

    /**
     * Metedo responsavel por retornar o numero de derrotas
     * @return numero derrotas
     */
    public int getLosses() {
        return losses;
    }

    @Override
    public String toString() {
        return  " goals = " + goals + ", goalsAgainst = " + goalsAgainst + ", wins = " + wins + ", draws = " + draws + ", losses = " + losses;
    }
    
    
    
}
