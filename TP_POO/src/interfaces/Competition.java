package interfaces;

import interfaces.Management.FixtureManagementContract;
import interfaces.Management.TeamManagementContract;
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
public class Competition implements CompetitionContract, java.io.Serializable{
    
    private final FixtureManagementContract fixtures; // pedidio no impelements javaDoc
    private final LeagueTableContract leagueTable; // pedidio no impelements javaDoc
    private final TeamManagementContract teams; // pedidio no impelements javaDoc
    private final int id; // pedidio no impelements javaDoc
    private final int year; // pedidio no impelements javaDoc
    
    private String caption;
    private int currentMatchday;
    private int numberOfMatchdays;
    private int numberOfTeams;
    private int numberOfGames;
    private String lastUpdated;

    /**
     * Contrutor Competition parametros base
     * @param fixtures
     * @param leagueTable
     * @param teams
     * @param id
     * @param year 
     */
    public Competition(FixtureManagementContract fixtures, LeagueTableContract leagueTable, TeamManagementContract teams, int id, int year) {
        this.fixtures = fixtures;
        this.leagueTable = leagueTable;
        this.teams = teams;
        this.id = id;
        this.year = year;
    }

    /**
     * Construtor Competition com todos os parametros das competições
     * @param fixtures
     * @param leagueTable
     * @param teams
     * @param id
     * @param year
     * @param caption
     * @param currentMatchday
     * @param numberOfMatchdays
     * @param numberOfTeams
     * @param numberOfGames
     * @param lastUpdated 
     */
    public Competition(FixtureManagementContract fixtures, LeagueTableContract leagueTable, TeamManagementContract teams, int id, int year, String caption, int currentMatchday, int numberOfMatchdays, int numberOfTeams, int numberOfGames, String lastUpdated) {
        this.fixtures = fixtures;
        this.leagueTable = leagueTable;
        this.teams = teams;
        this.id = id;
        this.year = year;
        this.caption = caption;
        this.currentMatchday = currentMatchday;
        this.numberOfMatchdays = numberOfMatchdays;
        this.numberOfTeams = numberOfTeams;
        this.numberOfGames = numberOfGames;
        this.lastUpdated = lastUpdated;
    }
    
    /**
     * Método responsável por retornar o código da competição
     * @return id competição
     */
    @Override
    public int getId() {
        return this.id;
    }
    
    /**
     * Método responsável por retornar a liga
     * @return liga
     */
    @Override
    public LeagueTableContract getLeague() {
        
        return this.leagueTable;
    }

    /**
     * metedo responsável por retornar o ano/epoca da competição
     * @return ano/epoca
     */
    @Override
    public int getYear() {
        return this.year;
    }

    /**
     * Método responsável por retornar todos os jogos de determinada competição
     * @return resultados/fixtures
     */
    @Override
    public FixtureManagementContract getFixture() {
        return this.fixtures;
    }

    /**
     * Método responsável por retornar todas as equipas de uma determinada competição
     * @return equipas
     */
    @Override
    public TeamManagementContract getTeams() {
        return this.teams;
    }

    /**
     * Método responsável por retornar a Caption
     * @return nome/caption
     */
    public String getCaption() {
        return this.caption;
    }

    /**
     * Método responsável por retornar o currentMatchday
     * @return currentMatchday
     */
    public int getCurrentMatchday() {
        return this.currentMatchday;
    }

    /**
     * Método responsável por retornar o NumberOfmatchdays
     * @return numberOfMatchdays
     */
    public int getNumberOfMatchdays() {
        return this.numberOfMatchdays;
    }

    /**
     * Método responsável por retornar o numberOfTeams
     * @return numberOfTeams
     */
    public int getNumberOfTeams() {
        return this.numberOfTeams;
    }

    /**
     * Método responsável por retornar o numberOfGames
     * @return numberOfGames
     */
    public int getNumberOfGames() {
        return this.numberOfGames;
    }

    /**
     * Método responsável por retornar lastUpdated
     * @return lastUpdated
     */
    public String getLastUpdated() {
        return this.lastUpdated;
    }
    
    /**
     * Método responsável por listar a competição
     * @return lista competição
     */
    @Override
    public String toString() {
        return "Competition{" + " id = " + id + ", year = " + year + ", caption = " + caption + ", currentMatchday = " + currentMatchday + ", numberOfMatchdays = " + numberOfMatchdays + ", numberOfTeams = " + numberOfTeams + ", numberOfGames = " + numberOfGames + ", lastUpdated = " + lastUpdated + "\n fixtures = " + fixtures + "\n leagueTable = " + leagueTable + "\n teams = " + teams + " \n }";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.fixtures);
        hash = 89 * hash + Objects.hashCode(this.leagueTable);
        hash = 89 * hash + Objects.hashCode(this.teams);
        hash = 89 * hash + this.id;
        hash = 89 * hash + this.year;
        hash = 89 * hash + Objects.hashCode(this.caption);
        hash = 89 * hash + this.currentMatchday;
        hash = 89 * hash + this.numberOfMatchdays;
        hash = 89 * hash + this.numberOfTeams;
        hash = 89 * hash + this.numberOfGames;
        hash = 89 * hash + Objects.hashCode(this.lastUpdated);
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
        final Competition other = (Competition) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (this.currentMatchday != other.currentMatchday) {
            return false;
        }
        if (this.numberOfMatchdays != other.numberOfMatchdays) {
            return false;
        }
        if (this.numberOfTeams != other.numberOfTeams) {
            return false;
        }
        if (this.numberOfGames != other.numberOfGames) {
            return false;
        }
        if (!Objects.equals(this.caption, other.caption)) {
            return false;
        }
        if (!Objects.equals(this.lastUpdated, other.lastUpdated)) {
            return false;
        }
        if (!Objects.equals(this.fixtures, other.fixtures)) {
            return false;
        }
        if (!Objects.equals(this.leagueTable, other.leagueTable)) {
            return false;
        }
        if (!Objects.equals(this.teams, other.teams)) {
            return false;
        }
        return true;
    }
    
    
}
