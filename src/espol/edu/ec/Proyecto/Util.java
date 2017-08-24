/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.Proyecto;

/**
 *
 * @author navi9
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {
   
    public static HashMap<String, String> getMapa(String fileName){
        HashMap<String, String> mapa= new HashMap<>();
        Scanner sc = new Scanner(System.in);
        File file = new File(fileName);
        try {
             sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(sc.hasNext()){
            String[] linea = sc.nextLine().split("[|]");
            mapa.put(linea[0], linea[1]);           
        } 
        sc.close();
        return mapa;  
    }
    
    public static HashMap<String, LinkedList<String>> getMapaPeliculaActores(String fileName){
        HashMap<String, LinkedList<String>> mapa= new HashMap<>();
        Scanner sc = new Scanner(System.in);
        File file = new File(fileName);
        try {
             sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(sc.hasNext()){
            String[] linea = sc.nextLine().split("[|]");
            if(mapa.containsKey(linea[0])){
                mapa.get(linea[0]).addLast(linea[1]);
            }else{
                mapa.put(linea[0], new LinkedList<>());
                mapa.get(linea[0]).addLast(linea[1]);
            }
        }
        sc.close();
        return mapa;
    
    }
}
