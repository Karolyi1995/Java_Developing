/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileinputoutput.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Main {
    
    private static final String FOLDER_FOR_FILES = "C:\\Users\\Student\\Documents\\";
    
    public static void main(String[] args) {
        
        String[] sz1 = null,sz2 = null,sz3 = null;
        int szamlalo1 = 0,szamlalo2 = 0,szamlalo3 = 0;
        String szo;
        Scanner sc = new Scanner(System.in);
       
            sz1 = getStringFromFile("szoveg1.txt");
            sz2 = getStringFromFile("szoveg2.txt");
            sz3 = getStringFromFile("szoveg3.txt");
        
        File f = null;
        try{
            f = new File("result.txt");
            if(f.exists()){
                f.delete();
            }
            f.createNewFile();
        }catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        if(f != null){
            try(PrintWriter pw = new PrintWriter(new FileWriter("result.txt"))){
            
                do{
                    System.out.println("Irjon be egy szot: ");
                    szo = sc.nextLine();

                    szamlalo1 = count(sz1,szo);
                    szamlalo2 = count(sz2,szo);
                    szamlalo3 = count(sz3,szo);

                    pw.println("Szoveg1.txt -> " + szamlalo1 + " db");
                    pw.println("Szoveg2.txt -> " + szamlalo2 + " db");
                    pw.println("Szoveg3.txt -> " + szamlalo3 + " db");

                    pw.flush();
                    System.out.println("Szeretne meg szot beolvasni? Y/N");
                }while(sc.nextLine().equals("Y"));
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        

    }
    
    private static Reader getReaderForFile(String path) throws FileNotFoundException{
        boolean b = Boolean.parseBoolean(System.getProperty("classpathSwitch"));
        if(b){
            return new InputStreamReader(Main.class.getResourceAsStream("/" + path));
        }else {
            return new FileReader(FOLDER_FOR_FILES+path);
        }
    }
    
    private static String[] getStringFromFile(String file){
        String StringFromFile = "";
        try{
            Scanner sc = new Scanner((new BufferedReader(getReaderForFile(file))));
        
            while(sc.hasNextLine()){
                StringFromFile += sc.next() + " ";
            }      
        }catch(FileNotFoundException ex){
            System.err.println(ex.getMessage());
        }
        
        return StringFromFile.split(" ");
    }
    
    
    private static int count(String[] tmp,String word){
        int count=0;
        for(int i = 0;i <tmp.length;i++){
                        if(tmp[i].contains(word)){
                        count++;
                        }
                    }
        return count;
    }
}
