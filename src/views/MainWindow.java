package views;

import controllers.*;
import java.util.Collections;
import javax.swing.UIManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author arturhebda
 */
public class MainWindow extends JFrame {

    static MainWindow myMainWindow;
    static DefaultListModel model = new DefaultListModel();
    static EvolutionController controller;
    

    private MainWindow() {
        initComponents();
        itemsList.setModel(model);
        controller = new EvolutionController(model);
    }
    
    
    static int[] getSelected() {
        return itemsList.getSelectedIndices();
    }
    
    static void unSelect() {
        itemsList.clearSelection();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        itemsPanel = new javax.swing.JLayeredPane();
        maximumWeightSlider = new javax.swing.JSlider();
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
        settingsPanel = new javax.swing.JLayeredPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        populationSize = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        mutationRate = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        elitismRate = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        crossoverRate = new javax.swing.JFormattedTextField();
        repairOrPenaltyMethod = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        selectionMethod = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        crossoverMethod = new javax.swing.JComboBox();
        backToStep1Button = new javax.swing.JButton();
        startSimulationButton = new javax.swing.JButton();
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

        maximumWeightSlider.setMajorTickSpacing(20);
        maximumWeightSlider.setMaximum(120);
        maximumWeightSlider.setPaintLabels(true);
        maximumWeightSlider.setPaintTicks(true);
        maximumWeightSlider.setBounds(50, 360, 510, 50);
        itemsPanel.add(maximumWeightSlider, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel1.setLabelFor(maximumWeightSlider);
        jLabel1.setText("Knapsack's Maximum Weight");
        jLabel1.setBounds(40, 330, 340, 30);
        itemsPanel.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        continueToStep2Button.setText("Continue");
        continueToStep2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueToStep2ButtonActionPerformed(evt);
            }
        });
        continueToStep2Button.setBounds(520, 470, 75, 23);
        itemsPanel.add(continueToStep2Button, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane1.setViewportView(itemsList);

        jScrollPane1.setBounds(50, 60, 420, 230);
        itemsPanel.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel2.setText("Items");
        jLabel2.setBounds(40, 30, 33, 19);
        itemsPanel.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        addItemButton.setText("Add");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });
        addItemButton.setBounds(480, 60, 100, 23);
        itemsPanel.add(addItemButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        editItemButton.setText("Edit");
        editItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editItemButtonActionPerformed(evt);
            }
        });
        editItemButton.setBounds(480, 90, 100, 23);
        itemsPanel.add(editItemButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        removeItemButton.setText("Remove");
        removeItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemButtonActionPerformed(evt);
            }
        });
        removeItemButton.setBounds(480, 120, 100, 23);
        itemsPanel.add(removeItemButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        generateItemsButton.setText("Generate");
        generateItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateItemsButtonActionPerformed(evt);
            }
        });
        generateItemsButton.setBounds(480, 270, 100, 23);
        itemsPanel.add(generateItemsButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("  or...");
        jLabel3.setBounds(510, 220, 28, 14);
        itemsPanel.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        removeAllItemsButton.setText("Remove all");
        removeAllItemsButton.setToolTipText("");
        removeAllItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllItemsButtonActionPerformed(evt);
            }
        });
        removeAllItemsButton.setBounds(480, 150, 100, 23);
        itemsPanel.add(removeAllItemsButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Items", itemsPanel);

        populationSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                populationSizeActionPerformed(evt);
            }
        });
        populationSize.setBounds(10, 40, 170, 20);
        jLayeredPane1.add(populationSize, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setText("Population Size");
        jLabel7.setBounds(20, 20, 170, 14);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mutationRate.setBounds(20, 130, 160, 20);
        jLayeredPane1.add(mutationRate, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setText("Mutation Rate");
        jLabel8.setBounds(20, 110, 100, 14);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        elitismRate.setBounds(20, 210, 160, 20);
        jLayeredPane1.add(elitismRate, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setText("Elitism Rate");
        jLabel9.setBounds(20, 190, 90, 14);
        jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setText("Crossover Rate");
        jLabel10.setBounds(20, 270, 120, 14);
        jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        crossoverRate.setBounds(20, 300, 160, 20);
        jLayeredPane1.add(crossoverRate, javax.swing.JLayeredPane.DEFAULT_LAYER);

        repairOrPenaltyMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        repairOrPenaltyMethod.setBounds(30, 380, 56, 20);
        jLayeredPane1.add(repairOrPenaltyMethod, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel11.setText("Repair / Penalty Method");
        jLabel11.setBounds(30, 360, 170, 14);
        jLayeredPane1.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel12.setText("Selection Method");
        jLabel12.setBounds(370, 140, 140, 14);
        jLayeredPane1.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        selectionMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectionMethod.setBounds(370, 160, 56, 20);
        jLayeredPane1.add(selectionMethod, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel13.setText("Crossover Method");
        jLabel13.setBounds(370, 210, 90, 14);
        jLayeredPane1.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        crossoverMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        crossoverMethod.setBounds(370, 230, 56, 20);
        jLayeredPane1.add(crossoverMethod, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backToStep1Button.setText("Back");
        backToStep1Button.setBounds(0, 440, 75, 29);
        jLayeredPane1.add(backToStep1Button, javax.swing.JLayeredPane.DEFAULT_LAYER);

        startSimulationButton.setText("Start Simulation");
        startSimulationButton.setBounds(437, 440, 140, 29);
        jLayeredPane1.add(startSimulationButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane1.setBounds(10, 10, 580, 470);
        settingsPanel.add(jLayeredPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Settings", settingsPanel);

        jScrollPane2.setBounds(10, 10, 600, 390);
        simulationPanel.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        evolutionSteeringButton.setText("Pause");
        evolutionSteeringButton.setBounds(520, 470, 97, 23);
        simulationPanel.add(evolutionSteeringButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel4.setText("Best Results");
        jLabel4.setBounds(10, 410, 120, 30);
        simulationPanel.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Overall");
        jLabel5.setBounds(90, 470, 60, 20);
        simulationPanel.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("In Last Population");
        jLabel6.setBounds(20, 440, 120, 20);
        simulationPanel.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bestResultSummary.setText("475PLN by 320kg (out of 321kg)");
        bestResultSummary.setBounds(170, 470, 210, 20);
        simulationPanel.add(bestResultSummary, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lastPopulationBestResultSummary.setText("450PLN by 320kg (out of 321kg)");
        lastPopulationBestResultSummary.setBounds(170, 440, 210, 20);
        simulationPanel.add(lastPopulationBestResultSummary, javax.swing.JLayeredPane.DEFAULT_LAYER);

        detailsButton.setText("Details");
        detailsButton.setBounds(430, 470, 97, 23);
        simulationPanel.add(detailsButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("Simulate", simulationPanel);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continueToStep2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueToStep2ButtonActionPerformed
        // TODO add your handling code here:
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

    private void populationSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_populationSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_populationSizeActionPerformed


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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JButton backToStep1Button;
    private javax.swing.JLabel bestResultSummary;
    private javax.swing.JButton continueToStep2Button;
    private javax.swing.JComboBox crossoverMethod;
    private javax.swing.JFormattedTextField crossoverRate;
    private javax.swing.JButton detailsButton;
    private javax.swing.JButton editItemButton;
    private javax.swing.JFormattedTextField elitismRate;
    private javax.swing.JButton evolutionSteeringButton;
    private javax.swing.JButton generateItemsButton;
    protected static javax.swing.JList itemsList;
    private javax.swing.JLayeredPane itemsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lastPopulationBestResultSummary;
    private javax.swing.JSlider maximumWeightSlider;
    private javax.swing.JFormattedTextField mutationRate;
    private javax.swing.JFormattedTextField populationSize;
    private javax.swing.JButton removeAllItemsButton;
    private javax.swing.JButton removeItemButton;
    private javax.swing.JComboBox repairOrPenaltyMethod;
    protected javax.swing.JComboBox selectionMethod;
    private javax.swing.JLayeredPane settingsPanel;
    private javax.swing.JLayeredPane simulationPanel;
    private javax.swing.JButton startSimulationButton;
    // End of variables declaration//GEN-END:variables

}
