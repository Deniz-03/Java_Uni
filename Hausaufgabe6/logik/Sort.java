/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package logik;
import raeume.Raum;

/**
 * Dies ist eine Hilfsklasse, die dabei hilft 
 * das Array der Raeume zu sortieren.
 */
public class Sort {
    
    
    /**
     * Diese Funktion tauscht zwei Elemente an den Indizes i und j miteinander.
     * 
     * @param raeume Eine Feld mit Instanzen vom Typ Raum.
     * @param i Der erste Index.
     * @param j Der zweite Index.
     */
    public static void swap(Raum[] raeume, int i, int j) {
        Raum temp = raeume[i];
        raeume[i] = raeume[j];
        raeume[j] = temp;
    }
    
    
    /**
     * Diese Methoed findet den Index des kleinsten Raums innerhalb des Arrays.
     * 
     * @param raeume Das Array in dem gesucht werden soll.
     * @param start Der Index ab dem gesucht werden soll.
     * 
     * @return Der Index vom kleinsten Raum im (Teil)Array.
     * 
     * 
     */
    public static int findMin(Raum[] raeume, int start) {

        int index = start;
        
        //Hier wird die kleinste Sitzplatzanzahl gespeichert.
        int smallest = raeume[index].getSitzplaetze();

        for (int i = start; i < raeume.length; i++) { 

            if (raeume[i].getSitzplaetze() < smallest) {
                smallest = raeume[i].getSitzplaetze();
                index = i;
                
            }
        }
        
        return index;
    }
    
    
    /**
     * Diese Methode sortiert ein Array von Raeumen
     * in aufsteigender Reihenfolge.
     * 
     * @param raeume Das Array, das sortiert werden soll. 
     *               Muss vom Typ Raum[] sein 
     * @param start Eine Hilfsvariable, die für die Rekursion wichtig ist.
     *              Beim verwenden der Funktion 
     *              sollte 0 als Startindex verwendet werden. 
     *              Es sei denn nur ein Teil des Arrays soll sortiert werden.
     *              
     *@return Ein aufsteigend sortiertes Array vom Typ Raum[].
     *                      
     *                 
     */
    public static Raum[] selectionSort(Raum[] raeume, int start) {
        Raum[] sortedRaeume = raeume;
        
        if (start != raeume.length - 1) {

            int index = findMin(sortedRaeume, start);
            swap(sortedRaeume, start, index);
            selectionSort(sortedRaeume, start + 1);

        } 
        
        return sortedRaeume;
        
    }
    
    

}
