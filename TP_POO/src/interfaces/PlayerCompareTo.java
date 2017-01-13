/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author LCLT
 */
public class PlayerCompareTo implements PlayerComparasion{
    
    private final String marketValue;
    
    public PlayerCompareTo(String marketValue){
        this.marketValue = marketValue;
    }

    @Override
    public int compareTo(PlayerComparasion player) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        //return "{" + "marketValue=" + marketValue + '}';
        return marketValue;
    }
    
    
    
}
