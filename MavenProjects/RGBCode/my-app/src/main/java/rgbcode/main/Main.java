/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgbcode.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import rgbcode.rgbcode.RGBCode;
import rgbcode.exception.ValueOutOfBoundsEx;

/**
 *
 * @author Student
 */
public class Main {
    
    public static void main(String[] args) {
        
        HashSet<RGBCode> set = new HashSet();
        ArrayList<RGBCode> list = new ArrayList();
        int red,green,blue;
        RGBCode rgb;
        String input;
        Scanner sc = new Scanner(System.in);
        
        do{
            try{
                System.out.println("Add an RGB Code");
                
                System.out.print("Red: ");
                red=Integer.parseInt(sc.nextLine());
                
                System.out.print("Green: ");
                green=Integer.parseInt(sc.nextLine());
                
                System.out.print("Blue: ");
                blue=Integer.parseInt(sc.nextLine());
                
                rgb = new RGBCode(red,green,blue);
                
                if(set.contains(rgb)){
                    System.out.println("Object already exists in the HashSet.");
                }
                
                set.add(rgb);
                
                if(!list.contains(rgb)){
                    list.add(rgb);
                }
                else{
                    System.out.println("Object already exists in the ArrayList.");
                }
                
            }catch (ValueOutOfBoundsEx ex){
                System.out.println(ex.getMessage());
            }finally{
                do{
                    System.out.println("Do you want to add a color? Y/N");
                    input = sc.nextLine();
                }while(!(input.equals("Y") || input.equals("N")));
            }
        }while(!input.equals("N"));
        
        System.out.println("Objects in the HashSet:");
        
        for(RGBCode h: set){
            System.out.println(h.toString());
        }
        
        System.out.println("Objects in the ArrayList:");
        
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        
        rgb = null;
        
        do{
            try{
                System.out.println("Removing Object: ");
                
                System.out.print("Red: ");
                red=Integer.parseInt(sc.nextLine());
                
                System.out.print("Green: ");
                green=Integer.parseInt(sc.nextLine());
                
                System.out.print("Blue: ");
                blue=Integer.parseInt(sc.nextLine());
                
                rgb = new RGBCode(red,green,blue); 
        
            }catch(ValueOutOfBoundsEx ex){
                System.out.println(ex.getMessage());
            }
        
        }while(rgb==null);
        
        
        if(list.contains(rgb)){
                list.remove(rgb);
        }
        
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    
}
