/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package raeume;
import veranstaltungen.Veranstaltung;
import logik.Sort;


/**
 * Diese Klasse organsisiert eine Gruppe von Raeumen in einem Feld(Array).
 */
public class Gebaeude {
    /**Dieses Feld(Array) wird alle Raeume in diesem Gebaeude beinhalten.
     * und organisieren
     */
    private Raum[] raeume;
    
    /**
     * Der Konstruktor der Klasse, dieser sortiert die Raeume vorher nach
     * Anzahl der Sitzplaetze und speichert diese dann im Array raeume.
     * 
     * @param raeume Ein sortiertes Array mit Instanzen von der Klasse Raum.
     */
    public Gebaeude(Raum[] raeume) {
        this.raeume = Sort.selectionSort(raeume, 0);
    }
    
    /** Gibt zugriff auf das Arraymit dem Räumen.
     * @return Ein Array mit allen Raeumen, die zum Gebaeude gehören.
     */
    public Raum[] getRaeume() {
        return raeume;
    }

    /**
     * Diese Methode gibt eine Übersicht über die Raumbelegungen.
     */
    public void overview() {
        for (Raum raum : raeume) {
            System.out.print(raum.getName() + " mit " 
                    + raum.getSitzplaetze() + " Sitzplätzen: ");
            if (raum.istFrei()) {
                System.out.println(" frei");
            } else {
                System.out.println("Veranstaltung '" 
                        + raum.getVeranstaltung().getName() + "'");
            }
        }
    }
    
    /**
     * Diese Funktion nimmt eine Veranstaltung entgegen und versucht sie einem
     * Raum innerhalb des Gebäudes zuzuweisen.
     * Dabei wird darauf geachtet, dass der Raum möglichst klein ist,
     * genug Sitzplaetze bietet und frei ist.
     * 
     * @param v Eine Veranstaltung, die einem Raum zugewiesen werden soll.
     * 
     * @return Ein Boolean, der true ist, wenn die Zuweisung erfolgreich war
     *         und ansonsten false ist.
     */
    public boolean raumZuweisen(Veranstaltung v) {
        boolean zugewiesen = false;
        for (Raum raum : raeume) {
            zugewiesen = raum.zuweisen(v);
            if (zugewiesen) {
                System.out.println("Veranstaltung '" 
                        + v.getName() + "' mit " 
                        + v.getTeilnehmer() + " Teilnehmenden wurde dem '" 
                        + raum.getName() + "' mit " 
                        + raum.getSitzplaetze() + " Sitzplätzen zugewiesen.");
                System.out.println();

                /*
                 *Ich habe mich hier bewusst für ein break entschieden,
                 *da ich eine for-Schleife geeigneter finde, 
                 *um durch ein Array zu iterieren,
                 *als eine Do-While oder While Schleife, wo man
                 *die Abbruch-Bedinung auch logisch in die Schleife integrieren
                 *könnte. Deswegen finde ich, dass in 
                 *diesem Fall die Lesbarkeit nicht verschlechtert wird, 
                 *sondern verbessert.
                 */
                break; 
            }
            
        }
        return zugewiesen;
    }
    
    
}
