package views;
import models.MyException;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

/**
 *
 * @author Mateusz
 */
public class EditItem extends JFrame implements ActionListener {

    double weight, value;
    int index;
    int[] selected = MainWindow.getSelected();
    
    public EditItem() {
        initComponents();
        itemWeight.addActionListener(this);
        itemValue.addActionListener(this);
        fill();
    }

    public void actionPerformed(ActionEvent evt) {
        doneButtonActionPerformed(evt);
    }
    
    private void fill() {
        
        String[] getValues = ((String)MainWindow.model.elementAt(selected[index])).split("\\|");
            
        itemWeight.setText(getValues[0]);
        itemValue.setText(getValues[1]);
        itemWeight.requestFocus();
        itemWeight.selectAll();
        itemValue.selectAll();
    }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        itemValue = new javax.swing.JTextField();
        itemWeight = new javax.swing.JTextField();
        doneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit an item");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                clear(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                clear(evt);
            }
        });

        jLabel2.setText("Item's value");

        jLabel1.setText("Item's weight");

        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(itemValue)
                            .addComponent(itemWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(doneButton)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(itemWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(itemValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(doneButton)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed


        try {
            try {
                
                weight = Double.parseDouble(itemWeight.getText());
                value = Double.parseDouble(itemValue.getText());
                
                if(value < 0 || weight <= 0)
                    throw new NumberFormatException();
                
                MainWindow.model.setElementAt(itemWeight.getText()+"|"+itemValue.getText(), selected[index]);
                
            } catch (NumberFormatException e) {
                throw new MyException("Only positive numbers accepted!");
            }
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
    private javax.swing.JTextField itemValue;
    private javax.swing.JTextField itemWeight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
