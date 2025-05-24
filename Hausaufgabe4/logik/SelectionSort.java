package logik;

public class SelectionSort {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int findExtreme(int[] a, int start, boolean min) {
        //Gibt Index von kleinstem oder gröten Element

        int index = start;
        if (min) {
            int smallest = a[index];

            for (int i = start; i < a.length; i++) { 

                if (a[i] < smallest) {
                    smallest = a[i];
                    index = i;
                }


            }
        } else {
            int largest = a[index];

            for (int i = start; i < a.length; i++) { 

                if (a[i] > largest) {
                    largest = a[i];
                    index = i;
                }


            }
        }

        return index;
    }

    public static void selectionSort(int[] a, int start, boolean asc) {

        if (start == a.length - 1) { //Rekursionsanker
            
        } else { //aufsteigend sortieren

            int index = findExtreme(a, start, asc);
            swap(a, start, index);
            selectionSort(a, start + 1,  asc);

        } 
    }
}
