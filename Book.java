package library;

public abstract class Book {
    
    public String[] keyword;
    public String name, author, genre, publisher;
    public int year;
    public static int counter;
    public int bookId;
    protected String dateBorrowed;

    protected String dateReturned;
    public int fine;
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

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static String[] getG() {
        return g;
    }

    public static void setG(String[] g) {
        Book.g = g;
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

    public String getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(String dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public String getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(String dateReturned) {
        this.dateReturned = dateReturned;
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

    public double computeFine(String dateBorrowed, String dateReturned) {
        double finePerDay = 0.20d;
        //date :     dd/mm/yyyy

        int[] daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int daysBorrowed = Integer.valueOf(dateBorrowed.substring(0, 2));
        int monthsB = Integer.valueOf(dateBorrowed.substring(3, 5));
        int monthsToDayBorrowed = 0;
        int yearToDayB = (int) (Integer.valueOf(dateBorrowed.substring(6)) * 365.25d);
        for (int i = 0; i < monthsB; i++) {
            monthsToDayBorrowed = daysOfMonths[i] + monthsToDayBorrowed;
        }

        int daysReturned = Integer.valueOf(dateReturned.substring(0, 2));
        int months = Integer.valueOf(dateReturned.substring(3, 5));
        int monthsToDayReturned = 0;
        int yearToDayR = (int) (Integer.valueOf(dateReturned.substring(6)) * 365.25d);
        for (int i = 0; i < months; i++) {
            monthsToDayReturned = daysOfMonths[i] + monthsToDayReturned;
        }

        int fineDays = (daysReturned + monthsToDayReturned + yearToDayR) - (daysBorrowed + monthsToDayBorrowed + yearToDayB + 21);
        if (fineDays < 0) {
            fineDays = 0;
        }
        System.out.println("fine Days " + fineDays);
        System.out.println("fined months " + (months - monthsB));
        System.out.println("fined days :" + (daysReturned - daysBorrowed));
        System.out.println(monthsToDayReturned);
        System.out.println(monthsToDayBorrowed);

        System.out.println("months to days : " + (monthsToDayReturned - monthsToDayBorrowed));
        System.out.println(fineDays * finePerDay);

        return (double) (fineDays * finePerDay);
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

    public Book(String genre) {
        this.genre = genre;
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
        return "Book{" + "Title: " + name + ", Author: " + author + ", Genre: " + genre + ", Publisher: " + publisher + ", Year: " + year + ", Books'Id: " + bookId + ", Date Borrowed: " + dateBorrowed + ", Date returned/To be returned: " + dateReturned + ", Fine:  " + fine + ", Fine'status: " + fineStatus + '}';
    }

}

