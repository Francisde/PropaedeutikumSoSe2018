package javaapplication5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Martin
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        Person person1 = new Person("Peter", 1990);

        // Achtung, wie bei Arrays ist das keine echte Kopie, sondern nur eine weitere Referenzauf die selbe Speicheradresse
        Person person2 = person1;
        person2.setName("Hans");
        
        Person person3= new Person("Max", 1993);
        Konto konto=new Konto(123,50,person3);
        Konto konto2 = new Konto(5642, 100.99, new Person("Anna",1974));
        
        System.out.println(konto);
        konto.buchung(-100);
        // Unsere festgelegte Integritätsbedingung (saldo darf nicht negativ sein) hat die Buchung verhindert
        System.out.println(konto);
     
    }
}
