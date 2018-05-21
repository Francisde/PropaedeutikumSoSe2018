/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_search;

/**
 *
 * @author martin
 */
public class Binary_search {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array= {2,3,4,5,6,7,8,9,10};
        
        System.out.println(binarySearch(array, 2
                , 0,array.length-1));
    }
    
    public static int binarySearch(int[] array, int gesuchteZahl, int linkerIndex, int rechterIndex){
        int index=rechterIndex-((rechterIndex-linkerIndex)/2);
        //System.out.println(index);
        if(linkerIndex>rechterIndex){
            //System.out.println(linkerIndex+"  "+rechterIndex);
            return -1;
        }
        if(array[index]==gesuchteZahl){
            
            return index;
        }else if(array[index]>gesuchteZahl){
            return binarySearch(array, gesuchteZahl, linkerIndex, index-1);
        }else{
            return binarySearch(array, gesuchteZahl, index+1, rechterIndex);
        }
        //return -1;
    }
    
}
