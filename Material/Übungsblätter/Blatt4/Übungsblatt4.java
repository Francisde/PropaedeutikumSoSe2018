/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package übungsblatt4;

/**
 *
 * @author martin
 */
public class Übungsblatt4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(tenToTwo(25));
        System.out.println(twoToTen(11001));
        System.out.println(twoToTen2(11001));
    }
    
    public static String tenToTwo(int a){
        String result="";
        while(a!=0){
            if(a%2==1){
                result="1"+result;
            }else{
                result="0"+result;
            }
            a=a/2;
        }
        
        return result;
    }
    
    public static int twoToTen(int a){
        int result=0;
        int currentNumber;
        int counter=0;
        while(a!=0){
            currentNumber=a%10;
            result=(int) (result+(currentNumber*Math.pow(2, counter)));
            a=a/10;
            counter++;
        }
        return result;
    }
    
    // Method twoToTen without explicite typecast
    public static int twoToTen2(int a){
        int result=0;
        int currentNumber;
        int counter=0;
        
        while(a!=0){
            currentNumber=a%10;
            int twoPower=1;
            for(int i=0;i<counter;i++){
                twoPower=twoPower*2;
            }
            result=result+(currentNumber*twoPower);
            a=a/10;
            counter++;
        }
        return result;
    }
    
}
