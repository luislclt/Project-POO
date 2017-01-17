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

public class Odds implements java.io.Serializable{
    
    private final double homeWin;
    private final double draw;
    private final double awayWin;

    public Odds(double homeWin, double draw, double awayWin) {
        this.homeWin = homeWin;
        this.draw = draw;
        this.awayWin = awayWin;
    }

    /**
     * Método responsável por retornar as odds da equipa da casa
     * @return homeWin
     */
    public double getHomeWin() {
        return homeWin;
    }

    /**
     * Método responsável por retornar as odds do empate
     * @return draw
     */
    public double getDraw() {
        return draw;
    }

    /**
     * Método responsável por retornar as odds da equipa de fora
     * @return awayWin
     */
    public double getAwayWin() {
        return awayWin;
    }

    /**
     * Método responsável por retornar a string das odds
     * @return string odds
     */
    @Override
    public String toString() {
        return "odds{" + " homeWin = " + homeWin + ", draw = " + draw + ", awayWin = " + awayWin + " }";
    }
    
    
    
}
