/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package email;

/**
 * Diese Klasse repraesentiert eine Emailadresse.
 * Diese hat folgendes Format [String]@[String].[String]
 */
public class Emailadresse {
    /**
     * Der String vor dem @ Symbol.
     */
    private String name;
    
    /**
     * Der String nach dem @ und vor der Endung.
     */
    private String anbieter;
    
    /**
     * Der String, der die Endung repraesentiert. Z.B. com/de
     */
    private String endung;
    
    /**
     * Der Konstruktor fuegt mehrere Strings zu einer Emailadresse zusammen.
     * 
     * @param name Ein String.
     * @param anbieter Ein String.
     * @param endung Ein String.
     */
    public Emailadresse(String name, String anbieter, String endung) {
        this.name = name;
        this.anbieter = anbieter;
        this.endung = endung;
    }
    
    /**
     * Diese Methode gibt einen String zurueck in Form einer vollstaendigen 
     * Emailadresse.
     * 
     * @return adress Ein String.
     */
    public String getAdress() {
        String adress = name + "@" + anbieter + "." + endung;
        return adress;
    }
    
}   
