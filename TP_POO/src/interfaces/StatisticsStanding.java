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

    public StatisticsStanding(int goals, int goalsAgainst, int wins, int draws, int losses) {
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    @Override
    public String toString() {
        return  " goals = " + goals + ", goalsAgainst = " + goalsAgainst + ", wins = " + wins + ", draws = " + draws + ", losses = " + losses;
    }
    
    
    
}
