/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.lang.System.*;
import java.util.*;
/**
 *
// * @author KaMyLuS
 */
public class Evolution implements Runnable {
    Item items[]; // tablica z przedmiotami
    int itemCount; // ile przedmiotow <=> dlugosc chromosomu
    int populationCount; // liczebnosc populacji
    int generationsLimit; // maksymalna ilość pokoleń (populacji)
    int knapsackCapacity; // pojemnosc plecaka
    boolean repair; // czy stosujemy funkcje naprawy
    boolean punish; // czy stosujemy funkcje kary
    private double maxItemPriority; // max(wartosc_przedmiotu/waga_przedmiotu)
    double elitismFactor; // wspolczynnik elitarnosci
    double crossFactor; // wspolczynnik krzyzowania
    double mutationFactor; // wspolczynnik mutacji
    Population population[] = new Population[2]; // populacja (obecna i poprzednia ?)
    Genome bestGenomeEver; //najlepszy genom ever

    PunishFitness evalPunishFunction; // funkcja obliczajaca przystosowanie i kare
    RepairFitness evalRepairFunc;
    SelectionMethod selectFunction; // funkcja selekcji osobnikow
    CrossoverMethod crossoverFunction; // funkcja odpowiedzialna za krzyzowanie

    private List listeners = new ArrayList();
    private EvolutionSummary summary;
    private Boolean running = false;

    long executionTimeInMilliseconds = 0;

    public Evolution(Item items[], int itemCount, int populCount, int generationsLimit, int knapCapac, boolean rep, double
            elitFac, double crossFac, double mutFac, PunishFitness evalPunishFunc, RepairFitness repairFunc,
            SelectionMethod selectFunc, CrossoverMethod crossFunc){
        this.items = items; // moze lepiej zrobic kopiowanie zamiast tego ?
        this.itemCount = itemCount;
        populationCount = populCount;
        this.generationsLimit = generationsLimit;
        knapsackCapacity = knapCapac;
        // TODO! to zdecydowanie wymaga zastanowienia i refactoringu.
        repair = rep && (repairFunc != null);
        punish = !repair && (evalPunishFunc != null);
        elitismFactor = elitFac;
        crossFactor = crossFac;
        mutationFactor = mutFac;

        evalPunishFunction = evalPunishFunc;
        evalRepairFunc = repairFunc;
        selectFunction = selectFunc;
        crossoverFunction = crossFunc;

        population[0] = new Population(this, populationCount, itemCount);
        population[1] = new Population(this, populationCount, itemCount);

        maxItemPriority = 0;
        for(Item item: items)
            maxItemPriority = Math.max(maxItemPriority, item.value/item.weigth);
    }

    // inicjalizacja - wygenerowanie 1szej losowej populacji itp.
    public void init(){
        population[1].genRandomPop();
        population[1].calcValWeigth(items);
        summary = new EvolutionSummary(this);
    }

    // ewolucja (max_gener - maksymalnie do tego pokolenia ewoluujemy)
    public void evolve(int max_gener){
        CompareGenome compare = new CompareGenome();
        long start, stop;
        executionTimeInMilliseconds = 0;
        running = true;

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

            start = System.currentTimeMillis();
            population[0] = new Population(population[1]);

            // ocenianie populacji i sprawy z tym zwiazane
            population[0].calcValWeigth(items);
            double sum = 0, minn = 0, maxx = 0;
            int minIndex = 0, maxIndex = 0;

            for(int j = 0; j < populationCount; j++){
                if (punish) population[0].chromosomes[j].setAdaptation(evalPunishFunction.evaluate(population[0].chromosomes[j].getValue(),
                            population[0].chromosomes[j].getWeigth(), knapsackCapacity, maxItemPriority));
                else if (repair) evalRepairFunc.evaluate(population[0].chromosomes[j], knapsackCapacity, items);

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

            population[0].findBestGenomeIndex();

            if(bestGenomeEver == null)
                bestGenomeEver = getBestGen();
            else if(compare.compare(getBestGen(), bestGenomeEver) < 0) //do Kamila: zmienić to, wg API jak a<b to b jest lepsze! (albo zaznaczyć, że to reverseComparator)
                bestGenomeEver = getBestGen();


            // elitarnosc
            int eliteCount = (int)(elitismFactor*populationCount);
            boolean sorted = false;
            if(eliteCount > 0){
                Arrays.sort(population[0].chromosomes, compare);
                population[0].setBestIndex(0);

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

            // obliczanie czasu wykonania
            stop = System.currentTimeMillis();
            executionTimeInMilliseconds += (stop - start);

            // notifing listeners every iteration
            synchronized(this) {
                if (! running) {
                    try {
                        this.wait();
                    } catch (InterruptedException ex) {}
                }

                /* wymagana konstrukcja, żeby można użyć Thread#interrupt()
                 * bez ryzyka pojawienia się nowych danych na wykresie */
                if (running)
                    fireEvolutionChanged(i);
            }
        }
    }

    // in milliseconds
    public long getExecutionTime() {
        return executionTimeInMilliseconds;
    }

    Genome getBestGenomeEver() {
        return bestGenomeEver;
    }

    Population getPrimaryPopulation() {
        return population[0];
    }

    public Item[] getItems() {
        return items;
    }

    public int getGenerationsLimit() {
        return generationsLimit;
    }

    Genome getBestGen(){
        return population[0].chromosomes[population[0].getBestIndex()];
    }

    private synchronized void fireEvolutionChanged(int i) {
        summary.update(i);

        Iterator listener = listeners.iterator();
        while (listener.hasNext())
            ((EvolutionListener) listener.next()).updateReceived(summary);
    }

    public void addListener(EvolutionListener l) {
        listeners.add(l);
    }

    public void removeListener(EvolutionListener l) {
        listeners.remove(l);
    }

    @Override
    public void run() {
        init();
        evolve(generationsLimit);
    }

    public synchronized void pause() {
        running = false;
    }

    public synchronized void resume() {
        running = true;
        this.notifyAll();
    }
}
