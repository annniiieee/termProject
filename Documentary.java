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
public class Documentary extends Book{
    public Documentary(String name, String author, String publisher, int year, String genre) {
        super(name, author, publisher, year, genre);
        this.genre = "Documentary";
        this.bookId = counter;
    }    
}
