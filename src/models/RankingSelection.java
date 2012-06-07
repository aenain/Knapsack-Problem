/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.lang.Math;
import java.util.*;

/**
 *
 * @author KaMyLuS
 */
public class RankingSelection implements SelectionMethod {
    @Override
    public void select(Population source, Population dest, int populCount, int selectCount, int selectFrom, boolean sorted){
        
        // jak nie posortowane, to sortujemy
        CompareGenome compare = new CompareGenome();
        
        Arrays.sort(source.chromosomes, compare);
        source.setBestIndex(0);
        
        /* wybieramy najlepszych:
           10% najlepszych - po 3 kopie
           kolejne 10% - po 2 kopie
           reszta pojedynczo -> czyli w ten sposob przejdzie w sumie ok 80% populacji */
        int tenPercent = selectCount/10;        
        if(tenPercent == 0) tenPercent = 1;
        
        int indDest = selectFrom, indSrc;
        
        // potrojnie najlepsze 10%
        outerLoop1:
        for(indSrc = 0; indSrc < tenPercent; indSrc++){
            for(int i = 0; i < 3; i++){
                if(indDest >= selectFrom+selectCount) break outerLoop1;
                dest.chromosomes[indDest++] = new Genome(source.chromosomes[indSrc]);
            }
        }
        
        // podwojnie kolejne 10%
        outerLoop2:
        for(; indSrc < 2*tenPercent; indSrc++){
            for(int i = 0; i < 2; i++){
                if(indDest >= selectFrom+selectCount) break outerLoop2;
                dest.chromosomes[indDest++] = new Genome(source.chromosomes[indSrc]);
            }
        }
        
        // reszta pojedynczo
        for(; indSrc < populCount; indSrc++)
        {
            if(indDest >= selectFrom+selectCount) break;
            dest.chromosomes[indDest++] = new Genome(source.chromosomes[indSrc]);
        }
    }

    @Override
    public String toString() {
        return "Ranking";
    }

    @Override
    public String toXMLName() {
        return "ranking";
    }
}

