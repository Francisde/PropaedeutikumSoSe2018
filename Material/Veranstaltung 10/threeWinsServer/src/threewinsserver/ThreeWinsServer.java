/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threewinsserver;

import java.io.IOException;

/**
 *
 * @author francis
 */
public class ThreeWinsServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // Initialisiere den Server mit auf Port 9000
        JavaServer myServer = new JavaServer(9000);
        myServer.starteServer();
    }
    
}
