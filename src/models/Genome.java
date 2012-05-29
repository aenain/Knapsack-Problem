/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.lang.System.*;
import java.util.*;
/**
 *
 * @author KaMyLuS
 */
public class Genome {
    
    boolean chromosome[]; // chromosom, 1 na i-tej pozycji -> bierzemy dany przedmiot
    int length; // dlugosc chromosomu
    double adaptation; // wartosc funkcji dopasowania dla danego chromosomu
    int value; // laczna wartosc przedmiotow w chromosomie
    int weigth; // laczna waga przedmiotow w chromosomie
    private Population population;
    
    
    public Genome(Population population, int length) {
        this.population = population;
        this.length = length;
        chromosome = new boolean[length];
        adaptation = 0;
    }
    
    public Genome(Genome source){
        length = source.getLength();
        adaptation = source.getAdaptation();
        population = source.getPopulation();
        value = source.getValue();
        weigth = source.getWeigth();
        chromosome = new boolean[length];
        
        java.lang.System.arraycopy(source.chromosome, 0, chromosome, 0, length);
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
    
    void setAdaptation(double a){
        adaptation = a;
    }
    // -----------------
    
    // odczyt wartosci
    
    int getLength(){
        return length;
    }

    public Population getPopulation() {
        return population;
    }

    double getAdaptation(){
        return adaptation;
    }

    public int getValue(){
        return value;
    }
    
    public int getWeigth(){
        return weigth;
    }
    
    boolean hasItem(int i){
        return chromosome[i];
    }

    public ArrayList<Item> getTakenItems() {
        ArrayList<Item> takenItems = new ArrayList<Item>();
        Item[] allItems = population.getEvolution().getItems();

        for (int i = 0; i < allItems.length; i++)
            if (hasItem(i))
                takenItems.add(allItems[i]);

        return takenItems;
    }

    // -------------
    
    void mutate(double mutatFactor){
        Random rand = new Random();
        for(int i = 0; i < length; i++)
            if(rand.nextDouble() < mutatFactor)
                chromosome[i] = !chromosome[i];
    }
}
