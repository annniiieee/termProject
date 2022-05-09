package library;


public interface iAdminRights {
    void addBook(Book book); 
    void removeBook(int id); 
    void addUsers(); 
    void removeUsers(); 
    void viewUsers(); 
    void viewLoans(); 
    void changeUserPassword(); 
    
}
