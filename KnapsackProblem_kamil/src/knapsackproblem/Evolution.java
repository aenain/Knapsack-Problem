/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;
import java.lang.System.*;
import java.util.*;
/**
 *
// * @author KaMyLuS
 */
public class Evolution {
    Subject subjects[]; // tablica z przedmiotami 
    int subjectsCount; // ile przedmiotow <=> dlugosc chromosomu
    int populationCount; // liczebnosc populacji
    int knapsackCapacity; // pojemnosc plecaka
    boolean repair; // czy stosujemy funkcje naprawy
    double ro; // max(wartosc_przedmiotu/waga_przedmiotu)
    double elitismFactor; // wspolczynnik elitarnosci
    double crossFactor; // wspolczynnik krzyzowania
    double mutationFactor; // wspolczynnik mutacji
    Population population[] = new Population[2]; // populacja (obecna i poprzednia ?)
    
    PunishFitness evalPunishFunction; // funkcja obliczajaca przystosowanie i kare
    RepairFitness evalRepairFunc;
    SelectionMethod selectFunction; // funkcja selekcji osobnikow
    CrossoverMethod crossoverFunction; // funkcja odpowiedzialna za krzyzowanie
    
    public Evolution(Subject subj[], int subCount, int populCount, int knapCapac, boolean rep, double 
            elitFac, double crossFac, double mutFac, PunishFitness evalPunishFunc, RepairFitness repairFunc,
            SelectionMethod selectFunc, CrossoverMethod crossFunc){
        subjects = subj; // moze lepiej zrobic kopiowanie zamiast tego ? 
        subjectsCount = subCount;
        populationCount = populCount;
        knapsackCapacity = knapCapac;
        repair = rep;
        elitismFactor = elitFac;
        crossFactor = crossFac;
        mutationFactor = mutFac;
        
        evalPunishFunction = evalPunishFunc;
        evalRepairFunc = repairFunc;
        selectFunction = selectFunc;
        crossoverFunction = crossFunc;
        
        population[0] = new Population(populationCount, subjectsCount);
        population[1] = new Population(populationCount, subjectsCount);   
        
        ro = 0;
        for(Subject s: subjects)
            ro = java.lang.Math.max(ro, s.value/s.weigth);
    }
    
    // inicjalizacja - wygenerowanie 1szej losowej populacji itp.
    void init(){
        population[1].genRandomPop();
        population[1].calcValWeigth(subjects);
    }
    
    // ewolucja (max_gener - maksymalnie do tego pokolenia ewoluujemy)
    void evolve(int max_gener){
        for(int i = 0; i < max_gener; i++){
            /* jak to widze:
             * 
             * 1. przepisujemy pop[1] do pop[0]
             * 2. oceniamy pop[0]; obliczamy srednia, najgorszego, najlepszego
             * 3. wybieramy wg wspolczynnika elitarnosci najlepszych osobnikow 
             *    z pop[0] do pop[1]
             * 4. reszte wybieramy odpowiednia metoda
             * 5. krzyzujemy losowe osobiki z pop[1] uwzgledniajac wspolczynnik 
             *    krzyzowania i wybrana metode krzyzowania
             * 6. mutujemy odpowiednie geny uwzgledniajac co trzeba
             * 7. pop[1] jest naszym nowym pokoleniem :)
             */
            
            population[0] = new Population(population[1]);
            
            // ocenianie populacji i sprawy z tym zwiazane
            population[0].calcValWeigth(subjects);
            double sum = 0, minn = 0, maxx = 0;
            int minIndex = 0, maxIndex = 0;

            for(int j = 0; j < populationCount; j++){
                if(!repair) population[0].chromosomes[j].setAdaptation(evalPunishFunction.evaluate(population[0].chromosomes[j].getValue(), 
                            population[0].chromosomes[j].getWeigth(), knapsackCapacity, ro));
                else evalRepairFunc.evaluate(population[0].chromosomes[j], knapsackCapacity, subjects); 
                    
                double adapt = population[0].chromosomes[j].getAdaptation();
                sum += adapt;
                if(j == 0) minn = maxx = adapt;
                else {
                    if(adapt < minn){
                        minn = adapt;
                        minIndex = j;
                    }
                    if(adapt > maxx){
                        maxx = adapt;
                        maxIndex = j;
                    }
                }
            }
            population[0].setWorst(minn);
            population[0].setBest(maxx);
            population[0].setAver(sum/populationCount);
            
            // wybieranie osobnikow do nastepnej populacji 
            CompareGenome compare = new CompareGenome();
            // elitarnosc
            int eliteCount = (int)(elitismFactor*populationCount);
            boolean sorted = false;
            if(eliteCount > 0){
                Arrays.sort(population[0].chromosomes, compare);
                sorted = true;
                for(int j = 0; j < eliteCount; j++){
                    population[1].chromosomes[j] = new Genome(population[0].chromosomes[j]);
                }
            }
            // wybor pozostalych osobnikow (tu prawdopodobnie sie bedzie trzeba pobawic z parametrami itp.)
            selectFunction.select(population[0], population[1], populationCount, populationCount-eliteCount, eliteCount, sorted);
            
            // krzyzowanie (obecnie jednopunktowe)
            crossoverFunction.crossover(population[1], populationCount, crossFactor, 1, eliteCount);
            
            // mutacje
            for(int j = 0; j < populationCount; j++)
                population[1].chromosomes[j].mutate(mutationFactor);
        }
    }
    
    Genome getBestGen(){
        return population[0].chromosomes[population[0].getBestIndex()];
    }
}
