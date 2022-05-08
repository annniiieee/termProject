/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserInputManager UIM = new UserInputManager();
        UserDatabase UD = new UserDatabase();
        AdminDatabase AD = new AdminDatabase();
        BookDataBase BD = new BookDataBase();
        Scanner sc = new Scanner (System.in); 
        int mainMenuOption = 0;
        
        do {
            boolean success = false;
            while (!success) {
                try {
                    mainMenuOption = UIM.displayLogInMainMenu();
                    success = true;
                } catch (Exception e) {
                    System.out.println("Please input a number.");
                }
            }

            switch (mainMenuOption) {
                case 1:
                    int userSessionId = UIM.getId();
                    if (UD.checkLoginCredentials(userSessionId)) {
                        int userOption = 0;
                        do {
                            boolean userSuccess = false;
                            while (!userSuccess) {
                                try {
                                    userOption = UIM.displayUserOption();
                                    userSuccess = true;
                                } catch (Exception e) {
                                    System.out.println("Please input a number.");
                                }
                            }
                            switch (userOption) {
                                case 1:
                                    UD.getUser(userSessionId).printInfo();
                                    break;
                                case 2:
                                    UD.changePassword(UD.getUser(userSessionId));
                                    break;
                                case 3:
                                    //borrow book
                                    System.out.println("Enter the ID of the book you would like to borrow: ");
                                    String y = sc.nextLine(); 
                                    BD.checkBookExistence(userOption);
                                    break;
                                case 4:
                                    //return book
                                    
                                    
                                    
                                    break;
                                case 5:
                                    //search a book
                                    System.out.println("Enter the title of the book you would like to search for: ");
                                    String x = sc.nextLine();
                                    Map<Integer, Book> map = BD.search(x);
                                    if (map.isEmpty()) {
                                        System.out.println("No book was found");
                                    }
                                    map.forEach((t, u) -> {
                                        System.out.println(t + ", " + u);
                                    });
                                    
                                    BD.checkSearchBook(UIM.getBookGenre(x, x, x, x, userOption));

                                    break;

                                case 6:
                                    //view and pay fees
                                    break;
                                case 0:
                                    System.out.println("Exiting user session...");
                                    break;
                                default:
                                    System.out.println("Invalid option. Please input a number between 0 and 6.");
                                    break;
                            }
                        } while (userOption != 0);

                    }
                    break;

                case 2:
                    int adminSessionId = UIM.getId();
                    if (AD.checkLoginCredentials(adminSessionId)) {
                        int adminOption = 0;
                        do {
                            boolean adminSuccess = false;
                            while (!adminSuccess) {
                                try {
                                    adminOption = UIM.displayAdminOption();
                                    adminSuccess = true;
                                } catch (Exception e) {
                                    System.out.println("Please input a number.");
                                }
                            }
                            switch (adminOption) {
                                case 1:
                                    //sometimes when use the getAdmin function it returns a null and crashes the program, 
                                    //but sometimes it works. We're just letting you know about this issue that we'll fix when we present the final product
                                    //, but cannot right now due to time constraints.
                                    AD.getAdmin(adminSessionId).printInfo();
                                    break;
                                case 2:
                                    AD.changePassword(AD.getAdmin(adminSessionId));
                                    break;
                                case 3:
                                    //ANnnie search for a book
                                    System.out.println("Enter the title of the book you would like to search for: ");

                                    String x = sc.nextLine();
                                    Map<Integer, Book> map = BD.search(x);
                                    if (map.isEmpty()) {
                                        System.out.println("No book is found");
                                    }
                                    map.forEach((t, u) -> {
                                        System.out.println(t + ", " + u);
                                    });

                                    break;
                                case 4:
                                    // add book
                                    BD.addBook(UIM.getBook());
                                    System.out.println("Book successfully added!");
                                    break;
                                case 5: //delete a book
                                    System.out.print("Id of the book to be removed : ");
                                    BD.removeBook(adminOption);
                                    System.out.println("Book succesfully removed");
                                    break;
                                case 6:
                                    //view books
                                    BD.printBooks();
                                    break;
                                case 7:
                                    //view user's profile
                                    //have to add security measures
                                    //int id = UIM.getId();
                                    //UD.getUser(id).printInfo();
                                    break;
                                case 8:
                                    //delete user 
                                    //have to add security measures
                                    //UD.removeUser(UIM.getId());
                                    //System.out.println("User has been removed.");
                                    break;
                                case 9:
                                    //view loans and fees
                                    break;
                                case 0:
                                    System.out.println("Exiting admin session...");
                                    break;
                                default:
                                    System.out.println("Invalid option. Please input a number between 0 and 8.");
                                    break;
                            }
                        } while (adminOption != 0);
                    }
                    break;

                case 3:
                    User u = UIM.createUser();
                    UD.addUser(u);
                    System.out.println("User created!");
                    u.printInfo();
                    break;
                case 4:
                    Admin a = UIM.createAdmin();
                    AD.addAdmin(a);
                    System.out.println("Admin created!");
                    a.printInfo();
                    break;
                case 0:
                    System.out.println("Thank you for using library inc.! ");
                    break;
                default:
                    System.out.println("Invalid option. Please input a number between 0 and 4.");
                    mainMenuOption = UIM.displayLogInMainMenu();
                    break;
            }
        } while (mainMenuOption != 0);
    }

}
