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
public class AdminDatabase implements Database {
    private HashMap<Integer, Admin> h = new HashMap<>();

    public AdminDatabase() {
    HashMap<Integer, Admin> h = this.h;
    }    
    
    public void addAdmin(Admin a){
        h.put(a.getId(), a);
    }

    public Admin getAdmin(int id){
        Admin a = null;
        if (h.containsKey(id)) {
            a = h.get(id);
        }
        else{
            System.out.println("No admin with that id found.");
        }
        return a;
    }        
    
    public boolean checkIdExistence(int id, HashMap<Integer, Admin> h){
        if (h.containsKey(id)) {
            return true;
        }
        else
            return false;
    }

    public boolean checkLoginCredentials(int userId){
        UserInputManager UIM = new UserInputManager();
        while (!checkIdExistence(userId, h)) {            
            System.out.println("Invalid user id. Please enter a valid id, or enter 0 to exit the process");
            userId = UIM.getId();
            if (userId == 0) {
                return false;
            }
        }
        String s = UIM.getPassWord();
        while (!checkPasswordInput(s, userId)) {            
            System.out.println("Invalid password. Please enter a valid password, or enter 0 to exit the process");
            s = UIM.getPassWord();
            if (s.equals("0")) {
                return false;
            }            
        }
        return true;
    }   
    
    public void removePeople(int id){
        if (h.isEmpty()) {
            System.out.println("Empty User Base.");
        }
        else{
            if (h.containsKey(id)) {
                h.remove(id);
            }
            else{
                System.out.println("Could not remove user. Invalid id.");
            }
        }
    }
    
    public void changePassword(People u){
        UserInputManager UIM = new UserInputManager();
        Scanner sc = new Scanner(System.in);
        int userId = UIM.getId();
        if (!checkLoginCredentials(userId)) {
            return;
        }
        h.get(userId).setPassword(UIM.getNewPassword());
    }
    
    public boolean checkIdExistence(int id){
        if (h.containsKey(id)) {
            return true;
        }
        else
            return false;
    }
    
    public boolean checkPasswordInput(String s, int id){
        if (s.equals(h.get(id).getPassword())) {
            return true;
        }
        return false;
    }}