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
 * @author Martin
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
        gebjahr = neuesGebjahr;
        count++;
    }

    /*
     * Die Methode berechnet das aktuelle Alter einer Person und gibt dies an die Aufrufende Methode zur&uuml;ck
     */
    public int alter() {

        return Calendar.getInstance().get(Calendar.YEAR) - gebjahr;
    }


    /*
     * Die Methode gib den Namen der Person zur&uuml;ck 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Mit der Methode kann der Name einer Person ge&auml;ndert werden. 
     * @param newName als String Objekt
     */
    public void setName(String newName) {
        name = newName;
    }

    /*
     * Methode gibt den aktuellen count-Wert zurück.
     */
    public static int getCount() {
        return count;
    }

    /**
     * Die Umgeschriebene toString Methode wandelt ein Person-Objekt in einen String um.
     * @return String aus Name und Geburtsdatum
     */
    @Override
    public String toString(){
        return "Name: "+name+" Alter: "+alter();
    }
}
