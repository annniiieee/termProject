
package termproject;

import java.util.*;

public class bookDatabase {
    Map<Integer, Book> linkedHashMap = new LinkedHashMap<>();
    public void addBook (Book book){
        linkedHashMap.put(book.bookId, book);
        
    }

    public bookDatabase() {
        Map<Integer, Book> linkedHashMap = new LinkedHashMap<>();        
    }

    
    
    public void removeBook(int id){
        if (linkedHashMap.isEmpty()) {
            System.out.println("Empty book base");
            
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
        System.out.println("The book list: ");
        for (Map.Entry<Integer,Book> entry : linkedHashMap.entrySet()){
            entry.getValue().printBook();
        }
    }
    
    
}
