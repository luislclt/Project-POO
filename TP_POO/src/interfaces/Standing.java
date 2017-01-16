package interfaces;

import interfaces.Management.TeamManagementContract;

/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public class Standing implements StandingInterface{
    
    //private final String URL;
    //private final String apiKey;
    
    //private final String Json_Competitions;
    
    private final int position;
    private final String teamName;
    private final String crestURI;
    private final int playedGames;
    private final int points;
    private final int goals;
    private final int goalsAgainst;
    private final int goalDifference;
    private final int wins;
    private final int draws;
    private final int losses;
    private final StatisticsStanding home;
    private final StatisticsStanding away;
    
    private final TeamContract team;

    public Standing(int position, String teamName, String crestURI, int playedGames, int points, int goals, int goalsAgainst, int goalDifference, int wins, int draws, int losses, StatisticsStanding home, StatisticsStanding away, TeamContract team) {
        
        this.position = position;
        this.teamName = teamName;
        this.crestURI = crestURI;
        this.playedGames = playedGames;
        this.points = points;
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.goalDifference = goalDifference;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.home = home;
        this.away = away;
        this.team = team;
    }

    

    @Override
    public TeamContract getTeam() {
        
        return this.team;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosition() {
        return this.position;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPoints() {
        return this.points;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getTeamName() {
        return teamName;
    }

    public String getCrestURI() {
        return crestURI;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
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

    public StatisticsStanding getHome() {
        return home;
    }

    public StatisticsStanding getAway() {
        return away;
    }

    @Override
    public String toString() {
        return "  Standing{" + "position = " + position + ", teamName = " + teamName + ", crestURI = " + crestURI + ", playedGames = " + playedGames + ", points = " + points + ", goals = " + goals + ", goalsAgainst = " + goalsAgainst + ", goalDifference = " + goalDifference + ", wins = " + wins + ", draws = " + draws + ", losses = " + losses + ", home = " + home + ", away = " + away + ", team = " + team + "\n}";
    }

    
    
    
    
}
