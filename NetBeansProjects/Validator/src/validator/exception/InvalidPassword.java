/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator.exception;

/**
 *
 * @author Student
 */
public class InvalidPassword extends Exception {
    
    public InvalidPassword(String message){
        super(message);
    }
}
