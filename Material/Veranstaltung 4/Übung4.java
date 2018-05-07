/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package übung4;

/**
 *
 * @author martin
 */
public class Übung4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int ergebnis = add(55, 10);
        System.out.println(ergebnis);

        ergebnis = mul(2, 10);
        System.out.println(ergebnis);

        double myQuadrat = quadrat(5.23);
        System.out.println(myQuadrat);

        int[] myArray = {2, 45, 10, 7, 80};
        printArray(myArray);

    }
    // Definition der eigenen Methoden immer außerhalb der Main Methode! Aber immer
    // innerhalb der Klasse.

    // Methode zur Addition zweier Integer
    public static int add(int a, int b) {
        int result = a + b;
        return result;
    }

    // Methode zur Multiplikation zweier Integer
    public static int mul(int a, int b) {
        int result = a * b;
        return result;
    }

    // Methode zur Bildung des quadrats eines Double
    public static double quadrat(double a) {
        double result = a * a;
        return result;
    }

    // Methode zur Ausgabe eines Array auf dem Bildschirm
    public static void printArray(int[] array) {
        // rufe die Länge des Arrays mit array.length ab
        for (int i = 0; i < array.length; i++) {
            // System.out.print und nicht System.out.println um alle prints in einer Zeile zu haben
            System.out.print(array[i] + "\t");
        }
        // Abschließendes System.out.println um den Cursor in die nächste Zeile zu setzten
        System.out.println("");
    }

}
