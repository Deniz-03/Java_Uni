/**
 *@author Deniz Rahnefeld (409637)
 *@author Peer Schulze (410246)
 */
package list;

/**
 * Diese Klasse erzeugt eine Verkettete Liste und verwendet 
 * dabei generische Objekttypen.
 * 
 * @param <T> Der Objekttyp der Elemente die in der Liste 
 *          gespeichert werden sollen.
 * 
 */
public class Liste<T> {
    /**
     * Dieses Attribut verweist auf den Startpunkt der Liste.
     */
    private Element start;
    
    
    /**
     * Der Konstruktor initialisiert die Liste, in dem er den Startpunkt setzt.
     * 
     * @param object Das Objekt, das den Startpunkt markieren soll.
     */
    public Liste(T object) {
        start = new Element(object);
    }
    
    
    /**
     * Diese Methode erlaubt den Zugriff auf das Start Element der Liste.
     * 
     * @return start Das verpackte Objekt an Index 0. 
     */
    public Element getStart() {
        return start;
    }
    /**
     * Diese Methode findet das letzte Element der Liste und gibt es aus.
     * 
     * @return object Das letzte verpackte Element der Liste.
     */
    private Element last() {
        Element current = this.start;
        /*
         * Die Schleife laueft solange, bis das naechste Element null ist.
         * Dieses wird danach zurueck gegeben.
         */
        while (current.getNext() != null) {
            current = current.getNext();
        }
        
        return current;
    }
    
    /**
     * Diese Methode haengt ein neues Objekt an die Liste an und vergrößert
     * sie dadurch auch automatisch.
     * 
     * @param object Das Objekt, das zur Liste Hinzugefügt werden soll.
     */
    public void append(T object) {
        //Das Objekt wird erst verpackt,
        Element element = new Element(object);
        //und dann an die Liste gehangen.
        this.last().setNext(element);  
    }
    
    /**
     * Diese Methode erlaubtden Zugriff auf das Objekt an Index i.
     * 
     * @param i Der Index vom Objekt, das zurueck gegeben werden soll.
     * 
     * @return Das unverpackte Objekt an der Stelle i
     */
    public T getObjectAtIndex(int i) {
        /*
         * Ich nutze hier trotz Iteration eine do-while, da 
         * ich mehr Kontrolle ueber die Abbruchbedingung haben moechte
         * (Falls das naechste Element Null ist soll abgebrochen werden).
         */
        
        int count = 0; 
        Element current = this.start;
        
        while (current.getNext() != null && count < i) {
            current = current.getNext();
            count++;
        }
        
        return current.get();
    } 
    
    
    /**
     * Diese Methode entfernt das gegebene Element aus der Liste.
     * 
     * @param object Das Objekt, das aus der Liste entfernt werden soll.
     */
    public void deleteElement(T object) {
        Element current = this.start;
        if (object.equals(start.get())) { //Wenn das Objekt das erste ist.
            start = start.getNext();
        } else {
        
            while (current.getNext().get() != object 
                    && current.getNext() != null) {
                
                current = current.getNext();
                
            }
            /*
             * Wenn das gegebene Objekt in der Liste enthalten ist,
             * dann ist jetzt current das Element vor dem Objekt,
             * das entfernt werden soll.
             */
            if (current.getNext() == null) {
                System.out.println("Das gegebene Objekt ist nicht"
                        + " in der Liste entalten.");
            } else {
                /*
                 * .getNext().getNext() ist das 
                 * uebernaechste Element in der Liste.
                 * Das bedeutet, dass hier die Referenz auf das uebernaechste
                 * Element weitergeleitet wird. 
                 * Damit gibt es dann keine Referenz
                 * mehr auf das zu loeschende Objekt.
                 */
                current.setNext(current.getNext().getNext());
            }
            
        }
    }
    
    /**
     * Diese private Klasse wird genutzt um ein Objekt zu verpacken, sodass
     * es auf das naechste Element in der Liste zeigt.
     * 
     */
    public class Element {
        
        /**
         * Das Objekt das verpackt werden soll.
         */
        private T object;
        /**
         * Das Objekt auf das verwiesen werden soll.
         */
        private Element nextObject;
        
        /**
         * Dieser Konstruktor verpackt das gegebene Objekt in eine neue
         * Instanz, die eine Referenz auf den Nachfolger hat.
         * 
         * @param object Das Objekt was verpackt werden soll.
         */
        public Element(T object) {
            this.object = object;
            this.nextObject = null;
        }
   
        /**
         * Diese Methode erlaubt den Zugriff auf das verpackte Objekt.
         * 
         * @return object Das unverpackte Objekt.
         * 
         */
        public T get() {
            return this.object;
        }
        
        /**
         * Diese Methode erlaubt den Zugriff auf das naechste Element.
         * 
         * @return nextObject das verpackte naechste Objekt in der Liste.
         */
        public Element getNext() {
            return this.nextObject;
        }
        
        /**
         * Diese Methode erstellt eine neue Referenz auf das naechste Element
         * fuer das gespeicherte Objekt.
         * 
         * @param object Ein bereits verpacktes Objekt auf das verwiesen
         *               werden soll.
         */
        public void setNext(Element object) {
            this.nextObject = object;
        }
    }
    
}
