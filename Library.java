package library;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.*;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Library {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        FileOutputStream fout = new FileOutputStream("receipt.txt");
        // TODO code application logic here
        UserInputManager UIM = new UserInputManager();
        UserDatabase UD = new UserDatabase();
        AdminDatabase AD = new AdminDatabase();
        BookDataBase BD = new BookDataBase();
        Scanner sc = new Scanner(System.in);
        LocalDate now = LocalDate.now();

        int mainMenuOption = 0;

        BD.addBook(new ComicBook("Marvel", "A", "B", 100, "ComicBook"));

        BD.addBook(new Documentary("BestBook", "C", "D", 1100, "Documentary"));
        BD.addBook(new Manga("frank", "E", "F", 1020, "Manga"));
        BD.addBook(new Novel("kevin", "G", "H", 3100, "Novel"));
        BD.addBook(new Novel("samuel", "samuel", "samuel", -100, "Novel"));
        BD.addBook(new Documentary("com", "I", "J", 0, "Documentary"));
        BD.addBook(new Manga("asd", "K", "L", 400, "Manga"));
        BD.addBook(new Manga("pop", "M", "N", 129, "Manga"));
        BD.addBook(new ComicBook("hey", "O", "P", 100, "Comicbook"));

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
                    User user = UD.getUser(userSessionId);
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
                                    Thread.sleep(100);
                                    break;

                                case 2:
                                    UD.changePassword(UD.getUser(userSessionId));
                                    break;
                                case 3:
                                    //allow to exit the system by pressing on 0
                                    // catch exception when the book has already been borrowed 
                                    int bookId = UIM.getBookId();
                                    if (BD.checkBookCredentials(bookId)) {
                                        Book b = BD.getBook(bookId);    
                                        user.borrowBook(b);
                                        user.printReceipt();                                        
                                    }
                                    Thread.sleep(100);

                                    break;

                                case 4:
                                    if (!user.getBookList().isEmpty()) {
                                        int bookId2 = UIM.getBookId();
                                        if (BD.checkBookCredentials(bookId2)) {
                                            user.removeBorrowedBook(BD.bookData.get(bookId2));                                        
                                        }                                        
                                    }
                                    else{
                                        System.out.println("You have not borrowed any books yet.");
                                    }
                                    break;
                                case 5:
                                    //search a book

                                    System.out.println("Enter a keyword: ");
                                    String x = sc.nextLine();
                                    Map<Integer, Book> map = BD.search(x);
                                    if (map.isEmpty()) {
                                        System.out.println("No book was found");
                                        Thread.sleep(100);

                                    }
                                    map.forEach((t, u) -> {
                                        System.out.println(t + ", " + u + ", Availability : " + u.available);
                                    });
                                    Thread.sleep(100);

                                    break;
                                case 6:
                                    //view all books and sort them
                                    BD.printBooks(BD.bookData);
                                    int sortOption = UIM.sortingOption();
                                    do {
                                        switch (sortOption) {
                                            case 1:
                                                System.out.println("Sorting by name of the book");
                                                BD.bubbleSort(BD.getBookData(), new Comparator<Book>() {
                                                    @Override
                                                    public int compare(Book o1, Book o2) {
                                                        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
                                                    }
                                                });
                                                break;
                                            case 2:
                                                System.out.println("Sorting by year");
                                                BD.bubbleSort(BD.getBookData(), new Comparator<Book>() {
                                                    @Override
                                                    public int compare(Book o1, Book o2) {
                                                        return Integer.compare(o1.getYear(), o2.getYear());
                                                    }
                                                }
                                                );
                                                break;
                                            case 0:
                                                System.out.println("Exiting book list...");
                                                break;
                                            default:
                                                System.out.println("Invalid input. Please input numbers between 0 and 2.");
                                                break;
                                        }
                                    } while ((sortOption = UIM.sortingOption()) != 0);
                                    break;

                                case 7:
                                    // view and pay fees 
                                    user.displpayFines(now);

                                    break;

                                case 8: //compute fine testing for exam
                                    System.out.println("The number of days you want to skip");
                                    now = now.plusDays(sc.nextInt());

                                    break;
                                case 0:
                                    System.out.println("Exiting user session...");
                                    break;
                                default:
                                    System.out.println("Invalid option. Please input a number between 0 and 7.");

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
                                    //view admin profile
                                    AD.getAdmin(adminSessionId).printInfo();
                                    break;
                                case 2:
                                    //change password
                                    AD.changePassword(AD.getAdmin(adminSessionId));
                                    break;
                                case 3:
                                    //search for a book

                                    System.out.println("Enter a keyword: ");
                                    String x = sc.nextLine();
                                    Map<Integer, Book> map = BD.search(x);
                                    if (map.isEmpty()) {
                                        System.out.println("No book is found");
                                        Thread.sleep(100);

                                    }
                                    map.forEach((t, u) -> {
                                        System.out.println(t + ", " + u);

                                    });
                                    Thread.sleep(100);

                                    break;
                                case 4:
                                    // add book
                                    BD.addBook(UIM.getBook());
                                    System.out.println("Book successfully added!");
                                    Thread.sleep(100);

                                    break;
                                case 5: //delete a book
                                    BD.removeBook(UIM.getBookId());

                                    Thread.sleep(100);
                                    break;
                                case 6:
                                    //view books
                                    BD.printBooks(BD.bookData);
                                    break;
                                case 7:
                                    //view user's profile
                                    UD.printUsers();
                                    int id = UIM.getUserId();
                                    if (UD.checkIdExistence(id)) {
                                        UD.getUser(id).printInfo();                                    
                                    }
                                    break;
                                case 8:
                                    //delete user 
                                    UD.removeUser(UIM.getId());
                                    break;
                                case 9:
                                    //display a user's fines
                                    int userIdtoCheck = UIM.getId();
                                    if (UD.checkIdExistence(userIdtoCheck)) {
                                        UD.getUser(userIdtoCheck).displpayFines(now);                                        
                                    }
                                    else{
                                        System.out.println("No user wuth that id found.");
                                    }
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
