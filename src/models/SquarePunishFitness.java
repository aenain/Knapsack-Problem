/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author KaMyLuS
 */
public class SquarePunishFitness implements PunishFitness{
    @Override
    public double evaluate(int value, int weigth, int capacity, double ro){
        if(weigth <= capacity) return value;
        return value - (ro*(weigth-capacity))*(ro*(weigth-capacity));
    }

    @Override
    public String toXMLName() {
        return "square";
    }

    @Override
    public String toString() {
        return "Square Punish";
    }
}
