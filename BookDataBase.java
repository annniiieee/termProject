package library;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BookDataBase implements iAdminRights {

    Map<Integer, Book> bookData = new LinkedHashMap<>();

    public Map<Integer, Book> getBookData() {
        return bookData;
    }

    public void setBookData(Map<Integer, Book> bookData) {
        this.bookData = bookData;
    }

    @Override
    public void addBook(Book book) {
        bookData.put(book.bookId, book);
    }

    @Override
    public void removeBook(int id) {
        if (bookData.isEmpty()) {
            System.out.println("Empty library");
        } else {
            if (bookData.containsKey(id)) {
                bookData.remove(id);
                System.out.println("Book succesfully removed");
            } else {
                System.out.println("Invalid id.");
            }
        }
    }

    public boolean checkBookExistence(int id) {
        if (bookData.containsKey(id)) {
            return true;

        } else {
            return false;
        }
    }

    //method overloading purposes 
    public boolean checkBookExistence(Book b) {
        if (bookData.containsValue(b)) {
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
            System.out.println();
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

    public Book getBook(int id) {
        if (bookData.containsKey(id)) {
            return bookData.get(id);

        }
        return null;
    }

    public int checkBookCredentials(int id){
        UserInputManager UIM = new UserInputManager();
        if (id == 0) {
            return -1;
        }
        else{
            while (!checkBookExistence(id)) {            
                System.out.println("Invalid book id. Please enter a valid id, or enter 0 to exit the process");
                id = UIM.getBookId();
                if (id == 0) {
                    return -1;
                }
            }         
        }
        return -1;
    }
    
    public <T> void bubbleSort (Map<Integer, T> map, Comparator<T> comparator) {

        List<Entry<Integer, T>> entry = new ArrayList<>(map.entrySet());

        for (int i = 0; i < entry.size(); i++) {
            for (int j = 0; j < entry.size() - 1; j++) {
                if (comparator.compare(entry.get(j).getValue(), entry.get(j + 1).getValue()) > 0) {

                    Entry<Integer, T> temporary = entry.get(j);
                    entry.set(j, entry.get(j + 1));
                    entry.set(j + 1, temporary);
                }
            }
        }
        ArrayList<T> answer = new ArrayList<>();
        for (int i = 0; i < entry.size(); i++) {
            System.out.println(entry.get(i).getValue());
        }
    }

    public void selectionSort (Map<Integer, Book> map) {

        List<Entry<Integer, Book>> entry = new ArrayList<>(map.entrySet());

        for (int i = 0; i < entry.size(); i++) {
            Entry<Integer, Book> min = entry.get(i);
            int minIndex = i;
            for (int j = i+1; j < entry.size(); j++) {
                if (entry.get(j).getValue().getYear() < min.getValue().getYear()) {
                    min = entry.get(j);
                    minIndex = j;
                }
            }
            Entry<Integer, Book> temp = entry.get(i);
            entry.set(i, min);
            entry.set(minIndex, temp);
        }
        ArrayList<Book> answer = new ArrayList<>();
        for (int i = 0; i < entry.size(); i++) {
            System.out.println(entry.get(i).getValue());
        }
    }
}
