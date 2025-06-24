/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package email;

/**
 * Diese Klasse repraesentiert Emails mit Absender, Betreff und Inhalt.
 */
public class Email {
    /**
     * Diese Instanz vom Typ Emailadresse
     * speichert den Absender der Email.
     */
    private Emailadresse absender;
    /**
     * Dieser String speichert den Betreff der Email.
     */
    private String betreff;
    /**
     * Dieser String speichert den Inhalt der Email.
     */
    private String inhalt;
    
    /**
     * Dieser Konstruktor erstellt eine Email mit Absender, Betreff und Inhalt.
     * 
     * @param absender Eine Instanz vom Typ Absender.
     * @param betreff Ein String.
     * @param inhalt Ein String.
     */
    public Email(Emailadresse absender, String betreff, String inhalt) {
        this.absender = absender;
        this.betreff = betreff;
        this.inhalt = inhalt;
    }
    
    /**
     * Diese Methode erlaubt den Zugriff auf den Absender.
     * 
     * @return absender Ein String, der den Absender repraesentiert.
     */
    public String getAbsender() {
        return this.absender.getAdress();
    }
    
    /**
     * Diese Methode erlaubt den Zugriff auf den Betreff.
     * 
     * @return betreff Eine String.
     */
    public String getBetreff() {
        return this.betreff;
    }
    
    /**
     * Diese Methode erlaubt den Zugriff auf den Inhalt.
     * 
     * @return inhalt Eine String.
     */
    public String getInhalt() {
        return this.inhalt;
    }
    
    /**
     * Diese Methode gibt entweder dieg gesamte Email, oder nur Absender
     * und Betreff in der Konsole aus.
     * 
     * @param content Ein Boolean der anzeigt, ob die gesamte Email ausgegeben
     *            werden soll.
     * 
     */
    public void printEmail(boolean content) {
        System.out.println(absender.getAdress());
        System.out.println(betreff);
        if (content) {
            System.out.println(inhalt);
        } 
    }
    
    
}
