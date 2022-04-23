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
public class People {
    protected int id; 
    protected String password;
    protected String firstName; 
    protected String lastName; 
    protected String address; 
    private static int counter; 

    public People(String password, String lastName, String firstName, String address) {
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        counter++;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static int getCounter() {
        return counter;
    }    
    
    public void printInfo() {
        System.out.println("Person Id: " + id);
        System.out.println("Name: " + lastName + ", " + firstName);
        System.out.println("Address: " + address);
        System.out.println("Password: " + password);
    }
}
