/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termproject;

/**
 *
 * @author Admin
 */
public class Novel extends Book{
    public Novel(String name, String author, String publisher, int year) {
        super(name, author, publisher, year);
        this.genre = "Novel";
        this.bookId = counter;
    }   
}
