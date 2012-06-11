package views;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class PdfFileFilter extends FileFilter {
    
    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getAbsolutePath().endsWith(".pdf");
    }
    
    @Override
    public String getDescription() {
        return "Pdf files (*.pdf)";
    }
}