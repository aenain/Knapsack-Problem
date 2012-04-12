/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

import java.lang.Math;
/**
 *
 * @author KaMyLuS
 */

// rozwiazywanie problemu plecakowego przy pomocy programowania dynamicznego
public class DynamicsKnapsackProblem {
    Subject subjects[];     // przedmioty
    int subjectCount;       // ilosc przedmiotow
    int knapsackCapacity;   // pojemnosc plecaka
    int result;             // najwieksza mozliwa wartosc przedmiotow do zabrania
    int A[][];              // tablica pomocnicza do program. dynam.
    
    void compute(){
        A = new int[subjectCount+1][knapsackCapacity+1];
        result = 0;
        
        for(int i = 0; i <= subjectCount; i++) A[i][0] = 0;
        for(int i = 0; i <= knapsackCapacity; i++) A[0][i] = 0;
        
        for(int i = 1; i <= subjectCount; i++)
             for(int j = 0; j <= knapsackCapacity; j++)
                 if(subjects[i-1].getWeigth() > j)
                     A[i][j] = A[i-1][j];
                 else
                     A[i][j] = java.lang.Math.max(A[i-1][j], A[i-1][j-subjects[i-1].getWeigth()]+subjects[i-1].getValue());
        
        for(int i = 0; i <= knapsackCapacity; i++)
            result = java.lang.Math.max(result, A[subjectCount][i]);
    }
}
