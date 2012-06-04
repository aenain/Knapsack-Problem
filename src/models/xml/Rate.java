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
    
    public double getCrossover() {
        return crossover;
    }
    
    public double getMutation() {
        return mutation;
    }
}
