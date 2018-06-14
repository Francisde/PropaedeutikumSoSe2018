/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author lektor
 */
public class Konto {
    
    private int kontonummer;
    private double guthaben;
    private Person kontoinhaber;
    private double dispo;
    
    public Konto(int kontonummer, double guthaben, Person kontoinhaber){
        this.kontonummer=kontonummer;
        this.guthaben=guthaben;
        this.kontoinhaber=kontoinhaber;
        dispo=0;
        
    }
    
    public void umsatz(double umsatz){
        if(guthaben+dispo+umsatz<0){
            System.out.println("Nicht genug Geld");
        }else{
            guthaben=guthaben+umsatz;
        }
        
    }
    @Override
    public String toString(){
        return "Konto: "+kontonummer+" Saldo: "+guthaben;
    }
    
    public void setDispo(double wert){
        this.dispo=wert;
    }
    
    
    
    
}
