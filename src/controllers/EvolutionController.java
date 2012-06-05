/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
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
    private JButton evolutionSteeringButton;
    private XYSeries minSeries, averageSeries, maxSeries;
    private Thread evolutionThread;
    
    // components with parameters
    private ParametersController parametersController;

    public EvolutionController(DefaultListModel itemListModel, JLabel lastPopulationBestResultSummary, JLabel bestResultSummary, JButton evolutionSteeringButton, XYSeriesCollection seriesCollection) {
        this.itemListModel = itemListModel;
        this.lastPopulationBestResultSummary = lastPopulationBestResultSummary;
        this.bestResultSummary = bestResultSummary;
        this.evolutionSteeringButton = evolutionSteeringButton;
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

    public void startSimulation() {
        minSeries.clear();
        averageSeries.clear();
        maxSeries.clear();

        evolutionThread = new Thread(evolution);
        evolutionThread.start();

        evolutionSteeringButton.setEnabled(true);
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

        if (summary.hasFinished()) {
            evolutionSteeringButton.setEnabled(false);
        }
    }
}
