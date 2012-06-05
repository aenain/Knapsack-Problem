/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import models.CrossoverMethod;
import models.PunishFitness;
import models.RepairFitness;
import models.SelectionMethod;
import org.simpleframework.xml.*;
import views.ItemHelper;
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

    public void setKnapsackCapacity(int knapsackCapacity) {
        this.knapsackCapacity = knapsackCapacity;
    }

    public Integer getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public Integer getGenerationLimit() {
        return generationLimit;
    }

    public void setGenerationLimit(int generationLimit) {
        this.generationLimit = generationLimit;
    }

    private void setRate(Rate rate) {
        this.rate = rate;
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

    private void setMethod(Method method) {
        this.method = method;
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

    public void setItems(models.Item[] items) {
        for (int i = 0; i < items.length; i++)
            this.items.add(items[i].toXML());
    }

    public void setItems(List<models.Item> items) {
        Iterator<models.Item> it = items.iterator();
        while (it.hasNext())
            this.items.add(it.next().toXML());
    }

    public void setItems(ArrayList<models.Item> items) {
        Iterator<models.Item> it = items.iterator();
        while (it.hasNext())
            this.items.add(it.next().toXML());
    }

    public void setItemsByModel(DefaultListModel model) {
        items = new LinkedList<models.xml.Item>();

        for (int i = 0; i < model.getSize(); i++)
            this.items.add(ItemHelper.toItem((String) model.elementAt(i)).toXML());
    }

    public void setRates(double elitism, double crossover, double mutation) {
        rate = new Rate();
        rate.setElitism(elitism);
        rate.setCrossover(crossover);
        rate.setMutation(mutation);
    }

    public void setMethods(SelectionMethod selection, CrossoverMethod crossover, PunishFitness penalty, RepairFitness repair) {
        method = new Method();
        method.setSelection(selection);
        method.setCrossover(crossover);
        method.setPenalty(penalty);
        method.setRepair(repair);
    }
}
