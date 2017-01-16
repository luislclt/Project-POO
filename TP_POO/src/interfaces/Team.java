package interfaces;

import interfaces.Management.PlayerManagementContract;
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
public class Team implements TeamContract{
    
    //private final String URL;
    //private final String apiKey;
    
    //private final String Json_Team;
    
   
    private String name; // pedidio no impelements javaDoc
    private String Code; // pedidio no impelements javaDoc
    private String SquadMarketValue; // pedidio no impelements javaDoc
    private PlayerManagementContract Players; // pedidio no impelements javaDoc
    
    
    private String shortName;
    private String crestUrl;
    
    /*
    * Constructor Team representa a estrutura de uma dada equipa 
    * 
    */
    
    public Team(String name, String Code, String SquadMarketValue, PlayerManagementContract Players) {
        this.name = name;
        this.Code = Code;
        this.SquadMarketValue = SquadMarketValue;
        this.Players = Players;
    }
    
    /*
    * Constructor Team representa a estrutura de uma dada equipa 
    * 
    */
    public Team(String name, String Code, String SquadMarketValue, PlayerManagementContract Players, String shortName, String crestUrl) {
        this.name = name;
        this.Code = Code;
        this.SquadMarketValue = SquadMarketValue;
        this.Players = Players;
        this.shortName = shortName;
        this.crestUrl = crestUrl;
    }
    
    /*
    * Método responsável por retornar o código da equipa
    * @param retorno String name
    */
    @Override
    public String getName() {
        return this.name;
    }
    
    /*
    * Método responsável por retornar o nome da equipa
    * @param retorno String code
    */
    @Override
    public String getCode() {
        return this.Code;
    }
    
    /*
    * Método responsável por retornar o valor total de mercado da equipa
    * @param String retorno SquadMarketValue
    */
    @Override
    public String getSquadMarketValue() {
        return this.SquadMarketValue;
    }
    
    /*
    * Método responsável por retornar uma coleção de jogadores de uma dada da equipa
    * @param PlayerManagement retorno players
    */
    @Override
    public PlayerManagementContract getPlayers() {
        
        return this.Players;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public PlayerContract getMostValuePlayer(){
        
        PlayerManagementContract playerManagement = getPlayers();
        
        
        
        
        PlayerContract player = getPlayer(0);
        
        
        return null;
    }
    
    public PlayerContract getPlayer(int position) {
        
        return (PlayerContract) this.Players.getObject(position);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public String toString() {
        return "  Team{" + " name = " + name + ", Code = " + Code + ", SquadMarketValue = " + SquadMarketValue + ", shortName = " + shortName + ", crestUrl = " + crestUrl + ",\n players = " + Players + "\n   }";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.Code);
        hash = 97 * hash + Objects.hashCode(this.SquadMarketValue);
        hash = 97 * hash + Objects.hashCode(this.Players);
        hash = 97 * hash + Objects.hashCode(this.shortName);
        hash = 97 * hash + Objects.hashCode(this.crestUrl);
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
        final Team other = (Team) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.Code, other.Code)) {
            return false;
        }
        if (!Objects.equals(this.SquadMarketValue, other.SquadMarketValue)) {
            return false;
        }
        if (!Objects.equals(this.shortName, other.shortName)) {
            return false;
        }
        if (!Objects.equals(this.crestUrl, other.crestUrl)) {
            return false;
        }
        if (!Objects.equals(this.Players, other.Players)) {
            return false;
        }
        return true;
    }
    
    
}
