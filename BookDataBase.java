
package termproject;

import java.util.*;

public class BookDataBase {
    
    Map<Integer, Book> linkedHashMap = new LinkedHashMap<>();
    
    public void addBook (Book book){
        linkedHashMap.put(book.bookId, book);
    }

    public BookDataBase() {
        Map<Integer, Book> linkedHashMap = new LinkedHashMap<>();        
    }

    
    
    public void removeBook(int id){
        if (linkedHashMap.isEmpty()) {
            System.out.println("Empty library");            
        }
        else{
            for (Map.Entry<Integer,Book> entry : linkedHashMap.entrySet()) {
                if (entry.getKey() == id) {
                    linkedHashMap.remove(entry.getKey());
                }
            }
        }
    }
    
    public boolean checkBookExistence(int id){
        if (linkedHashMap.containsKey(id)) {
            return true; 
            
        }
        else {
            return false; 
        }
    }
    
    public void printBooks(){
        if (linkedHashMap.isEmpty()) {
            System.out.println("Emppty book list.");
        }
        else{
            System.out.println("The book list: ");
            int j = 0;
            for (Map.Entry<Integer,Book> entry : linkedHashMap.entrySet()){
                System.out.print(j++ + "- ");
                entry.getValue().printBook();
            }        
        }
    }    
}
