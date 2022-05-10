package library;

import java.util.*;
import java.util.stream.Collectors;

public class BookDataBase implements iAdminRights, Database {

    Map<Integer, Book> bookData = new LinkedHashMap<>();

    @Override
    public void addBook(Book book) {
        bookData.put(book.bookId, book);
    }

    @Override
    public void removeBook(int id) {
        if (bookData.isEmpty()) {
            System.out.println("Empty library");
        } else {

            bookData.remove(id);
        }
    }

    public boolean checkBookExistence(int id) {
        if (bookData.containsKey(id)) {
            return true;

        } else {
            return false;
        }
    }

    public void printBooks(Map<Integer, Book> bookData) {
        if (bookData.isEmpty()) {
            System.out.println("Empty book list.");
        } else {
            System.out.println("The book list: ");
            int j = 1;
            for (Map.Entry<Integer, Book> entry : bookData.entrySet()) {
                System.out.print(j++ + "- ");
                entry.getValue().printBook();
            }
        }
    }

    public Map<Integer, Book> search(String query) {
        return this.bookData.keySet().stream().filter(
                id
                -> Arrays.stream(
                        this.bookData.get(id).keyword
                )
                        .anyMatch(
                                (keyword) -> keyword.equalsIgnoreCase(query)
                        )
        ).collect(
                Collectors.toMap(id -> id, this.bookData::get)
        );
    }

    public Book getBook(int id){
        if (bookData.containsKey(id)) {
            return bookData.get(id);
        }
        else{
            System.out.println("id does not correspod to any existing book");
            return getBook(id);
        }
    }
    
    public void sortByYear(){
        Map<Integer, Book> cloneBookData = bookData;
        int temp =0;
        for (int i = 1; i < cloneBookData.size()-1; i++) {
            for (int j = 1; j < cloneBookData.size()-1-i; j++) {
                
                
                if (cloneBookData.get(j).getYear() > cloneBookData.get(j+1).getYear()) {
                    temp = cloneBookData.get(j).getYear();
                    cloneBookData.get(j).setYear(cloneBookData.get(j+1).getYear());
                    cloneBookData.get(j).setYear(temp);
                }
            }
        }
        printBooks(cloneBookData);
    }
    
    public void sortByName(){
        Map<Integer, Book> cloneBookData = bookData;
        Collections.sort(cloneBookData, new sortBookByNameComparator());
    }
}
