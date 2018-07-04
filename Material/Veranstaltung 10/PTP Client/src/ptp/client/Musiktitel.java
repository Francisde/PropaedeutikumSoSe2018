/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptp.client;

/**
 * @author Martin Mehlhose
 */

/*
* Klasse zur Erstellung und Bearbeitung von Musiktitel Objekten
*/
public class Musiktitel {
    
    // Definition der Variablen eines Musiktitels
    private String interpret;
    private String titel;
    
    /*
    * Konstruktor zum anlegen eines neuen Musiktitels
    */
    public Musiktitel(String interpret, String titel){
        this.interpret=interpret;
        this.titel=titel;
    }
    
    // Methode gibt den Interpret als String zurück
    public String getInterpret(){
        return interpret;
    }
    
    // Methode gibt den Titel als String zurück
    public String getTitel(){
        return titel;
    }
    
    // Methode gibt ein Musiktitel Objekt als String zurück
    @Override
    public String toString(){
        return "Interpret: " + interpret +", Titel: "+titel;
    }
    /* 
    * Methode Wandelt Musiktitel in sendefähigen String um
    * Einfügen von Escapesequenzen /esc um einzelne Daten zu trennen
    * und eines Hashcodes des String zur Prüfung der korrekten Übertragung
    */
    public String toSend(){
        return interpret+"/esc"+titel+"/esc"+PTPClient.lokaleMusikdatenbank.size()+"/hash"+this.toString().hashCode();
    }
    
    /*
    * Methode vergleicht das aktuelle Objekt mit einem anderen Musiktitel und
    * gibt true zurück, wenn Interpret und Titel gleich sind
    */
    public boolean equals(Musiktitel musiktitel){
        if(musiktitel.getInterpret().equals(this.interpret)){
            if(musiktitel.getTitel().equals(this.titel)){
                return true;
            }
        }
        return false;
    }
    
    // Definition der globalen Musikdatenbank
    public static Musiktitel[] globaleMusikdatenbank={
        new Musiktitel("Beatles", "I Wanna Be Your Man"),
        new Musiktitel("Sportfreunde Stiller", "Ein Kompliment"),
        new Musiktitel("Beatles","All My Loving"),
        new Musiktitel("Rolling Stones", "Satisfaction"),
        new Musiktitel("Michael Jackson", "Thriller"),
        new Musiktitel("Razorlight", "Wire to Wire"),
        new Musiktitel("Leningrad", "www"),
        new Musiktitel("Santigold","Girls"),
        new Musiktitel("Herman's Hermits", "I'm into something good"),
        new Musiktitel("M.I.A.","Paper Planes"),
        new Musiktitel("Nathaniel Rateliff","S.O.B."),
    };
    
}
