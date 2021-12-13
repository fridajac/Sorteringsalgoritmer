package src;

public class QuickSorter implements IntSorter {

    public void sort(int[] a) {
        ArrayUtil.shuffle(a); //skapa array och blanda om den
        int N = a.length - 1; // N är lika med arrayens längd -1
        quickSort(a, 0, N);// skicka till metoden quicksort, låg 0, hög N(högsta talet) och arrayen.
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high; j++) {
            if (arr[j] < pivot) {
                i++; // Increment index of  smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitioningIndex = partition(arr, low, high);
            quickSort(arr, low, partitioningIndex - 1);
            quickSort(arr, partitioningIndex + 1, high);
        }
    }
}












/*    public void quickSort(int lo,  int hi, int[] array) {
        if(hi > lo){// Om N()hösta värdet är högre än lägsta värdet.
            int pivot = partition(lo, hi, array);// skicka lägsta, högsta och arrayen till partition metoden.
            quickSort(lo, pivot-1, array); // Kör quicksort metoden igen på lägsta till pivot värdet () ska vara hälften?
            quickSort(pivot+1, hi, array);// Kör quicksort metoden igen på pivot(bör vara häften) till högsta värdet.
        }
    }

    public int partition(int lo, int hi, int[] a) { // ta inparametrar i form av högsta och lägsta värdet från quicksort.
        int pivot = a[lo]; // Sätt pivot värdet till värde i arrayen som tillhör lägsta värdet.
        int greaterElement = lo-1;// skapa en variabel som är lika med lägsta minus-1
        for(int i = lo; i < hi-1; i++){ // Loopa från lägsta till högsta.
            if(a[i] < pivot){ //om ett element som är mindre än pivot hittas:
                greaterElement++; // Öka variabeln som började på lägsta minus 1 med 1.
                int temp = a[greaterElement]; //skapa en temporär plats för arrayens värde för greaterelement.
                a[greaterElement] = a[i];// lägg greaterelement i platsen du är på i arrayen just nu.
                a[i] = temp;//
            }
        }
        int temp = a[greaterElement+1];
        a[greaterElement+1] = a[hi];
        a[hi] = temp;
        return (greaterElement+1);
    }*/

