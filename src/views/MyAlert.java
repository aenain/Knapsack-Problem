package views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateusz
 */

public class MyAlert extends JFrame{
    
    private JFrame frame = new JFrame("Window");
    
    public MyAlert(String content) {
        JOptionPane.showMessageDialog(frame, content, "Darn!", JOptionPane.ERROR_MESSAGE);
    }
    
    public MyAlert(Exception e) {
        this(e.toString());
    }
    
}
