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
    public Documentary(String name, String author, String genre, String publisher, int year) {
        super(name, author, genre, publisher, year);
        this.genre = "Documentary";
        counter++;
    }    
}
