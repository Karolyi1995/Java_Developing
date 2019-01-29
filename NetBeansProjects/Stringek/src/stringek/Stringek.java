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
public class Stringek {

    private String str;
    
    public Stringek(String param){
        str=param;
    }
    
    public String fordit(){
        String tmp="";
        for(int i=str.length()-1;i>=0;i--){
               tmp+=str.charAt(i);
           }
        return tmp;
    }
    
    public String toUpper(){
        return str.toUpperCase();
    }
    
    public String toLower(){
        return str.toLowerCase();
    }
    
    public String stringWithUnderscore(){
        String tmp="";
        for(int i=0;i<str.length();i++){
            
            if(i!=str.length()-1){
                tmp+=str.charAt(i) + "_";
            }
            else{
                tmp+=str.charAt(i);
            }
        }
        return tmp;
    }
    
}
