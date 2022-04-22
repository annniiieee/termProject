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
public class UserDatabase{
    HashMap<Integer, User> h = new HashMap<>();

    public UserDatabase() {
        HashMap<Integer, User> h = new HashMap<>();
    }
    
    public void addUser(User u){
        h.put(u.getId(), u);
    }
    
    public void removeUser(int id){
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
    
    public void changePassword(User u){
        UserInputManager UIM = new UserInputManager();
        Scanner sc = new Scanner(System.in);
        int userId = UIM.getId();
        if (!checkLoginCredentials(userId)) {
            return;
        }
        h.get(userId).setPassword(UIM.getNewPassword());
    }
    
    public User getUser(int id){
        User u = null;
        for (Map.Entry<Integer, User> entry : h.entrySet()) {
            if (entry.getKey()== id) {
                u = entry.getValue();
            }
        }   
        return u;
    }
    
    public boolean checkIdExistence(int id){
        if (h.containsKey(id)) {
            return true;
        }
        else
            return false;
    }
    
    public void printUser(){
        System.out.println("The User list is: ");
        for (Map.Entry<Integer, User> entry: h.entrySet()) {
            entry.getValue().printInfo();
        }
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
}
