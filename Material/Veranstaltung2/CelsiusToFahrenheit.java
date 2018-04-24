/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celsiustofahrenheit;

/**
 *
 * @author martin
 */

import IO.*;
public class CelsiusToFahrenheit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double eingabe = IOTool.readDouble("Gib die Temperatur ein Celsius ein: ");
        double ergebnisFahrenheit, ergebnisKelvin;
        
        ergebnisFahrenheit= (eingabe*1.8)+32;
        ergebnisKelvin=eingabe+273;
        
        
        System.out.println("Die Temperatur in Fahrenheit beträgt: "+ergebnisFahrenheit);
        System.out.println("Die Temperatur in kelvin beträgt: "+ergebnisKelvin);
    }
}
