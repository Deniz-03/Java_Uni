/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package email;
import list.Liste;

import java.util.InputMismatchException;
import java.util.Scanner;

 /**
  * Diese Klasse enthaelt das Hauptprogramm.
  */
public class Mailverwalter {
    
    /**
     * Diese Methode filtert die Liste der Emails
     * nach einem gegebenen Kriterium. Alle Emails, die dieses Kriterium
     * erfuellen werden entfernt.
     * 
     * @param emailListe Eine Liste von Emails.
     * @param filter Das Filterkriterium in Form einer Funktion.
     * 
     */
    public static void filterMails(Liste<Email> emailListe, 
            MailFilter filter) {
        Liste<Email>.Element current = emailListe.getStart();
        Liste<Email>.Element toBeDeleted = emailListe.getStart();
        while (current.getNext() != null) {
            /*
             * Hier wird mit 2 Variablen gearbeitet, 
             * denn wenn current geloescht wird, 
             * kann man kein current.getNext() ausfuehren, daher wird 
             * erst ein Element weiter iteriert, dann wird das Element
             * geloescht und dann wird die Hilfsvariabel geupdated.
             */
            current = current.getNext();
            if (filter.istErfuellt(toBeDeleted.get())) {
                emailListe.deleteElement(toBeDeleted.get());
            }
            toBeDeleted = current;
        }
    }
    
    /**
     * Diese Methode gibt alle Emails in der Konsole aus, dabei kann
     * entschieden werden, ob nur die Absender und Betreffe oder auch
     * die Inhalte ausgegeben werden sollen.
     * 
     * @param emailListe Eine Liste von Emails.#
     * @param inhalt Dieser Boolean bestimmt ob auch der Inhalt ausgegeben 
     *               werden soll.
     */
    public static void printAllElements(Liste<Email> emailListe, 
            boolean inhalt) {
        Liste<Email>.Element current = emailListe.getStart();
        while (current.getNext() != null) {
            current.get().printEmail(inhalt);
            System.out.println();
            current = current.getNext();
        }
    }
    
    /**
     * Diese Methode ist laesst den Nutzer zwischen 4 Optionen auswaehlen.
     * 1) Filtern nach Absender
     * 2) Filtern nach Betreff
     * 3) Filtern nach Inhalt
     * 4) beenden.
     * 
     * @param scanner Die zentrale Scanner Instanz im Programm.
     * 
     * @return input Dieser Integer bestimmt nach welcher Art gefiltert werden
     *               soll.
     */
    public static int menu(Scanner scanner) {
        System.out.println("Was moechtest du tun?");
        System.out.println("1) Filtern nach Absender");
        System.out.println("2) Filtern nach Betreff");
        System.out.println("3) Filtern nach Inhalt");
        System.out.println("4) beenden");
        
        boolean korrekteEingabe = false;
        int input = -1;
        do {
            try {
               
                input = scanner.nextInt();
                if (input > 4 || input < 1) {
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
        
        return input;
    }
    
    /**
     * Diese Methode fragt den Nutzer nach einem Stichwort nach dem 
     * dann in der jeweiligen Kategorie entsprechend sortiert werden soll.
     * 
     * @param scanner Die zentrale Scanner Instanz im Programm.
     * @param input Dieser Integer zeigt an innerhalb welcher Kategorie
     *              gefiltert werden soll.
     *              
     * @return keyword Der String nach dem in der entsprechenden Kategorie 
     *                 gefiltert werden soll.
     */
    public static String keyword(Scanner scanner, int input) {
        scanner.nextLine(); //Da vorher der Input eingelesen wurde.
        String keyword = null;
        switch (input) {
        case 1:
            System.out.println("Wessen Emails sollen rausgefiltert werden?");
            keyword = scanner.nextLine();
            break;
        case 2:
            System.out.println("Mit welchem Wort "
                    + "sollen die Betreffe beginnen?");
            keyword = scanner.nextLine();
            break;
        case 3: 
            System.out.println("Welches Wort soll im Inhalt enthalten sein?");
            keyword = scanner.nextLine();
            break;
        case 4:
            break;
        default:
            break;
        }
        
        return keyword;
        
    }
    
    /**
     * Diese Methode gibt der filterMails Methode das passende Keyword und 
     * eine anonyme Funktion, die als Filter Kriterium verstanden werden kann.
     * 
     * @param emailListe Eine verkettete Liste vom Typ Email
     * @param input Ein Integer, der bestimmt 
     *              welcher Filter angewendet werden soll.
     * @param keyword Ein String, nach dem in der entsprechenden Kategorie
     *                gefiltert werden soll.
     *                
     * @return runnig Dieser Boolean zeigt an, ob das Programm weiterlaufen 
     *                soll.
     */
    public static boolean filterCriterium(Liste<Email> emailListe,
            int input, String keyword) {
        boolean running = true;
        switch (input) {
        case 1:
            filterMails(emailListe, 
                    mail -> mail.getAbsender().equals(keyword));
            
            break;
        case 2:
            filterMails(emailListe, 
                    mail -> !mail.getBetreff().startsWith(keyword));
            break;
        case 3: 
            filterMails(emailListe, 
                    mail -> !mail.getInhalt().contains(keyword));
            break;
        case 4:
            printAllElements(emailListe, true);
            running = false;
            break;
        default:
            break;  
        }
        return running;
    }
    
    /**
     * Die Main Methode.
     * 
     * @param args Kann hier ignoriert werden.
     */
    public static void main(String[] args) {  
        
        Liste<Email> emailListe = EmailListe.initialize();
        printAllElements(emailListe, false);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        do {
            int input = menu(scanner);
            String keyword = keyword(scanner, input);
            running = filterCriterium(emailListe, input, keyword);
            if (running) {
                printAllElements(emailListe, false);
            }
        } while (running);
        
        
    }

}