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
        itemValue.addActionListener(this);
        itemWeight.addActionListener(this);
        fill();
    }

    public void actionPerformed(ActionEvent evt) {
        doneButtonActionPerformed(evt);
    }

    private void fill() {
        String[] values = ItemHelper.getValues((String)MainWindow.model.elementAt(selected[index]));

        itemWeight.setText(values[0]);
        itemValue.setText(values[1]);
        itemValue.requestFocus();
        itemValue.selectAll();
        itemWeight.selectAll();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        itemWeight = new javax.swing.JTextField();
        itemValue = new javax.swing.JTextField();
        doneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Item");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                clear(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                clear(evt);
            }
        });

        jLabel2.setText("Weight [kg]");

        jLabel1.setText("Value [PLN]");

        doneButton.setText("Save");
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
                .addContainerGap(263, Short.MAX_VALUE)
                .addComponent(doneButton)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(itemWeight)
                    .addComponent(itemValue, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(itemValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(itemWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(doneButton)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed


        try {
            try {

                weight = ItemHelper.toNumber(itemValue.getText());
                value = ItemHelper.toNumber(itemWeight.getText());

                if(value < 0 || weight <= 0)
                    throw new NumberFormatException();

                MainWindow.model.setElementAt(ItemHelper.toLabel(value, weight), selected[index]);

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
