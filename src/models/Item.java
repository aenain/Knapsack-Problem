/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author KaMyLuS
 */
public class Item {
    int weigth; 
    int value;
    
    public Item(int w, int v){
        weigth = w;
        value = v;
    }
    
    // pobranie wartosci
    
    int getWeigth(){
        return weigth;
    }
    
    int getValue(){
        return value;
    }
    
    //-----------------
}
