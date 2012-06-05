/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.xml;

import org.simpleframework.xml.*;

/**
 *
 * @author arturhebda
 */

@Root
class Rate {
    @Attribute(required=false)
    private double elitism;
    
    @Attribute(required=false)
    private double crossover;
    
    @Attribute(required=false)
    private double mutation;
    
    public double getElitism() {
        return elitism;
    }

    public void setElitism(double elitism) {
        this.elitism = elitism;
    }
    
    public double getCrossover() {
        return crossover;
    }

    public void setCrossover(double crossover) {
        this.crossover = crossover;
    }
    
    public double getMutation() {
        return mutation;
    }

    public void setMutation(double mutation) {
        this.mutation = mutation;
    }
}
