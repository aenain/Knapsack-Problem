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
import javax.swing.JSpinner;
import models.CrossoverMethod;
import models.Evolution;
import models.GeneticOperator;
import models.LinearPunishFitness;
import models.SquarePunishFitness;
import models.PunishFitness;
import models.RandModuloRepairFitness;
import models.FromBeginRepairFitness;
import models.RepairFitness;
import models.RouletteSelection;
import models.RankingSelection;
import models.SelectionMethod;
import models.SinglePointCrossover;
import models.DoublePointCrossover;
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
    private JSpinner knapsackCapacity;
    private JSpinner populationSize, generationsLimit, mutationRate, elitismRate, crossoverRate;
    private JComboBox crossoverMethod, repairOrPenaltyMethod, selectionMethod;
    private DefaultComboBoxModel repairOrPenaltyModel, selectionModel, crossoverModel;
    
    public ParametersController(JComponent[] components) {
        knapsackCapacity = (JSpinner) components[0];
        populationSize = (JSpinner) components[1];
        generationsLimit = (JSpinner) components[2];
        mutationRate = (JSpinner) components[3];
        elitismRate = (JSpinner) components[4];
        crossoverRate = (JSpinner) components[5];
        crossoverMethod = (JComboBox) components[6];
        repairOrPenaltyMethod = (JComboBox) components[7];
        selectionMethod = (JComboBox) components[8];

        initComboBoxesWithGeneticOperators();
    }

    // tu należy dodać nowe operatory jak się pojawią, reszta zrobi się automagicznie!
    public final void initComboBoxesWithGeneticOperators() {
        repairOrPenaltyModel = new DefaultComboBoxModel(new GeneticOperator[] {
            new RandModuloRepairFitness(), new FromBeginRepairFitness(), new LinearPunishFitness(), new SquarePunishFitness()
        });
        selectionModel = new DefaultComboBoxModel(new SelectionMethod[] {
            new RouletteSelection(), new RankingSelection()
        });
        crossoverModel = new DefaultComboBoxModel(new CrossoverMethod[] {
            new SinglePointCrossover(), new DoublePointCrossover()
        });

        repairOrPenaltyMethod.setModel(repairOrPenaltyModel);
        selectionMethod.setModel(selectionModel);
        crossoverMethod.setModel(crossoverModel);
    }

    public int getKnapsackCapacity() {
        return (Integer) knapsackCapacity.getValue();
    }
    
    public void setKnapsackCapacity(int capacity) {
        knapsackCapacity.setValue(capacity);
    }
    
    public int getPopulationSize() {
        return (Integer) populationSize.getValue();
    }
    
    public void setPopulationSize(Integer size) {
        populationSize.setValue(size);
    }
    
    public int getGenerationsLimit() {
        return (Integer) generationsLimit.getValue();
    }
    
    public void setGenerationsLimit(Integer limit) {
        generationsLimit.setValue(limit);
    }
    
    public double getMutationRate() {
        return (Double) mutationRate.getValue();
    }
    
    public void setMutationRate(Double rate) {
        mutationRate.setValue(rate);
    }
    
    public double getElitismRate() {
        return (Double) elitismRate.getValue();
    }
    
    public void setElitismRate(Double rate) {
        elitismRate.setValue(rate);
    }
    
    public double getCrossoverRate() {
        return (Double) crossoverRate.getValue();
    }
    
    public void setCrossoverRate(Double rate) {
        crossoverRate.setValue(rate);
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
