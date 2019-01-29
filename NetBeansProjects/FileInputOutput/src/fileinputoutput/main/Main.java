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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        try(BufferedReader br1 = new BufferedReader(getReaderForFile("szoveg1.txt"));
            BufferedReader br2 = new BufferedReader(getReaderForFile("szoveg2.txt"));
            BufferedReader br3 = new BufferedReader(getReaderForFile("szoveg3.txt"))) {
            
            sz1 = br1.readLine().split(" ");
            sz2 = br2.readLine().split(" ");
            sz3 = br3.readLine().split(" ");
            
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
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

                    szo = sc.nextLine();

                    for(int i = 0;i < sz1.length;i++){
                        if(sz1[i].contains(szo)){
                        szamlalo1++;
                        }
                    }

                    for(int i = 0;i < sz2.length;i++){
                        if(sz2[i].contains(szo)){
                        szamlalo2++;
                        }
                    }

                    for(int i = 0;i < sz3.length;i++){
                        if(sz3[i].contains(szo)){
                            szamlalo3++;
                        }    
                    }

                    pw.println("Szoveg1.txt -> " + szamlalo1 + " db");
                    pw.println("Szoveg2.txt -> " + szamlalo2 + " db");
                    pw.println("Szoveg3.txt -> " + szamlalo3 + " db");

                    pw.flush();

                }while(sc.nextLine().equals("Y"));
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        

    }
    
    private static Reader getReaderForFile(String path) throws FileNotFoundException{
        boolean b = Boolean.parseBoolean(System.getProperty("classpathSwitch"));
        if(b){
            return new InputStreamReader(Main.class.getResourceAsStream(path));
        }else {
            return new FileReader(FOLDER_FOR_FILES+path);
        }
    }
}
