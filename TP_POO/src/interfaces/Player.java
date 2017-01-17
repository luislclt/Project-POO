package interfaces;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public class Player implements PlayerContract, java.io.Serializable{
    
    //private final String URL;
    //private final String apiKey;
    
    //private final String Json_Player;
    
    private String name; // pedidio no impelements javaDoc
    private String position; // pedidio no impelements javaDoc
    private int jerseyNumber; // pedidio no impelements javaDoc
    private NationalityContract nationality; // pedidio no impelements javaDoc
    private String marketValue; // pedidio no impelements javaDoc
    private int age; // pedidio no impelements javaDoc
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date dateOfBirth;
    private Date contractUntil;

    public Player(String name, String position, int jerseyNumber, NationalityContract nationality, String marketValue, int age) {
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.nationality = nationality;
        this.marketValue = marketValue;
        this.age = age;
    }

    public Player(String name, String position, int jerseyNumber, NationalityContract nationality, String marketValue, int age, Date dateOfBirth, Date contractUntil) {
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.nationality = nationality;
        this.marketValue = marketValue;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.contractUntil = contractUntil;
    }
    
    /**
     * Método responsável por retornar o nome do jogador
     * @return o nome de um jogador
     */
    @Override
    public String getName() {
        
        return this.name;
    }

    /**
     * Método responsável por retornar o número do jogador
     * @return o número de um jogador
     */
    @Override
    public int getJerseyNumber() {
        
        return this.jerseyNumber;
    }
    
    /**
     * Método responsável por retornar a nacionalidade
     * @return a nacionalidade
     */
    @Override
    public NationalityContract getNationality() {
        
        return this.nationality;
        
    }

    /**
     * Método responsável por retornar o valor de mercado de um jogador
     * @return o valor de mercado de um jogador
     */
    @Override
    public String getMarketValue() {
        
        return this.marketValue;
    }

    /**
     * Método responsável por retornar a posição (avançado, defesa, etc) de um jogador
     * @return a posição (avançado, defesa, etc) de um jogador
     */
    @Override
    public String getPosition() {
        
        return this.position;
    }

    /**
     * Método responsável por retornar a idade de um jogador
     * @return a idade de um jogador
     */
    @Override
    public int getAge() {
        
        return this.age;
    }
    
    /**
     * Método responsável por retornar um valor inteiro resultante da comparação de dois jogadores
     * @param player - o jogador a comparar
     * @return o valor inteiro resultante da comparação
     */
    @Override
    public int compareTo(PlayerComparasion player) {
        
        //Player player1 = new PlayerCompareTo(this.marketValue);
        
        Player player1 = (Player) player;
        
        //String y = player1.toString();
        //String x = player.toString();
        
        //System.out.println(" Player 1: "+x);
        //System.out.println(" Player 2: "+y);
        
        return this.marketValue.compareTo(player1.getMarketValue());
        
    }
    
    /**
     * Método responsável por retornar o valor do Mercado do jogador
     * @return o valor do Mercado
     */
    public int getNumberMarketValue(){
        
        int value = 0;
        
        Object object_marketValue = this.marketValue;
            if(null == object_marketValue){
                value = 0;
            }else{
                
                try {
                    String result1 = object_marketValue.toString().replaceAll("[-+.^:,€]","");
                    String result = result1.replaceAll("\\s","");
                    value = Integer.parseInt(result);
                    return value;
                } catch (NumberFormatException e) {
                    
                    return 0;
                }
            }
        
        return value;
    }
    
    /**
     * Método responsável por retornar a data de nascimento do jogador
     * @return a data de nascimento do jogador
     */
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    /**
     * Método responsável por retornar a data de fim do contrato do jogador
     * @return a data fim do contrato do jogador
     */
    public Date getContractUntil() {
        return this.contractUntil;
    }
    
    /**
     * Método responsável por retornar a String do jogador
     * @return String do jogador
     */
    @Override
    public String toString() {
        
        return " Player{" + " name = " + name + ", position = " + position + ", jerseyNumber = " + jerseyNumber + ", dateOfBirth = " + dateFormat.format(dateOfBirth) + ", nationality = " + nationality + ", contractUntil = " + dateFormat.format(contractUntil) + ", marketValue = " + marketValue + ", age = " + age + " }";
    }

    
}
