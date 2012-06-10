package views;

import controllers.*;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author arturhebda
 */
public class MainWindow extends JFrame {

    private void disposeEvolutionDetails() {
        if (evolutionDetails != null)
            evolutionDetails.dispose();
    }

    public void setEvolutionDetails(EvolutionDetails evolutionDetails) {
        disposeEvolutionDetails();
        this.evolutionDetails = evolutionDetails;
    }

    private class Graph {
        private static final String title = "Evolution Graph";
        private XYSeries minSeries = new XYSeries("Min");
        private XYSeries averageSeries = new XYSeries("Average");
        private XYSeries maxSeries = new XYSeries("Max");
        private XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        final ChartPanel chartPanel;

        public Graph() {
            chartPanel = createDemoPanel();
        }

        private ChartPanel createDemoPanel() {
            JFreeChart jfreechart = ChartFactory.createXYLineChart(
                title, "Generation", "Knapsack's Value", createSampleData(),
                PlotOrientation.VERTICAL, true, true, false);
            XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
            xyPlot.setDomainCrosshairVisible(true);
            xyPlot.setRangeCrosshairVisible(true);
            XYItemRenderer renderer = xyPlot.getRenderer();
            renderer.setSeriesPaint(0, Color.blue);
            NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
            domain.setVerticalTickLabels(true);
            domain.setAutoRange(true);
            return new ChartPanel(jfreechart);
        }

        private XYDataset createSampleData() {
            xySeriesCollection.addSeries(minSeries);
            xySeriesCollection.addSeries(averageSeries);
            xySeriesCollection.addSeries(maxSeries);
            return xySeriesCollection;
        }
    }

    static MainWindow myMainWindow;
    public static DefaultListModel model = new DefaultListModel();
    private EvolutionController controller;
    Graph graph = new Graph();    

    private MainWindow() {
        initComponents();
        myInitComponents();
        itemsList.setModel(model);
        controller = new EvolutionController(model, lastPopulationBestResultSummary, bestResultSummary, evolutionSteeringButton, detailsButton, graph.xySeriesCollection);

        JComponent[] components = {maximumWeight, populationSize, maxGenerations, mutationRate, elitismRate, crossoverRate, crossoverMethod, repairOrPenaltyMethod, selectionMethod};
        controller.setParameterComponents(components);

        jScrollPane2.getViewport().add(graph.chartPanel);
    }

    static int[] getSelected() {
        return itemsList.getSelectedIndices();
    }

    static void unSelect() {
        itemsList.clearSelection();
    }

