/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package raum;

/**
 * Eine spezialisierung der Oberklasse Raum. Diese Klasse ist der Standardraum
 * im Dungeon.
 */
public class Schlafkammer extends Raum {
   /**
    * Ruft nur den Super-Konstruktor auf.
    */
    public Schlafkammer() {
        super();
    }
    
    /**
     * Diese Methode gibt einen String zurück, der Informationen über den 
     * Raumtyp enthält und im menu verwendet wird.
     * 
     * @return Ein String, der im Menu verwendet werden soll.
     */
    @Override
    public String getOpt() {
        return "Naechste Schlafkammer betreten.";
    }
}
