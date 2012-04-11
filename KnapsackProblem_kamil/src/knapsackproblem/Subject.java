/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

/**
 *
 * @author KaMyLuS
 */
public class Subject {
    int weigth; 
    int value;
    
    public Subject(int w, int v){
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
