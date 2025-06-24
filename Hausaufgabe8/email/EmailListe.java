/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package email;

import list.Liste;

/**
 * Diese Klasse lagert nur den Initialisierungscode aus.
 */
public class EmailListe {
    
    /**
     * Diese Methode erzeugt eine Liste von Emails.
     * 
     * @return liste Eine Liste von Emails.
     */
    public static Liste<Email> initialize() {
        //Initialisierung von Absendern
        Emailadresse abs1 = new Emailadresse("peer", "gmail", "com");
        Emailadresse abs2 = new Emailadresse("musterfrau", 
                "uni-hildesheim", "de");
        Emailadresse abs3 = new Emailadresse("tim", "gmail", "com");
        Emailadresse abs4 = new Emailadresse("newsletter", "shop", "de");
        Emailadresse abs5 = new Emailadresse("noreply", "amazon", "com");
        
        //Betreffe
        String betreff1 = "Rechnung fuer Ihren Einkauf";
        String betreff2 = "Top Angebote nur heute!";
        String betreff3 = "Kino heute";
        String betreff4 = "Naechste Sitzung";
        String betreff5 = "Herzlichen Glueckwunsch!";
        String betreff6 = "Hausaufgaben";
        String betreff7 = "Bestellung";
        
        //Inhalte teilweise von ChatGPT generiert.
        String inhalt1 = "Im Anhang finden Sie Ihre Rechnung vom 21.06.";
        String inhalt2 = "Sichern Sie sich 50% Rabatt auf Sommermode."; 
        String inhalt3 = "Lust auf Kino heute Abend?"
                + " Hab zwei Karten fuer Oppenheimer.";
        String inhalt4 = "Anbei die Unterlagen fuer die naechste Sitzung.";
        String inhalt5 = "Sie haben gewonnen! "
                + "Bitte fordern Sie Ihren Preis an";
        String inhalt6 = "Kannst du mir deine Loesungen schicken?";      
        String inhalt7 = "Vielen Dank fuer deinen Einkauf! Rechnungsnr: 12345";
        //Emails
        Email email1 = new Email(abs1, betreff6, inhalt6);
        Email email2 = new Email(abs3, betreff3, inhalt3);
        Email email3 = new Email(abs5, betreff1, inhalt1);   
        Email email4 = new Email(abs4, betreff2, inhalt2);
        Email email5 = new Email(abs4, betreff5, inhalt5);
        Email email6 = new Email(abs2, betreff4, inhalt4);
        Email email7 = new Email(abs5, betreff7, inhalt7);

        //Liste
        Liste<Email> liste = new Liste<Email>(email1);
        liste.append(email2);
        liste.append(email3);
        liste.append(email4);
        liste.append(email5);
        liste.append(email6);
        liste.append(email7);
        
        return liste;
    }
}
