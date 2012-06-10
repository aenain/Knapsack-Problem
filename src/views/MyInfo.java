/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author arturhebda
 */
public class MyInfo extends JFrame {
    private JFrame frame = new JFrame("Window");
    
    public MyInfo(String content) {
        JOptionPane.showMessageDialog(frame, content, "", JOptionPane.INFORMATION_MESSAGE);
    }
}
