package interfaces;

import interfaces.Management.PlayerManagement;
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
public class Team implements TeamContract, java.io.Serializable{
    
    private String name; // pedidio no impelements javaDoc
    private String Code; // pedidio no impelements javaDoc
    private String SquadMarketValue; // pedidio no impelements javaDoc
    private PlayerManagementContract Players; // pedidio no impelements javaDoc
    
    private String shortName;
    private String crestUrl;
    
    /**
     * Constructor Team representa a estrutura de uma dada equipa basica informação
     * @param name
     * @param Code
     * @param SquadMarketValue
     * @param Players 
     */
    public Team(String name, String Code, String SquadMarketValue, PlayerManagementContract Players) {
        this.name = name;
        this.Code = Code;
        this.SquadMarketValue = SquadMarketValue;
        this.Players = Players;
    }
    
    /**
     * Constructor Team representa a estrutura de uma dada equipa informação completa
     * @param name
     * @param Code
     * @param SquadMarketValue
     * @param Players
     * @param shortName
     * @param crestUrl 
     */
    public Team(String name, String Code, String SquadMarketValue, PlayerManagementContract Players, String shortName, String crestUrl) {
        this.name = name;
        this.Code = Code;
        this.SquadMarketValue = SquadMarketValue;
        this.Players = Players;
        this.shortName = shortName;
        this.crestUrl = crestUrl;
    }
    
    /**
     * Método responsável por retornar o nome da equipa
     * @return o nome da equipa
     */
    @Override
    public String getName() {
        return this.name;
    }
    
    /**
     * Método responsável por retornar o código da equipa
     * @return o código da equipa
     */
    @Override
    public String getCode() {
        return this.Code;
    }
    
    /**
     * Método responsável por retornar o valor total de mercado da equipa
     * @return o valor total de mercado da equipa
     */
    @Override
    public String getSquadMarketValue() {
        return this.SquadMarketValue;
    }
    
    /**
     * Método responsável por retornar uma coleção de jogadores de uma dada da equipa
     * @return uma coleção de jogadores
     */
    @Override
    public PlayerManagementContract getPlayers() {
        
        return this.Players;
    }
    
    /**
     * Método responsável por retornar um player com o valor de mercado mais alto
     * @return o jogador com valor de mercado mais alto
     */
    public PlayerContract getMostValuePlayer(){
        
        PlayerManagement playerManagement = (PlayerManagement) getPlayers();
        
        PlayerContract player1 = (PlayerContract) playerManagement.getObject(0);
        
        for(int i=1; i< playerManagement.size(); i++){
            
            PlayerContract player2 = (PlayerContract) playerManagement.getObject(i);
            if(player2.compareTo(player1) > 0 ){
                player1 = player2;
            }
        }
        
        return player1;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Método responsável por retornar um player pela posição
     * @param position
     * @return um jogador
     */
    public PlayerContract getPlayer(int position) {
        
        return (PlayerContract) this.Players.getObject(position);
    }
    
    /**
     * Método responsável por retornar a String da equipa
     * @return a String da equipa
     */
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
