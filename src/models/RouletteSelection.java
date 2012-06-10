/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Random;

/**
 *
 * @author KaMyLuS
 */
public class RouletteSelection implements SelectionMethod {
    @Override
    public void select(Population source, Population dest, int populCount, int selectCount, int selectFrom, boolean sorted){
        // trzeba zapewnic, zeby przystosowanie bylo dodatnie
        double minn = 0, sum = 0, distribSum = 0;
        for(int i = 0; i < populCount; i++){
            minn = java.lang.Math.min(source.chromosomes[i].getAdaptation(), minn);
            sum += source.chromosomes[i].getAdaptation();
        }
            
        double shift = java.lang.Math.max(0, -minn);
        sum += shift*populCount;
        
        // liczymy prawdopodobienstwa i dystrybuanty
        double probability[] = new double[populCount];
        double distribution[] = new double[populCount];
        for(int i = 0; i < populCount; i++){
            probability[i] = (source.chromosomes[i].getAdaptation()+shift)/sum;
            distribSum += (source.chromosomes[i].getAdaptation()+shift)/sum; 
            distribution[i] = distribSum;
        }
        
        // krecimy ruletka
        Random rand = new Random();
        int ind = selectFrom;
        for(int i = 0; i < selectCount; i++){
            int toSelect = -1;
            double r = rand.nextDouble();
            
            if(r < distribution[0]) {
                toSelect = 0;
            } else {
                int index = java.util.Arrays.binarySearch(distribution, r);
                if(index > 0) {
                    toSelect = index;
                } else {
                    toSelect = -(index+1);
                }
            }
            //toSelect += selectFrom;
            
            dest.chromosomes[ind++] = new Genome(source.chromosomes[toSelect]);
        }
    }

    @Override
    public String toString() {
        return "Roulette";
    }

    @Override
    public String toXMLName() {
        return "roulette";
    }
}
