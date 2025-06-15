/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package main;
import dungeon.Dungeon;

/**
 * Hier wird nur der Dungeon gestartet.
 */ 
public class Main {
    
    /**
     * Die Main Methode.
     * 
     * @param args Kann hier ignoriert werden.
     */
    public static void main(String[] args) {
        Dungeon d = new Dungeon();
        d.starten();
    }

}
