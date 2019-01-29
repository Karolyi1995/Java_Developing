/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autovalidation.Main;

import autovalidation.autovalidation.AutoValidation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    
    public static void main(String[] args) {
        
        HashMap map = new HashMap();
        String type;
        int remaining;
        Scanner sc = new Scanner(System.in);
        AutoValidation auto;
        
        do{
            System.out.println("Add a new car type:");
            
            System.out.println("Car type: ");
            type = sc.nextLine();
            
            System.out.println("How many is left: ");
            remaining = Integer.parseInt(sc.nextLine());
            
            auto = new AutoValidation(type,remaining); 
            
            if(map.containsKey(auto.getAutoType())){
                System.out.println("Key already exists in the map");
            }
            else{
                map.put(type, remaining);
            }
            
            System.out.println("Do you want to add more car types? Y/N");
           
        }while(sc.nextLine().equals("Y"));
        
         do{
            System.out.println("Sell a car:");
            
            System.out.println("Car type: ");
            type = sc.nextLine();
            
            if(map.containsKey(type)){
                Integer actualRemaining = (Integer)(map.get(type));
                if(actualRemaining==0){
                    System.out.println("This car is out of stock");
                }
                else map.put(type,actualRemaining-1);
            }
            
            System.out.println("Do you want to sell more cars? Y/N");
            
        }while(sc.nextLine().equals("Y"));
         
         Set entrySet = map.entrySet();
        Iterator i = entrySet.iterator();
        
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.println("Key is: " + me.getKey() + " value is: " + me.getValue());
        }
         
    }
    
    
    
}
