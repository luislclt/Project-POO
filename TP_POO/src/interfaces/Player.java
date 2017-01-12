/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

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
    private String nationality;
    private String contractUntil;
    private String marketValue;
    private int age;

    public Player(String Json_Player) {
        
        this.Json_Player = Json_Player;
    }
    
    
    
    
    

    @Override
    public String getName() {
        
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getJerseyNumber() {
        
        
        return -1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NationalityContract getNationality() {
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMarketValue() {
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPosition() {
        
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAge() {
        
        return -1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(PlayerComparasion player) {
        
        return -1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
