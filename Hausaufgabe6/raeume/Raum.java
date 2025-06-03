/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package raeume;
import veranstaltungen.Veranstaltung;


/**
 * Diese Klasse implementiert allgemeine Raeume, die fuer Veranstaltungen
 * genutzt werden können. Jeder Raum hat eine Anzahl an Sitzplaetzen und 
 * kann eine Veranstaltung zugewiesen haben, ansonsten ist der Raum frei.
 * 
 */
public class Raum {
    /**Die Anzahl der Sitzplaetze wird hier gespeichert.*/
    private int sitzplaetze;
    /**Die entsprechende Veranstaltung wird in dieser Variable gespeichert.*/
    private Veranstaltung veranstaltung;
    
    /**Der Konstruktor, für den Fall, dass Sitzlaetze und Veranstaltung.
     * bereits bekannt sind
     * @param sitzplaetze Die Anzahl der Sitzplaetze des Raums.
     * @param veranstaltung Eine Veranstaltung, die den Raum belegt.
     * 
     */
    public Raum(int sitzplaetze, Veranstaltung veranstaltung) {
        this.sitzplaetze = sitzplaetze;
        this.veranstaltung = veranstaltung;
    }
    
    /**Wenn beim Erstellen des Raums nur die Anzahl der Sitzplaetze
     *gegeben wird, wird dieser Konstruktor aufgerufen.
     *
     *@param sitzplaetze Die Anzahl der Sitzplaetze des Raums.
     */
    public Raum(int sitzplaetze) {
        this.sitzplaetze = sitzplaetze;
        this.veranstaltung = null;
    }
    
    /**Checkt ob der Raum eine Veranstaltung hat.
     * @return Ein Boolean der true ist, wenn der Raum nicht belegt ist
     *         und false, wenn er belegt ist durch eine Veranstaltung.
     */
    public boolean istFrei() {
        boolean frei = false;
        if (this.veranstaltung == null) {
            frei = true;
        }
        return frei;
    }
    
    /**Eine Methode die dem Raum eine Veranstaltung zuweist, 
     *wenn dieser frei ist. 
     *Zusätzlich wird innerhalb der Methode geschaut, ob der Raum frei ist
     *und ob die Anzahl der Sitzplaetze mit der Anzahl der Teilnehmenden passt.
     *
     *@param v Eine Veranstaltung, die dem Raum zugewiesen werden soll.
     *
     *@return zugewiesen: Ein Boolean, der anzeigt, 
     *                   ob die Zuweisung erfolgreich war.
     *                   
     */
    public boolean zuweisen(Veranstaltung v) {
        boolean zugewiesen = false;
        if (v.getTeilnehmer() <= sitzplaetze && this.istFrei()) {
            this.veranstaltung = v;
            zugewiesen = true;
        } 
        return zugewiesen;
    }
    
    /**
     * Eine Methode, um die Anzahl der Sitzplaetze zu bekommen.
     * 
     * @return Ein Integer, der die Anzahl der sitzplaetze
     *         repräsentiert.
     */
    public int getSitzplaetze() {
        return sitzplaetze;
    }
    
    /**
     * Eine Methode, um die zugewiesene Veranstaltung zu bekommen.
     * 
     * @return  Eine Instanz der Klasse Veranstaltung, oder null.
     */
    public Veranstaltung getVeranstaltung() {
        return veranstaltung;
    }
    
    /**Gibt Zugriff auf den Namen des Raumtyps.
     * 
     * @return Der Name des Raumtyps
     */
    public String getName() {
        return "Allgemeiner Raum";
    }
    
}
