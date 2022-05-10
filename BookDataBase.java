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
    
    public void sortbyName(){
        Map<Integer, Book> cloneBookData = new HashMap<>();
        List<Book> l = new LinkedList<>(bookData.values());
        Collections.sort(l, new sortBookByNameComparator());
        
        for (int i = 0; i < l.size(); i++) {
            l.get(i).printBook();
        }
    }
    
    public void sortByYear(){
        
    }
}
