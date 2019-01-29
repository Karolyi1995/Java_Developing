/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autovalidation2.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    
    private static final ArrayList validAuto = new ArrayList(5);
    static{
        validAuto.add("BMW");
        validAuto.add("Peugeot");
        validAuto.add("Opel");
        validAuto.add("Audi");
        validAuto.add("Seat");
    }    
    public static void main(String[] args) {
        
        Map map = new HashMap();
        String type;
        Scanner sc = new Scanner(System.in);
        int AutoCount = 0;
        
        do{
            System.out.println("Add a new car");
            
            System.out.println("Car type: ");
            type = sc.nextLine(); 
            
            if(!map.containsKey(type)){
                
                if(validAuto.contains(type)){
                    map.put(type,1);
                }
                else{
                    System.out.println("Auto is not a valid type.");
                }
            }
            else{
                map.put(type,(Integer) map.get(type)+1);
            }
            
            System.out.println("Do you want to add more car types? Y/N");
           
        }while(!sc.nextLine().equals("N"));
        
        
        Iterator i = map.entrySet().iterator();
        
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.println("Key is: " + me.getKey() + " value is: " + me.getValue());
        }
        
        for(Object entry: map.entrySet()){
            System.out.println(((Map.Entry)entry).getKey());
            AutoCount += (Integer)((Map.Entry)entry).getValue();
        }
        
        
        
        System.out.println("Cars in stock: " + AutoCount);
        
        do{
            System.out.println("Sell a car:");
            
            System.out.println("Car type: ");
            type = sc.nextLine();
            
            if(map.containsKey(type)){
                Integer actualRemaining = (Integer)(map.get(type));
                if(actualRemaining==1){
                    System.out.println("The last " + type + " is sold.");
                    map.remove(type);
                }
                else map.put(type,actualRemaining-1);
            }else{
                System.out.println("Car is out of stock.");
            }
            
            System.out.println("Do you want to sell more cars? Y/N");
            
        }while(!sc.nextLine().equals("N"));
         
        i = map.entrySet().iterator();
        
        AutoCount = 0;
        
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.println("Key is: " + me.getKey() + " value is: " + me.getValue());
        }
        
        for(Object entry: map.entrySet()){
            System.out.println(((Map.Entry)entry).getKey());
            AutoCount += (Integer)((Map.Entry)entry).getValue();
        }
        
        System.out.println("Cars in stock left: " + AutoCount);     
    }
    
}
