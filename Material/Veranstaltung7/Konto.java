/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author Martin
 */
public class Konto {

    private final Person kontoinhaber;
    private final int kontonummer;
    private double saldo;

    /**
     * Konstruktor erstellt ein neues Kontoobjekt und initialisert die Objektvariablen
     * @param kontonummer
     * @param saldo
     * @param kontoinhaber 
     */
    Konto(int kontonummer, double saldo, Person kontoinhaber) {
        this.kontonummer = kontonummer;
        this.saldo = saldo;
        this.kontoinhaber = kontoinhaber;
    }
    
    /**
     * Gibt die Kontonummer an das aufrufende Programm zur&uuml;ck
     * @return 
     */
    public int getKontonummer() {
        return kontonummer;
    }
    
    /**
     * Gibt den Saldo an das aufrufende Programm zur&uuml;ck
     * @return 
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Gibt den Kontoinhaber an das aufrufende Programm zur&uuml;ck
     * @return 
     */
    public Person getKontoinhaber() {
        return kontoinhaber;
    }

    /**
     * Die Methode bucht den angegebenen Betrag auf das Saldo des Kontos
     * @param betrag 
     */
    public void buchung(double betrag) {
        if (saldo + betrag < 0) {
            System.out.println("zu wenig Geld!");
        } else {
            saldo = saldo + betrag;
        }
    }
    
    /**
     * &Uuml;berschreibt die toString() Methode und liefert einen String des Kontoobjekts
     * @return 
     */
    @Override
    public String toString() {
        return "Konto: " + kontonummer + " Saldo: " + saldo;
    }

}
