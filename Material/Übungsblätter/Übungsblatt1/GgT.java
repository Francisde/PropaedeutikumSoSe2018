/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ggt;

import io.*;

/**
 *
 * @author Martin
 * @since 03.05.2018
 */
public class GgT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ersteZahl=IOTool.readInt("Gib die erste Zahl ein: ");
        int zweiteZahl=IOTool.readInt("Gib die zweite Zahl ein: ");
        
        int a;
        int b;
        int r=ersteZahl;
        if(ersteZahl>zweiteZahl){
            a=ersteZahl;
            b=zweiteZahl;
        }else{
            a=zweiteZahl;
            b=ersteZahl;
        }
        
        while(true){
            if(a%b==0){
                break;
            }else{
                r=a%b;
                a=b;
                b=r;
            }
        }
        System.out.println("ggT von "+ersteZahl+" und "+zweiteZahl+" ist: "+r);
    }
    
}
