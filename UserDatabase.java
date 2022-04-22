/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class UserDatabase extends Database{

    public UserDatabase() {
        HashMap<Integer, User> h = new HashMap<>();        
    }
    
    public void printUser(){
        System.out.println("The User list is: ");
        for (Map.Entry<Integer, People> entry: h.entrySet()) {
            entry.getValue().printInfo();
        }
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
    
}
