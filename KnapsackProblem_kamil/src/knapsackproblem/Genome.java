/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

import java.util.*;
/**
 *
 * @author KaMyLuS
 */
public class Genome {
    
    boolean chromosome[]; // chromosom, 1 na i-tej pozycji -> bierzemy dany przedmiot
    int length; // dlugosc chromosomu
    int adaptation; // wartosc funkcji dopasowania dla danego chromosomu
    int value; // laczna wartosc przedmiotow w chromosomie
    int weigth; // laczna waga przedmiotow w chromosomie
    
    public Genome(int len){
        length = len;
        chromosome = new boolean[len];
        adaptation = 0;
    }
    
    // generowanie losowego chromosomu
    void genRandomChrom(){
        Random rand = new Random();
        for(int i = 0; i < length; i++)
            chromosome[i] = rand.nextBoolean();        
    }
    
    // ustawianie roznych wartosci
    
    void setValue(int v){
        value = v;
    }
    
    void setWeigth(int w){
        weigth = w;
    }
    
    void setAdaptation(int a){
        adaptation = a;
    }
    // -----------------
    
    // odczyt wartosci
    
    int getLength(){
        return length;
    }
    
    int getAdaptation(){
        return adaptation;
    }
    
    int getValue(){
        return value;
    }
    
    int getWeigth(){
        return weigth;
    }
    
    boolean isSubject(int i){
        return chromosome[i];
    }
}
