/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Hashtable;

/**
 *
 * @author arturhebda
 */
public interface EvolutionListener {
    public void updateReceived(Hashtable<String, Number> hash);
}
