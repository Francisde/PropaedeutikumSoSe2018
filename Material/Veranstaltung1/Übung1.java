/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package übung1;

/**
 *
 * @author lektor
 */
public class Übung1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        int a = 25;
        int b= 10;
        
        int umfang, flaecheninhalt;
        
        umfang = 2*a +2*b;
        
        flaecheninhalt= a*b;
        
        System.out.println("Umfang"+umfang);
        */
        double a=5;
        double b=25;
        double c=2;
        
        double ergebnis1;
        double ergebnis2;
        double zwischenergebnis;
        a=a/a;
        b=b/a;
        c=c/a;
        
        zwischenergebnis=((b/2)*(b/2))-c;
        
        if(zwischenergebnis>=0){
           zwischenergebnis= Math.sqrt(zwischenergebnis);
            
           ergebnis1=-(b/2)+zwischenergebnis;
           ergebnis2=-(b/2)-zwischenergebnis;
           
            System.out.println("Ergebnis1: "+ ergebnis1);
            System.out.println("Ergebnis2: "+ ergebnis2);
        }else {
            System.out.println("Kein Ergebnis.");
        }
}
    
}
