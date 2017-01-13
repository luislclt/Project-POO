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
public class Nationality implements NationalityContract{
    
    private final String nationality;
    
    public Nationality(String nationality){
        this.nationality = nationality;
    }

    @Override
    public String getNationality() {
        return this.nationality;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return  nationality;
    }
    
}
