/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EvolutionDetails.java
 *
 * Created on Jun 5, 2012, 3:18:28 PM
 */
package views;

import controllers.EvolutionController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 *
 * @author arturhebda
 */
public class EvolutionDetails extends javax.swing.JFrame {

    /** Creates new form EvolutionDetails */
    public EvolutionDetails() {
        initComponents();
        myInitComponents();
    }

    private void myInitComponents() {
        dynamicAlgorithmResult = new JLabel();
        dynamicAlgorithmResult.setForeground(Color.BLACK);
        dynamicAlgorithmResult.setSize(300, 28);
        dynamicAlgorithmResult.setLocation(startDynamicAlgorithmButton.getLocation());
        dynamicAlgorithmResult.setVisible(false);

        startDynamicAlgorithmButton.getParent().add(dynamicAlgorithmResult, BorderLayout.SOUTH);

        dynamicAlgorithmItemList.setModel(dynamicAlgorithmItemsModel);
        geneticAlgorithmItemList.setModel(geneticAlgorithmItemsModel);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        algorithmTabs = new javax.swing.JTabbedPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        geneticAlgorithmItemList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        dynamicAlgorithmItemList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bestGeneticAlgorithmResult = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        startDynamicAlgorithmButton = new javax.swing.JButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        exportToPdfButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setTitle("Evolution's Details");

        algorithmTabs.setEnabled(false);

        geneticAlgorithmItemList.setEnabled(false);
        jScrollPane1.setViewportView(geneticAlgorithmItemList);

        jScrollPane1.setBounds(10, 40, 600, 320);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel2.setText("Taken Items");
        jLabel2.setBounds(10, 10, 140, 17);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        algorithmTabs.addTab("Genetic", jLayeredPane1);

        dynamicAlgorithmItemList.setEnabled(false);
        jScrollPane2.setViewportView(dynamicAlgorithmItemList);

        jScrollPane2.setBounds(10, 40, 600, 320);
        jLayeredPane2.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel1.setText("Taken Items");
        jLabel1.setBounds(10, 10, 140, 17);
        jLayeredPane2.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        algorithmTabs.addTab("Dynamic", jLayeredPane2);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14));
        jLabel3.setText("Best Results");

        jLabel4.setForeground(new java.awt.Color(103, 103, 103));
        jLabel4.setText("Genetic Algorithm");

        jLabel5.setForeground(new java.awt.Color(103, 103, 103));
        jLabel5.setText("Dynamic Algorithm");

        bestGeneticAlgorithmResult.setText("1000 PLN by 50 kg (out of 51 kg)");

        startDynamicAlgorithmButton.setText("Start");
        startDynamicAlgorithmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDynamicAlgorithmButtonActionPerformed(evt);
            }
        });
        startDynamicAlgorithmButton.setBounds(0, 0, 75, 29);
        jLayeredPane3.add(startDynamicAlgorithmButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        exportToPdfButton.setText("Export to PDF");
        exportToPdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportToPdfButtonActionPerformed(evt);
            }
        });
        exportToPdfButton.setBounds(500, 0, 130, 29);
        jLayeredPane4.add(exportToPdfButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        closeButton.setBounds(420, 0, 79, 29);
        jLayeredPane4.add(closeButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLayeredPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 635, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(33, 33, 33)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(layout.createSequentialGroup()
                                .add(24, 24, 24)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel4)
                                    .add(jLabel5))
                                .add(26, 26, 26)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLayeredPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(bestGeneticAlgorithmResult))))
                        .add(23, 23, 23))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(algorithmTabs, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(algorithmTabs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 418, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(bestGeneticAlgorithmResult))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel5)
                        .add(10, 10, 10))
                    .add(jLayeredPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLayeredPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportToPdfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportToPdfButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportToPdfButtonActionPerformed

    private void startDynamicAlgorithmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDynamicAlgorithmButtonActionPerformed
        startDynamicAlgorithmButton.setVisible(false);
        dynamicAlgorithmResult.setText("Please wait...");
        dynamicAlgorithmResult.setVisible(true);

        JComponent[] components = {dynamicAlgorithmResult, algorithmTabs, dynamicAlgorithmItemList};
        controller.startDynamicAlgorithm(components);
    }//GEN-LAST:event_startDynamicAlgorithmButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    public static void show(final EvolutionController controller, final MainWindow mainWindow) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                EvolutionDetails details = new EvolutionDetails();
                details.setController(controller);
                details.setMainWindow(mainWindow);
                details.populateResults();
                details.setLocationRelativeTo(null);
                details.setVisible(true);
            }
        });
    }

    public void setController(EvolutionController controller) {
        this.controller = controller;
    }

    public void populateResults() {
        if (controller.hasDynamicAlgorithmResult()) {
            algorithmTabs.setEnabled(true);
            startDynamicAlgorithmButton.setVisible(false);
            // TODO! uzupełnienie widoków o wyniki dynamicznego algorytmu
        }

        controller.populateGeneticAlgorithmResults(bestGeneticAlgorithmResult);
    }

    public static DefaultListModel dynamicAlgorithmItemsModel = new DefaultListModel();
    public static DefaultListModel geneticAlgorithmItemsModel = new DefaultListModel();

    private EvolutionController controller;
    private javax.swing.JLabel dynamicAlgorithmResult;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane algorithmTabs;
    private javax.swing.JLabel bestGeneticAlgorithmResult;
    private javax.swing.JButton closeButton;
    private javax.swing.JList dynamicAlgorithmItemList;
    private javax.swing.JButton exportToPdfButton;
    private javax.swing.JList geneticAlgorithmItemList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton startDynamicAlgorithmButton;
    // End of variables declaration//GEN-END:variables

    // just to make sure that there will be only ONE frame evolutionDetails at a time.
    private void setMainWindow(MainWindow mainWindow) {
        mainWindow.disposeEvolutionDetails();
        mainWindow.setEvolutionDetails(this);
    }
}
