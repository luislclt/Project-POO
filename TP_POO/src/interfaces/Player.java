/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author tania
 */
public class Player implements PlayerContract{
    
    private String Json_Player;
    
    private String name;
    private String position;
    private int jerseyNumber;
    private String dateOfBirth;
    private NationalityContract nationality;
    private String contractUntil;
    private String marketValue;
    private int age;

    public Player(String Json_Player) {
        
        this.Json_Player = Json_Player;
        
        JSONParser jsonParser = new JSONParser();
        try{
            
            JSONObject object = (JSONObject) jsonParser.parse(this.Json_Player); // Json_Player contem a string do player a trabalhar
            
            this.name = object.get("name").toString();//.get("id").toString();
            this.position = object.get("position").toString();
            
            this.dateOfBirth = object.get("dateOfBirth").toString();
            
            String nationalityTemp = object.get("nationality").toString();
            this.nationality = new Nationality(nationalityTemp);
            
            this.contractUntil = object.get("contractUntil").toString();
            this.marketValue = object.get("marketValue").toString();
            
            String string_jerseyNumber = object.get("jerseyNumber").toString();
            this.jerseyNumber = Integer.parseInt(string_jerseyNumber);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDOB = dateFormat.parse(this.dateOfBirth);
            //System.out.println(" dateDOB: " +dateFormat.format(dateDOB));
            
            Calendar dateOfDOB = Calendar.getInstance();
            dateOfDOB.setTime(dateDOB);
            
            Calendar CurrentDate = Calendar.getInstance();
            CurrentDate.setTime(new Date()); // Today
            
            //System.out.println("  AGE: "+ (CurrentDate.get(Calendar.YEAR) - dateofDOB.get(Calendar.YEAR)) );
            this.age = (CurrentDate.get(Calendar.YEAR) - dateOfDOB.get(Calendar.YEAR));
            
            
        } catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> Player\n");
            //Logger.getLogger(FootballContract.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            System.out.println("\n Erro ParseException Data --> Player\n");
            //Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String getJson_Player() {
        return Json_Player;
    }

    public void setJson_Player(String Json_Player) {
        this.Json_Player = Json_Player;
        
        JSONParser jsonParser = new JSONParser();
        try{
            
            JSONObject object = (JSONObject) jsonParser.parse(this.Json_Player); // Json_Player contem a string do player a trabalhar
            
            this.name = object.get("name").toString();//.get("id").toString();
            this.position = object.get("position").toString();
            
            this.jerseyNumber = (int) object.get("jerseyNumber");
            this.dateOfBirth = object.get("dateOfBirth").toString();
            
            String nationalityTemp = object.get("nationality").toString();
            this.nationality = new Nationality(nationalityTemp);
            
            this.contractUntil = object.get("contractUntil").toString();
            this.marketValue = object.get("marketValue").toString();
            
            String string_jerseyNumber = object.get("jerseyNumber").toString();
            this.jerseyNumber = Integer.parseInt(string_jerseyNumber);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDOB = dateFormat.parse(this.dateOfBirth);
            //System.out.println(" dateDOB: " +dateFormat.format(dateDOB));
            
            Calendar dateOfDOB = Calendar.getInstance();
            dateOfDOB.setTime(dateDOB);
            
            Calendar CurrentDate = Calendar.getInstance();
            CurrentDate.setTime(new Date()); // Today
            
            //System.out.println("  AGE: "+ (CurrentDate.get(Calendar.YEAR) - dateofDOB.get(Calendar.YEAR)) );
            this.age = (CurrentDate.get(Calendar.YEAR) - dateOfDOB.get(Calendar.YEAR));
            
        } catch ( ParseException ex) {
            System.out.println("\n Erro ParseException --> Player\n");
            //Logger.getLogger(FootballContract.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.text.ParseException ex) {
            System.out.println("\n Erro ParseException Data --> Player\n");
            //Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getName() {
        
        return this.name;
    }

    @Override
    public int getJerseyNumber() {
        
        
        return this.jerseyNumber;
    }
    
    
    @Override
    public NationalityContract getNationality() {
        
        return this.nationality;
        
    }

    @Override
    public String getMarketValue() {
        
        return this.marketValue;
    }

    @Override
    public String getPosition() {
        
        return this.position;
    }

    @Override
    public int getAge() {
        
        return this.age;
    }
    
    @Override
    public int compareTo(PlayerComparasion player) {
        
        PlayerCompareTo player1 = new PlayerCompareTo(this.marketValue);
        String y = player1.toString();
        String x = player.toString();
        
        //System.out.println(" Player 1: "+x);
        //System.out.println(" Player 2: "+y);
        
        return x.compareTo(y); //this.marketValue.compareTo(player);
        
    }
    
    public String getDateOfBirth() {
        return this.dateOfBirth;
    }
    
    public String getContractUntil() {
        return this.contractUntil;
    }
    
    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", position=" + position + ", jerseyNumber=" + jerseyNumber + ", dateOfBirth=" + dateOfBirth + ", nationality=" + nationality + ", contractUntil=" + contractUntil + ", marketValue=" + marketValue + ", age=" + age + '}';
    }

    
}
