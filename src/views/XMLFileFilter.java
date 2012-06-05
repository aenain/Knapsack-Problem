/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.File;

/**
 *
 * @author arturhebda
 */
public class XMLFileFilter extends javax.swing.filechooser.FileFilter {
    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getAbsolutePath().endsWith(".xml");
    }
    
    @Override
    public String getDescription() {
        // some day maybe we should add support of I18N.
        return "Configuration files (*.xml)";
    }
}
