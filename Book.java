package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public abstract class Book {
    public String[] keyword;
    public String name, author, genre, publisher;
    public int year;
    public static int counter;
    public int bookId;
    private LocalDate dateBorrowed;
    private LocalDate dateReturned; 
    public int fine;

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }

    public LocalDate getDateBorrowed() {
        return dateBorrowed;
    }

    public String fineStatus;
    public boolean available = true;

    public static String[] g = {"Manga", "Novel", "Comicbook", "Documentary"};

    public String[] getKeyword() {
        return keyword;
    }

    public void setKeyword(String[] keyword) {
        this.keyword = keyword;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setDateBorrowed(LocalDate dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    
    public LocalDate getDateBorrowed(LocalDate dateBorrowed) {
       return dateBorrowed;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static String[] getG() {
        return g;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Book.counter = counter;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getFineStatus() {
        return fineStatus;
    }

    public void setFineStatus(String fineStatus) {
        this.fineStatus = fineStatus;
    }

    public double computeFine(LocalDate returned) {
        double finePerDay = 0.20d;
        if ((ChronoUnit.DAYS.between(dateBorrowed, returned)) > 14);

        long timeDelta = Math.max(
                0,
                ChronoUnit.DAYS.between(dateBorrowed.plusDays(14), returned)
        );

        
       // System.out.println(timeDelta * finePerDay);
        return timeDelta * finePerDay;
        
    }

    public Book(String name, String author, String publisher, int year, String genre) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.genre = genre;
        counter++;
        

        this.keyword = new String[]{name, author, publisher, String.valueOf(year), genre};
    }

    public void printBook() {
        System.out.println(getName() + " by " + getAuthor()
                + "\nGenre: " + getGenre()
                + "\nPublisher: " + getPublisher()
                + "\nYear: " + getYear()
                + "\nBook Id: " + getBookId());
    }

    @Override
    public String toString() {
        return "Book {" + "Title: " + name + " | Author: " + author + " | Genre: " + genre + " | Publisher: " + publisher + " | Year: " + year + " | Book's Id: " + bookId + " | Date Borrowed: " + dateBorrowed + '}';
    }

}
