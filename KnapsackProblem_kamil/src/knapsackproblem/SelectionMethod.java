/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackproblem;

/**
 *
 * @author KaMyLuS
 */
public interface SelectionMethod {
    // funkcja wyboru (source - populacja wejsciowa, dest - populacja wynikowa
    // selectCount - ile osobnikow trzeba wybrac, selectFrom - indeks osobnika w source 
    // od ktorego nalezy brac pod uwage przy wyborze - wczesniejszych wogole nie bierzemy
    // sorted - czy wejsciowa populacja jest posortowana (malejaco) )
    void select(Population source, Population dest, int selectCount, int selectFrom, boolean sorted);
}
