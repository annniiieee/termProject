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
public class AdminDatabase {
    private HashMap<Integer, Admin> h = new HashMap<>();

    public AdminDatabase() {
        HashMap<Integer, Admin> h = new HashMap<>();
    }    

    public HashMap<Integer, Admin> getH() {
        return h;
    }

    public void setH(HashMap<Integer, Admin> h) {
        this.h = h;
    }
    
    public void printUser(){
        System.out.println("The User list is: ");
        for (Map.Entry<Integer, Admin> entry: h.entrySet()) {
            entry.getValue().printInfo();
        }
    }  
    
    public Admin getUser(int id){
        Admin a = null;
        for (Map.Entry<Integer, Admin> entry : h.entrySet()) {
            if (entry.getKey()== id) {
                a = (Admin) entry.getValue();
            }
        }   
        return a;
    }        
}
