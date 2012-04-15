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
public class RandModuloRepairFitness implements RepairFitness {
    @Override
    public void evaluate(Genome gen, int knapCapac, Item subj[]){
        int i = 0, genLength = gen.getLength(), weigth = gen.getWeigth(), value = gen.getValue();
        Random rand = new Random();
        while(weigth > knapCapac){
            if(gen.isItem(i)){
                gen.chromosome[i] = false;
                weigth -= subj[i].getWeigth();
                value -= subj[i].getValue();
            }
            i = (i+rand.nextInt(10)+1)%genLength;
        }
        gen.setValue(value);
        gen.setAdaptation(value);
        gen.setWeigth(weigth);
    }
}
