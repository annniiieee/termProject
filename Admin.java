/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


/**
 *
 * @author Admin
 */
public class Admin extends People{

    public Admin(String password, String lastName, String firstName, String address) {
        super(password, lastName, firstName, address);
        this.id = getCounter();
    }
    
    @Override
    public void printInfo() {
        System.out.println("Admin Id: " + id);
        System.out.println("Name: " + lastName + ", " + firstName);
        System.out.println("Address: " + address);
        System.out.println("Password: " + password);
    }    
}
