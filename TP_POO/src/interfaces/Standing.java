package interfaces;

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
public class Standing implements StandingInterface, java.io.Serializable{
    
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

    /**
     * metedo contrutor do standing
     * @param position
     * @param teamName
     * @param crestURI
     * @param playedGames
     * @param points
     * @param goals
     * @param goalsAgainst
     * @param goalDifference
     * @param wins
     * @param draws
     * @param losses
     * @param home
     * @param away
     * @param team 
     */
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
    
    /**
     * Método responsável por retornar uma determinada equipa
     * @return a equipa
     */
    @Override
    public TeamContract getTeam() {
        
        return this.team;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável por retornar a posição (lugar na classificação) de uma equipa
     * @return a posição (lugar na classificação)
     */
    @Override
    public int getPosition() {
        return this.position;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método responsável por retornar o número de pontos da equipa
     * @return o número de pontos
     */
    @Override
    public int getPoints() {
        return this.points;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método responsável por retornar nome da equipa
     * @return o nome da equipa
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Método responsável por retornar o CrestURI da equipa
     * @return o crestURI
     */
    public String getCrestURI() {
        return crestURI;
    }

    /**
     * Método responsável por retornar os jogos da equipa
     * @return playedGames
     */
    public int getPlayedGames() {
        return playedGames;
    }

    /**
     * Método responsável por retornar o número de golos da equipa
     * @return o número de golos
     */
    public int getGoals() {
        return goals;
    }

    /**
     * Método responsável por retornar o número de golos sofridos da equipa
     * @return o número de golos sofridos
     */
    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    /**
     * Método responsável por retornar o número de diferença dos golos entre as equipas
     * @return os golos de diferença
     */
    public int getGoalDifference() {
        return goalDifference;
    }

    /**
     * Método responsável por retornar o número de vitórias da equipa
     * @return o número de vitórias
     */
    public int getWins() {
        return wins;
    }

    /**
     * Método responsável por retornar o número de impates da equipa
     * @return o número de impates
     */
    public int getDraws() {
        return draws;
    }

    /**
     * Método responsável por retornar o número de derrotas da equipa
     * @return o número de derrotas
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Método responsável por retornar os goals, goalsAgainst, wins, draws, losses da equipa casa
     * @return as estatisticas da equipa da casa
     */
    public StatisticsStanding getHome() {
        return home;
    }

    /**
     * Método responsável por retornar os goals, goalsAgainst, wins, draws, losses da equipa de fora
     * @return as estatisticas da equipa de fora
     */
    public StatisticsStanding getAway() {
        return away;
    }
    
    /**
     * Método responsável por retornar a String da estatisticas das equipas
     * @return a String das estatisticas das equipas
     */
    @Override
    public String toString() {
        return "  Standing{" + "position = " + position + ", teamName = " + teamName + ", crestURI = " + crestURI + ", playedGames = " + playedGames + ", points = " + points + ", goals = " + goals + ", goalsAgainst = " + goalsAgainst + ", goalDifference = " + goalDifference + ", wins = " + wins + ", draws = " + draws + ", losses = " + losses + ", home = " + home + ", away = " + away + ", team = " + team + "\n}";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.position;
        hash = 13 * hash + Objects.hashCode(this.teamName);
        hash = 13 * hash + Objects.hashCode(this.crestURI);
        hash = 13 * hash + this.playedGames;
        hash = 13 * hash + this.points;
        hash = 13 * hash + this.goals;
        hash = 13 * hash + this.goalsAgainst;
        hash = 13 * hash + this.goalDifference;
        hash = 13 * hash + this.wins;
        hash = 13 * hash + this.draws;
        hash = 13 * hash + this.losses;
        hash = 13 * hash + Objects.hashCode(this.home);
        hash = 13 * hash + Objects.hashCode(this.away);
        hash = 13 * hash + Objects.hashCode(this.team);
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
        final Standing other = (Standing) obj;
        if (this.position != other.position) {
            return false;
        }
        if (this.playedGames != other.playedGames) {
            return false;
        }
        if (this.points != other.points) {
            return false;
        }
        if (this.goals != other.goals) {
            return false;
        }
        if (this.goalsAgainst != other.goalsAgainst) {
            return false;
        }
        if (this.goalDifference != other.goalDifference) {
            return false;
        }
        if (this.wins != other.wins) {
            return false;
        }
        if (this.draws != other.draws) {
            return false;
        }
        if (this.losses != other.losses) {
            return false;
        }
        if (!Objects.equals(this.teamName, other.teamName)) {
            return false;
        }
        if (!Objects.equals(this.crestURI, other.crestURI)) {
            return false;
        }
        if (!Objects.equals(this.home, other.home)) {
            return false;
        }
        if (!Objects.equals(this.away, other.away)) {
            return false;
        }
        if (!Objects.equals(this.team, other.team)) {
            return false;
        }
        return true;
    }
    
}
