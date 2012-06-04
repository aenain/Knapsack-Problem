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
}
