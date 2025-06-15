/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package gegner;

import dungeon.Spieler;

/**
 * Eine spezialisierung der Klasse Ork. Diese Klasse repräsentiert den Boss im 
 * Dungeon.
 */
public class Orkkoenigin extends Ork {
    /**
     * Diese Boolean zeigt an, ob noch Unterstuetzung gerufen werden kann.
     */
    private boolean unterstuetzungRuf;
    
    /**
     * Dieser Konstruktor legt die Attributwerte für die Orkkoenigin fest.
     */
    public Orkkoenigin() {
        this.lebenspunkte = 25;
        this.unterstuetzungRuf = true;
        this.trefferschaden = 5;
        beute();
    }
    
    /**
     * Mit dieser Methode kann einmalig Unterstuetzung fuer die Orkkoenigin
     * gerufen werden.
     * 
     * @return orks Ein Array mit 2 Instanzen vom Typ Ork,
     *              oder ein leeres Array ab dem zweiten Aufruf der Methode.
     */
    public Ork[] rufeUnterstuetzung() {
        Ork[] orks = new Ork[2];
        if (this.unterstuetzungRuf) {
            orks[0] = new Ork();
            orks[1] = new Ork();
        }
        return orks;
    }
    
    /**
     * Diese Methode wird verwendet, um einem Spieler schaden zuzufuegen,
     * zusaetzlich wird, falls moeglich, Unterstuetzung gerufen.
     * 
     * @param spieler Eine Instanz vom Typ Spieler.
     * 
     * @return mehrOrks Ein Array mit den zusaetzlichen Orks,
     *                  die gerufen werden koennen.
     */
    @Override
    public Ork[] angreifen(Spieler spieler) {
        Ork[] mehrOrks = null;
        if (unterstuetzungRuf) {
            mehrOrks = rufeUnterstuetzung();
            this.unterstuetzungRuf = false;
        }
        double chance = Math.random();
        if (chance <= 80.0 / 100.0) { //erfolgreiche Trefferwahrscheinlichkeit.
            System.out.println("Orkkoenigin fuegt Spieler " 
                    + this.trefferschaden + " zu");
            spieler.dealDmg(this.trefferschaden);
        }
        return mehrOrks;
        
    }
    
    
    /**
     * Diese Methode erzeugt einen Wert zwischen 0 und 200, 
     * der die größe der fallengelassenen Beute repräsentiert.
     */
    @Override
    protected void beute() {
        int loot = (int) (Math.random() * 201); // -> [0,200]
        this.beute = loot;
    }
    
    /**
     * Diese Methode gibt Informationen ueber den Ork zurück.
     * 
     * @return Ein String der Informationen ueber die Art des Orks, sowie
     *          dessen lebenspunkte enthält.
     */
    @Override
    public String printDetails() {
        return "Orkkoenigin (" + this.lebenspunkte + " LP)";
    }
    
    
    
}
