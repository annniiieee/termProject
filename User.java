/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class User extends People {
    ArrayList <Book> borrowedBooks = new ArrayList <>(); 

    public User(String password, String lastName, String firstName, String address) {
        super(password, lastName, firstName, address);
        this.id = getCounter();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void printInfo() {
        System.out.println("User Id: " + id);
        System.out.println("Name: " + lastName + ", " + firstName);
        System.out.println("Address: " + address);
        System.out.println("Password: " + password);
    }       
}