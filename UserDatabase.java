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
public class UserDatabase extends Database{

    public UserDatabase() {
        HashMap<Integer, User> h = new HashMap<>();        
    }
    
    public void addUser(User u){
        h.put(u.getId(), u);
    }
    
    public User getUser(int id){
        User u = null;
        for (Map.Entry<Integer, People> entry : h.entrySet()) {
            if (entry.getKey()== id) {
                u = (User) entry.getValue();
            }
        }   
        return u;
    }    
    
    public void removeUser(int id){
        if (h.containsKey(id)) {
            h.remove(id);        
        }
        System.out.println("Id does not exist.");
    }
    
}
