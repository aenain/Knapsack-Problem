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
public class FromBeginRepairFitness implements RepairFitness {
    @Override
    public void evaluate(Genome gen, int knapCapac, Item subj[]){
        int i = 0, weigth = gen.getWeigth(), value = gen.getValue();
        while(weigth > knapCapac){
            if(gen.hasItem(i)){
                gen.chromosome[i] = false;
                weigth -= subj[i].getWeigth();
                value -= subj[i].getValue();
            }
            i++;
        }
        gen.setValue(value);
        gen.setAdaptation(value);
        gen.setWeigth(weigth);
    }

    @Override
    public String toString() {
        return "From Begin-to-end Repair";
    }

    @Override
    public String toXMLName() {
        return "begin-end";
    }
}
