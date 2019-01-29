/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.main;

import java.util.Scanner;
import validator.exception.LengthInvalidEx;
import validator.validator.Validator;
import validator.exception.WrongFormatEx;

/**
 *
 * @author Student
 */
public class Main {
    
    public static void main(String[] args){
        String password;
        Validator v = new Validator();
        Scanner sc = new Scanner(System.in);
        boolean valid;
        do{
        try{
                valid = true;
                password=sc.nextLine();
                v.validatePassword(password);
            
        } catch(LengthInvalidEx ex){
            System.out.println(ex.getMessage());
            valid = false;
        } catch(WrongFormatEx ex){
            System.out.println(ex.getMessage());
            valid = false;
        }
    }while(valid != true);
        System.out.println("Jelszó elfogadva");
    }
    
}
