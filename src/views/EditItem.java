package views;
import models.MyException;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Mateusz
 */
public class EditItem extends JFrame {

    Integer weight, value;
    int index;
    int[] selected = MainWindow.getSelected();

    public EditItem() {
        initComponents();
        fill();
    }

    public void actionPerformed(ActionEvent evt) {
        doneButtonActionPerformed(evt);
    }

    private void fill() {
        String[] values = ItemHelper.getValues((String)MainWindow.model.elementAt(selected[index]));

        itemWeight.setValue(Integer.parseInt(values[1]));
        itemValue.setValue(Integer.parseInt(values[0]));
        itemValue.requestFocus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        doneButton = new javax.swing.JButton();
        itemValue = new javax.swing.JSpinner();
        itemWeight = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Item");
        setResizable(false);

        jLabel1.setText("Value [PLN]");

        jLabel2.setText("Weight [kg]");

        doneButton.setText("Save");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        itemValue.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        itemWeight.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(itemValue)
                    .addComponent(itemWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(doneButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemValue)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemWeight)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addComponent(doneButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        try {
            value = (Integer) itemValue.getValue();
            weight = (Integer) itemWeight.getValue();

            if (value <= 0 || weight <= 0)
                throw new MyException("Only positive numbers accepted!");

            MainWindow.model.setElementAt(ItemHelper.toLabel(value, weight), selected[index]);
        } catch (Exception e) {
            new MyAlert(e);
        } finally {
            if(index == selected.length - 1) {
                dispose();
                return;
            }

            index++;
            fill();
        }


    }//GEN-LAST:event_doneButtonActionPerformed

    private void clear(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_clear
        //Akcja wykonywana przy zamknięciu okna, zarówno przez usera, jak i dispose()
        MainWindow.unSelect();
    }//GEN-LAST:event_clear


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                EditItem myItem = new EditItem();
                myItem.setLocationRelativeTo(null);
                myItem.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doneButton;
    private javax.swing.JSpinner itemValue;
    private javax.swing.JSpinner itemWeight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
