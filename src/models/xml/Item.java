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
    @Attribute(name="value")
    private Integer value;
    
    @Attribute(name="weight")
    private Integer weight;
    
    public Integer getValue() {
        return value;
    }
    
    public Integer getWeight() {
        return weight;
    }

    public Item(@Attribute(name="value") Integer value, @Attribute(name="weight") Integer weight) {
        this.value = value;
        this.weight = weight;
    }

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public Item(models.Item item) {
        value = item.getValue();
        weight = item.getWeigth();
    }
}
