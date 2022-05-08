package library;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Library {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        // TODO code application logic here
        UserInputManager UIM = new UserInputManager();
        UserDatabase UD = new UserDatabase();
        AdminDatabase AD = new AdminDatabase();
        BookDataBase BD = new BookDataBase();

        int mainMenuOption = 0;

        BD.addBook(new ComicBook("Marvel", "", "", 100, ""));

        BD.addBook(new ComicBook("BestBook", "", "", 100, ""));
        BD.addBook(new ComicBook("frank", "", "", 100, ""));
        BD.addBook(new ComicBook("kevin", "", "", 100, ""));
        BD.addBook(new ComicBook("samuel", "samuel", "samuel", 100, "samuel"));
        BD.addBook(new ComicBook("com", "", "", 100, ""));
        BD.addBook(new ComicBook("asd", "", "", 100, ""));
        BD.addBook(new ComicBook("pop", "", "", 100, ""));
        BD.addBook(new ComicBook("hey", "", "", 100, ""));

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

                                    int id = UIM.getBookId();
                                    LocalDate date = LocalDate.now(); 
                                          LocalDate  dateReturn = LocalDate.now().plusDays(14); 
                                    Book book = BD.bookData.get(id);
                                    if (book.available == true) {
                                        book.setAvailable(false);
                                        user.bookList.add(book);
                                        System.out.println("Succesfully borrowed");
                                        book.setDateBorrowed(String.valueOf(date));
                                        System.out.println("The book was borrows on: " + book.getDateBorrowed());
                                        book.setDateReturned(String.valueOf(dateReturn));
                                        System.out.println("To be returned: " + book.getDateReturned());
                                        Thread.sleep(100);
                                    } else {
                                        System.err.println("Book not available");
                                        Thread.sleep(100);

                                    }

                                    break;
                                case 4:
                                    int id2 = UIM.getBookId();
                                    Book book2 = BD.bookData.get(id2);
                                    boolean exist = false;

                                    for (int i = 0; i < user.bookList.size(); i++) {
                                        if (book2.equals(user.bookList.get(i))) {
                                            exist = true;
                                        }
                                    }

                                    if (exist) {

                                        user.bookList.remove(book2);
                                        book2.setAvailable(true);
                                    } else {

                                        System.err.println("You have not borrowed this book");
                                        Thread.sleep(100);

                                    }
                                    break;
                                case 5:
                                    //search a book
                                    Scanner sc = new Scanner(System.in);
                                    System.out.println("Search for: ");
                                    String x = sc.nextLine();
                                    Map<Integer, Book> map = BD.search(x);
                                    if (map.isEmpty()) {
                                        System.out.println("No book is found");
                                        Thread.sleep(100);

                                    }
                                    map.forEach((t, u) -> {
                                        System.out.println(t + ", " + u + ", Availability : " + u.available);
                                    });
                                    Thread.sleep(100);

                                    break;
                                case 6:
                                    System.out.println(user.bookList);

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
                                    Scanner sc = new Scanner(System.in);
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
