/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author Student
 */
public class Fibonacci {

    public void fibonacci(int lepes){
	int kisebb=1,nagyobb=1,osszeg;
	System.out.print(kisebb + " " + nagyobb + " ");
	for(int i=0;i<lepes;i++)
	{
		osszeg=kisebb+nagyobb;
		kisebb=nagyobb;
		nagyobb=osszeg;
		System.out.print(nagyobb + " ");
	}
}
    
    
}
