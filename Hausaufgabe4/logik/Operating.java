package logik;
import java.util.Scanner;

public class Operating {
    static Scanner input = new Scanner(System.in);

    public static void increment(int[] a, int i) {   
        a[i]++;
    }

    public static void incrementAll(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i]++;
        }
    }

    public static void decrement(int[] a, int i) {
        a[i]--;
    }

    public static void decrementAll(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i]--;
        }
    }

    public static int[] stringtoIntArray(String array) {
        String[] parts = array.split(" ");
        int[] a = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            a[i] = Integer.parseInt(parts[i]);
        }

        return a;
    }

    public static int[] arrayInput() {
        System.out.println("Bitte geben Sie die initiale Zahlenreihe ein:");
        int[] array = stringtoIntArray(input.nextLine());
        return array;
    }

    public static boolean commandInterpreter(String command, int[] array) {
        /*
         *Funktion, um die Eingabe zu interpretieren 
         *und die entsprechenden Funktionen auszuwählen.
         */

        boolean stillrunning = true;
        String[] parts = command.split(" ");
        char c = parts[0].charAt(0);

        if (c == 's') { //Sortieren
            if (parts[1].equalsIgnoreCase("auf")) {
                SelectionSort.selectionSort(array, 0, true);
            } else if (parts[1].equalsIgnoreCase("ab")) {
                SelectionSort.selectionSort(array, 0, false);
            }
        } else if (c == 'i') { //Inkrementieren
            if (parts[1].equals("*")) {
                incrementAll(array);
            } else {
                int i = Integer.parseInt(parts[1]);
                if (i < 1) {
                    System.out.println("Warnung, Position beginnt ab 1!");
                } else {
                    increment(array, i - 1);
                }
            }
        } else if (c == 'd') { //Dekrementieren
            if (parts[1].equals("*")) {
                decrementAll(array);
            } else {
                int i = Integer.parseInt(parts[1]);
                if (i < 1) {
                    System.out.println("Warnung, Position beginnt ab 1!");
                } else {
                    decrement(array, i - 1);
                }
            }

        } else if (c == 'x') { //Programm beenden
            stillrunning = false;
        }
        return stillrunning; 
    }

    public static void menu() {
        boolean stillrunning = true;
        int[] array = arrayInput();
        do {
            System.out.println("Nächster befehl: ");
            String command = input.nextLine();
            stillrunning = commandInterpreter(command, array);
            System.out.println("Die aktuelle Zahlenreihe ist: ");

            for (int element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
            System.out.println();
        } while (stillrunning);
        System.out.println("Programm ist beendet");
    }

}
