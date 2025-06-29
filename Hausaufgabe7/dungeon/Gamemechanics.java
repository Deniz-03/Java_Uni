/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package dungeon;

import java.util.InputMismatchException;
import java.util.Scanner;
import gegner.Ork;
import raum.Raum;
import raum.Thronsaal;

/**
 * In dieser Klasse werden alle Methoden zusammen gefasst, die zur
 * Spielverlauf beitragen.
 */
public class Gamemechanics {
    
    /**
     * Ein Integer, der zaehlt in welchen Raum wir uns befinden.
     */
    private int room;
    
    /**
     * Diese Variable bestimmt, ob man den Dungeon verlaesst
     * und damit ob der Gameloop abgebrochen wird.
     */
    private boolean gameloop;
    
    
    /**
     * Der Konstruktor initialisiert den Gameloop boolean und setzt
     * den room counter auf 0.
     */
    public Gamemechanics() {
        this.gameloop = true;
        this.room = 0;
    }
    
    /**
     * Diese Methode erlaubt den Zugriff auf den Index des aktuellen Raums.
     * 
     * @return room Ein Integer, der Index des aktuellen Raums.
     */
    public int getRoom() {
        return this.room;
    }
    
    /**
     * Diese Methode erlaubt den Zugriff auf den Gameloop boolean.
     * 
     * @return gameloop ein Boolean, der anzeigt, ob der Gameloop weiterlaueft.
     */
    public boolean getGameloop() {
        return this.gameloop;
    }
    
    /**
     * Diese Methode ist dazu da, um das Ziel fuer einen Einzelangriff
     * auszuwaehlen.
     * 
     * @param scanner Eine Instanz vom Typ Scanner.
     * @param orks Ein Array mit allen Orks die aktuell im Raum sind.
     * 
     * @return Eine Instanz vom Typ Ork.
     */
    public Ork zielFuerAngriff(Scanner scanner, Ork[] orks) {
        System.out.println("Welchen Ork moechtest du Angreifen?");
        boolean korrekteEingabe = false;
        int ziel = 0;
        //Wiederholt bis korrekte Eingabe getaetigt wurde.
        do {
            try {
               
                ziel = scanner.nextInt();
                if (ziel > orks.length) {
                    throw new IllegalArgumentException();
                } else {
                    korrekteEingabe = true;  
                }
               
               
            } catch (InputMismatchException e) {
                System.out.println("Eingabe ist keine gueltige Zahl.");
            } catch (IllegalArgumentException e) {
                System.out.println("Keine gueltige Option ausgewaehlt.");
            }
        } while (!korrekteEingabe);
        return orks[ziel - 1];
    }
    
    /**
     * Diese Methode schaut welche Optionen verfuegbar sind und gibt sie als
     * String Array zurueck.
     * 
     * @param zustand Ein Integer, der den aktuellen Zustand des Dungeons
     *                beschreibt.
     *                Case 1: Im Kampf und Heiltrank
     *                Case 2: Im Kampf ohne Heiltrank
     *                Case 3: Kein Kampf, es gibt einen naechsten Raum
     *                Case 4: Kein Kampf, es gibt keinen naechsten Raum,
     *                        Schatz wurde noch nicht gelooted
     *                Case 5: Kein Kampf, es gibt keinen naechsten Raum, 
     *                        Schatz wurde gelooted.
     *                        
     * @param raeume Das Array in dem die Raeume des Dungeons 
     *               zusammengefasst werden.
     * 
     * @return opt Ein Array mit Strings, die die moeglichen Optionen 
     *             repraesentieren.
     */
    public String[] getOpt(int zustand, Raum[] raeume) {
        
        String[] opt = null; 
        String opt1 = "Einzelangriff";
        String opt2 = "Flaechenangriff";
        String opt3 = "Heiltrank verwenden";
        String opt5 = "Dungeon verlassen";
        String opt6 = "Schatz pluendern";
        
        switch (zustand) {
        case 1:
            String[] options1 = {opt1, opt2, opt3};
            opt = options1;
            break;
        case 2:
            String[] options2 = {opt1, opt2};
            opt = options2;
            break;
        case 3:
            //Opt4 wird erst hier initialiiert um IndexOutOfBounds zu vermeiden
            String opt4 = raeume[room + 1].getOpt();
            String[] options3 = {opt4, opt5};
            opt = options3;
            break;
        case 4:
            String[] options4 = {opt6, opt5};
            opt = options4;
            break;
        case 5:
            String[] options5 = {opt5};
            opt = options5;
            break;
        default:
            break;
        }
        
        return opt; 
    }
    
