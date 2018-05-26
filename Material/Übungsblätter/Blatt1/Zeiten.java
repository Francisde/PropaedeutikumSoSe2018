/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeiten;

import io.*;

/**
 *
 * @author Martin
 * @since 03.05.2018
 */
public class Zeiten {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sekunden = IOTool.readInt("Gib eine Zeit in Sekunden ein: ");
        //Berechnung der Tage
        int tage=sekunden/(60*60*24);
        sekunden=sekunden-tage*(60*60*24);
        
        // Berechnung der Stunden
        int stunden=sekunden/(60*60);
        sekunden=sekunden-stunden*(60*60);
        
        int minuten = sekunden/60;
        sekunden=sekunden-minuten*60;
        System.out.println("Tage: "+tage);
        System.out.println("Stunden: "+stunden);
        System.out.println("Minuten: "+minuten);
        System.out.println("Sekunden: "+sekunden);
        
    }
    
}
