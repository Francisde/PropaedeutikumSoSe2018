/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threewinsserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



/**
 *
 * @author martin
 */

/*
* Klasse zum Anlegen eines Server-Objekts
*/
public class JavaServer {

    // Speichert den ServerSocket für das Server-Object
    private final ServerSocket serverSocket;
    private ArrayList<Connection> freeclients=new ArrayList();
    
    /*
    * Konstruktor zum erstellen des Server-Objekts auf dem gefordertem Port
    */
    public JavaServer(int port) throws IOException{
        serverSocket = new ServerSocket( port );
        System.out.println("Server gestartet.");
        
    }
    
    // Methode gibt den Server Socket zurück
    public ServerSocket getServerSocket(){
        return serverSocket;
    }
    
    /*
    * Methode starteServer lauscht in einer Endlosschleife nach Anfragen von Clients
    * und erstellt für jede Verbindungsanfrage einen Thread um die Anfrage 
    * abzuhandeln
    */
    public void starteServer(){
        

        while ( true ){
            Socket client = null;

            try
            {
                // Anweisung nimmt eine Verbindung von einem Client an
                client = serverSocket.accept();
                //Ein neuer Connection Thread wird erstellt und Anfrage abgearbeitet 
                Connection connection =new Connection(client);
                freeclients.add(connection);
                connection.waitForMatch();
                if(freeclients.size()==2){
                    new Thread(new Spiel(freeclients.get(0),freeclients.get(1))).start();
                    freeclients.clear();
                }
                //new Thread(connection).start();
                
            }
            
            // Fange Input/Output Exception ab
            catch ( IOException e ) {
                
                System.out.println("IOException");
            } 
        }
    }
}
