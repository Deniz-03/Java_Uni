package Telefonbuch;

public class Telefonnr {
    //wegen möglicher führender Nullen als String
    private String ländercode; 
    private String netzvorwahl;
    private String basisnr;
    private String name;

    public Telefonnr(String ländercode, String netzvorwahl, String basisnr, String name) {
        this.ländercode = ländercode;
        this.netzvorwahl = netzvorwahl;
        this.basisnr = basisnr;
        this.name = name;
    }

    public String getLändercode() {
        return ländercode;
    }

    public String getNetzvorwahl() {
        return netzvorwahl;
    }

    public String getBasisnr() {
        return basisnr;
    }

    public String getName() {
        return name;
    }

    public boolean sameLändercode(Telefonnr t) {
        //Ländercodes vergleichen -> true/false
        String ländercode = t.getLändercode();
        boolean same;

        if (this.ländercode.equals(ländercode)) {
            same = true;
        } else {
            same = false;
        }

        return same;

    }

    public boolean sameNetz(Telefonnr t) {
        //Netzvorwahl vergleichen, 
        //falls auch Ländercodegleich ist -> true/false
        String netzvorwahl = t.getNetzvorwahl();
        boolean same;

        if (sameLändercode(t)) {
            if (this.netzvorwahl.equals(netzvorwahl)) {
                same = true;
            } else {
                same = false;
            }
        } else { 
            //Dieser Fall sollte nicht eintreten 
            //und wird an der entsprechenden Stelle berücksichtigt.
            same = false;
            System.out.println("Achtung, unterschiedliche Ländercodes!");
        }

        return same;
    }

    public int cost(Telefonnr t, int minutes) {
        //Kosten berechnen -> double
        //gleiches Land und Netz: 5cnt/min
        int landundNetz = 5;
        //gleiches Land anderes netz: 14cnt/min
        int nurland = 14;
        //unterschiedliche Länder: 35cnt/min
        int uländer = 35;
        int cost;

        if (sameLändercode(t)) {
            if (sameNetz(t)) {
                cost = landundNetz * minutes;
            } else {
                cost = nurland * minutes;
            }
        } else {
            cost = uländer * minutes;
        }

        return cost;
    }

    public void  printContactNr(Telefonnr t) {
        //Land unterschiedlich 
        //print ( '+' + Ländercode + Netzvorwahl + BasisNr )
        //Land gleich print ( 0 + Netzvorwahl + BasisNr )
        String netzvorwahl = t.getNetzvorwahl();
        String basisnr = t.getBasisnr();
        String nr;
        if (sameLändercode(t)) {
            nr = "(0" + netzvorwahl + basisnr + ")";
        } else  {
            String ländercode = t.getLändercode();
            nr = "(+" + ländercode + netzvorwahl + basisnr + ")";
        }
        System.out.println(nr);
    }


}
