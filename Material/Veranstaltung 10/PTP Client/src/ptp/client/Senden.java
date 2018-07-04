/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Martin Mehlhose
 */

/*
* Klasse zu Senden von Daten an andere Clients 
*/
public class Senden{

    static String host= "192.168.178.55";
    /*
    * Methode sendet einen Multicast an alle Ports an denen PTP Clients 
    * sein könnten
    */
    public static void sendeMulticast(DatagramSocket socket) throws IOException{        

            // lege die Internetadresse des Empfängers fest
            InetAddress ia = InetAddress.getByName( host );
            
            // gehe alle möglichen Ports durch um MusikDB zu senden
            for(int i=0;i<PTPClient.moeglichePorts.length;i++){
                // prüfe ob gewählter Port der eigene ist -> hier muss nicht gesendet werden
                if(PTPClient.moeglichePorts[i]!=socket.getLocalPort()){
                    // Sende sie MusikDB an den gegebenen Port
                    einzelSendung(socket, PTPClient.moeglichePorts[i]);
                }
            }    
    }
    
    /*
    * Methode um die Daten aus der MusikDB an einen einzelnen Empfänger an dem 
    * Gegebenen Port zu senden
    */
    public static void einzelSendung(DatagramSocket socket, int port) throws IOException{
        // lege die Internetadresse des Empfängers fest
        InetAddress ia = InetAddress.getByName( host );
         
        // gehe jeden Musiktitel in der MusikDB durch
        for(int j=0;j<PTPClient.lokaleMusikdatenbank.size();j++){
            //wandle den aktuellen Musiktitel in ein ByteArray zum senden um
            String s = PTPClient.lokaleMusikdatenbank.get(j).toSend();
            byte[] raw = s.getBytes();

            // Sende das aktuelle ByteArray als DatagramPacket
            DatagramPacket packet = new DatagramPacket( raw, raw.length, ia, port );
            socket.send( packet );

        }   
    }
    /*
    * Methode zum Senden einer Kontrollnachricht an einen Client
    */
    public static void sendeNachricht(DatagramSocket socket, int port, String nachricht) throws IOException{
        // lege die Internetadresse des Empfängers fest
        InetAddress ia = InetAddress.getByName( host );
        
        //Wandle Nachricht in byte Array um
        byte[] raw = nachricht.getBytes();

        // Sende das aktuelle ByteArray als DatagramPacket
        DatagramPacket packet = new DatagramPacket( raw, raw.length, ia, port );
        socket.send( packet );
           
    }
}