    /**
     * Diese Methode ermittelt einen von 5 Zustaenden waehrend des Spiels.
     * 
     * Zustand 1: Im Kampf und Heiltrank
     * Zustand 2: Im Kampf ohne Heiltrank
     * Zustand 3: Kein Kampf, es gibt einen naechsten Raum
     * Zustand 4: Kein Kampf, es gibt keinen naechsten Raum,
     *            Schatz wurde noch nicht gelooted
     * Zustand 5: Kein Kampf, es gibt keinen naechsten Raum, 
     *            Schatz wurde gelooted.
     * 
     * @param spieler Die aktive Instanz des Spielers.
     * @param raeume Ein Array mit allen Raeumen im Dungeon.
     *
     * @return zustand Ein Integer der einen von 5 Zustaenden beschreibt.
     * 
     * 
     */
    public int getZustand(Spieler spieler, Raum[] raeume) {
        int zustand;
        boolean imKampf = true;
        if (raeume[room].getOrks().length == 0) {
            imKampf = false;
        }
        if (imKampf) { //Kampfsituation
            if (spieler.getHeiltrank()) { //Heilen moeglich?
                zustand = 1; 

            } else {
                zustand = 2;
            }
        } else { //Keine Kampfsituation
            if (room < raeume.length - 1) { //gibt es einen naechsten Raum?
                zustand = 3;
            } else { //Spieler befindet sich im Bossraum
                Thronsaal t = (Thronsaal) raeume[room];
                if (!t.getLooted()) { //Schatz noch nicht gepluendert.
                    System.out.println("Aktuelle Punktzahl: " 
                            + spieler.getGold());
                    zustand = 4;
                } else { //Schatz gepluendert.
                    System.out.println("Aktuelle Punktzahl: " 
                            + spieler.getGold());
                    zustand = 5;
                }
            }
        }
        return zustand;
    }
    
    /**
     * Diese Methode ist das interaktive Menu fuer den Spieler.
     * Hier wird der Spieler zur Eingabe aufgefordert, wodurch das
     * Spielgeschehen gesteuert wird.
     * 
     * 
     * @param scanner Eine Instanz vom Typ Scanner
     * @param zustand Ein Integer, der den aktuellen Zustand des Dungeons
     *                repraesentiert.
     * @param raeume Das Array in dem die Raeume des Dungeons 
     *               zusammengefasst werden.
     *               
     * @return output Ein Integer, der im Gameloop verwendet wird, um die 
     *                Entscheidungen vom Spieler zu berücksichtigen.
     */
    public int menuInput(Scanner scanner, int zustand, Raum[] raeume) {
        int output = 0; //Default Wert ist keine gueltige Option
        System.out.println("Was möchtest du tun?");
        String[] opt = getOpt(zustand, raeume);

        //Listet moegliche Optionen auf.
        for (int i = 0; i < opt.length; i++) {
            System.out.println("    " + (i + 1) + ") " + opt[i]);
        }
        
        boolean korrekteEingabe = false;
         //Wiederholt bis korrekte Eingabe getaetigt wurde.
        do {
            try {
                
                output = scanner.nextInt();
                if (output < 1 || output > opt.length) {
                    throw new IllegalArgumentException();
                }
                korrekteEingabe = true;
                
            } catch (InputMismatchException e) {
                System.out.println("Eingabe ist keine gueltige Zahl.");
            } catch (IllegalArgumentException e) {
                System.out.println("Keine gueltige Option ausgewaehlt.");
            }
        } while (!korrekteEingabe);
        return output;
    }
    
