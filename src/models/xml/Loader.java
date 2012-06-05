/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.xml;

import java.io.File;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


/**
 *
 * @author arturhebda
 */
public class Loader {
    private Serializer serializer;

    public Loader() {
        serializer = new Persister();
    }
    
    public Configuration load(File source) throws Exception {
        return serializer.read(models.xml.Configuration.class, source);
    }
}
