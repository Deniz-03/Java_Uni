/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package veranstaltungen;

/**
 * Diese Klasse repräsentiert verschiedene Veranstaltungen, die Raeumen
 * zugewiesen werden können. Sie hat einen Namen, sowie eine Anzahl an 
 * Teilnehmenden.
 * 
 * */
public class Veranstaltung {
    /**Der Name der Veranstaltung.*/
    private String name;
    /**Die Anzahl der teilnehmenden Personen.*/
    private int teilnehmer;
    
    
    /**
     * Der Konstruktor für die Klasse.
     * 
     * @param name Der Name der Veranstaltung.
     * @param teilnehmer Die Anzahl der teilnehmenden Personen.
     */
    public Veranstaltung(String name, int teilnehmer) {
        this.name = name;
        this.teilnehmer = teilnehmer;   
    }
    
    /**Gibt Zugriff auf den Namen der Veranstaltung.
     *@return Der Name der Veranstaltung
     */
    public String getName() {
        return name;
    }
    
    /**Gibt Zugriff auf die Anzahl der Teilnehmenden.
     * @return Die Anzahl der teilnehmenden Personen
     */
    public int getTeilnehmer() {
        return teilnehmer;
    }
}
 