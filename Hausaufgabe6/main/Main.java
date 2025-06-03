/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package main;
import raeume.*;
import veranstaltungen.Veranstaltung;
import java.util.Scanner;

/**
 * In dieser Hauptklasse befindet sich das Hauptprogramm und die main Funktion.
 * Hier werden alle Klassen miteinander verknüpft, sodass am Ende
 * das gewünschte Programm entsteht.
 */
public class Main {
    
    /**
     * Diese Methode lässt den User eine Veranstaltung erzeugen.
     * 
     * @param uInput Ein Scanner, der vom User input annimmt.
     * 
     * @return Eine fertige Instanz der Klasse Veranstaltung oder null, wenn
     *         der User das Programm beenden möchte.
     */
    public static Veranstaltung createVeranstaltung(Scanner uInput) {
        String veranstaltungsname;
        int teilnehmerZahl;
        Veranstaltung newV;
        System.out.println("Veranstaltungsname: ");
        veranstaltungsname = uInput.nextLine();
        //Überprüfung ob das Programm enden soll.
        if (!veranstaltungsname.equalsIgnoreCase("ende")) {
            System.out.println("Teilnehmerzahl: ");
            teilnehmerZahl = uInput.nextInt();
            uInput.nextLine(); //nach nextInt nötig
            System.out.println();
            newV = new Veranstaltung(veranstaltungsname, teilnehmerZahl);
        } else {
            System.out.println();
            newV = null;
        }
        return newV;

    }
    
    
    /**
     * Die Hauptmethode, die das Programm asuführt, das Veranstaltungen Räume
     * zuordnet.
     * 
     * @param args Kann hier ignoriert werden. Ist nur Formalität.
     */
    public static void main(String[] args) {
        //Initialisierung
        Scanner uInput = new Scanner(System.in);
        boolean ende = false;
        
        //Erstellung der Raeume.
        Raum allgRaum1 = new Raum(30);
        Raum allgRaum2 = new Raum(45);
        
        Raum sem1 = new Seminarraum(30);
        Raum sem2 = new Seminarraum(30);
        Raum sem3 = new Seminarraum(45);
        Raum sem4 = new Seminarraum(60);
        
        Raum h1 = new Hoersaal(250);
        
        Raum bspR1 = new Besprechungsraum(10);
        Raum bspR2 = new Besprechungsraum(10);
        Raum bspR3 = new Besprechungsraum(10);
        Raum bspR4 = new Besprechungsraum(10);
        
        Raum wsR1 = new Workshopraum(20);
        Raum wsR2 = new Workshopraum(30);
        
        Raum[] raeume = {allgRaum1, allgRaum2, sem1, sem2, sem3, sem4,
                         h1, bspR1, bspR2, bspR3, bspR4, wsR1, wsR2};
        
        //Gebaeude wird mit dem Array der Raeume erstellt.
        Gebaeude g1 = new Gebaeude(raeume);

        //Hier beginnt das eigentliche Programm.
        System.out.println("Willkommen zum Raumzuweisungsprogramm!");
        System.out.println();
        System.out.println("Bitte geben Sie die Veranstaltungen ein.");
        System.out.println("Geben Sie \"Ende\" ein," 
                + "um die Eingabe zu beenden.");
        System.out.println();
        
        do {
            boolean zugewiesen = true;
            Veranstaltung currentV = createVeranstaltung(uInput);
            if (currentV == null) {
                ende = true;


                System.out.println("Übersicht der Raumbelegungen: ");
                System.out.println();

                g1.overview();

            } else {
                zugewiesen = g1.raumZuweisen(currentV);
                if (!zugewiesen) {
                    System.out.println("Kein passender Raum für '" 
                            + currentV.getName() + "' mit " 
                            + currentV.getTeilnehmer() 
                            + " Teilnehmenden gefunden.");
                    System.out.println();
                }
                
            } 
            
        } while (!ende);
        
        
        
        
        
    }

}