    private void myInitComponents() {
        configFileChooser = new JFileChooser();
        filter = new views.XMLFileFilter();
        configFileChooser.addChoosableFileFilter(filter);
        configFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        configFileChooser.setCurrentDirectory(new java.io.File("."));

        saveConfigFileChooser = new JFileChooser();
        saveConfigFileChooser.addChoosableFileFilter(filter);
        saveConfigFileChooser.setCurrentDirectory(new java.io.File("."));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        itemsPanel = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        continueToStep2Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        addItemButton = new javax.swing.JButton();
        editItemButton = new javax.swing.JButton();
        removeItemButton = new javax.swing.JButton();
        generateItemsButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        removeAllItemsButton = new javax.swing.JButton();
        loadConfigButton = new javax.swing.JButton();
        maximumWeight = new javax.swing.JSpinner();
        settingsPanel = new javax.swing.JLayeredPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        repairOrPenaltyMethod = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        selectionMethod = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        crossoverMethod = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        populationSize = new javax.swing.JSpinner();
        maxGenerations = new javax.swing.JSpinner();
        elitismRate = new javax.swing.JSpinner();
        crossoverRate = new javax.swing.JSpinner();
        mutationRate = new javax.swing.JSpinner();
        backToStep1Button = new javax.swing.JButton();
        startSimulationButton = new javax.swing.JButton();
        saveConfigButton = new javax.swing.JButton();
        simulationPanel = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        evolutionSteeringButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bestResultSummary = new javax.swing.JLabel();
        lastPopulationBestResultSummary = new javax.swing.JLabel();
        detailsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("0-1 Knapsack Problem");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel1.setText("Knapsack's Maximum Weight");
        jLabel1.setBounds(90, 410, 340, 30);
        itemsPanel.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        continueToStep2Button.setText("Continue");
        continueToStep2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueToStep2ButtonActionPerformed(evt);
            }
        });
        continueToStep2Button.setBounds(610, 480, 101, 29);
        itemsPanel.add(continueToStep2Button, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane1.setViewportView(itemsList);

        jScrollPane1.setBounds(100, 50, 420, 310);
        itemsPanel.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel2.setText("Items");
        jLabel2.setBounds(90, 20, 37, 17);
        itemsPanel.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        addItemButton.setText("Add");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });
        addItemButton.setBounds(530, 50, 100, 29);
        itemsPanel.add(addItemButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        editItemButton.setText("Edit");
        editItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editItemButtonActionPerformed(evt);
            }
        });
        editItemButton.setBounds(530, 80, 100, 29);
        itemsPanel.add(editItemButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        removeItemButton.setText("Remove");
        removeItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemButtonActionPerformed(evt);
            }
        });
        removeItemButton.setBounds(530, 110, 100, 29);
        itemsPanel.add(removeItemButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        generateItemsButton.setText("Generate");
        generateItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateItemsButtonActionPerformed(evt);
            }
        });
        generateItemsButton.setBounds(530, 330, 100, 29);
        itemsPanel.add(generateItemsButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("  or...");
        jLabel3.setBounds(560, 240, 33, 16);
        itemsPanel.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        removeAllItemsButton.setText("Remove All");
        removeAllItemsButton.setToolTipText("");
        removeAllItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllItemsButtonActionPerformed(evt);
            }
        });
        removeAllItemsButton.setBounds(530, 140, 100, 29);
        itemsPanel.add(removeAllItemsButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        loadConfigButton.setText("Load Configuration");
        loadConfigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadConfigButtonActionPerformed(evt);
            }
        });
        loadConfigButton.setBounds(442, 480, 165, 29);
        itemsPanel.add(loadConfigButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        maximumWeight.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(50), Integer.valueOf(0), null, Integer.valueOf(1)));
        maximumWeight.setBounds(470, 410, 150, 28);
        itemsPanel.add(maximumWeight, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabs.addTab("Items", itemsPanel);

        jLabel7.setText("Generations Limit");
        jLabel7.setBounds(150, 40, 170, 30);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setText("Mutation Rate");
        jLabel8.setBounds(150, 300, 100, 16);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setText("Elitism Rate");
        jLabel9.setBounds(150, 110, 90, 16);
        jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setText("Crossover Rate");
        jLabel10.setBounds(150, 200, 120, 30);
        jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        repairOrPenaltyMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rand Modulo Repair" }));
        repairOrPenaltyMethod.setBounds(370, 320, 190, 27);
        jLayeredPane1.add(repairOrPenaltyMethod, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setText("Repair / Penalty Method");
        jLabel11.setBounds(150, 320, 170, 30);
        jLayeredPane1.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setText("Selection Method");
        jLabel12.setBounds(150, 130, 140, 30);
        jLayeredPane1.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        selectionMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Roulette" }));
        selectionMethod.setBounds(370, 130, 190, 30);
        jLayeredPane1.add(selectionMethod, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setText("Crossover Method");
        jLabel13.setBounds(150, 230, 130, 30);
        jLayeredPane1.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        crossoverMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single Point" }));
        crossoverMethod.setBounds(370, 230, 190, 27);
        jLayeredPane1.add(crossoverMethod, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel14.setText("Population Size");
        jLabel14.setBounds(150, 10, 170, 30);
        jLayeredPane1.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        populationSize.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(100), Integer.valueOf(1), null, Integer.valueOf(1)));
        populationSize.setBounds(380, 10, 170, 28);
        jLayeredPane1.add(populationSize, javax.swing.JLayeredPane.DEFAULT_LAYER);

        maxGenerations.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(250), Integer.valueOf(1), null, Integer.valueOf(1)));
        maxGenerations.setBounds(380, 40, 170, 28);
        jLayeredPane1.add(maxGenerations, javax.swing.JLayeredPane.DEFAULT_LAYER);

        elitismRate.setModel(new javax.swing.SpinnerNumberModel(0.2d, 0.0d, 1.0d, 0.01d));
        elitismRate.setBounds(380, 100, 170, 28);
        jLayeredPane1.add(elitismRate, javax.swing.JLayeredPane.DEFAULT_LAYER);

        crossoverRate.setModel(new javax.swing.SpinnerNumberModel(0.5d, 0.0d, 1.0d, 0.01d));
        crossoverRate.setBounds(380, 200, 170, 28);
        jLayeredPane1.add(crossoverRate, javax.swing.JLayeredPane.DEFAULT_LAYER);

        mutationRate.setModel(new javax.swing.SpinnerNumberModel(0.05d, 0.0d, 1.0d, 0.01d));
        mutationRate.setBounds(380, 290, 170, 28);
        jLayeredPane1.add(mutationRate, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane1.setBounds(20, 50, 680, 430);
        settingsPanel.add(jLayeredPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        backToStep1Button.setText("Back");
        backToStep1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToStep1ButtonActionPerformed(evt);
            }
        });
        backToStep1Button.setBounds(10, 480, 75, 29);
        settingsPanel.add(backToStep1Button, javax.swing.JLayeredPane.DEFAULT_LAYER);

        startSimulationButton.setText("Start");
        startSimulationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSimulationButtonActionPerformed(evt);
            }
        });
        startSimulationButton.setBounds(600, 480, 110, 29);
        settingsPanel.add(startSimulationButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        saveConfigButton.setText("Save");
        saveConfigButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveConfigButtonActionPerformed(evt);
            }
        });
        saveConfigButton.setBounds(530, 480, 75, 29);
        settingsPanel.add(saveConfigButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabs.addTab("Settings", settingsPanel);

        jScrollPane2.setBounds(10, 0, 700, 430);
        simulationPanel.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        evolutionSteeringButton.setText("Pause");
        evolutionSteeringButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evolutionSteeringButtonActionPerformed(evt);
            }
        });
        evolutionSteeringButton.setBounds(610, 480, 97, 29);
        simulationPanel.add(evolutionSteeringButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel4.setText("Best Results");
        jLabel4.setBounds(10, 430, 120, 30);
        simulationPanel.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Overall");
        jLabel5.setBounds(90, 490, 60, 20);
        simulationPanel.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("In Last Population");
        jLabel6.setBounds(20, 460, 120, 20);
        simulationPanel.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bestResultSummary.setBounds(170, 490, 300, 20);
        simulationPanel.add(bestResultSummary, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lastPopulationBestResultSummary.setBounds(170, 460, 300, 20);
        simulationPanel.add(lastPopulationBestResultSummary, javax.swing.JLayeredPane.DEFAULT_LAYER);

        detailsButton.setText("Details");
        detailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsButtonActionPerformed(evt);
            }
        });
        detailsButton.setBounds(510, 480, 97, 29);
        simulationPanel.add(detailsButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabs.addTab("Simulation", simulationPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(tabs, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(tabs, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continueToStep2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueToStep2ButtonActionPerformed
        tabs.setSelectedIndex(1);
    }//GEN-LAST:event_continueToStep2ButtonActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        AddItem.main(null);
    }//GEN-LAST:event_addItemButtonActionPerformed

    private void removeItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemButtonActionPerformed
        int[] selected = getSelected();
        
        for(int i = selected.length - 1; i >= 0; i--) {
            model.removeElementAt(selected[i]);
        }
    }//GEN-LAST:event_removeItemButtonActionPerformed

    private void editItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editItemButtonActionPerformed
        if(getSelected().length > 0)
            EditItem.main(null);
    }//GEN-LAST:event_editItemButtonActionPerformed

    private void generateItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateItemsButtonActionPerformed
        KnapsackGenerator.main(null);
    }//GEN-LAST:event_generateItemsButtonActionPerformed

    private void removeAllItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllItemsButtonActionPerformed
        model.removeAllElements();
    }//GEN-LAST:event_removeAllItemsButtonActionPerformed

    private void backToStep1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToStep1ButtonActionPerformed
        tabs.setSelectedIndex(0);
    }//GEN-LAST:event_backToStep1ButtonActionPerformed

    private void startSimulationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSimulationButtonActionPerformed
        evolutionSteeringButton.setText("Pause");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                controller.gatherParametersAndStartSimulation();
                tabs.setSelectedIndex(2);
            }
        });
    }//GEN-LAST:event_startSimulationButtonActionPerformed

    private void evolutionSteeringButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evolutionSteeringButtonActionPerformed
        if (evolutionSteeringButton.getText().equals("Pause")) {
            evolutionSteeringButton.setText("Resume");
            controller.pauseSimulation();
        }
        else {
            evolutionSteeringButton.setText("Pause");
            controller.resumeSimulation();
        }
    }//GEN-LAST:event_evolutionSteeringButtonActionPerformed

    private void loadConfigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadConfigButtonActionPerformed
        int returnValue = configFileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                controller.loadConfig(configFileChooser.getSelectedFile());
            } catch (Exception e) {
                new MyAlert(e);
            }
        }
    }//GEN-LAST:event_loadConfigButtonActionPerformed

    private void detailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsButtonActionPerformed
        EvolutionDetails.show(controller, this);
    }//GEN-LAST:event_detailsButtonActionPerformed

    private void saveConfigButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveConfigButtonActionPerformed
        int returnValue = saveConfigFileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                controller.saveConfig(saveConfigFileChooser.getSelectedFile());
                new MyInfo("Configuration saved!");
            } catch (Exception e) {
                new MyAlert(e);
            }
        }
    }//GEN-LAST:event_saveConfigButtonActionPerformed


    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
         
         

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                myMainWindow = new MainWindow();
                myMainWindow.setLocationRelativeTo(null);
                myMainWindow.setVisible(true);
            }
        });
    }

    private EvolutionDetails evolutionDetails;
    private JFileChooser configFileChooser, saveConfigFileChooser;
    private XMLFileFilter filter;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JButton backToStep1Button;
    private javax.swing.JLabel bestResultSummary;
    private javax.swing.JButton continueToStep2Button;
    private javax.swing.JComboBox crossoverMethod;
    private javax.swing.JSpinner crossoverRate;
    private javax.swing.JButton detailsButton;
    private javax.swing.JButton editItemButton;
    private javax.swing.JSpinner elitismRate;
    private javax.swing.JButton evolutionSteeringButton;
    private javax.swing.JButton generateItemsButton;
    protected static javax.swing.JList itemsList;
    private javax.swing.JLayeredPane itemsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lastPopulationBestResultSummary;
    private javax.swing.JButton loadConfigButton;
    private javax.swing.JSpinner maxGenerations;
    private javax.swing.JSpinner maximumWeight;
    private javax.swing.JSpinner mutationRate;
    private javax.swing.JSpinner populationSize;
    private javax.swing.JButton removeAllItemsButton;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JComboBox repairOrPenaltyMethod;
    private javax.swing.JButton saveConfigButton;
    protected javax.swing.JComboBox selectionMethod;
    private javax.swing.JLayeredPane settingsPanel;
    private javax.swing.JLayeredPane simulationPanel;
    private javax.swing.JButton startSimulationButton;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables

}
