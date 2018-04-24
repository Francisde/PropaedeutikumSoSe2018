/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gausssumme;

/**
 *
 * @author martin
 */

import IO.*;
public class GaussSumme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int eingabe= IOTool.readInt("Gib eine Zahl ein: ");
        int ergebnis=0;
        
        for(int i=0;i<=eingabe;i++){
            ergebnis=ergebnis+i;

        }
        System.out.println("Ergebnis: "+ergebnis);
    }
    
}
