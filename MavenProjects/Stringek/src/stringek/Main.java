/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringek;

/**
 *
 * @author Student
 */
public class Main {
    
    public static void main(String[] args) {
        Stringek s = new Stringek("Ez egy teszt string");
        
        System.out.println(s.fordit());
        System.out.println(s.stringWithUnderscore());
        System.out.println(s.toLower());
        System.out.println(s.toUpper());
    }
    
}
