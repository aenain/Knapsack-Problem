/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author KaMyLuS
 */
public class KnapsackProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int itemCount = 100, populCount = 1000, maxGener = 5500, maxWeigth = 200,
                maxValue = 250, knapCapac = 1000;
        double elitFact = 0.1, crossFact = 0.75, mutFact = 0.1;
        PunishFitness linearPF = new LinearPunishFitness();
        RepairFitness randModRF = new RandModuloRepairFitness();
        SelectionMethod rouletteSel = new RouletteSelection();
        CrossoverMethod singleP = new SinglePointCrossover();
        
        Random rand = new Random();
        Item items[] = new Item[itemCount];
        System.out.println("Przedmioty:");
        for(int i = 0; i < itemCount; i++){
            items[i] = new Item(rand.nextInt(maxWeigth)+1, rand.nextInt(maxValue)+1);
            System.out.println("id: " + i + " waga: " + items[i].getWeigth() + " wart: " + items[i].getValue());
        }
        
        Evolution evol = new Evolution(items, itemCount, populCount, knapCapac, true,
                elitFact, crossFact, mutFact, linearPF, randModRF, rouletteSel, singleP);
        evol.init();
        evol.evolve(maxGener);
        
        Genome bestGen = new Genome(evol.getBestGen());
        System.out.println("\n--------------");
        System.out.println("Najlepszy:");
        System.out.println("Wartosc: " + bestGen.getValue() + " waga: " + 
                bestGen.getWeigth() + " adapt: " + bestGen.getAdaptation());
        System.out.println("Zawiera przedmioty:");
        int sumWeigth = 0, sumValue = 0;
        for(int i = 0; i < bestGen.getLength(); i++){
            if(bestGen.isItem(i)){
                 System.out.println("id: " + i + " waga: " + items[i].getWeigth() + " wart: " + items[i].getValue());
                 sumWeigth += items[i].getWeigth();
                 sumValue += items[i].getValue();
            }
        }
        System.out.println("Suma wag:" + sumWeigth + " wartosci: " + sumValue);
        
        DynamicsKnapsackProblem dynKnap = new DynamicsKnapsackProblem();
        dynKnap.knapsackCapacity = knapCapac;
        dynKnap.items = items;
        dynKnap.itemCount = itemCount;
        dynKnap.compute();
        System.out.println("\n--------------");
        System.out.println("Algorytm dynamiczny:");
        System.out.println("Wartosc: " + dynKnap.result);
        System.out.println("Roznica: " + (dynKnap.result-bestGen.getValue()));
        System.out.println("Dynamik/genetyczny: " + ((double)(dynKnap.result)/bestGen.getValue()));
    }
}
