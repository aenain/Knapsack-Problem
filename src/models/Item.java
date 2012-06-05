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

    public Item(String weight, String value) {
        this.weigth = Integer.parseInt(weight);
        this.value = Integer.parseInt(value);
    } 
    
    // pobranie wartosci
    
    public int getWeigth(){
        return weigth;
    }
    
    public int getValue(){
        return value;
    }
    
    public models.xml.Item toXML() {
        return new models.xml.Item(this);
    }
}
