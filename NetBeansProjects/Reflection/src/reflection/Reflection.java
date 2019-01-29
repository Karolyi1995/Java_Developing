/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflection;

/**
 *
 * @author Student
 */
public class Reflection {

    public int number1;
    public int number2;
    private static int number = 0 ;

    public Reflection(int NUMBER1, int NUMBER2) {
        this.number1 = NUMBER1;
        this.number2 = NUMBER2;
    }
    
    public int multiply(){
        return number1*number2;
    }
    
    public int multiply(int number3){
        return number1*number2+number3;
    }
    
}
