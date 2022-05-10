package library;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BookDataBase implements iAdminRights, Database {

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
        } else {
            System.out.println("id does not correspod to any existing book");
            return getBook(id);
        }
    }

    public <T> List<T> bubbleSort(
            Map<Integer, T> map,
            Comparator<T> comparator) {

        List<Entry<Integer, T>> entry = new ArrayList<>(map.entrySet());
       

        for (int i = 0; i < entry.size(); i++) {

            for (int j = 0; j < entry.size() - 1; j++) {

                if (comparator.compare(entry.get(j).getValue(), entry.get(j + 1).getValue()) > 0) {

                    Entry<Integer, T> temporary = entry.get(j);
                    entry.set(j, entry.get(j+1));
                    entry.set(j + 1, temporary);

                }

            }

        }

        ArrayList<T> answer = new ArrayList<>();
        for (int i = 0; i < entry.size(); i++) {
            answer.add(entry.get(i).getValue());
        }
        return answer;
    }

    public static void main(String[] args) {

        BookDataBase bd = new BookDataBase();
        HashMap<Integer, Integer> hashmap = new HashMap();
        hashmap.put(1, 2);
        hashmap.put(11, 2);
        hashmap.put(12, 27);
        hashmap.put(13, 22);
        hashmap.put(18, 24);
        hashmap.put(185, 4562);

        System.out.println(bd.bubbleSort(hashmap, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        }));

    }

}
