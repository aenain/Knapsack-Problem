/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author arturhebda
 */
public class EvolutionSummary {
    private Number minPopulationFitness, averagePopulationFitness, maxPopulationFitness, iteration;
    private Genome bestPopulationGenome, bestGenome;
    private Evolution evolution;
    
    public EvolutionSummary(Evolution evolution) {
        this.evolution = evolution;
    }
    
    // type is one of "min", "average", "max"
    public Number getFitness(String type) {
        if (type.equals("min"))
            return minPopulationFitness;
        else if (type.equals("average"))
            return averagePopulationFitness;
        else if (type.equals("max"))
            return maxPopulationFitness;
        else
            return 0;
    }
    
    public Genome getBestPopulationGenome() {
        return bestPopulationGenome;
    }
    
    public Genome getBestGenome() {
        return bestGenome;
    }
    
    public Number getIteration() {
        return iteration;
    }
    
    public void update(int iteration) {
        this.iteration = iteration;
        Population population = evolution.getPrimaryPopulation();
        
        minPopulationFitness = population.getWorst();
        averagePopulationFitness = population.getAver();
        maxPopulationFitness = population.getBest();
        
        bestPopulationGenome = evolution.getBestGen();
        bestGenome = evolution.getBestGenomeEver();
    }
}
