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
    
    PunishFitness evalFunction;
    SelectionMethod selectFunction;
    
    public Evolution(Subject sub[], int sub_c, int pop_c, boolean rep, double 
            elit_fac, double cross_fac, double mut_fac){
        subjects = sub; // moze lepiej zrobic kopiowanie zamiast tego ? 
        subjectsCount = sub_c;
        populationCount = pop_c;
        repair = rep;
        elitismFactor = elit_fac;
        crossFactor = cross_fac;
        mutationFactor = mut_fac;
        
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
            // stosujemy funkcje kary
            if(!repair) { 
                double sum = 0, minn = 0, maxx = 0;
                
                for(int j = 0; j < populationCount; j++){
                    population[0].chromosomes[j].setAdaptation(evalFunction.evaluate(population[0].chromosomes[j].getValue(), 
                            population[0].chromosomes[j].getWeigth(), knapsackCapacity, ro));
                    
                    double adapt = population[0].chromosomes[j].getAdaptation();
                    sum += adapt;
                    if(j == 0) minn = maxx = adapt;
                    else {
                        minn = java.lang.Math.min(minn, adapt);
                        maxx = java.lang.Math.max(minn, adapt);
                    }
                }
                population[0].setWorst(minn);
                population[0].setBest(maxx);
                population[0].setAver(sum/populationCount);
            }
            // jesli jednak wolimy naprawiac zle chromosomy
            else{
                
            }
            
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
            selectFunction.select(population[0], population[1], populationCount-eliteCount, eliteCount-1, sorted);
            
            // tu jakies krzyzowanie
            // ...
            
            // jakby bylo za malo osobnikow (?) - jakies dorabianie ?
            
            // mutacje
            for(int j = 0; j < populationCount; j++)
                population[1].chromosomes[j].mutate(mutationFactor);
        }
    }
}
