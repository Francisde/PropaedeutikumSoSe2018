/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zahlenraten;

import io.*;
/**
 *
 * @author Martin
 * @since 03.05.2018
 */
public class Zahlenraten {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int zufallszahl = (int) ( Math.random()*100);
        int eingabe;
        
        while(true){
            eingabe=IOTool.readInt("Rate die Zahl: ");
            if(eingabe<zufallszahl){
                System.out.println("zu klein");
            }else if(eingabe>zufallszahl){
                System.out.println("zu groß");
            }else{
                System.out.println("Richtig. Die Zufallszahl war "+zufallszahl);
                break;
            }
        }
    }
    
}
