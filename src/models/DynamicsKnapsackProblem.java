/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
/**
 *
 * @author KaMyLuS
 */

import java.util.Vector;

// rozwiazywanie problemu plecakowego przy pomocy programowania dynamicznego
public class DynamicsKnapsackProblem {
    Item items[];     // przedmioty
    int itemCount;       // ilosc przedmiotow
    int knapsackCapacity;   // pojemnosc plecaka
    int result;             // najwieksza mozliwa wartosc przedmiotow do zabrania
    int weight;             // waga najlepszego plecaka
    int A[][];              // tablica pomocnicza do program. dynam.
    Vector<Item> takenItems = new Vector<Item>(); // zabrane przedmioty
    
    long executionTimeInMilliseconds;

    public DynamicsKnapsackProblem() {}

    public DynamicsKnapsackProblem(Item[] items, int knapsackCapacity) {
        this.items = items;
        this.itemCount = items.length;
        this.knapsackCapacity = knapsackCapacity;
    }
    
    public void compute() {
        long start, stop;
        start = System.currentTimeMillis();
        
        // warunki poczatkowe
        A = new int[itemCount+1][knapsackCapacity+1];
        result = weight = 0;
        
        for(int i = 0; i <= itemCount; i++) A[i][0] = 0;
        for(int i = 0; i <= knapsackCapacity; i++) A[0][i] = 0;
        
        // obliczamy poszczegolne wagi
        for(int i = 1; i <= itemCount; i++)
             for(int j = 0; j <= knapsackCapacity; j++)
                 if(items[i-1].getWeigth() > j)
                     A[i][j] = A[i-1][j];
                 else
                     A[i][j] = Math.max(A[i-1][j], A[i-1][j-items[i-1].getWeigth()]+items[i-1].getValue());
        
        // znajdujemy najlepsza wartosc
        for(int i = 0; i <= knapsackCapacity; i++){
            if(A[itemCount][i] > result){
                result = A[itemCount][i];
                weight = i;
            }
        }
        
        // dobieramy sie do wybranych przedmiotow
        int temp = weight;
        for(int i = itemCount; i > 0; i--)
        {
            if(temp-items[i-1].getWeigth() >= 0 && A[i][temp] == A[i-1][temp-items[i-1].getWeigth()] + items[i-1].getValue()){
                takenItems.add(items[i-1]);
                temp -= items[i-1].getWeigth();
            }
        }

        stop = System.currentTimeMillis();
        executionTimeInMilliseconds = stop - start;
    }

    public Item[] getTakenItems() {
        Item[] result = new Item[takenItems.size()];
        takenItems.toArray(result);
        return result; 
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return result;
    }

    // in milliseconds
    public double getExecutionTime() {
        return executionTimeInMilliseconds;
    }
}
