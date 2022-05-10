/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class sortBookByNameComparator implements Comparator<Book>{
    @Override
    public int compare(Book b1,Book b2){  
        return b1.getName().compareTo(b2.getName());  
        }  
    }      
