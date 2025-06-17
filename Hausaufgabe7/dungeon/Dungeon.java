/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package dungeon;
import raum.*;
import java.util.Scanner;


/**
 * Diese Klasse organisiert die Raeume des Dungeon und den Spieler, der
 * sich durch die Raeume bewegt.
 */
public class Dungeon {
    /**
     * Ein Array mit den Raeumen des Dungeons.
     */
    private Raum[] raeume; 
    

    
    /**
     * Diese Methode initialisiert das Dungeon und ist der zentrale Ort, wo
     * das Spiel organisiert ist.
     */
    public void starten() {
        //Das Dungeon wird mit Raeumen gefüllt.
        raeume = new Raum[5];
        for (int i = 0; i < 4; i++) {
            raeume[i] = new Schlafkammer(); 
        }
        raeume[4] = new Thronsaal();
        
        //Ein Spieler wird erstellt.
        Spieler spieler = new Spieler();
        //Erste Anweisungen und Begrüßung.
        System.out.println("Willkommen im Dungeon!");
        System.out.println();
        System.out.println("Du betrittst die 1. Schlafkammer:");        

        
        /*
         * Eine zentrale Scannervariable für das Spiel.
         */
        Scanner scanner = new Scanner(System.in);
        
        /*
         * Eine Instanz fuer Gamemechanics wird erstellt.
         */
        Gamemechanics gM = new Gamemechanics();
        
        //Der erste Raum wird automatisch betreten.
        raeume[gM.getRoom()].betreten();
        

        //Gameloop
        do {
            System.out.println("----");
            raeume[gM.getRoom()].printOrks(); //Orks werden ausgegeben.
            spieler.printSpieler(); //Spieler + Lebenspunkte wird ausgegeben.
            System.out.println();
            //Zustand wird ueberprueft.
            int zustand = gM.getZustand(spieler, raeume);
            /*
             * Zustand 1: Im Kampf und Heiltrank
             * Zustand 2: Im Kampf ohne Heiltrank
             * Zustand 3: Kein Kampf, es gibt einen naechsten Raum
             * Zustand 4: Kein Kampf, es gibt keinen naechsten Raum,
             *            Schatz wurde noch nicht gelooted
             * Zustand 5: Kein Kampf, es gibt keinen naechsten Raum, 
             *            Schatz wurde gelooted. 
             */
            
            //Basierend auf dem Zustand wird das Menu aufgerufen.
            int in = gM.menuInput(scanner, zustand, raeume);
            
            //Aktion durch Zustand und Input auswaehlen.
            gM.action(zustand, spieler, in, scanner, raeume);
            
            //Es wird geguckt, ob der Gameloop weitergehen kann.
            gM.checkGameloop(spieler);

        } while (gM.getGameloop());
        
        /*
         * Wenn das Spiel zu Ende ist, werden Punkte ausgegeben oder 
         * es wird ausgegeben dass man gestorben ist.
         */
        
        gM.gameover(spieler);
        
    }
    
}