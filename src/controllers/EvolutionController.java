/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.JTextField;
import models.*;
import views.*;

/**
 *
 * @author arturhebda
 */
public class EvolutionController extends BaseController {
    private Evolution evolution;
    private DefaultListModel itemListModel;
    
    public EvolutionController(DefaultListModel itemListModel) {
        evolution = null;
        this.itemListModel = itemListModel;
    }

    /** @param components - [maximumWeightSlider, populationSize, mutationRate, elitismRate, crossoverRate, repairOrPenaltyMethod, selectionMethod] **/
    public void gatherParametersAndStartSimulation(JComponent[] components) {
        // collect params
        int knapsackCapacity = ((JSlider) components[0]).getValue();
        int populationSize = Integer.parseInt(((JTextField) components[1]).getText());
        double mutationRate = Double.parseDouble(((JTextField) components[2]).getText());
        double elitismRate = Double.parseDouble(((JTextField) components[3]).getText());
        double crossoverRate = Double.parseDouble(((JTextField) components[4]).getText());

        // TODO! wybieranie metod na podstawie wartości z komboboksów
        RouletteSelection selectionMethod = new RouletteSelection();
        LinearPunishFitness punishFitness = new LinearPunishFitness();
        RandModuloRepairFitness repairFitness = new RandModuloRepairFitness();
        SinglePointCrossover crossoverMethod = new SinglePointCrossover();

        int itemCount = itemListModel.getSize();
        Item[] items = new Item[itemCount];
        
        for (int i = 0; i < itemCount; i++) {
            String[] values = ItemHelper.getValues((String) itemListModel.get(i));
            items[i] = new Item(values[1], values[0]); // w kontrolerach i widokach najpierw jest value, potem weight; w modelach odwrotnie
        }
        
        evolution = new Evolution(items, itemCount, populationSize, knapsackCapacity, true, elitismRate, crossoverRate, mutationRate, punishFitness, repairFitness, selectionMethod, crossoverMethod);
        evolution.init();
    }
    
    public void updateGenerationInfo() {
        // add 3 points to chart
        // change info about 
    }
}
