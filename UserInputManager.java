/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author Admin
 */
public class UserInputManager {
    
    public static int getId(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What is your id? " );
        int a = 0;
        try {
            a = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid Id. Please input a number.");
            a = getId();
        }
        return a;
    }
    
    public static String getPassWord(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What is your password? ");
        System.out.println("");
        return sc.nextLine();        
    }    
}
