package javaapplication5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author martin
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        Konto konto1 = new Konto(1234, 50.00, null);
        System.out.println(konto1);
        konto1.umsatz(-100);
        System.out.println(konto1);
        
        Sparbuch sparbuch = new Sparbuch(121, 0.00, 3,null);
        sparbuch.umsatz(50);
        System.out.println(sparbuch);
    }

}
