/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author martin
 */
public class IOTool {

    public static int readInt(String args){
        System.out.print(args);
        int result=0;
        boolean read=false;
        Scanner scanner= new Scanner(System.in);
        while(!read){
            try{
                result=scanner.nextInt();
                read=true;
            }catch(NoSuchElementException ex){
                scanner.next();
                System.out.println("Falsche Eingabe!");
                System.out.print(args);
            } catch(IllegalStateException ec){
                scanner.next();
                System.out.println("Scanner geschlossen!");
                return -1;
            }
        }
        scanner.close();

        return result;
    }

    public static double readDouble(String args){
        System.out.print(args);
        double result=0;
        boolean read=false;
        Scanner scanner= new Scanner(System.in);
        while(!read){
            try{
                result=scanner.nextDouble();
                read=true;
            }catch(NoSuchElementException ex){
                scanner.next();
                System.out.println("Falsche Eingabe!");
                System.out.print(args);
            } catch(IllegalStateException ec){
                scanner.next();
                System.out.println("Scanner geschlossen!");
                return -1.0;
            }
        }
        scanner.close();

        return result;
    }

    public static String readString(String args){
        System.out.print(args);
        String result="";
        boolean read=false;
        Scanner scanner= new Scanner(System.in);
        while(!read){
            try{
                result=scanner.next();
                read=true;
            }catch(NoSuchElementException ex){
                scanner.next();
                System.out.println("Falsche Eingabe!");
                System.out.print(args);
            } catch(IllegalStateException ec){
                scanner.next();
                System.out.println("Scanner geschlossen!");
                return "";
            }
        }
        scanner.close();

        return result;
    }

}
