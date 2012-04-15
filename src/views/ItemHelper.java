/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author arturhebda
 */
public class ItemHelper {
    public static final String valueUnit = " PLN";
    public static final String weightUnit = " kg";
    public static final Pattern numberPattern = Pattern.compile("(\\d+(.\\d+)?)");

    public static String toLabel(String value, String weight) {
        return value + valueUnit + " by " + weight + weightUnit;
    }
    
    public static String toLabel(Double value, Double weight) {
        return ItemHelper.toLabel(value.toString(), weight.toString());
    }

    public static String toWeightLabel(String weight) {
        return weight + weightUnit;
    }

    public static String toValueLabel(String value) {
        return value + valueUnit;
    }

    public static Double toNumber(String text) {
        Matcher matcher = numberPattern.matcher(text.replaceAll(",", "."));
        matcher.find();
        return Double.parseDouble(matcher.group());
    }

    public static String[] getValues(String itemLabel) {
        Matcher matcher = numberPattern.matcher(itemLabel.replaceAll(",", "."));
        String[] values = new String[2];
        int i = 0;
        
        while (matcher.find() && i < 2) {
            values[i] = matcher.group();
            i++;
        }
        
        return values;
    }
}
