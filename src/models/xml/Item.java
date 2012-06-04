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
public class Item {
    @Attribute
    private Integer value;
    
    @Attribute
    private Integer weight;
    
    public Integer getValue() {
        return value;
    }
    
    public Integer getWeight() {
        return weight;
    }
}