    /**
     * Diese Methode fuehrt eine Aktion basierend auf Zustand und Input aus.
     * 
     * @param zustand Ein Integer der einen von 5 Zustaenden beschreibt.
     * @param spieler Der aktive Spieler im Dungeon.
     * @param scanner Die zentrale Scanner Instanz fuer das Spiel.
     * @param in Ein integer. Der input vom Spieler
     * @param raeume Das Array in dem die Raeume des Dungeons 
     *               zusammengefasst werden.
     */
    public void action(int zustand, Spieler spieler, int in, Scanner scanner,
            Raum[] raeume) {
        Ork[] orks = raeume[room].getOrks();        
        switch (zustand) {
        case 1: //Heiltrank und im Kampf
            if (in == 1) {
                Ork ork = this.zielFuerAngriff(scanner, orks);
                spieler.angreifenZiel(ork);
                if (ork.istTot()) {
                    raeume[room].removeOrk(ork);
                }
                
                
            } else if (in == 2) {
                spieler.flaechenangriff(orks);
                //ueberpruefen ob einer der orks tot ist
                for (int i = 0; i < orks.length; i++) {
                    if (orks[i].istTot()) {
                        raeume[room].removeOrk(orks[i]);     
                    }  
                }
            } else if (in == 3) {
                spieler.heilen();
            }
            this.orkAction(spieler, raeume);
            break;
            
        case 2://Im Kampf ohne Heiltrank
            if (in == 1) {
                Ork ork = this.zielFuerAngriff(scanner, orks);
                spieler.angreifenZiel(ork);
                if (ork.istTot()) {
                    raeume[room].removeOrk(ork);
                }

            } else if (in == 2) {
                spieler.flaechenangriff(orks);
                for (int i = 0; i < orks.length; i++) {
                    if (orks[i].istTot()) {
                        raeume[room].removeOrk(orks[i]);     
                    }  
                }
            }
            
            this.orkAction(spieler, raeume);
            break;
            
        case 3: //Außerhalb eines Kampfes
            if (in == 1) {
                raeume[room + 1].betreten();
                this.room += 1;
            } else if (in == 2) {
                this.gameloop = false;
            }
            break;
            
        case 4: //Boss besiegt noch nicht gelooted
            if (in == 1) {
                Thronsaal t = (Thronsaal) raeume[room];
                int gold = t.loot();
                spieler.addGold(gold);
            } else if (in == 2) {
                this.gameloop = false;
            }
            break;
            
        case 5://Boss besiegt und gelooted
            if (in == 1) {
                this.gameloop = false;
            } 
            break;
        default:
            break;
        }   
    }
    
    /**
     * Diese Methode laesst alle uebrigen Orks zum Zug kommen.
     * 
     * @param spieler Die aktive Instanz vom Typ Spieler.
     * @param raeume Das Array in dem die Raeume des Dungeons 
     *               zusammengefasst werden.
     */
    public void orkAction(Spieler spieler, Raum[] raeume) {
        Ork[] orks = raeume[room].getOrks();
        for (Ork ork : orks) {
            /*Wenn Orkkoenigin Unterstuetzug ruft, 
             *dann wird das an dieser Stelle beruecksichtigt,
             *da ork.angreifen ein Array an Orks zurueck geben kann, wenn
             *die Orkkoenigin die Methode das erste mal aufruft.
             */
            raeume[room].addOrks(ork.angreifen(spieler));
        }
    }
    
    /**
     * Diese Methode wird nach dem Gameloop aufgerufen und zeigt das Ergebnis
     * des Spiels.
     * 
     * @param spieler Die aktive Instanz vom Typ Spieler.
     */
    public void gameover(Spieler spieler) {
        System.out.println("----");
        if (spieler.istTot()) {
            System.out.println("Du bist gestorben und "
                    + "verlierst all dein Gold :(");
        } else {
            System.out.println("Herzlichen Glueckwunsch! Du hast "
                    + spieler.getGold() + " Gold gesammelt.");
        }
        
    }
    
    /**
     * Diese Methode prueft, ob der Gameloop weitergehen soll.
     * 
     * @param spieler Die aktive Instanz vom Typ Spieler.
     * 
     * 
     */
    public void checkGameloop(Spieler spieler) {
        if (spieler.istTot()) {
            this.gameloop = false;
        } else if (!this.gameloop) {
            this.gameloop = false;
        } else {
            this.gameloop = true;
        }
    }
    
}
