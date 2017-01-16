package interfaces;

import java.time.LocalDateTime;

/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public class Fixture implements FixtureContract{
    
    
    private final LocalDateTime date;
    private final StatusGame Status;
    private final int matchday;
    private final String homeTeamName;
    private final String awayTeamName;
    private final TeamContract homeTeam;
    private final TeamContract awayTeam;
    
    private final ResultGame result;
    private final Odds odds;

    public Fixture(LocalDateTime date, StatusGame Status, int matchday, String homeTeamName, String awayTeamName, TeamContract homeTeam, TeamContract awayTeam, ResultGame result, Odds odds) {
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
    
    
    @Override
    public LocalDateTime getDate() {
        return this.date;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StatusGame getStatus() {
        return this.Status;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TeamContract getHomeTeamName() {
        //return (TeamContract) (Object) this.homeTeamName;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TeamContract getAwayTeamName() {
        //return (TeamContract) (Object) this.awayTeamName;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    * getTotalGoalsHomeTeam
    * GoalsHomeTeam
    */
    @Override
    public int getTotalGoalsHomeTeam() {
        return this.result.getGoalsHomeTeam();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    * getTotalGoalsAwayTeam
    * GoalsAwayTeam
    */
    @Override
    public int getTotalGoalsAwayTeam() {
        return this.result.getGoalsAwayTeam();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TeamContract getHomeTeam() {
        return homeTeam;
    }

    public TeamContract getAwayTeam() {
        return awayTeam;
    }
    
    
    public int getMatchday() {
        return this.matchday;
    }

    public ResultGame getResult() {
        return this.result;
    }

    public Odds getOdds() {
        return this.odds;
    }

    @Override
    public String toString() {
        return "Fixture{ " + " date = " + date + ", Status = " + Status + ", matchday = " + matchday + ", homeTeamName = " + homeTeamName + ", awayTeamName = " + awayTeamName + ", result = " + result + ", odds = " + odds + " }";
    }
    
    
    
}
