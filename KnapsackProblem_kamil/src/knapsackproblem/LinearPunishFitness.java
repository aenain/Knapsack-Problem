/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

/**
 *
 * @author KaMyLuS
 */
public class LinearPunishFitness implements PunishFitness{
    @Override
    public double evaluate(int value, int weigth, int capacity, double ro){
        if(weigth <= capacity) return value;
        return value - ro*(weigth-capacity);
    }
}
