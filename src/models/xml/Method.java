/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.xml;

import java.util.HashMap;
import models.CrossoverMethod;
import models.PunishFitness;
import models.RepairFitness;
import models.SelectionMethod;
import org.simpleframework.xml.*;
/**
 *
 * @author arturhebda
 */

@Root
class Method {
    @Attribute
    private String selection;
    
    @Attribute
    private String crossover;
    
    @Attribute(required=false)
    private String penalty;
    
    @Attribute(required=false)
    private String repair;
    
    public String getSelection() {
        return selection;
    }
    
    public String getCrossover() {
        return crossover;
    }
    
    public String getPenalty() {
        return penalty;
    }
    
    public String getRepair() {
        return repair;
    }

    public void setSelection(SelectionMethod selection) {
        this.selection = selection.toXMLName();
    }
    
    public void setCrossover(CrossoverMethod crossover) {
        this.crossover = crossover.toXMLName();
    }
    
    public void setPenalty(PunishFitness penalty) {
        if (penalty != null)
            this.penalty = penalty.toXMLName();
    }

    public void setRepair(RepairFitness repair) {
        if (repair != null)
            this.repair = repair.toXMLName();
    }
}
