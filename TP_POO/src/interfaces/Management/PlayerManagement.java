/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.Management;

import interfaces.Management.PlayerManagementContract;
import interfaces.Management.PlayerManagementContract;
import interfaces.PlayerContract;

/**
 *
 * @author tania
 */
public class PlayerManagement implements PlayerManagementContract{
    
    private String name;
    private String position;
    private int jerseyNumber;
    private String dateOfBirth;
    private String nationality;
    private String contractUntil;
    private String marketValue;
    

    @Override
    public PlayerContract getPlayer(String arg0, String arg1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addObject(Object newObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object removeObject(int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObject(int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
