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
public class Reflection2 extends Reflection {
    
    public int number3;
    
    public Reflection2(int NUMBER1, int NUMBER2,int NUMBER3) {
        super(NUMBER1, NUMBER2);
        this.number3 = NUMBER3;
    }
    
    public int distributiveMultiply(){
        return number3*number1+number3*number2;
    }
    
}
