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

public class Odds {
    
    private final double homeWin;
    private final double draw;
    private final double awayWin;

    public Odds(double homeWin, double draw, double awayWin) {
        this.homeWin = homeWin;
        this.draw = draw;
        this.awayWin = awayWin;
    }

    public double getHomeWin() {
        return homeWin;
    }

    public double getDraw() {
        return draw;
    }

    public double getAwayWin() {
        return awayWin;
    }

    @Override
    public String toString() {
        return "odds{" + " homeWin = " + homeWin + ", draw = " + draw + ", awayWin = " + awayWin + " }";
    }
    
    
    
}
