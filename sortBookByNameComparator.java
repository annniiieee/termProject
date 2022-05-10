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
public class sortBookByNameComparator implements Comparator<Map.Entry<Integer, Book>>{
    @Override
    public int compare(Map.Entry<Integer, Book> b1,Map.Entry<Integer, Book> b2){  
        return b1.getValue().getName().compareTo(b2.getValue().getName());  
        }  
    }      
