/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;
import java.lang.System.*;
/**
 *
 * @author KaMyLuS
 */
public class Population {
    int populationCount; // liczebnosc populacji
    int chromosomeLength; // dlugosc chromosomu
    Genome chromosomes[]; // chromosomy calej poszczegolnych osobnikow
    double worst, aver, best; // najgorsza, srednia, najlepsza wartosc przystosowania osobnikow
    
    public Population(int pc, int cl){
        populationCount = pc;
        chromosomeLength= cl;
        chromosomes = new Genome[populationCount];
    }
    
    public Population(Population source){
        populationCount = source.populationCount;
        chromosomeLength = source.chromosomeLength;
        worst = source.worst;
        aver = source.aver;
        best = source.best;
        chromosomes = new Genome[populationCount];
        java.lang.System.arraycopy(source.chromosomes, 0, chromosomes, 0, populationCount);
    }
    
    // odczyt wartosci
    
    double getWorst(){
        return worst;
    }
    
    double getAver(){
        return aver;
    }
    
    double getBest(){
        return best;
    }
    
    //-----------------------
    
    // ustawienie wartosci
    
    void setWorst(double w){
        worst = w;
    }
    
    void setAver(double a){
        aver = a;
    }
    
    void setBest(double b){
        best = b;
    }
    
    //---------------------------
    
    // generowanie losowej populacji
    void genRandomPop(){
        for(int i = 0; i < populationCount; i++){
            chromosomes[i] = new Genome(chromosomeLength);
            chromosomes[i].genRandomChrom();
        }
    }
    
    // obliczanie wagi i wartosci dla calej populacji
    void calcValWeigth(Subject sub[]){
        for(int i = 0; i < populationCount; i++){
            int v = 0;
            int w = 0;
            
            for(int j = 0; j < chromosomeLength; j++){
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
