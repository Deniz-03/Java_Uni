/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package email;

/**
 * Diese Schnittstelle definiert eine Methode,
 * um eine Liste vom Typ Email nach verschiedenen Kriterien zu filten.
 */
public interface MailFilter {
    /**
     * Diese Methode prueft auf einem Email Obejkt, 
     * ob das Kriterium erfuellt ist. 
     * 
     * @param email Eine Instanz vom Typ Email.
     * 
     * @return boolean Dieser Boolean zeigt an, ob das Kriterium erfuellt ist.
     */
    public boolean istErfuellt(Email email);
}

