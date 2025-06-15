/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package gegner;
import dungeon.Spieler;

/**
 * Diese Klasse stellt den Standardgegner im Dungeon dar.
 */
public class Ork {
    /**
     * Diese Variable zählt die lebenspunkt des Orks.
     */
    protected int lebenspunkte;
    /**
     * Diese variable legt den Trefferschaden fest und kann nach der
     * Erstellung nicht mehr verändert werden.
     */
    protected int trefferschaden;
    /**
     * Diese Variable legt die Beutemenge fest und kann nach der 
     * Erstellung nicht mehr verändert werden.
     */
    protected int beute;
    
    
    /**
     * Konstruktor der Klasse.
     */
    public Ork() {
        this.lebenspunkte = 10;
        schaden(); //Der Trefferschaden wird hier festgelegt.
        beute(); //Die Beutemenge wird hier festgelegt.
    }
    
    
    /**
     * Diese Methode erzeugt einen Wert zwischen 2-4, der dem Spieler
     * an Lebenspunkten abgezogen werden soll.
     */
    private void schaden() {
        double chance = Math.random();
        int dmg;
        if (chance <= (1.0 / 3.0)) {
            dmg = 2;
        } else if (chance > (1.0 / 3.0) && chance <= (2.0 / 3.0)) { 
            dmg = 3; 
        } else {
            dmg = 4;
        }
        
        this.trefferschaden = dmg;
    }
    
    /**
     * Diese Methode erzeugt einen Wert zwischen 0 und 100, 
     * der die größe der fallengelassenen Beute repräsentiert.
     */
    protected void beute() {
        int loot = (int) (Math.random() * 101); // -> [0,100]
        this.beute = loot;
    }  
    
    /**
     * Diese Methode fügt dem Ork Schaden zu.
     * 
     * @param dmg Ein Integerwert der den Lebenspunkten abgezogen werden soll.
     * 
     * @return gold Ein Integer, der die Beute repraesentiert, falls der 
     *              Ork stirbt. Ansonsten 0
     */
    public int dealDmg(int dmg) {
        this.lebenspunkte = this.lebenspunkte - dmg;
        System.out.println("AHHHHR!!");
        int gold = 0;
        if (this.istTot()) {
            System.out.println("Ork wurde besiegt und hinterlaesst " 
                    + this.beute + " Gold.");
            gold = this.beute;
            
        }
        return gold;
    }
    
    /**
     * Diese Methode wird verwendet, um einem Spieler schaden zuzufuegen.
     * 
     * @param spieler Eine Instanz vom Typ Spieler.
     * 
     * @return orks In diesem Fall ein leeres Array. Wichtig fuer Unterklasse.
     */
    public Ork[] angreifen(Spieler spieler) {
        double chance = Math.random();
        if (chance <= (80.0 / 100.0)) { 
            //erfolgreiche Trefferwahrscheinlichkeit.
            System.out.println("Ork fuegt Spieler " 
                    + this.trefferschaden + " zu");
            spieler.dealDmg(this.trefferschaden);
        }
        return null;
    }
    
    
    
    /**
     * Diese Methodde überprüft, ob der Ork noch lebt.
     * 
     * @return istTot Ein Boolean, der anzeigt, ob der Ork tot ist.
     */
    public boolean istTot() {
        boolean istTot = true;
        if (this.lebenspunkte > 0) {
            istTot = false;
        }
        return istTot;
        
    }
    
    /**
     * Diese Methode gibt Informationen ueber den Ork zurück.
     * 
     * @return Ein String der Informationen ueber die Art des Orks, sowie
     *          dessen lebenspunkte enthält.
     */
    public String printDetails() {
        return "Ork (" + this.lebenspunkte + " LP)";
    }
    
}
