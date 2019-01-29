/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.validator;

import validator.exception.LengthInvalidEx;
import validator.exception.WrongFormatEx;


/**
 *
 * @author Student
 */
public class Validator{
    
    
    public void validatePassword(String password) throws LengthInvalidEx,WrongFormatEx {
        
        boolean DigitFlag=false,UpperFlag=false,SymbolFlag=false;
        
        if(password.length() < 9){
            throw new LengthInvalidEx("Password is too short");
        }
        
        if(password.length() > 20){
            throw new LengthInvalidEx("Password is too long");
        }
        
        for(int i=0;i<password.length();i++){
            if(Character.isDigit(password.charAt(i))){
                DigitFlag=true;
            }
        
            if(Character.isUpperCase(password.charAt(i))){
                UpperFlag=true;
            }
        
            if(!Character.isLetterOrDigit(password.charAt(i)) && !Character.isSpaceChar(password.charAt(i))){
               SymbolFlag=true;
            }
        }
        if(DigitFlag == false){
            throw new WrongFormatEx("Password requires at least 1 digit");
        }
        if(UpperFlag == false){
            throw new WrongFormatEx("Password requires at least 1 upper case letter.");
        }
        if(SymbolFlag == false){
            throw new WrongFormatEx("Password requires at least 1 symbol");
        }
    }
    
    private boolean hasDigit(char c){
        return Character.isDigit(c);
    }
    
    private boolean hasUpper(char c){
        return Character.isUpperCase(c);
    }
    
    private boolean hasSymbol(char c){
       return Character.isLetterOrDigit(c) && Character.isSpaceChar(c);
    
}
}
          