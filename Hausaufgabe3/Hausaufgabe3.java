//Aufgabenblatt: 3, Aufgabe: 1, Peer Schulze (410246), Deniz Rahnefeld (409637)
import java.util.Scanner;

public class Hausaufgabe3 {
    
    public static int value(int grenze) {
        if (grenze < 0) {
            return -1*grenze;
        } else {
            return grenze;
        } 
    }

    public static boolean isprime(int zahl) {
        if (zahl < 2) {
            return false;
        }

        for (int i = zahl-1; i >= 2; i--){
            if (zahl % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int next5thprime(int zahl) {
        int i = 0;
        while (i < 5) {
            zahl++;
            if (isprime(zahl)) {
                i++;
            }
        }
        return zahl;
    }

    public static int repeatInput(Scanner eingabe, int untergrenze) {
        int obergrenze = untergrenze-1;
        do {
            System.out.println("Bitte wiederhole deine Eingabe jetzt.");
            System.out.println("Obergrenze:");
            obergrenze = value(eingabe.nextInt());
        } while (obergrenze <= untergrenze);
        return obergrenze;
    }

    public static int add10(int untergrenze) {
        return untergrenze+10;
    }

    public static int menu(Scanner eingabe, int untergrenze, int obergrenze) { 
        System.out.println("Die Obergrenze liegt nicht " 
                + "über der Untergrenze");
        System.out.println("Was möchtest du tun?");
        System.out.println("Die Obergrenze wird auf die " 
                + "Untergrenze + 10 gesetzt (1)");
        System.out.println("Eingabe wiederholen (2)");
        System.out.println("Obergrenze auf die fünftnächste " 
                + "Primzahl nach der Untergrenze setzen (3)");

        int input = eingabe.nextInt();
        int output;

        switch (input) {
            case 1:
                output = add10(untergrenze);
                break;
            case 2:
                output = repeatInput(eingabe, untergrenze);
                break;
            case 3:
                output = next5thprime(untergrenze);
                break;
            default:
                output = obergrenze;
                break;
        }
        return output;

    }



    
    public static void main(String[] args) {

        /*Logischer Fehler 1:
         * Ein Testfall, der ein Fehlverhalten offenbart,
         * ist wenn man zunächst einfach korrekte Werte für die Untergrenze,
         * sowie die Obergrenze eingibt. Es werden keine Zahlen ausgegeben,
         * die entweder durch 3 oder 5 teilbar sind. Um genau zu sein, werden
         * gar keine Zahlen ausgegeben.
         * 
         * Diesen Fehler kann man beheben, indem man entweder die
         * Textausgaben tauscht vor den Eingaben, 
         * oder die Variablennamen  'obergrenze' und 'untergrenze' tauscht bei
         * der Eingabe. Hier ist also eine Inkonsistenz zwischen den verlangten
         * Werten und den Variablennamen.
         */
        
        /* Logischer Fehler 2:
         * Der 2 Fehler ist auch erkennbar, wenn man bspw. als Untergrenze
         * 3 und als Obergrenze 5 festlegt. Die 3 wird korrekt ausgegeben,
         * abe die 5 nicht. Der Fehler ist hier also, dass die Grenzen
         * unterschiedlich behandelt werden bzw. dass die Obergrenze
         * nicht inkludiert ist im Intervall.
         * 
         * Die Fehlerursache hier ist in der Schleifen-Bedingung zu finden.
         * Dort steht zahl < Obergrenze. Diese Bedingung schließt die 
         * Obergrenze als Wert aus. Man muss also den Vergleichsoperator
         * zu <= ändern.
         */
        
        /*Logischer Fehler 3:
         * Diesen Fehler kann man feststellen, wenn man z.B. als Untergrenze
         * 2 wählt und die Obergrenze 20. Wenn man sich die Formulierung 
         * genau ansieht, dann ist hier ein exklsuiv-oder gefragt. 
         * Das bedeutet, dass die 15 z.B. nicht mit ausgegeben werden dürfte.
         * Bei diesem Testfall sieht man aber, dass das doch der Fall ist.
         * 
         * Der Fehler liegt hier im Logik-Operator in der If-Bedingung.
         * Hier wird ein einfaches oder verwendet. Statt '||' müsste man hier
         * ein '^' verwenden.
         */
        
        
        Scanner eingabe = new Scanner(System.in);
        System.out.println("Untergrenze:");
        int untergrenze = value(eingabe.nextInt());
        System.out.println("Obergrenze:");
        int obergrenze = value(eingabe.nextInt());

        if (untergrenze >= obergrenze) {
            obergrenze = menu(eingabe, untergrenze, obergrenze);
        }


        System.out.println("Folgende Zahlen sind entweder durch 3 oder durch 5"
                + " teilbar:");
        for (int zahl = untergrenze; zahl <= obergrenze; zahl++) {
            if (zahl % 3 == 0 ^ zahl % 5 == 0) {
                System.out.println(zahl);
            }
        }
        
        
        
        
    }

}