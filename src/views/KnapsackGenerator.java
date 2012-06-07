package views;
import java.util.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import models.MyException;
//import static java.lang.Math.*;


public class KnapsackGenerator extends javax.swing.JFrame {
    
    //DecimalFormat df = new DecimalFormat("0.00");
    //DecimalFormatSymbols symbols = new DecimalFormatSymbols();

    public KnapsackGenerator() {
        initComponents();
        /*
        symbols.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(symbols);
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
         * 
         */
    }
    
    /*
    String round(double d) {
        
        //Number num = 0;
        String num = null;
        try {
            //System.out.println("format: "+df.format(d));
            num = df.format(d);//df.parse(df.format(d));  to do odblokowania jak pieprzymy to, czy liczby mają mieć tyle samo cyfr po przecinku, ucina zera od prawej
        } catch (Exception e) {
            new MyAlert("Błąd parsowania");
        }
        return num;
        
        //return num.doubleValue();
    }
     * 
     */


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numberOfObjects = new javax.swing.JSpinner();
        maxValue = new javax.swing.JSpinner();
        minValue = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        maxWeight = new javax.swing.JSpinner();
        minWeight = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generate Items");
        setPreferredSize(new java.awt.Dimension(355, 228));
        setResizable(false);

        jLabel1.setText("Count");

        jLabel2.setText("Value [PLN]");

        jLabel4.setText("Weight [kg]");

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("to");

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("to");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numberOfObjects)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(minWeight, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(minValue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maxWeight)
                                    .addComponent(maxValue, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(numberOfObjects))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minWeight)
                    .addComponent(maxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             
        try {
            int rangeMinV = (Integer)minValue.getValue();
            int rangeMaxV = (Integer)maxValue.getValue();
            int rangeMinW = (Integer)minWeight.getValue();
            int rangeMaxW = (Integer)maxWeight.getValue();
            int n = (Integer)numberOfObjects.getValue();
            
            /*
            Integer in = (Integer)minWeight.getValue();
            String ch = in.toString();
            
            
            if(!ch.matches("^\\d+$"))
                throw new MyException("Only numbers allowed!");
            /*
            double check = Double.parseDouble((String)minWeight.getValue());
            check = Double.parseDouble((String)maxWeight.getValue());
            check = Double.parseDouble((String)minValue.getValue());
            check = Double.parseDouble((String)maxValue.getValue());
             * 
             */
        
            if(rangeMinW > rangeMaxW || rangeMinV > rangeMaxV)
                throw new MyException("A minimal value can't be bigger than a maximal value!");
            
            if(rangeMinW <= 0 || rangeMinV < 0 || rangeMaxW <=0 || rangeMaxV < 0)
                throw new MyException("Only positive numbers accepted!");
        
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

                int randomV = rangeMinV + (int)((rangeMaxV - rangeMinV) * r.nextDouble());
                int randomW = rangeMinW + (int)((rangeMaxW - rangeMinW) * r.nextDouble());
                //System.out.println(randomW+" "+randomV);
                
                MainWindow.model.addElement(ItemHelper.toLabel(randomV, randomW));
                //MainWindow.model.addElement(round(randomW)+"|"+round(randomV));
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
