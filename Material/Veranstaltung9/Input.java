/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Martin
 */
public class Input {

    Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public int readInt() {
        int result = 0;
        while (true) {
            try {
                result = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Falsche Eingabe! nochmal");
                scanner.nextLine();
            }
        }
        return result;
    }
    
    public String readString(){
        String result="";
        while(true){
            try{
                result=scanner.nextLine();
                break;
            
            } catch (InputMismatchException e) {
                System.out.println(e);
                System.out.println("Falsche Eingabe! nochmal");
                scanner.nextLine();
            }
        }
        return result;
    }
    
    public void close(){
        scanner.close();
    }

}
