/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.io.*;

/**
 *
 * @author Martin
 */
public class FileIO {

    public static String readFile(String filename) {
        File file = new File(filename);
        BufferedReader br;
        if (file.exists()) {
            try {
                Reader in = new FileReader(file);
                br = new BufferedReader(in);

                String result = "";
                String line;
                while ((line =br.readLine()) != null) {
                    result = result + line+"\n";
                }
                br.close();
                return result;
                
            } catch (FileNotFoundException ex) {

            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        return "";
    }
    
    public static void fileOutput(String data, String filename){
        File file = new File(filename);
            
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(data);
            fw.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
