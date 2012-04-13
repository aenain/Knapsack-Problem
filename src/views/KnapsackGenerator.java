package views;
import java.util.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import models.MyException;
//import static java.lang.Math.*;


public class KnapsackGenerator extends javax.swing.JFrame {
    
    DecimalFormat df = new DecimalFormat("0.00");
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();

    public KnapsackGenerator() {
        initComponents();
        symbols.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(symbols);
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
    }
    
    String round(double d) {
        
        //Number num = 0;
        String num = null;
        try {
            //System.out.println("format: "+df.format(d));
            num = df.format(d);//df.parse(df.format(d));
        } catch (Exception e) {
            new MyAlert("Błąd parsowania");
        }
        return num;
        //System.out.println(num);
        //return num.doubleValue();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numberOfObjects = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        maxWeight = new javax.swing.JSpinner();
        minWeight = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        maxValue = new javax.swing.JSpinner();
        minValue = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generator");
        setResizable(false);

        jLabel1.setText("Number of objects");

        jLabel2.setText("Min. weight");

        jLabel3.setText("Max. weight");

        jLabel4.setText("Min. value");

        jLabel5.setText("Max. value");

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(minWeight)
                                    .addComponent(minValue, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(33, 33, 33)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maxValue, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(maxWeight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(numberOfObjects, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton1)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfObjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(minWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(minValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             
        try {
            int rangeMinW = (Integer)minWeight.getValue();
            int rangeMaxW = (Integer)maxWeight.getValue();
            int rangeMinV = (Integer)minValue.getValue();
            int rangeMaxV = (Integer)maxValue.getValue();
            int n = (Integer)numberOfObjects.getValue();
        
            if(rangeMinW > rangeMaxW || rangeMinV > rangeMaxV)
                throw new MyException("A minimal value can't be bigger than a maximal value!");
        
        /*
        ustawianie ilości liczb przed przecinkiem
        double logar = log10(((rangeMaxV < rangeMaxW)? rangeMaxW : rangeMaxV));
        int maxx = (int)logar+1;
        
        df.setMinimumIntegerDigits(maxx);
        df.setMaximumIntegerDigits(maxx);
         * 
         */
        
            Random r = new Random();
        
            while(n-- > 0) {

                double randomV = rangeMinV + (rangeMaxV - rangeMinV) * r.nextDouble();
                double randomW = rangeMinW + (rangeMaxW - rangeMinW) * r.nextDouble();
        
                MainWindow.model.addElement(round(randomW)+"|"+round(randomV));
            }
        
            dispose();
        } catch(Exception e) {
            new MyAlert(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                KnapsackGenerator myGenerator = new KnapsackGenerator();
                myGenerator.setVisible(true);
                myGenerator.setLocationRelativeTo(null);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner maxValue;
    private javax.swing.JSpinner maxWeight;
    private javax.swing.JSpinner minValue;
    private javax.swing.JSpinner minWeight;
    private javax.swing.JSpinner numberOfObjects;
    // End of variables declaration//GEN-END:variables
}
