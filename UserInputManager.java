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
public class UserInputManager {
    
    public int getId(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What is your id? " );
        int a = 0;
        try {
            a = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid Id. Please input a number.");
            a = getId();
        }
        return a;
    }
    
    public String getPassWord(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Password: ");
        return sc.nextLine();        
    }
    
    public String getSearch(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your key word(s): ");
        return sc.nextLine();             
    }
    
    public User createUser(){
        String f = getFirstName();
        String l = getLastName();
        String a = getAddress();
        return new User(User.getCurrentId(), createPassword(), l, f, a);
    }
    
    public String getFirstName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your first name.");
        String fName = sc.nextLine();
        while (fName.equals("")) {            
            System.out.println("Empty name. Please input a name.");
            fName = sc.nextLine();
        }
        return fName;
    }

    public String getLastName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your last name.");
        String lName = sc.nextLine();
        while (lName.equals("")) {            
            System.out.println("Empty name. Please input a name.");
            lName = sc.nextLine();
        }
        return lName;
    }
    
    public String getAddress(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your address.");
        String address = sc.nextLine();
        while (address.equals("")) {            
            System.out.println("Empty address. Please input a address.");
            address = sc.nextLine();
        }
        return address;  
    }
    
    public String createPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a password.");
        String password = sc.nextLine();
        while (password.equals("")) {            
            System.out.println("Empty address. Please input a address.");
            password = sc.nextLine();
        }
        return password;          
    }
}
