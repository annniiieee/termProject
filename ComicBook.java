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
public class ComicBook extends Book{

    public ComicBook(String name, String author, String publisher, int year, String genre) {
        super(name, author, publisher, year, genre);
        this.genre = "Comicbook";
        this.bookId = counter;
    }  
    
}
