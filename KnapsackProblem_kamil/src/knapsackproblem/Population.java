/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

/**
 *
 * @author KaMyLuS
 */
public class Population {
    int pop_count; // liczebnosc populacji
    int chrom_len; // dlugosc chromosomu
    Genome chromosomes[]; // chromosomy calej poszczegolnych osobnikow
    int worst, aver, best; // najgorsza, srednia, najlepsza wartosc przystosowania osobnikow
    
    Population(int pc, int cl){
        pop_count = pc;
        chrom_len = cl;
        chromosomes = new Genome[pop_count];
    }
    
    // odczyt wartosci
    
    int getWorst(){
        return worst;
    }
    
    int getAver(){
        return aver;
    }
    
    int getBest(){
        return best;
    }
    
    //-----------------------
    
    // generowanie losowej populacji
    void genRandomPop(){
        for(int i = 0; i < pop_count; i++){
            chromosomes[i] = new Genome(chrom_len);
            chromosomes[i].genRandomChrom();
        }
    }
    
    // obliczanie wagi i wartosci dla calej populacji
    void calcValWeigth(Subject sub[]){
        for(int i = 0; i < pop_count; i++){
            int v = chromosomes[i].getValue();
            int w = chromosomes[i].getWeigth();
            
            for(int j = 0; j < chrom_len; j++){
                if(chromosomes[i].isSubject(j)){
                    v += sub[j].getValue();
                    w += sub[j].getWeigth();
                }
            }
            
            chromosomes[i].setValue(v);
            chromosomes[i].setWeigth(w);
        }
    }
}
