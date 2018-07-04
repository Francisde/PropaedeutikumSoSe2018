/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threewinsserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martin
 */

/*
 * Die Klasse Connection handelt die Verbindung zu einem bestimmten Client.
 * Die KLasse implementiert das Interface Runnable um Multithread mit mehreren
 * Clients zu ermöglichen.
 */
public class Connection implements Runnable {

    // Speichert den aktuellen Client
    private final Socket client;
    Scanner in;
    PrintWriter out;
    String name;

    /*
    * Konstruktor des Connection Objects, speichert den Client der aktuellen Connection
    * die von dem Objekt bearbeitet wird.
     */
    public Connection(Socket client) throws IOException {
        this.client = client;
        in = new Scanner(client.getInputStream());
        out = new PrintWriter(client.getOutputStream(), true);
    }
    public void waitForMatch(){
        out.println("Wait for matchmaking");
    }

    
    public void send(String string){
        out.println(string);
    }
    
    public String read(){
        return in.next();
    }
    public void run() {
        try {
            // Initialisierung des Scanners und Writers für die Kommunikatin
            Scanner in = new Scanner(client.getInputStream());
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            boolean aktiveVerbindung = true;

            /*  Die While Schleife prüft ob ob eine Eingabe vom Client kam und reagiert
              mit einer entsprechenden Antwort*/
            while (aktiveVerbindung) {
                // eingabe speichert die Anfrage vom Client
                String eingabe = in.nextLine();

                // Falls Client die verbindung beenden will verlasse die Schleife
                if (eingabe.equals("exit")) {
                    aktiveVerbindung = false;
                    System.out.println("Verbindung zum Client wird beendet");
                } else {
                    // Gib die Wetterdaten zur Anfrage zurück
                    //out.println(Wetterdaten.returnWetterDaten(eingabe));
                }
                // Warte 100ms um in der Zwischenzeit andere Connections zu bearbeiten
                Thread.sleep(100);
            }
            // Beende die Verbindung zum Client
            client.close();

        } catch (IOException | InterruptedException e) {
            try {
                // Versuche die Verbindung zu beenden, falls unerwartet Fehler auftreten
                client.close();
            } catch (IOException ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
