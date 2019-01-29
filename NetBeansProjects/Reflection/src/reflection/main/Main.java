/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflection.main;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import reflection.Reflection;
import reflection.Reflection2;
import java.lang.reflect.Modifier;

/**
 *
 * @author Student
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers;
        Object obj = null;
        Method m;
        String[] method;
        String methodname;
        Class[] parameters = null;
        Field[] f1 = Reflection.class.getDeclaredFields();
        Field[] f2 = Reflection2.class.getDeclaredFields();
        Method[] m1 = Reflection.class.getDeclaredMethods();        //getMethods beépített függvényeket is visszaad, ezért nem használom
        Method[] m2 = Reflection2.class.getDeclaredMethods();
        Constructor[] c1 = Reflection.class.getDeclaredConstructors();
        Constructor[] c2 = Reflection2.class.getDeclaredConstructors();
        printFields(f1);
        printFields(f2);
        printMethods(m1);
        printMethods(m2);
        printConstructors(c1);
        printConstructors(c2);
        
        System.out.println("Write 2 or 3 numbers");
        numbers = sc.nextLine().split(" ");
        
        if(numbers.length==2){
            Reflection r = (Reflection) tryConstructor(numbers,Reflection.class,int.class,int.class);
            System.out.println(r.number1 + " " + r.number2);
            obj = r;
        }
        if(numbers.length==3){
            Reflection2 r = (Reflection2) tryConstructor(numbers,Reflection2.class,int.class,int.class,int.class);
            System.out.println(r.number1 + " " + r.number2 + " " + r.number3);
            obj = r;
        }
        if(obj == null){
            System.exit(-1);
        }
        
        System.out.println("Call a method: ");
        method = sc.nextLine().split(" ");
        
        for(int i = 1;i<method.length;i++){
            try {
                parameters[i-1]=Class.forName(method[i]);
            } catch (ClassNotFoundException ex) {
                System.err.println(ex.getMessage());
            }
        }
        
        try {
            
            m = obj.getClass().getMethod(method[0],parameters);
            System.out.println(m.invoke(obj,parameters));
            
        } catch (NoSuchMethodException ex) {
            System.err.println(ex.getMessage());
        } catch (ReflectiveOperationException ex){
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause());
        } 
        
     
    }
    
    private static void printArray(Object[] o){
        for (Object o1 : o) {
            System.out.println(o1);
        }
        System.out.println();
    }
    
    private static void printFields(Field[] f){
        for(Field fi: f){
            System.out.println(fi.getName() + " " + fi.getType() + " " + decodeModifiers(fi,fi.getModifiers()) + fi.getAnnotations());
        }  
    }
    
    private static void printConstructors(Constructor[] c){
        for(Constructor ci: c){
            System.out.println(ci.getName() + " " + decodeModifiers(ci,ci.getModifiers()) + " " + ci.getAnnotations());
        }
    }
    
    private static void printMethods(Method[] m){
        for(Method mi: m){
            System.out.println(mi.getName() + " " + decodeModifiers(mi,mi.getModifiers()) + " " + mi.getParameterTypes() + " " + mi.getReturnType() + " " +
                    mi.getExceptionTypes() + " " + mi.getAnnotations());
        }
    }
    
    private static String decodeModifiers(AccessibleObject o,int mods){
        String Modifiers = "";
        System.out.println(o.getClass());
        System.out.println(mods);
        if ((Modifier.PUBLIC&mods)==1)      Modifiers += "public ";
	if ((Modifier.PROTECTED&mods)==4)   Modifiers += "protected ";
	if ((Modifier.PRIVATE&mods)==2)     Modifiers += "private ";
	if ((Modifier.STATIC&mods)==8)      Modifiers += "static ";
	if ((Modifier.FINAL&mods)==16)       Modifiers += "final ";
	if ((Modifier.TRANSIENT&mods)==128)   Modifiers += "transient ";
	if ((Modifier.VOLATILE&mods)==64)    Modifiers += "volatile ";
	return Modifiers;
    }
    
    public static Object tryConstructor(String[] numbers,Class cl,Class<?>... parameters){
        Object r = null ;
        Constructor c;
            try{
                c = cl.getConstructor(parameters);
                if(parameters.length==2){
                    r = (Reflection) c.newInstance(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1]));
                }
                if(parameters.length==3){
                    r = (Reflection2) c.newInstance(Integer.parseInt(numbers[0]),Integer.parseInt(numbers[1]),Integer.parseInt(numbers[2]));
                }
            } catch (NoSuchMethodException ex) {
                System.err.println(ex.getMessage());
            } catch (ReflectiveOperationException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex.getCause());
            } 
       return r; 
    }
    
}
