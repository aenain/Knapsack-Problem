/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Mateusz
 */

public class MyException extends Exception{
    private final String msg;
    
    public MyException() {
        this("");
    }
    
    public MyException (String msg) {
        this.msg = msg;
    }
    
    @Override
    public String toString() {
        return "Error: "+msg;
    }
}
