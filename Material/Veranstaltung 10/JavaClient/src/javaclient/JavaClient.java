/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author martin
 */
public class JavaClient {

    // lokale Variable für Client Socket
    private Socket client;
    private Scanner in;
    private PrintWriter out;
    private Scanner nutzereingabe;

    /*
    * Konstuktor zum Erstelen eines Client Objekts mit gewünschter Internetadresse und Port
    * initialisierung des Writer und der Eingabe Scanner
     */
    public JavaClient(String url, int port) throws IOException {

        this.client = new Socket(url, port);

        System.out.println("Client gestartet und mit Server verbunden!");

        nutzereingabe = new Scanner(System.in);
        out = new PrintWriter(client.getOutputStream(), true);
        in = new Scanner(client.getInputStream());
    }

    /*
    * Methode gibt den Socket des Objekts zurück
     */
    public Socket getSocket() {
        return this.client;
    }

    /*
    * Methode zum Beenden der Verbindung schließt den Socket
     */
    public void beenden() throws IOException {
        client.close();
    }

    public void handleConnection() {

        while (true) {
            // Abfrage vom Nutzer
            String empfangen = in.nextLine();

            if (empfangen.equals("Request")) {
                String eingabe = nutzereingabe.next();

                // Anfrage an den Server mit Nutzereingabe
                out.println(eingabe);
            }else

            // Beende falls Eingabe exit war.
            if (empfangen.equals("exit")) {
                break;
            }else{
                System.out.println(empfangen);
            }
            
        }
        // Beenden der Scanner und des Writers
        in.close();
        out.close();
        nutzereingabe.close();

    }

}
