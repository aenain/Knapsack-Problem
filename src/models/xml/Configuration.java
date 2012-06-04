/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.xml;

import java.util.List;
import org.simpleframework.xml.*;
/**
 *
 * @author arturhebda
 * @doc http://simple.sourceforge.net/
 * @usage
        Serializer serializer = new Persister();
        File source = new File("configuration.xml");
        models.xml.Configuration configuration = serializer.read(models.xml.Configuration.class, source);
        System.out.println(configuration.getItemList().size());
 */

@Root(name="knapsackProblem")
public class Configuration {
    @ElementList
    private List<Item> items;

    @Path("settings/knapsack")
    @Attribute(name="capacity")
    private Integer knapsackCapacity;

    @Path("settings/genetic/population")
    @Attribute(name="size")
    private Integer populationSize;

    @Path("settings/genetic/generation")
    @Attribute(name="limit")
    private Integer generationLimit;
    
    @Path("settings/genetic")
    @Element
    private Rate rate;
    
    @Path("settings/genetic")
    @Element
    private Method method;
    
    public List<Item> getItems() {
        return items;
    }
    
    public Integer getKnapsackCapacity() {
        return knapsackCapacity;
    }
    
    public Integer getPopulationSize() {
        return populationSize;
    }
    
    public Integer getGenerationLimit() {
        return generationLimit;
    }
    
    public Double getCrossoverRate() {
        return rate.getCrossover();
    }
    
    public Double getElitismRate() {
        return rate.getElitism();
    }
    
    public Double getMutationRate() {
        return rate.getMutation();
    }
    
    public String getSelectionMethod() {
        return method.getSelection();
    }
    
    public String getCrossoverMethod() {
        return method.getCrossover();
    }
    
    public String getPenaltyMethod() {
        return method.getPenalty();
    }
    
    public String getRepairMethod() {
        return method.getRepair();
    }
    
    public List<Item> getItemList() {
        return items;
    }
}
