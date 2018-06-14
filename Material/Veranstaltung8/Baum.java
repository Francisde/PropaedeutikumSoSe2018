/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author lektor
 */
public class Baum {

    private int wert;
    private Baum linkerTeilbaum;
    private Baum rechterTeilbaum;

    public Baum(int wert) {
        this.wert = wert;
        linkerTeilbaum = null;
        rechterTeilbaum = null;
    }

    public void insert(int wert) {
        if (this.wert == wert) {
            return;
        } else if (this.wert < wert) {
            if (rechterTeilbaum == null) {
                rechterTeilbaum = new Baum(wert);
            } else {
                rechterTeilbaum.insert(wert);
            }
        } else {
            if (linkerTeilbaum == null) {
                linkerTeilbaum = new Baum(wert);
            } else {
                linkerTeilbaum.insert(wert);
            }
        }
    }

    public void insert(int[] werte) {
        for(int i=0;i<werte.length;i++){
            insert(werte[i]);
        }  
    }
    
    
    @Override
    public String toString(){
        String result="";
        if(linkerTeilbaum==null&&rechterTeilbaum==null){
            return result+wert;
        }
        if(linkerTeilbaum==null){
            result=result+"( ";
        }else{
            result=result+"("+linkerTeilbaum.toString();
        }
        result=result+","+wert+",";
        if(rechterTeilbaum==null){
            result=result+" )";
        }else{
            result= result+rechterTeilbaum.toString()+")";
        }
        
        return result;
    }

}
