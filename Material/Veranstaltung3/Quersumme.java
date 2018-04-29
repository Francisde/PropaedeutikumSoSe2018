/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quersumme;

/**
 *
 * @author martin
 */
public class Quersumme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int eingabe=IO.IOTool.readInt("Gib eine Zahle ein: ");
        int ergebnis=0;
        int teiler=10;
        int ziffer;
        while(eingabe!=0){
            ziffer= eingabe%teiler;
            ergebnis=ergebnis+ziffer;
            eingabe=eingabe/teiler;
        }
        System.out.println("Quersumme= "+ergebnis);
    }
}
