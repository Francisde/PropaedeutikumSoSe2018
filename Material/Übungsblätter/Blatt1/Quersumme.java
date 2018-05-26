/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quersumme;
import io.*;

/**
 *
 * @author Martin
 * @since 03.05.2018
 */
public class Quersumme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int eingabe=IOTool.readInt("Gib eine Zahle ein: ");
        int ergebnis=0;
        int teiler=10;
        int ziffer;
        int zwischenwert=eingabe;
        
        // Berechnung der "normalen" Quersumme
        while(zwischenwert!=0){
            ziffer= zwischenwert%teiler;
            ergebnis=ergebnis+ziffer;
            zwischenwert=zwischenwert/teiler;
        }
        System.out.println("Quersumme= "+ergebnis);
        
        
        ergebnis=0;
        int i=1;
        // Berechnung der gewichteten Quersumme
        while(eingabe!=0){
            ziffer=eingabe%teiler;
            ergebnis=ergebnis+(ziffer*i);
            eingabe=eingabe/teiler;
            i++;
        }
        System.out.println("\ngewichtete Quersumme: "+ergebnis);
    
    }
}
