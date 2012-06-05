/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.JTextField;
import models.CrossoverMethod;
import models.Evolution;
import models.GeneticOperator;
import models.LinearPunishFitness;
import models.PunishFitness;
import models.RandModuloRepairFitness;
import models.RepairFitness;
import models.RouletteSelection;
import models.SelectionMethod;
import models.SinglePointCrossover;
import models.xml.Configuration;
import models.xml.Loader;
import models.xml.Saver;
import views.ItemHelper;
import views.MainWindow;

/**
 *
 * @author arturhebda
 */
public class ParametersController {
    private JSlider knapsackCapacity;
    private JTextField populationSize, generationsLimit, mutationRate, elitismRate, crossoverRate;
    private JComboBox crossoverMethod, repairOrPenaltyMethod, selectionMethod;
    private DefaultComboBoxModel repairOrPenaltyModel, selectionModel, crossoverModel;
    
    public ParametersController(JComponent[] components) {
        knapsackCapacity = (JSlider) components[0];
        populationSize = (JTextField) components[1];
        generationsLimit = (JTextField) components[2];
        mutationRate = (JTextField) components[3];
        elitismRate = (JTextField) components[4];
        crossoverRate = (JTextField) components[5];
        crossoverMethod = (JComboBox) components[6];
        repairOrPenaltyMethod = (JComboBox) components[7];
        selectionMethod = (JComboBox) components[8];

        initComboBoxesWithGeneticOperators();
    }

    // tu należy dodać nowe operatory jak się pojawią, reszta zrobi się automagicznie!
    public final void initComboBoxesWithGeneticOperators() {
        repairOrPenaltyModel = new DefaultComboBoxModel(new GeneticOperator[] {
            new LinearPunishFitness(), new RandModuloRepairFitness()
        });
        selectionModel = new DefaultComboBoxModel(new SelectionMethod[] {
            new RouletteSelection()
        });
        crossoverModel = new DefaultComboBoxModel(new CrossoverMethod[] {
            new SinglePointCrossover()
        });

        repairOrPenaltyMethod.setModel(repairOrPenaltyModel);
        selectionMethod.setModel(selectionModel);
        crossoverMethod.setModel(crossoverModel);
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
        return (SelectionMethod) selectionModel.getSelectedItem();
    }

    public void setSelectionMethod(String methodXMLName) {
        GeneticOperator operator = findGeneticOperatorByName(selectionModel, methodXMLName);
        if (operator != null)
            selectionModel.setSelectedItem(operator);
    }
    
    public PunishFitness getPunishFitness() {
        GeneticOperator selectedOperator = (GeneticOperator) repairOrPenaltyModel.getSelectedItem();

        if (selectedOperator instanceof PunishFitness)
            return (PunishFitness) selectedOperator;
        else
            return null;
    }

    public void setPunishFitness(String methodXMLName) {
        GeneticOperator operator = findGeneticOperatorByName(repairOrPenaltyModel, methodXMLName);
        if (operator != null)
            repairOrPenaltyModel.setSelectedItem(operator);
    }
    
    public RepairFitness getRepairFitness() {
        GeneticOperator selectedOperator = (GeneticOperator) repairOrPenaltyModel.getSelectedItem();

        if (selectedOperator instanceof RepairFitness)
            return (RepairFitness) selectedOperator;
        else
            return null;
    }

    public void setRepairFitness(String methodXMLName) {
        GeneticOperator operator = findGeneticOperatorByName(repairOrPenaltyModel, methodXMLName);
        if (operator != null)
            repairOrPenaltyModel.setSelectedItem(operator);
    }
    
    public CrossoverMethod getCrossoverMethod() {
        return (CrossoverMethod) crossoverModel.getSelectedItem();
    }

    public void setCrossoverMethod(String methodXMLName) {
        CrossoverMethod operator = (CrossoverMethod) findGeneticOperatorByName(crossoverModel, methodXMLName);
        if (operator != null)
            crossoverModel.setSelectedItem(operator);
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

        setCrossoverMethod(config.getCrossoverMethod());
        setSelectionMethod(config.getSelectionMethod());
        setRepairFitness(config.getRepairMethod());
        setPunishFitness(config.getPenaltyMethod());

        Iterator<models.xml.Item> it = config.getItems().iterator();
        models.xml.Item item;
        
        MainWindow.model.clear();
        
        while (it.hasNext()) {
            item = it.next();
            MainWindow.model.addElement(ItemHelper.toLabel(item.getValue(), item.getWeight()));
        }
    }

    public void saveConfig(File destination) throws Exception {
        Configuration config = new Configuration();
        config.setKnapsackCapacity(getKnapsackCapacity());
        config.setPopulationSize(getPopulationSize());
        config.setGenerationLimit(getGenerationsLimit());
        config.setRates(getElitismRate(), getCrossoverRate(), getMutationRate());
        config.setMethods(getSelectionMethod(), getCrossoverMethod(), getPunishFitness(), getRepairFitness());
        config.setItemsByModel(MainWindow.model);

        Saver saver = new Saver();
        saver.save(config, destination);
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

    private GeneticOperator findGeneticOperatorByName(DefaultComboBoxModel model, String name) {
        GeneticOperator operator;
        
        for (int i = 0; i < model.getSize(); i++) {
            operator = (GeneticOperator) model.getElementAt(i);
            
            if (operator.toXMLName().equals(name) || operator.toString().equals(name))
                return operator;
        }

        return null;
    }
}
