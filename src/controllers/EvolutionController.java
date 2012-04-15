/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.util.Hashtable;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import models.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import views.*;

/**
 *
 * @author arturhebda
 */
public class EvolutionController extends BaseController implements EvolutionListener {
    private Evolution evolution;
    private DefaultListModel itemListModel;
    private int knapsackCapacity;
    private JLabel lastPopulationBestResultSummary, bestResultSummary;
    private XYSeries minSeries, averageSeries, maxSeries;
    
    public EvolutionController(DefaultListModel itemListModel, JLabel lastPopulationBestResultSummary, JLabel bestResultSummary, XYSeriesCollection seriesCollection) {
        evolution = null;
        this.itemListModel = itemListModel;
        this.lastPopulationBestResultSummary = lastPopulationBestResultSummary;
        this.bestResultSummary = bestResultSummary;
        minSeries = seriesCollection.getSeries(0);
        averageSeries = seriesCollection.getSeries(1);
        maxSeries = seriesCollection.getSeries(2);
    }

    /** @param components - [maximumWeightSlider, populationSize, maxGenerations, mutationRate, elitismRate, crossoverRate, repairOrPenaltyMethod, selectionMethod] **/
    public void gatherParametersAndStartSimulation(JComponent[] components) {
        // collect params
        this.knapsackCapacity = ((JSlider) components[0]).getValue();
        int populationSize = Integer.parseInt(((JTextField) components[1]).getText());
        int maxGenerations = Integer.parseInt(((JTextField) components[2]).getText());
        double mutationRate = Double.parseDouble(((JTextField) components[3]).getText());
        double elitismRate = Double.parseDouble(((JTextField) components[4]).getText());
        double crossoverRate = Double.parseDouble(((JTextField) components[5]).getText());

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
        evolution.addListener(this);

        evolution.init();
        evolution.evolve(maxGenerations);
    }

    @Override
    public void updateReceived(Hashtable<String, Number> hash) {
        Number iteration = hash.get("iteration");

        minSeries.add(iteration, hash.get("minPopulationFitness"));
        averageSeries.add(iteration, hash.get("averagePopulationFitness"));
        maxSeries.add(iteration, hash.get("maxPopulationFitness"));
        
        // best results
        lastPopulationBestResultSummary.setText(ItemHelper.toBestResultLabel(hash.get("bestPopulationGenomeValue"), hash.get("bestPopulationGenomeWeight"), knapsackCapacity));
        bestResultSummary.setText(ItemHelper.toBestResultLabel(hash.get("bestGenomeValue"), hash.get("bestGenomeWeight"), knapsackCapacity));
    }
}
