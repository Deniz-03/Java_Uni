/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package raeume;

import veranstaltungen.Veranstaltung;

/**
 * Eine Spezialfall eines Raums in einem Gebäude.
 */
public class Seminarraum extends Raum {
    
    /**
     *der Konstruktor ruft den Konstruktor, der Oberklasse auf und gibt die
     *Parameter einfach weiter.
     *
     *@param sitzplaetze Die Anzahl an Sitzplaetzen.
     *@param veranstaltung Eine zugewiesene Veranstaltung zu diesem Raum.
     */
    public Seminarraum(int sitzplaetze, Veranstaltung veranstaltung) {
        super(sitzplaetze, veranstaltung);
    }
    
    /**
     *der Konstruktor ruft den Konstruktor, der Oberklasse auf und gibt die
     *Parameter einfach weiter. In diesem Fall gibt es keine Veranstaltung.
     *
     *@param sitzplaetze Die Anzahl an Sitzplaetzen.
     *    
     */
    public Seminarraum(int sitzplaetze) {
        super(sitzplaetze);
    }

    /**Gibt Zugriff auf den Namen des Raumtyps.
     * @return Der Name des Raumtyps.
     */
    @Override
    public String getName() {
        return "Seminarraum";
    }
    
    

}
