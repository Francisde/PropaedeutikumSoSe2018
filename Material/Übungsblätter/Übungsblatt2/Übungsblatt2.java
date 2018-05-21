/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package übungsblatt2;
/**
 *
 * @author martin
 */
public class Übungsblatt2 {

    public static void main(String[] args) {
        System.out.println("Min: " + min(2, 5));
        System.out.println("Max: " + max(2, 5));
        System.out.println("Div: " + div(5.0, 0));
        System.out.println("Div: " + div(5, 2));
        System.out.println("Mittelwert: " + mittelwert(2, 3, 5));
        int[] testarray = {2, 4, 5, 3, 10, 8, -1};
        System.out.println("isIN: " + isIn(testarray, 5));
        System.out.println("isIN: " + isIn(testarray, 9));
        System.out.println("Min: " + min(testarray));
        System.out.println("Max: " + max(testarray));
        double[] testarray2 = {2.0, 3.5, 0.1, 99.4, 20.0, 15.21};
        System.out.println("Geometrisches Mittel: "+geomMittel(testarray2));
        System.out.println("ack: "+ack(3,2));
    }

    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public static int max(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }

    public static double div(double a, double b) {
        if (b == 0.0) {
            return -0.0;
        } else {
            return a / b;
        }
    }

    public static double mittelwert(double a, double b, double c) {
        double result = (1.0 / 3.0);
        result = result * (a + b + c);
        return result;
    }

    public static boolean isIn(int[] array, int a) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                return true;
            }
        }
        return false;
    }

    public static int min(int[] array) {
        int result = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }

    public static int max(int[] array) {
        int result = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > result) {
                result = array[i];
            }
        }
        return result;
    }

    public static double geomMittel(double[] array) {
        double result = 1;
        for (int i = 0; i < array.length; i++) {
            result = result * array[i];
        }
        result = Math.pow(result, (1.0 / array.length));
        return result;
    }
    
    public static int ack(int a, int b){
        if(a==0){
            return b+1;
        }else if(b==0 && a>0){
            return ack(a-1,1);
        }else{
            return ack(a-1,ack(a,b-1));
        }
    }

}
