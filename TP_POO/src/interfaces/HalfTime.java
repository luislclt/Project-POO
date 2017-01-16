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
public class HalfTime {
    
    private final int goalsHomeTeam;
    private final int goalsAwayTeam;

    public HalfTime(int goalsHomeTeam, int goalsAwayTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public int getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public int getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    @Override
    public String toString() {
        return "HalfTime {" + " goalsHomeTeam = " + goalsHomeTeam + ", goalsAwayTeam = " + goalsAwayTeam + " }";
    }
    
    
    
}
