//Aufgabenblatt: 1, Aufgabe: 1, Peer Schulze (410246), Deniz Rahnefeld (409637)
public class Hausaufgabe1 {
    public static void main(String[] args){
    System.out.println("Aufgabe 1: "); // Für bessere Lesbarkeit in der Konsole

    System.out.println("1) " + (48 - 25) * 3);
    /* Als erstes wird die Klammer ausgewertet, also der Minus-Operator. Die
     * beiden Operanden sind vom Datentyp int.
     * Das Ergebnis ist auch ein Integer.
     * Als nächstes wird der Multiplikations-Operator ausgewertet.
     * Hier sind auch das Ergebnis, sowie beide Operanden Integer.
     * Zuletzt wird der Plus-Operator ausgewertet. Der Text ist vom Typ String
     * und die Zahl vom Typ int. Das Ergebnis ist ein neuer String.
     */

    System.out.println("2) " + (639648632784L + 1));
    /* Als erstes wird wieder die Klammer ausgewertet. Also das +.
     * Der erste Operand ist vom Typ long und der zweite vom Typ int.
     * Das Ergebnis ist auch vom Typ long.
     * Zuletzt wird der erste Plus-Operator ausgewertet.
     * Der erste Operand ist vom Typ String und der zweite vom Typ long.
     * Das Ergebnis ist ein String.
     */

    System.out.println("3) " + (25.0/3.0));
    /* Als erstes wird wieder die Klammer ausgewertet.
     * Also der Divisions-Operator.
     * Beide Operanden sind vom Datentyp double.
     * Das Ergebnis ist auch vom Typ double.
     * Zuletzt wird der erste Plus-Operator ausgewertet.
     * Der erste Operand ist vom Typ String und der zweite vom Typ double.
     * Das Ergebnis ist ein String.
     */

    }
}
