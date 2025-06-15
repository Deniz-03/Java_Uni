/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package dungeon;
import gegner.Ork;


/**
 * Diese Klasse repräsentiert den Spieler, der sich durch das Dungeon kämpft.
 */
public class Spieler {
    /**
     * Diese Variable zeigt an wie viel Lebenspunkte, der Spieler noch hat.
     */
    private int lebenspunkte;
    /**
     * Dieser Boolean zeigt an, ob der Spieler noch einen Heiltrank hat.
     */
    private boolean heiltrank;
    /**
     * Diese Variable zählt das Gold, das der Spieler gesammelt hat.
     */
    private int gold;
    
    /**
     * Der Konstruktor der Klasse Spieler nimmt keine Parameter entgegen,
     * da alle Attribute Default-Werte haben.
     * 
     * 
     */
    public Spieler() {
        this.lebenspunkte = 50;
        this.heiltrank = true;
        this.gold = 0;
    }
    
    /**
     * Diese Methode gibt Information über die Lebenspunkte des Spielers
     * in der Konsole aus.
     */
    public void printSpieler() {
        System.out.println("Spieler hat " + this.lebenspunkte 
                + "Lebenspunkte.");
    }
    
    /**
     * Eine Methode, um zu ueberpruefen,
     * ob der Spieler noch einen Heiltrank hat.
     * 
     * @return heiltrank Ein boolean, der anzeigt, 
     *                   ob Heiltrank verwendet wurde.
     */
    public boolean getHeiltrank() {
        return this.heiltrank;
    }
    
    
    /**
     * Diese Funktion ermittelt den Schadenswert für die Angriffsmethoden.
     * 
     * @return dmg Ein Integer aus der Menge {0, 6 ,9}
     */
    private static int dmgCalc() {
        double chance = Math.random();
        int dmg;
        if (chance > (5.0 / 100.0)) { //erfolgreicher Angriff
            chance = Math.random();
            if (chance <= (10.0 / 100.0)) { //critical Hit
                System.out.println("Kritisch:");
                dmg = 9;
            } else { //normaler Hit
                dmg = 6;
            }
        } else {
            System.out.println("Daneben: ");
            dmg = 0;
        }
        
        return dmg;
    }
    
    /**
     * Diese Methode lässt den Spieler einen einzelnen Ork angreifen.
     * Erfolgschance des Angriff: 95%
     * Krit. Chance: 10% (9 statt 6 Schaden).
     * 
     * @param ork Der Ork dem Schaden zugefügt werden soll.
     */
    public void angreifenZiel(Ork ork) {
        int dmg = dmgCalc();
        if (dmg != 0) {
            /*
             * Wenn der Ork bei dem Angriff stirbt wird das Gold
             * dem Spieler gegeben. Ansonsten werden 0 Gold hinzugefuegt.
             */
            System.out.println("Spieler fuegt Ork " + dmg + " Schaden zu.");
            this.addGold(ork.dealDmg(dmg));
        }

    }
    
    
    /**
     * Diese Methode startet einen Flächenangriff auf die Orks im Raum.
     * Der Schaden dabei wird gleichmäßig auf alle Orks verteilt.
     * 
     * @param orks Ein Array mit 0-3 Instanzen vom Typ Ork.
     */
    public void flaechenangriff(Ork[] orks) {
        int dmg = (int) (dmgCalc() / orks.length); 
        System.out.println("Spieler fuegt allen Orks " + dmg + " Schaden zu.");
        for (Ork ork : orks) {
            /*
             * Wenn der Ork bei dem Angriff stirbt wird das Gold
             * dem Spieler gegeben. Ansonsten werden 0 Gold hinzugefuegt.
             */
            this.addGold(ork.dealDmg(dmg));
        }   
    }
    
    
    /**
     * Diese Methode stellt 15 Lebenspunkte wieder her - auch über das Maximum
     * von 50 hinaus. Diese Methode kann nur einmal pro Spiel genutzt werden.
     * 
     */
    public void heilen() {
        if (this.heiltrank) {
            this.lebenspunkte += 15;
            this.heiltrank = false;
            System.out.println("Der Spieler trinkt seinen Heiltrank" 
                    + "und erhaelt 15 LP");
        }
    }
    
    
    
    /**
     * Diese Methode überprüft, ob der Spieler noch lebt.
     * 
     * @return istTot Ein boolean der anzeigt, ob der Spieler tot ist.
     */
    public boolean istTot() {
        boolean istTot = true;
        if (this.lebenspunkte > 0) {
            istTot = false;
        }
        return istTot;
    }
    
    /**
     * Diese Methode fügt dem Spieler Schaden zu.
     * 
     * @param dmg Ein Integerwert der den Lebenspunkten abgezogen werden soll.
     */
    public void dealDmg(int dmg) {
        this.lebenspunkte = this.lebenspunkte - dmg;
    }
    
    /**
     * Diese Methode ermöglicht es dem Spieler Gold zu sammeln.
     * 
     * @param gold Ein Integer, um den die Goldmenge erhöht werden soll.
     */
    public void addGold(int gold) {
        this.gold += gold;
    }
    
    /**
     * Diese Methode gibt Auskunft ueber die Goldmenge des Spielers.
     * 
     * @return gold Ein Integer, der die Goldmenge repraesentiert.
     */
    public int getGold() {
        return this.gold;
    }
    
}
