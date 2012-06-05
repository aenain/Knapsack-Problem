/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author KaMyLuS
 */
public interface SelectionMethod extends GeneticOperator {
    // funkcja wyboru, parametry:
    // source - populacja wejsciowa, 
    // dest - populacja wynikowa, 
    // populCount - liczebnosc populacji,
    // selectCount - ile osobnikow trzeba wybrac, 
    // selectFrom - indeks osobnika w source od ktorego nalezy brac pod uwage przy wyborze - wczesniejszych wogole nie bierzemy
    // sorted - czy wejsciowa populacja jest posortowana (malejaco) )
    public void select(Population source, Population dest, int populCount, int selectCount, int selectFrom, boolean sorted);
}
