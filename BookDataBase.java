package library;

import java.util.*;
import java.util.stream.Collectors;

public class BookDataBase implements iAdminRights {

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

    public void printBooks() {
        if (bookData.isEmpty()) {
            System.out.println("Empty book list.");
        } else {
            System.out.println("The book list: ");
            int j = 0;
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

    @Override
    public void addUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewLoans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeUserPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
