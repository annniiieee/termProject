package library;
public class Admin {
    protected int id; 
    protected String password;
    protected String name; 
    protected String address; 
    static int counter; 
    protected double salary; 

    public admin(int id, String password, String name, String address, double salary) {
        counter++; 
        this.id = counter;
        this.password = password;
        this.name = name;
        this.address = address;
        this.salary = salary; 
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static int getCounter() {
        return counter;
    }

 
    
    
}

    
}
