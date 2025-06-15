/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package raum;
import gegner.*;

/**
 * Eine spezialisierung der Oberklasse Raum. Diese Klasse ist der Bossraum
 * im Dungeon.
 */
public class Thronsaal extends Raum {
    /**
     * Diese Variable repräsentiert den Schatz,
     * den man in diesem Raum looten kann.
     */
    private int schatz;
    /**
     * Dieser Boolean zeigt an, ob der Raum gelooted wurde.
     */
    private boolean looted;
    
    
    /**
     * Dieser Konstruktor ruft den Konstruktor der Oberklasse Raum auf,
     * der Schatz wird auf 1000 Gold gesetzt und looted auf false.
     * 
     */
    public Thronsaal() {
        super();
        this.schatz = 1000;
        this.looted = false;
    }
    
    /**
     * Diese Methode spawnt die Orkkoenigin beim Betreten.
     * 
     */
    @Override
    public void betreten() {
        Ork[] mehrOrks = {new Orkkoenigin()};
        this.addOrks(mehrOrks);   
    }
    
    /**
     * Diese Methode gibt einen String zurück, der Informationen über den 
     * Raumtyp enthält und im menu verwendet wird.
     * 
     * @return Ein String, der im Menu verwendet werden soll.
     */
    @Override
    public String getOpt() {
        return "Thronsaal betreten.";
    }
    
    /**
     * Diese Methode gibt den Integerwert, des Schatzes zurueck.
     * Der Schatz wird also gelooted.
     * 
     * @return schatz der Integer, der die Goldmenge des Schatzes
     *                repraesentiert.
     */
    public int loot() {
        System.out.println("Spieler pluendert den Schatz "
                + "und erhaelt 1000 Gold!");
        this.looted = true;
        return schatz;
    }
    
    /**
     * Diese Methode gibt den Wert von looted zurueck.
     * 
     * @return looted Ein Boolean.
     */
    public boolean getLooted() {
        return this.looted;
    }
    
    
    
}
