/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author martin
 */
public class Person {

    private static int count = 0;
    private String name;
    private int gebjahr;
    private Date gebDate;

    /*
     * Konstruktor zum Erstellen eines neuen JavaObjects vom Typ Person
     */
    public Person(String neuerName, int neuesGebjahr) {
        name = neuerName;
        //gebDate=newGebDate;
        gebjahr = neuesGebjahr;
        count++;
        
    }

    /*
     * Die Methode berechnet das aktuelle Alter einer Person und gibt dies an die Aufrufende Klasse zurück
     */
    public int alter() {

        return Calendar.getInstance().get(Calendar.YEAR) - gebjahr;
    }


    /*
     * Die Methode gib den Namen der Person zurück 
     */
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    /*
     * Methode gibt den aktuellen count-Wert zurück.
     */
    public static int getCount() {
        return count;
    }
    
    @Override
   public String toString(){
       return "Name:"+name+" Alter: "+alter();
   }

}
