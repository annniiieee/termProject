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
abstract class Book {
    public String name, author, genre, publisher;
    public int year;
    public static int counter;
    
    public Book(String name, String author, String publisher, int year) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    public Book(String name, String author, String genre, String publisher, int year) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.year = year;
    }

    

    public Book(String genre) {
        this.genre = genre;
    }
    
    
}
