package interfaces;

import interfaces.Management.PlayerManagementContract;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
    
    private final String Json_Team;
    
    private int count;
    private String name;
    private String Code;
    private String shortName;
    private String SquadMarketValue;
    private String crestUrl;
    private PlayerManagementContract Players[];
    
    /*
    * Constructor Team representa a estrutura de uma dada equipa 
    * @param String Json_Team
    */
    public Team(String Json_Team) {
        this.Json_Team = Json_Team;
        
        JSONParser jsonParser = new JSONParser();
        try{
            
            JSONObject object_count = (JSONObject) jsonParser.parse(this.Json_Team);
            String String_count = object_count.get("count").toString();
            this.count = Integer.parseInt(String_count);
            
            Object object = jsonParser.parse(this.Json_Team);
            JSONArray arrayCompetitions = (JSONArray) object;
            
            for(int aux=0; aux<arrayCompetitions.size(); aux++){
                
                JSONObject Team = (JSONObject) arrayCompetitions.get(aux); // position aux 
                //if(competition.get("id").toString().equals(String.valueOf(competitionId))){
                    
                    // Procura apenas pelo "_Links"
                    //JSONParser jsonParser_links = new JSONParser();
                    //Object object_links = jsonParser_links.parse(competition.toString());
                    //JSONObject Json_object_links = (JSONObject) object_links;
                    
                    //string_Link = Json_object_links.get("_links").toString();
                    
                    this.name = Team.get("name").toString();//.get("id").toString();
                    this.Code = Team.get("Code").toString();
                    this.shortName = Team.get("shortName").toString();
                    this.SquadMarketValue = Team.get("SquadMarketValue").toString();
                    this.SquadMarketValue = Team.get("SquadMarketValue").toString();
                    this.crestUrl = Team.get("crestUrl").toString();
                    
                //}
            }
        }catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> Player\n");
            //Logger.getLogger(FootballContract.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        
        //PlayerManagementContract playerManagement = new PlayerManagement(this.Players);
        
        //playerManagement.getObject(0)
        
        //playerManagement.findObject(playerManagement.);
        //playerManagement.getPlayer(this.name, );
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Team{" + "name=" + name + ", Code=" + Code + ", shortName=" + shortName + ", SquadMarketValue=" + SquadMarketValue + ", crestUrl=" + crestUrl + '}';
    }

    
    
    
    
}
