/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author KaMyLuS
 */
public interface CrossoverMethod extends GeneticOperator {
    /* funkcja wykonujaca crossover, parametry:
     * population - populacja na ktorej wykonujemy krzyzowanie
     * populCount - liczebnosc populacji
     * crossFactor - wspolczynnik krzyzowania
     * pointCount - ile punktow przeciecia
     * crossFrom - indeksy o >= numerze bierzemy pod uwage przy krzyzowaniu,
     *   wczesniejszych wogole nie uwzgledniamy (przydatne gdy chcemy zachowac
     *   w niezmienionej postaci najlepsze osobniki)
     */
    public void crossover(Population population, int populCount, double crossFactor, int pointCount, int crossFrom);
}
