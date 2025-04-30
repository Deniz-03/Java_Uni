//Aufgabenblatt: 2, Aufgabe: 1, Peer Schulze (410246), Deniz Rahnefeld (409637)
import java.util.Scanner;

public class Hausaufgabe2 {

    public static void printMatches(int n) {
        for(int i = 0; i<n; i++) {
            System.out.print('I');
        }
        System.out.println();
    }


    public static int playerinput(int playerID) {
        System.out.print("Spieler " + playerID);
        System.out.println(", wie viele Streichhölzer möchtest du entfernen?");
        /*Wegen der 80 Zeichen pro Zeileregel musste ich
          die Abfrage in 2 prints aufteilen.
        */
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();

        if (in < 1 || 3 < in) {
            System.out.println("Nur 1, 2, 3 möglich!");
            in = input.nextInt();
        }

        return in;
    }


    public static void main(String[] args) {
        //INITIALIZE
        System.out.println("Streichhölzer Wegnehmen");
        System.out.println("=======================");
        System.out.println();

        int s = 21;
        printMatches(s);

        int playerID = 1;

        //Gameloop
        while (s > 0) {

            s = s - playerinput(playerID);
            System.out.println();
            if (s <= 0) {
                break;
            }


            printMatches(s);


            switch (playerID) {
            case 1:
                playerID = 2;
                break;
            case 2:
                playerID = 1;
                break;
            }

        }


        //Spielende
        System.out.println("Spieler " + playerID + " hat verloren :(");


    }
}
