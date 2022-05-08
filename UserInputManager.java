/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Scanner;

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
    
    public Book getBook(){
        Scanner sc = new Scanner(System.in);
        String n1 = getWhatever("name");
        String n2 = getWhatever("author");
        String n4 = getWhatever("publisher");
        String n3 = getGenre();
        int y = getYear();
        Book b = getBookGenre(n1, n2, n3, n4, y);
        return b;
    }
    
    public String getWhatever(String s){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the " + s + " of the book?");
        String n1 = sc.nextLine();    
        if (n1.isBlank()) {
            System.out.println("Empty " + s + ". Please enter a valid " + s + ".");
            return getWhatever(s);
        }
        return n1;
    }
    
    public String getGenre(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the genre of the book?");
        String n3 = sc.nextLine();   
        while (!checkValidGenre(n3)) {            
            System.out.println("Invalid genre name. Please input a correct genre name.");
            n3 = sc.nextLine();
        }    
        return n3;
    }
    
    public int getYear(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the year that the book was published?");
        int y;
        try {
            y = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid year. Please input a number.");
            y = getYear();
        }    
        return y;
    }
        
    public boolean checkValidGenre(String genre){
        for (String s : Book.g) {
            if (genre.equalsIgnoreCase(s)) {
                return true;
            }           
        }
        return false;
    }
    
    public Book getBookGenre(String n1, String n2, String n3, String n4, int y){
        if (n3.equalsIgnoreCase("manga")) {
            return new Manga(n1, n2, n4, y, n3);
        }        
        if (n3.equalsIgnoreCase("comicbook")) {
            return new ComicBook(n1, n2, n4, y, n3);
        }        
        if (n3.equalsIgnoreCase("documentary")) {
            return new Documentary(n1, n2, n4, y, n3);
        }        
        else{
            return new Novel(n1, n2, n4, y, n3);        
        }
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
    
    public Admin createAdmin(){
        String f = getFirstName();
        String l = getLastName();
        String a = getAddress();
        return new Admin(createPassword(), l, f, a);
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
        if (password.contains(" ")) {
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
    
    public int displayLogInMainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to library inc.! What would you like to do today? "
                         + "\n1. Log in as user." 
                         + "\n2. Log in as admin." 
                         + "\n3. Create a new user." 
                         + "\n4. Create a new admin."
                         + "\n0. End session.");   
        
        return sc.nextInt();
    }
    
    public int displayUserOption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do today? "
                         + "\n1. View profile."
                         + "\n2. Change a password." 
                         + "\n3. Borrow a book." 
                         + "\n4. Return a book."
                         + "\n5. Search a book."
                         + "\n6. View and pay fees."
                         + "\n0. Log out.");
        return sc.nextInt();
    }
    
    public int displayAdminOption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do today? "
                         + "\n1. View profile."
                         + "\n2. Change your password." 
                         + "\n3. Search a book." 
                         + "\n4. Add a book."
                         + "\n5. Delete a book."
                         + "\n6. View all books in the library."
                         + "\n7. View a user's profile."
                         + "\n8. Delete a user."
                         + "\n9. View a user's loans and fees."
                         + "\n0. Log out.");        
        return sc.nextInt();
    }
    
    public int getBookOption(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How would you like to search the book? "
                         + "\n1. Search by name."
                         + "\n2. Search by ID." 
                         + "\n3. Search by author." 
                         + "\n4. Search by year."
                         + "\n5. Search by genre."
                         + "\n6. Search by publisher."
                        );           
        return sc.nextInt();
    }
}
