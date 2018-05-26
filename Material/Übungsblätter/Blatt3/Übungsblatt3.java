/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package übungsblatt.pkg3;

/**
 *
 * @author martin
 */
public class Übungsblatt3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] testArray = {2, 4, 5, 3, 10, 8, -1};

        printArray(testArray);
        int[] revertArray = revertArray(testArray);
        printArray(revertArray);
        int[] testArray2 = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(monoton(testArray2));
    
        findPerfectNumbers();
        
//        printArray(testArray);
//        verdoppelArray(testArray);
//        printArray(testArray);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }

    public static int[] revertArray(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - i - 1];
        }
        return result;
    }

    public static char monoton(int[] array) {
        char result = 'S';
        int lastInt = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > lastInt && result != 'M' && result != 'N') {
                result = 'S';
                lastInt = array[i];
            } else if (array[i] >= lastInt && result != 'N') {
                result = 'M';
                lastInt = array[i];
            } else {
                return 'N';
            }
        }
        return result;
    }
    
    public static void findPerfectNumbers (){
        for(int i=2;i<100000;i++){
            int sum=1;
            for(int j=i-1;j>1;j--){
                if(i%j==0){
                    sum=sum+j;
                }
            }
            if(sum==i){
                System.out.println("Perfekte Zahl:"+i);
            }
        }
    }
    
    public static void verdoppelArray(int[] array){
        for(int i=0;i<array.length;i++){
            array[i]=array[i]*2;
        }
    }

}
