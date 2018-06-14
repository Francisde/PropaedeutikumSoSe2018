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
public class Sparbuch extends Konto{
    
    private double zins;
    
    public Sparbuch(int kontonummer, double guthaben, double zins, Person person){
        super(kontonummer, guthaben, person);
        this.zins=zins;
    }
    
    @Override
    public void setDispo(double wert){
        System.out.println("Dispo nicht möglich");
    }
    
}
