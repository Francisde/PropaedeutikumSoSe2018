/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

/**
 *
 * @author Martin
 * @since  03.05.2018
 */
public class PI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        double ergebnis=1;
        // Berechnung von PI/2 nach dem wallisschen Produkt
        
        for(double i=1;i<10000000;i++){
            ergebnis=ergebnis*(((2*i)*(2*i))/((2*i-1)*(2*i+1)));
        }
        
        System.out.println("PI: "+ergebnis*2);
    }
    
}
