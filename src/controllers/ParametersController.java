/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.JTextField;
import models.CrossoverMethod;
import models.Evolution;
import models.LinearPunishFitness;
import models.PunishFitness;
import models.RandModuloRepairFitness;
import models.RepairFitness;
import models.RouletteSelection;
import models.SelectionMethod;
import models.SinglePointCrossover;
import models.xml.Configuration;
import models.xml.Loader;
import views.ItemHelper;
import views.MainWindow;

/**
 *
 * @author arturhebda
 */
public class ParametersController {
    private JSlider knapsackCapacity;
    private JTextField populationSize, generationsLimit, mutationRate, elitismRate, crossoverRate;
    
    public ParametersController(JComponent[] components) {
        knapsackCapacity = (JSlider) components[0];
        populationSize = (JTextField) components[1];
        generationsLimit = (JTextField) components[2];
        mutationRate = (JTextField) components[3];
        elitismRate = (JTextField) components[4];
        crossoverRate = (JTextField) components[5];
    }
    
    public int getKnapsackCapacity() {
        return knapsackCapacity.getValue();
    }
    
    public void setKnapsackCapacity(int capacity) {
        knapsackCapacity.setValue(capacity);
    }
    
    public int getPopulationSize() {
        return Integer.parseInt(populationSize.getText());
    }
    
    public void setPopulationSize(Integer size) {
        populationSize.setText(size.toString());
    }
    
    public int getGenerationsLimit() {
        return Integer.parseInt(generationsLimit.getText());
    }
    
    public void setGenerationsLimit(Integer limit) {
        generationsLimit.setText(limit.toString());
    }
    
    public double getMutationRate() {
        return Double.parseDouble(mutationRate.getText());
    }
    
    public void setMutationRate(Double rate) {
        mutationRate.setText(rate.toString());
    }
    
    public double getElitismRate() {
        return Double.parseDouble(elitismRate.getText());
    }
    
    public void setElitismRate(Double rate) {
        elitismRate.setText(rate.toString());
    }
    
    public double getCrossoverRate() {
        return Double.parseDouble(crossoverRate.getText());
    }
    
    public void setCrossoverRate(Double rate) {
        crossoverRate.setText(rate.toString());
    }
    
    public SelectionMethod getSelectionMethod() {
        // TODO! wybieranie na podstawie komboboksa
        return new RouletteSelection();
    }
    
    public PunishFitness getPunishFitness() {
        // TODO! wybieranie na podstawie komboboksa
        return new LinearPunishFitness();
    }
    
    public RepairFitness getRepairFitness() {
        // TODO! wybieranie na podstawie komboboksa
        return new RandModuloRepairFitness();
    }
    
    public CrossoverMethod getCrossoverMethod() {
        // TODO! wybieranie na podstawie komboboksa
        return new SinglePointCrossover();
    }

    public void loadConfig(File source) throws Exception {
        Loader loader = new Loader();
        Configuration config = loader.load(source);
        
        setKnapsackCapacity(config.getKnapsackCapacity());
        setPopulationSize(config.getPopulationSize());
        setGenerationsLimit(config.getGenerationLimit());
        
        setCrossoverRate(config.getCrossoverRate());
        setMutationRate(config.getMutationRate());
        setElitismRate(config.getElitismRate());
        
        // TODO! ustawianie metod wszystkich na podstawie xml-a
        
        Iterator<models.xml.Item> it = config.getItems().iterator();
        models.xml.Item item;
        
        MainWindow.model.clear();
        
        while (it.hasNext()) {
            item = it.next();
            MainWindow.model.addElement(ItemHelper.toLabel(item.getValue(), item.getWeight()));
        }
    }
    
    public Evolution createEvolution(models.Item[] items) {
        return new Evolution(   items,
                                items.length,
                                getPopulationSize(),
                                getGenerationsLimit(),
                                getKnapsackCapacity(),
                                true,
                                getElitismRate(),
                                getCrossoverRate(),
                                getMutationRate(),
                                getPunishFitness(),
                                getRepairFitness(),
                                getSelectionMethod(),
                                getCrossoverMethod());
    }
}
