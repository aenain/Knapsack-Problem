/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
/**
 *
 * @author KaMyLuS
 */

// rozwiazywanie problemu plecakowego przy pomocy programowania dynamicznego
public class DynamicsKnapsackProblem {
    Item items[];     // przedmioty
    int itemCount;       // ilosc przedmiotow
    int knapsackCapacity;   // pojemnosc plecaka
    int result;             // najwieksza mozliwa wartosc przedmiotow do zabrania
    int A[][];              // tablica pomocnicza do program. dynam.
    long executionTimeInMilliseconds;
    
    void compute(){
        long start, stop;
        start = System.currentTimeMillis();

        A = new int[itemCount+1][knapsackCapacity+1];
        result = 0;
        
        for(int i = 0; i <= itemCount; i++) A[i][0] = 0;
        for(int i = 0; i <= knapsackCapacity; i++) A[0][i] = 0;
        
        for(int i = 1; i <= itemCount; i++)
             for(int j = 0; j <= knapsackCapacity; j++)
                 if(items[i-1].getWeigth() > j)
                     A[i][j] = A[i-1][j];
                 else
                     A[i][j] = Math.max(A[i-1][j], A[i-1][j-items[i-1].getWeigth()]+items[i-1].getValue());
        
        for(int i = 0; i <= knapsackCapacity; i++)
            result = Math.max(result, A[itemCount][i]);

        stop = System.currentTimeMillis();
        executionTimeInMilliseconds = stop - start;
    }

    public Item[] takenItems() {
        return new Item[]{}; // TODO!
    }

    public int getWeight() {
        return 10; // TODO!
    }

    public int getValue() {
        return result;
    }

    // in milliseconds
    public double getExecutionTime() {
        return executionTimeInMilliseconds;
    }
}
