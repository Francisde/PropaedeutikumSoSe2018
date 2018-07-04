/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptp.client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Martin Mehlhose
 */

/*
* Ausführbare Hauptklasse des PTPClient Programms mit main Methode
*/
public class PTPClient {

    // Liste möglicher Ports, auf denen die Clients arbeiten können
    public static int[] moeglichePorts = {50001, 50002, 50003, 50004, 50005, 50006, 50007, 50008, 50009, 50010};
    
    // Anlegen einer lokalen Musikdatenbank
    public static List<Musiktitel> lokaleMusikdatenbank;

    // Main Funktion
    public static void main(String[] args) throws IOException{
        
        DatagramSocket socket = null;
        // Initialisierte lokale Musikdatenbank
        lokaleMusikdatenbank = new ArrayList<>();
        
        // Initialisiere Zufallsgenerator
        Random rand = new Random();
        
        // Wähle zufällig zwei Musiktitle aus globaler Datenbank in die lokale Datenbank aus
        int zufallszahl1 =rand.nextInt(Musiktitel.globaleMusikdatenbank.length);
        int zufallszahl2=zufallszahl1;
        while(zufallszahl1==zufallszahl2){
            zufallszahl2=rand.nextInt(Musiktitel.globaleMusikdatenbank.length);
         }
        lokaleMusikdatenbank.add(Musiktitel.globaleMusikdatenbank[zufallszahl1]);
        lokaleMusikdatenbank.add(Musiktitel.globaleMusikdatenbank[zufallszahl2]);
        
        
        
        // wähle einen freien Port aus
        for(int i=0;i<moeglichePorts.length;i++){
            try{
                socket = new DatagramSocket(moeglichePorts[i]);
                System.out.println("Client gestartet auf Port: "+moeglichePorts[i]);
                break;
            }catch(SocketException socketExeption){
                
            }
        }
        // Gebe die initiale Lokale Datenbank aus
        ausgabeMusikdatenbank();
        
        // Starte Methode zum Empfangen
        
        Senden.sendeMulticast(socket);
        
        Empfangen.empfangen(socket);
        
    }
    
    /*
    Methode zur Ausgabe der Musikdatenbank im Client
    */
    public static void ausgabeMusikdatenbank(){
        System.out.println("\nAktuelle Musikdatenbank: \n");
        for(int i=0;i<lokaleMusikdatenbank.size();i++){
            System.out.println(lokaleMusikdatenbank.get(i));
        }
    }
    
}
