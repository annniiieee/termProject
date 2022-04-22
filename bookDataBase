
package termproject;

import java.util.*;

public class bookDatabase {
    Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
    String book; 
    int key; 
    public void addBook (int key, String book){
        linkedHashMap.put(key, book);
        
    }

    public bookDatabase(String book, int key) {
        this.book = book;
        this.key = key;
    }
    
    public void removeBook(int key){
        if (linkedHashMap.isEmpty()) {
            System.out.println("Empty book base");
            
        }
        else{
            for (Map.Entry<Integer,String> entry : linkedHashMap.entrySet()) {
                if (entry.getKey() == key) {
                    linkedHashMap.remove(entry.getKey());
                }
            }
        }
    }
    
     public void removeBook(String book){
        if (linkedHashMap.isEmpty()) {
            System.out.println("Empty book base");
            
        }
        else{
            for (Map.Entry<Integer,String> entry : linkedHashMap.entrySet()) {
                if (entry.getValue() == book) {
                    linkedHashMap.remove(entry.getValue());
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
}
