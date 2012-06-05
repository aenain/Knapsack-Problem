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
public class Saver {
    private Serializer serializer;

    public Saver() {
        serializer = new Persister();
    }

    public void save(Configuration config, File destination) throws Exception {
        serializer.write(config, destination);
    }
}
