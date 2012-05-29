/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.lang.System.*;
/**
 *
 * @author KaMyLuS
 */
public class Population {
    public static final CompareGenome reverseComparator = new CompareGenome();

    int populationCount; // liczebnosc populacji
    int chromosomeLength; // dlugosc chromosomu
    Genome chromosomes[]; // chromosomy calej poszczegolnych osobnikow
    double worst, aver, best; // najgorsza, srednia, najlepsza wartosc przystosowania osobnikow
    int worstIndex, bestIndex; // nr najgorszego i najlepszego osobnika
    private Evolution evolution;

    public Population(Evolution evolution, int pc, int cl){
        this.evolution = evolution;
        populationCount = pc;
        chromosomeLength= cl;
        chromosomes = new Genome[populationCount];
    }

    public Population(Population source){
        populationCount = source.populationCount;
        chromosomeLength = source.chromosomeLength;
        evolution = source.getEvolution();
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

    int getWorstIndex(){
        return worstIndex;
    }

    double getAver(){
        return aver;
    }

    double getBest(){
        return best;
    }

    public void findBestGenomeIndex() {
        int bestGenomeIndex = 0;
        Genome bestGenome = chromosomes[0];

        for (int i = 1; i < populationCount; i++) {
            if (reverseComparator.compare(bestGenome, chromosomes[i]) > 0) {// TODO! zmienić jeśli zmieni sie comparator!
                bestGenome = chromosomes[i];
                bestGenomeIndex = i;
            }
        }

        this.bestIndex = bestGenomeIndex;
    }

    int getBestIndex(){
        return bestIndex;
    }

    int getChromosomeLength(){
        return chromosomeLength;
    }

    public Evolution getEvolution() {
        return evolution;
    }

    //-----------------------

    // ustawienie wartosci

    void setWorst(double w){
        worst = w;
    }

    void setWorstIndex(int i){
        worstIndex = i;
    }

    void setAver(double a){
        aver = a;
    }

    void setBest(double b){
        best = b;
    }

    void setBestIndex(int i){
        bestIndex = i;
    }

    //---------------------------

    // generowanie losowej populacji
    void genRandomPop(){
        for(int i = 0; i < populationCount; i++){
            chromosomes[i] = new Genome(this, chromosomeLength);
            chromosomes[i].genRandomChrom();
        }
    }

    // obliczanie wagi i wartosci dla calej populacji
    void calcValWeigth(Item sub[]){
        for(int i = 0; i < populationCount; i++){
            int v = 0;
            int w = 0;

            for(int j = 0; j < chromosomeLength; j++){
                if(chromosomes[i].hasItem(j)){
                    v += sub[j].getValue();
                    w += sub[j].getWeigth();
                }
            }

            chromosomes[i].setValue(v);
            chromosomes[i].setWeigth(w);
        }
    }
}
