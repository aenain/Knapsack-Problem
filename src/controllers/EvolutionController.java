/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.io.File;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import models.*;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import views.*;

/**
 *
 * @author arturhebda
 */
public class EvolutionController extends BaseController implements EvolutionListener {
    private int knapsackCapacity;
    private Evolution evolution;
    private DefaultListModel itemListModel;
    private JLabel lastPopulationBestResultSummary, bestResultSummary;
    private JButton evolutionSteeringButton, evolutionDetailsButton;
    private XYSeries minSeries, averageSeries, maxSeries;
    private Thread evolutionThread;
    private EvolutionSummary summary;
    
    // components with parameters
    private ParametersController parametersController;

    public EvolutionController(DefaultListModel itemListModel, JLabel lastPopulationBestResultSummary, JLabel bestResultSummary, JButton evolutionSteeringButton, JButton evolutionDetailsButton, XYSeriesCollection seriesCollection) {
        this.itemListModel = itemListModel;
        this.lastPopulationBestResultSummary = lastPopulationBestResultSummary;
        this.bestResultSummary = bestResultSummary;
        this.evolutionSteeringButton = evolutionSteeringButton;
        this.evolutionDetailsButton = evolutionDetailsButton;
        minSeries = seriesCollection.getSeries(0);
        averageSeries = seriesCollection.getSeries(1);
        maxSeries = seriesCollection.getSeries(2);
        evolutionThread = null;
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

    public boolean hasDynamicAlgorithmResult() {
        // TODO! sprawdzanie, czy został odpalony dla tych parametrów co ewolucja
        // na pewno będzie ustawiany false w startSimulation, a true po kliku w przycisk
        // startujący na buttonie w Details
        return false;
    }

    public void startSimulation() {
        minSeries.clear();
        averageSeries.clear();
        maxSeries.clear();

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

    // comonents - {dynamicAlgorithmResult, algorithmTabs}
    public void startDynamicAlgorithm(JComponent[] components) {
        JLabel dynamicAlgorithmResult = (JLabel) components[0];
        JTabbedPane algorithmTabs = (JTabbedPane) components[1];
        EvolutionDetails.dynamicAlgorithmItemsModel.clear();

        // TODO! tu się mieli ten algorytm, następnie jest aktualizowany model listy
        // i jest podawany najlepszy rezultat

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
}
