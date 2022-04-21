package termproject;
//student 

public class User {

    protected int id;
    protected String password;
    protected String lastName;
    protected String firstName;
    protected String address;
    static int counter = 0;

    public User(String password, String lastName, String firstName, String address) {
        counter++;
        this.id = counter;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public static void setCounter(int counter) {
        User.counter = counter;
    }

    public void printInfo() {
        System.out.println("The details of this user are: \n");
        System.out.println("Name: " + lastName + ", " + firstName);
        System.out.println("Address: " + address);
    }

}
