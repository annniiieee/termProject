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
public class UserAdminDatabase{
    int a;
    HashMap<String, User> h = new HashMap<>();

    public UserAdminDatabase(HashMap<String, User> h) {
        this.h = h;
    }
    
    public void addUser(User u){
        h.put(u.getPassword(), u);
    }
    
    public void removeUser(int id){
        if (h.isEmpty()) {
            System.out.println("Empty User Base.");
        }
        else{
            for (Map.Entry<String, User> entry : h.entrySet()) {
                if (entry.getValue().getId() == id) {
                    h.remove(entry.getKey());
                }
            }
        }
    }
}
