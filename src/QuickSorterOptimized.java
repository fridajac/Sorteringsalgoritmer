package src;

public class QuickSorterOptimized implements IntSorter {

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
        int M = 500;
        if (low < high) {
            if (high - low <= M) {
                insertionSort(low, high, arr);

            }
            else {
                int partitioningIndex = partition(arr, low, high);
                quickSort(arr, low, partitioningIndex - 1);
                quickSort(arr, partitioningIndex + 1, high);
            }
        }
    }

    public static void insertionSort(int lo, int hi, int[] a) {
        for (int i = lo; i < hi + 1; i++) {
            for (int j = i; j > lo && a[j] < a[j - 1]; j--) {
                int x = a[j];
                a[j] = a[j - 1];
                a[j - 1] = x;
            }
        }
    }

}
