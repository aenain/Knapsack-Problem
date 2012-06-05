/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author KaMyLuS
 */
public interface RepairFitness extends GeneticOperator {
    public void evaluate(Genome gen, int knapCapac, Item subj[]); 
}
