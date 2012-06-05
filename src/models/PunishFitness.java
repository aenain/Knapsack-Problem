/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author KaMyLuS
 */
public interface PunishFitness extends GeneticOperator {
    public double evaluate(int value, int weigth, int capacity, double ro);   
}
