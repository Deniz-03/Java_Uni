/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package raum;
import gegner.Ork;

/**
 * Das ist die Oberklasse für die verschiedenen Raumtypen im Textadventure.
 */
public abstract class Raum {
    /**
     * Die Gegner die in dem Raum warten.
     */
    private Ork[] orks; 
    
    /**
     * Der Konstruktor erstellt ein leeres Array von Orks, das
     * spaeter aufgefüllt wird.
     */
    public Raum() {
        this.orks = new Ork[0];
    }
    
    /**
     * Diese Methode gibt die Liste der Orks zurück.
     * 
     * @return orks Ein Array mit 0-3 Instanzen vom Typ Ork.
     */
    public Ork[] getOrks() {
        return this.orks;
    }
    
    /**
     * Diese Methode gibt eine Liste mit allen Orks im Raum
     * in der Konsole aus und zeigt, wie viel Lebenspunkte diese noch haben.
     */
    public void printOrks() {
        for (int i = 0; i < this.orks.length; i++) {
            System.out.println("    " + (i + 1) + ") " 
                    + this.orks[i].printDetails());
        }
    }
    
    /**
     * Diese Methode wird in den Unterklassen überschrieben und dient
     * der Polymorphie.
     * 
     * @return Ein String mit folgender Form:
     *         '(naechsten) [Raumtyp] betreten'
     */
    public abstract String getOpt();

    /**
     * Erzeugt 0-3 Orks für den Raum.
     */
    public void betreten() {
        double chance = Math.random();
        if (chance <= (1.0 / 4.0)) { //Chance auf 0 Orks
            System.out.println("Du hast Glück! Die Schlafkammer ist frei.");
            //chance auf 1 Ork.
        } else if (chance > (1.0 / 4.0) && chance <= (2 / 4)) { 
            System.out.println("Ein Ork versperrt dir den Weg.");
            Ork[] mehrOrks = {new Ork()};
            this.addOrks(mehrOrks);
            //chance auf 2 Orks.
        } else if (chance > (2.0 / 4.0) && chance <= (3.0 / 4.0)) { 
            System.out.println("Orks versperren dir den Weg.");
            Ork[] mehrOrks = {new Ork(), new Ork()};
            this.addOrks(mehrOrks);
            //chance auf 3 Orks.
        } else if (chance > (3.0 / 4.0) && chance <= (4.0 / 4.0))  { 
            System.out.println("Orks versperren dir den Weg.");
            Ork[] mehrOrks = {new Ork(), new Ork(), new Ork()};
            this.addOrks(mehrOrks);
        }
    }
    
    /**
     * Diese Methode fügt Orks zum Raum hinzu. Diese Methode ist wichtig für
     * die Orkkoenigin, die Unterstuetzung rufen kann.
     * 
     * @param moreOrks Ein Array, dass Instanzen vom Typ Ork enthält.
     */
    public void addOrks(Ork[] moreOrks) {
        /*
         * Da diese Funktion jedes mal aufgerufen wird wenn Orks etwas machen,
         * soll sie nur ausgeführt werden, wenn auch wirklich ein Array und 
         * nicht null uebergeben wird.
         */
        if (moreOrks != null) {
            int orkslength;
            if (this.orks != null) {
                orkslength = this.orks.length;
            } else {
                orkslength = 0;
            }
            int length = moreOrks.length + orkslength;
            Ork[] mehrOrks = new Ork[length];
            for (int i = 0; i < orkslength; i++) {
                mehrOrks[i] = this.orks[i];
            }
            int j = 0;
            for (int i = orkslength; i < length; i++) {
                mehrOrks[i] = moreOrks[j];
                j++;
            }
            this.orks = mehrOrks;
        }
    }
    
    /**
     * Diese Methode entfernt den Ork der als Parameter uebergeben wurde
     * aus dem Array.
     * 
     *  @param ork Eine Instanz vom Typ Ork, die aus dem Array entfernt werden
     *             soll.
     */
    public void removeOrk(Ork ork) {
        Ork[] wenigerOrks = new Ork[this.orks.length - 1];
        int index = 0;
        for (int i = 0; i < this.orks.length; i++) {
            if (this.orks[i] != ork) {
                wenigerOrks[index] = this.orks[i];
                index += 1;
            }
          
        }
        this.orks = wenigerOrks;
        
        
    }
    
    
    
}
