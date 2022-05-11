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
public class UserDatabase {
    public HashMap<Integer, User> h = new HashMap<>();        

    public UserDatabase() {
    HashMap<Integer, User> h = this.h;
    }
    
    public void addUser(User u){
        h.put(u.getId(), u);
    }
    
    public User getUser(int id){
        User u = null;
        if (h.containsKey(id)) {
            u = h.get(id);
        }
        else{
            System.out.println("No user with that id found.");
        }
        return u;
    }    
    
    public void removeUser(int id){
        if (h.isEmpty()) {
            System.out.println("Empty User Base.");
        }
        else if (h.containsKey(id)) {
            h.remove(id);        
            System.out.println("User has been removed.");
        }
        else{
            System.out.println("User id does not exist");
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
    }

    public boolean checkLoginCredentials(int userId){
        UserInputManager UIM = new UserInputManager();
        while (!checkIdExistence(userId)) {            
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
    
     public void printUsers(HashMap<Integer, User> h) {
        if (h.isEmpty()) {
            System.out.println("Empty user list.");
        } else {
            System.out.println("The user list: ");
            for (Map.Entry<Integer, User> entry : h.entrySet()) {
                //System.out.print(j++ + "- ");
                entry.getValue().printUser();
            }
            System.out.println();
        }
    }
}