/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class AdminDatabase extends Database{

    public AdminDatabase() {
        HashMap<Integer, Admin> h = new HashMap<>();
    }    
    
    public void addAdmin(Admin a){
        h.put(a.getId(), a);
    }

    public Admin getAdmin(int id){
        Admin a = null;
        for (Map.Entry<Integer, People> entry : h.entrySet()) {
            if (entry.getKey()== id) {
                a = (Admin) entry.getValue();
            }
        }   
        return a;
    }        
    
    
}
