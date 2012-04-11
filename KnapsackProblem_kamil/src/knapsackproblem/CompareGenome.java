/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;
import java.util.Comparator;
/**
 *
 * @author KaMyLuS
 */
public class CompareGenome implements Comparator<Genome>{
    boolean isZero(double x){
        return java.lang.Math.abs(x) < 10e-7;
    }
    @Override
    public int compare(Genome a, Genome b){
        if(b == null) return -1;
        
        if(isZero(a.getAdaptation() - b.getAdaptation())){
            if(a.getValue() == b.getValue()){
                if(a.getWeigth() > b.getWeigth()) return -1;
                else if(a.getWeigth() < b.getWeigth()) return 1;
                else return 0;
            }
            else if(a.getValue() > b.getValue()) return -1;
            else return 1;
        }
        else if(a.getAdaptation() > b.getAdaptation()) return -1;
        else return 1;
    }
}
