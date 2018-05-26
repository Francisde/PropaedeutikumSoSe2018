/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gausssumme;

/**
 *
 * @author Martin
 * @since 03.05.2018
 */

import io.*;
public class GaussSumme {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {
        
        int eingabe= IOTool.readInt("Gib eine Zahl ein: ");
        int ergebnis=0;
        
        // Gausssche Summe mit for-Schleife
        for(int i=0;i<=eingabe;i++){
            ergebnis=ergebnis+i;

        }
        System.out.println("Ergebnis: "+ergebnis);
        
        //Gaussche Summe mit while-Schleife
        int i=0;
        ergebnis=0;
        while(i<=eingabe){
            ergebnis=ergebnis+i;
            i++;
        }
        System.out.println("Gausssumme mit while-loop: "+ergebnis);
    
        // Fakultät mit while-Schleife
        ergebnis=1;
        while(eingabe>=0){
            if(eingabe==0){
                ergebnis=ergebnis*1;
            }else{
                ergebnis=ergebnis*eingabe;
            }
            eingabe--;
        }
        
        System.out.println("Fakultät: "+ergebnis);
        
    }
    public static int add(int a, int b){
        return 0;
    }
    public static double add(double a, double b){
        return 0.0;
    }

    
}
