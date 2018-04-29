package teilbarkeit;

import io.*;

/**
 *
 * @author martin
 * @since 27.04.2018
 */
public class Teilbarkeit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int eingabe = IOTool.readInt("Gib eine Zahl ein: ");

        // erste Möglichkeit
        for (int i = 0; i <= eingabe; i++) {
            if (i % 5 == 0) {
                if (i % 7 != 0) {
                    System.out.println(i);
                }
            }
        }

        // ein wenig besser
        for (int i = 0; i <= eingabe; i++) {
            if ((i % 5 == 0) && (i % 7 != 0)) {
                System.out.println(i);
            }
        }
    
    }
}
