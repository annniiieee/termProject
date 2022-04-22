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
        System.out.print("PLease input password: ");
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
        return new User(createPassword(), l, f, a);
    }
    
    public String getFirstName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your first name. ");
        String fName = sc.nextLine();
        while (fName.equals("")) {            
            System.out.println("Empty name. Please input a name.");
            fName = sc.nextLine();
        }
        return fName;
    }

    public String getLastName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your last name. ");
        String lName = sc.nextLine();
        while (lName.equals("")) {            
            System.out.println("Empty name. Please input a name.");
            lName = sc.nextLine();
        }
        return lName;
    }
    
    public String getAddress(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your address. ");
        String address = sc.nextLine();
        while (address.equals("")) {            
            System.out.println("Empty address. Please input a address.");
            address = sc.nextLine();
        }
        return address;  
    }
    
    public String createPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input a password.");
        String password = sc.nextLine();
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.substring(i, i+1).equals(" ")) {
                counter++;
            }             
        }
        if (counter > 0) {
            System.out.println("Password containts invalid characters (Spaces).");
            return createPassword();            
        }
        return password;          
    }
    
    public String getNewPassword(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your new password?");
        String newS = sc.nextLine();
        System.out.println("Please enter your new password again."); 
        String newCheckS = sc.nextLine();
        if (newS.equals(newCheckS)) {
            return newS;
        }
        else{
            System.out.println("Entered passwords do not match.");
            return getNewPassword();
        }
    }
    
    public int displayUserOption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to library inc.! What would you like to do today? "
                         + "\n1. Create a new user." 
                         + "\n2. Change a password." 
                         + "\n3. Borrow a book." 
                         + "\n4. Return a book."
                         + "\n5. Search a book."
                         + "\n6. View and pay fees.");
        return sc.nextInt();
    }
    
    public int displayAdminOption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to library inc.! What would you like to do today? "
                         + "\n1. Create a new admin account." 
                         + "\n2. Change an admin password." 
                         + "\n3. Search a book." 
                         + "\n4. Add a book."
                         + "\n5. Delete a book."
                         + "\n6. Search a user's information."
                         + "\n7. Delete a user."
                         + "\n8. View a user's loans and fees.");        
        return sc.nextInt();
    }

}
