/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class User extends People {

    ArrayList<Book> bookList = new ArrayList<>();

    public User(String password, String lastName, String firstName, String address) {
        super(password, lastName, firstName, address);
        this.id = getCounter();
        bookList = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Book> getBookList() {
        return this.bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    
    
    public void displayFines(LocalDate now) {
        if (bookList.isEmpty()) {
            System.out.println("User has not borrowed books yet.");
        }
        for (int i = 0; i < bookList.size(); i++) {
            System.out.print("Book ID: " + bookList.get(i).bookId + " \t Title: " + bookList.get(i).name + "\t Fine : " + bookList.get(i).computeFine(now));
            System.out.println();
        }
    }

    public void removeBorrowedBook(Book b) {
        boolean exist = false;
        for (int i = 0; i < bookList.size(); i++) {
            if (b.equals(bookList.get(i))) {
                exist = true;
            }
        }
        if (exist) {
            bookList.remove(b);
            b.setAvailable(true);
            System.out.println("Book returned.");
        } else {
            System.err.println("You have not borrowed this book");
        }        
    }

    public void borrowBook(Book book) {
        if (book.available == true) {
            book.setAvailable(false);
            bookList.add(book);
            System.out.println("Succesfully borrowed");
            book.setDateBorrowed(LocalDate.now());
            book.getDateBorrowed(); 
            System.out.println("Check receipt.txt for your receipt!");
    } else {
            System.err.println("Book not available");
        }
    }

    @Override
    public void printInfo() {
        System.out.println("User Id: " + id);
        System.out.println("Name: " + lastName + ", " + firstName);
        System.out.println("Address: " + address);
        System.out.println("Password: " + password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void printUser() {
        System.out.println(getId() + ": " 
               + getFirstName()+ ", " + getLastName());
              
    }
}
