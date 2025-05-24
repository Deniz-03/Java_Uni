
package Telefonbuch;
import java.util.Scanner;
public class Telefonbuch {
    private Telefonnr user;
    private Telefonnr[] telefonbuch;

    public Telefonbuch(Telefonnr user, Telefonnr[] contacts) {
        this.user = user;
        this.telefonbuch = contacts;
    }

    public void addcontact(Telefonnr t) {
        //Telefonbuch wird um einen weiteren Kontakt erweitert.

        int currentlength;
        Telefonnr[] contacts;
        if (this.telefonbuch == null) {
            currentlength = 1;
            contacts = new Telefonnr[currentlength];
            contacts[currentlength-1] = t;
        } else {
            currentlength = this.telefonbuch.length;
            contacts = new Telefonnr[currentlength+1];

            for(int i = 0; i < currentlength; i++) {
            contacts[i] = telefonbuch[i];
            }

            contacts[currentlength] = t;
        }
        

        this.telefonbuch = contacts;
    }

    public void printTelefonbuch() {
        for(Telefonnr element : this.telefonbuch) {
            System.out.print("* " + element.getName() + ": ");
            this.user.printContactNr(element);
        }
    } 

    public static void main(String[] args) {
        //Anlegen vom Benutzer
        Telefonnr deniz = new Telefonnr("49", "172", "534818", "Deniz");
        Telefonbuch vondeniz = new Telefonbuch(deniz, null);
        //

        //Kontake erstellen

        //Tim
        Telefonnr tim = new Telefonnr("1", "0600", "557231", "Tim");
        vondeniz.addcontact(tim);
        //Peer
        Telefonnr peer = new Telefonnr("49", "1522", "042156", "Peer");
        vondeniz.addcontact(peer);
        //Vincent
        Telefonnr vincent = new Telefonnr("49", "172", "799038", "Vincent");
        vondeniz.addcontact(vincent);
        //Jonas
        Telefonnr jonas = new Telefonnr("49", "1522", "43265", "Jonas");
        vondeniz.addcontact(jonas);
        //Pepe
        Telefonnr pepe = new Telefonnr("34", "0533", "48894", "Pepe");
        vondeniz.addcontact(pepe);
        //David
        Telefonnr david = new Telefonnr("34", "0112", "79935", "David");
        vondeniz.addcontact(david);
        //Kevin
        Telefonnr kevin = new Telefonnr("1", "0600", "92147", "Kevin");
        vondeniz.addcontact(kevin);


        vondeniz.printTelefonbuch();

    }
    
}
