/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Thread evolutionThread;
    
    public EvolutionController(DefaultListModel itemListModel, JLabel lastPopulationBestResultSummary, JLabel bestResultSummary, XYSeriesCollection seriesCollection) {
        this.itemListModel = itemListModel;
        this.lastPopulationBestResultSummary = lastPopulationBestResultSummary;
        this.bestResultSummary = bestResultSummary;
        minSeries = seriesCollection.getSeries(0);
        averageSeries = seriesCollection.getSeries(1);
        maxSeries = seriesCollection.getSeries(2);
        evolutionThread = null;
    }

    /** @param components - [maximumWeightSlider, populationSize, maxGenerations, mutationRate, elitismRate, crossoverRate, repairOrPenaltyMethod, selectionMethod] **/
    public void gatherParametersAndStartSimulation(JComponent[] components) {
        // collect params
        
        this.knapsackCapacity = ((JSlider) components[0]).getValue();
        int populationSize = Integer.parseInt(((JTextField) components[1]).getText());
        int generationsLimit = Integer.parseInt(((JTextField) components[2]).getText());
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

        stopSimulation();

        evolution = new Evolution(items, itemCount, populationSize, generationsLimit, knapsackCapacity, true, elitismRate, crossoverRate, mutationRate, punishFitness, repairFitness, selectionMethod, crossoverMethod);
        evolution.addListener(this);
        
        startSimulation();
    }

    public void startSimulation() {
        minSeries.clear();
        averageSeries.clear();
        maxSeries.clear();

        evolutionThread = new Thread(evolution);
        evolutionThread.start();
    }
    
    public void pauseSimulation() {
        evolution.pause();
    }
    
    public void resumeSimulation() {
        evolution.resume();
    }

    public void stopSimulation() {
        if (evolution != null)
            evolution.pause();

        if (evolutionThread != null)
            evolutionThread.interrupt();
    }

    @Override
    public void updateReceived(EvolutionSummary summary) {
        Number iteration = summary.getIteration();

        minSeries.add(iteration, summary.getFitness("min"));
        averageSeries.add(iteration, summary.getFitness("average"));
        maxSeries.add(iteration, summary.getFitness("max"));
        
        // best results
        Genome bestPopulationGenome = summary.getBestPopulationGenome();
        lastPopulationBestResultSummary.setText(ItemHelper.toBestResultLabel(bestPopulationGenome.getValue(), bestPopulationGenome.getWeigth(), knapsackCapacity));

        Genome bestGenome = summary.getBestGenome();
        bestResultSummary.setText(ItemHelper.toBestResultLabel(bestGenome.getValue(), bestGenome.getWeigth(), knapsackCapacity));
    }
}
