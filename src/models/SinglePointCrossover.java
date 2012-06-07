/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.*;

/**
 *
 * @author KaMyLuS
 */

// krzyzowanie jednopunktowe
public class SinglePointCrossover implements CrossoverMethod {
    @Override
    public void crossover(Population population, int populCount, double crossFactor, int pointCount, int crossFrom){
        
        // jak mamy mniej niz 2 geny, to sobie nie pokrzyzujemy...
        if(population.getChromosomeLength() < 2) return;
        
        // wybieramy osobniki, ktore beda krzyzowane
        Vector<Integer> toCross = new Vector<Integer>();
        Random rand = new Random();
        for(int i = crossFrom; i < populCount; i++){
            double r = rand.nextDouble();
            if(r < crossFactor) toCross.add(i);
        }
        
        // gdy nie wszystkie osobniki beda mialy pare
        if(toCross.size()%2 == 1)
            toCross.remove(rand.nextInt(toCross.size()));
        
        // krzyzujemy
        while(toCross.size() > 0){
            int cross1 = rand.nextInt(toCross.size());
            toCross.remove(cross1);
            int cross2 = rand.nextInt(toCross.size());
            toCross.remove(cross2);
            
            int chromLen = population.getChromosomeLength();
            int crossPoint = rand.nextInt(chromLen-1);
            Genome gen1 = new Genome(population.chromosomes[cross1]);
            Genome gen2 = new Genome(population.chromosomes[cross2]);
            
            for(int i = crossPoint+1; i < chromLen; i++){
                population.chromosomes[cross1].chromosome[i] = gen2.chromosome[i];
                population.chromosomes[cross2].chromosome[i] = gen1.chromosome[i];
            }
        }
    }

    @Override
    public String toString() {
        return "Single Point";
    }

    @Override
    public String toXMLName() {
        return "single-point";
    }
}
