/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prim;

import io.*;

/**
 *
 * @author martin
 */
public class Prim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean isPrime;
        int eingabe = IOTool.readInt("gib n ein: ");
        for (int i = 2; i <= eingabe; i++) {
            isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true) {
                System.out.println(i);
            }
        }
    }

}
