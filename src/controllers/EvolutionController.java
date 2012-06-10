/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.io.File;
import java.util.Iterator;
import javax.swing.*;
import models.*;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import views.EvolutionDetails;
import views.ItemHelper;

/**
 *
 * @author arturhebda
 */
public class EvolutionController extends BaseController implements EvolutionListener, DynamicAlgorithmListener {
    private int knapsackCapacity;
    private Evolution evolution;
    private DefaultListModel itemListModel;
    private JLabel lastPopulationBestResultSummary, bestResultSummary;
    private JButton evolutionSteeringButton, evolutionDetailsButton;
    private XYSeries minSeries, averageSeries, maxSeries;
    private Thread evolutionThread, dynamicAlgorithmThread;
    private EvolutionSummary summary;
    private DynamicsKnapsackProblem dynamicAlgorithm;
    private boolean dynamicAlgorithmComputed;
    private EvolutionDetails details;
    private JFreeChart chart;
    
    // components with parameters
    private ParametersController parametersController;

    public EvolutionController(DefaultListModel itemListModel, JLabel lastPopulationBestResultSummary, JLabel bestResultSummary, JButton evolutionSteeringButton, JButton evolutionDetailsButton, XYSeriesCollection seriesCollection, JFreeChart chart) {
        this.itemListModel = itemListModel;
        this.lastPopulationBestResultSummary = lastPopulationBestResultSummary;
        this.bestResultSummary = bestResultSummary;
        this.evolutionSteeringButton = evolutionSteeringButton;
        this.evolutionDetailsButton = evolutionDetailsButton;
        minSeries = seriesCollection.getSeries(0);
        averageSeries = seriesCollection.getSeries(1);
        maxSeries = seriesCollection.getSeries(2);
        evolutionThread = null;
        dynamicAlgorithm = null;
        dynamicAlgorithmComputed = false;
        this.chart = chart;
    }

    public void setEvolutionDetails(EvolutionDetails details) {
        this.details = details;

        if (details != null)
            details.setChart(chart);
    }

    public void setParameterComponents(JComponent[] components) {
        parametersController = new ParametersController(components);
    }

    public void gatherParametersAndStartSimulation() {
        int itemCount = itemListModel.getSize();
        models.Item[] items = new models.Item[itemCount];
        
        for (int i = 0; i < itemCount; i++) {
            String[] values = ItemHelper.getValues((String) itemListModel.get(i));
            items[i] = new models.Item(values[1], values[0]); // w kontrolerach i widokach najpierw jest value, potem weight; w modelach odwrotnie
        }

        stopSimulation();

        evolution = parametersController.createEvolution(items);
        knapsackCapacity = parametersController.getKnapsackCapacity();
        evolution.addListener(this);
        
        startSimulation();
    }

    public void loadConfig(File source) throws Exception {
        parametersController.loadConfig(source);
    }

    public void saveConfig(File destination) throws Exception {
        parametersController.saveConfig(destination);
    }

    // sprawdzanie, czy został odpalony dla tych parametrów co ewolucja;
    // na pewno będzie ustawiany false w startSimulation, a true po kliku w przycisk
    // startujący na buttonie w Details
    public boolean hasDynamicAlgorithmResult() {
        return dynamicAlgorithmComputed;
    }

    public void startSimulation() {
        minSeries.clear();
        averageSeries.clear();
        maxSeries.clear();

        dynamicAlgorithm = null;
        dynamicAlgorithmComputed = false;

        evolutionThread = new Thread(evolution);
        evolutionThread.start();

        evolutionSteeringButton.setEnabled(true);
        evolutionDetailsButton.setEnabled(false);
    }
    
    public void pauseSimulation() {
        evolution.pause();
        evolutionDetailsButton.setEnabled(true);
    }
    
    public void resumeSimulation() {
        evolution.resume();
        evolutionDetailsButton.setEnabled(false);
    }

    public void stopSimulation() {
        if (evolution != null)
            evolution.pause();

        if (evolutionThread != null)
            evolutionThread.interrupt();

        evolutionDetailsButton.setEnabled(true);
    }

    @Override
    public void updateReceived(EvolutionSummary summary) {
        this.summary = summary;
        Number iteration = summary.getIteration();

        minSeries.add(iteration, summary.getFitness("min"));
        averageSeries.add(iteration, summary.getFitness("average"));
        maxSeries.add(iteration, summary.getFitness("max"));
        
        // best results
        Genome bestPopulationGenome = summary.getBestPopulationGenome();
        lastPopulationBestResultSummary.setText(ItemHelper.toBestResultLabel(bestPopulationGenome.getValue(), bestPopulationGenome.getWeigth(), knapsackCapacity));

        Genome bestGenome = summary.getBestGenome();
        bestResultSummary.setText(ItemHelper.toBestResultLabel(bestGenome.getValue(), bestGenome.getWeigth(), knapsackCapacity));

        if (summary.hasFinished()) {
            evolutionSteeringButton.setEnabled(false);
            evolutionDetailsButton.setEnabled(true);
        }
    }

    @Override
    public void computingFinished(DynamicsKnapsackProblem algorithm) {
        dynamicAlgorithm = algorithm;
        dynamicAlgorithmComputed = true;

        if (details != null)
            details.populateDynamicAlgorithmResults();
    }

    public void startDynamicAlgorithm() {
        dynamicAlgorithm = new DynamicsKnapsackProblem(evolution.getItems(), knapsackCapacity);
        dynamicAlgorithm.addListener(this);

        dynamicAlgorithmComputed = false;
        dynamicAlgorithmThread = new Thread(dynamicAlgorithm);
        dynamicAlgorithmThread.start();
    }

    public void stopDynamicAlgorithm() {
        dynamicAlgorithmThread.interrupt();
        dynamicAlgorithmComputed = false;
    }

    // comonents - {dynamicAlgorithmResult, algorithmTabs}
    public void populateDynamicAlgorithmResults(JComponent[] components) {
        JLabel dynamicAlgorithmResult = (JLabel) components[0];
        JTabbedPane algorithmTabs = (JTabbedPane) components[1];

        EvolutionDetails.dynamicAlgorithmItemsModel.clear();

        for (Item item: dynamicAlgorithm.getTakenItems())
            EvolutionDetails.dynamicAlgorithmItemsModel.addElement(ItemHelper.toLabel(item));

        dynamicAlgorithmResult.setText(ItemHelper.toBestResultLabel(dynamicAlgorithm.getValue(), dynamicAlgorithm.getWeight(), knapsackCapacity));
        dynamicAlgorithmResult.setVisible(true);
        algorithmTabs.setEnabled(true);
    }

    public void populateGeneticAlgorithmResults(JLabel bestGeneticAlgorithmResult) {
        Genome bestGenome = summary.getBestGenome();
        bestGeneticAlgorithmResult.setText(ItemHelper.toBestResultLabel(bestGenome.getValue(), bestGenome.getWeigth(), knapsackCapacity));

        EvolutionDetails.geneticAlgorithmItemsModel.clear();

        Iterator<models.Item> it = bestGenome.getTakenItems().iterator();
        while (it.hasNext())
            EvolutionDetails.geneticAlgorithmItemsModel.addElement(ItemHelper.toLabel(it.next()));
    }
    
    public Evolution getEvolution() {
        return evolution;
    }
    
    public DynamicsKnapsackProblem getDynamicAlgorithm() {
        return dynamicAlgorithm;
    }
    
    public ParametersController getParametersController() {
        return parametersController;
    }
}
