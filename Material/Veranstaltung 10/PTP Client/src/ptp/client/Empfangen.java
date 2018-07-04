/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * @author Martin Mehlhose
 */
public class Empfangen {
    

    /*
    * Methode, die das Empfangen von Datenpacketen abarbeitet
    */
    public static void empfangen(DatagramSocket socket) throws IOException{
        
        // Auf Anfrage in einer Dauerschleife warten
        while(true){  
            DatagramPacket packet = new DatagramPacket( new byte[1024], 1024 );
            try {
                // nehme ein Daten Paket an
                socket.receive( packet );
            } catch (IOException ex) {
                System.out.println("IO Exception");
            }
                
            //Daten des Absenders auslesen
            int portSender = packet.getPort();

            // Daten auslesen und in String konvertieren
            int         len     = packet.getLength();
            byte[]      data    = packet.getData();
            String empfangenesPaket = new String( data, 0, len );
            
            // Der Sender möchte Kopie unserer DB
            if(empfangenesPaket.equals("request")){
                Senden.einzelSendung(socket, packet.getPort());
            }
            // teile empfangenes Paket an Escape Sequenzen
            String[] test=new String[2];
            test[0]=empfangenesPaket.substring(0, empfangenesPaket.indexOf("/esc"));
            test[1]=empfangenesPaket.substring(empfangenesPaket.indexOf("/esc")+4, empfangenesPaket.lastIndexOf("/esc"));
            int dbGroeseAbsender=Integer.parseInt(empfangenesPaket.substring(
                    empfangenesPaket.lastIndexOf("/esc")+4,empfangenesPaket.indexOf("/hash")));
            int hashcode= Integer.parseInt(empfangenesPaket.substring(empfangenesPaket.indexOf("/hash")+5));
            
            // Erstelle aus den Daten ein neues Musikobject
            Musiktitel musiktitel =new Musiktitel(test[0],test[1]);
            
            /*
            * Falls der Hashcode der Sendung nicht mit dem berechnetem Übereinstimmt
            * muss Fehler bei der Übertragung vorliegen. Fordere neue Übertragung an.
            */
            if(musiktitel.toString().hashCode()!=hashcode){
                Senden.sendeNachricht(socket, packet.getPort(), "request");
            }else{
                
                // Prüfe ob Musikobjekt in lokaler Datenbank
                boolean isInList=false;
                for(Musiktitel i : PTPClient.lokaleMusikdatenbank){
                    if(musiktitel.equals(i)){
                        isInList=true;
                    }
                }

                /*
                * Wenn Musikobject nicht in lokaler Datenbank ist wird es eingefügt
                * Da lokale Datenbank und Sender Datenbank offenbar unterschiedlich 
                * wird ein Senden der lokalen Daten an den ursprünglichen Sender veranlasst
                */
                if(isInList==false){
                    PTPClient.lokaleMusikdatenbank.add(musiktitel);
                    // Die neue aktuelle Musikdatenbank  wird ausgegeben
                    PTPClient.ausgabeMusikdatenbank();
                }

                /*
                * Wenn Musiktitel nicht in eigner Datenbank oder die beiden DB unterschiedlich groß
                * Hat der Sender offenbar andere Daten. Daher wird senden der lokalen Daten an 
                * ursprünglichen Absender veranlasst.
                */
                if(isInList==false||(dbGroeseAbsender!=PTPClient.lokaleMusikdatenbank.size())){

                    Senden.einzelSendung(socket, portSender);

                }
            }
        }
    }
    
}
