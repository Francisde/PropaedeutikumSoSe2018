/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclient;

import java.io.IOException;

/**
 *
 * @author martin
 */
/*
* Main Klasse des Client Programms
*/
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        // erstelle ein neues Client-Objekt
        JavaClient myClient;
        try{
        myClient = new JavaClient("192.168.178.22",9000);
        
        // Aufruf der Methode welche die Verbindungsanfragen abarbeitet
        myClient.handleConnection();
        
        
        // beenden des Clients
        myClient.beenden();
        
        // Fange den Fall ab, falls Server nicht erreichbar ist.
        }catch(IOException e){
            System.out.println("Server nicht erreichbar");

        }finally{
            System.out.println("Programm wird beendet");
        }



    }
    
}
