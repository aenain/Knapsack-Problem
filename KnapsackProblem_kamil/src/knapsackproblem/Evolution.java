/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

/**
 *
// * @author KaMyLuS
 */
public class Evolution {
    Subject subs[]; // tablica z przedmiotami 
    int sub_count; // ile przedmiotow
    Population pop[] = new Population[2]; // populacja (obecna i poprzednia ?)
    
    public Evolution(Subject sub[], int sub_c){
        subs = sub; // moze lepiej zrobic kopiowanie zamiast tego ? 
        sub_count = sub_c;
    }
    
    // inicjalizacja - wygenerowanie 1szej losowej populacji itp.
    void init(){
        pop[1].genRandomPop();
        pop[1].calcValWeigth(subs);
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
             * 4. krzyzujemy losowe osobiki z pop[0] uwzgledniajac wspolczynnik 
             *    krzyzowania i wybrana metode krzyzowania
             * 5. mutujemy odpowiednie geny uwzgledniajac co trzeba
             * 6. pop[1] jest naszym nowym pokoleniem :)
             */
        }
    }
}
