/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramma;

import java.util.Arrays;

/**
 *
 * @author Student
 */
public class Anagramma {
    
    public void Anagramma(String s1,String s2){
        if(s1.length()!=s2.length()){
            System.out.println("Nem anagrammák");
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(Arrays.equals(c1, c2)){
            System.out.println("Anagrammák");
        }
        else{
            System.out.println("Nem anagrammák");
        }
    }
    
}