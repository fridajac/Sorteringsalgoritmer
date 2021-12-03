package src;

public class MergeSorter implements IntSorter {

    public void sort(int[] a){
        mergeSort(0, a.length, a);
    }

    //mergeSort på del av array från lo till hi
    public static void mergeSort(int lo, int hi, int[] a) {
        if (hi <= lo) return; //sålänge vi har fler än 1 element
        int mid = (lo + hi)/2;
        mergeSort(lo, mid, a);
        mergeSort(mid + 1, hi, a);
        //nu är två halvor sorterade
        merge(lo, hi, mid, a);
    }

    public static void merge(int lo, int hi, int mid, int[] a) {
        int[] tempArrayLeft = new int[mid - lo + 1];
        int[] tempArrayRight = new int[hi - mid];
        //kopiera över alla värden till extra lagringsarrayer
        for (int i = 0; i < tempArrayLeft.length; i++) {
            tempArrayLeft[i] = a[i];
        }
        for (int i = 0; i < tempArrayRight.length; i++) {
            tempArrayRight[i] = a[i];
        }
        int i = 0;
        int j = 0;
        for (int k = lo; k < hi; k++) {
            if (i < tempArrayLeft.length && j < tempArrayRight.length) {
                if (tempArrayLeft[i] < tempArrayRight[j]) {
                    a[k] = tempArrayLeft[i++];
                } else {
                    a[k] = tempArrayRight[j++];
                }
            }
        }
    }
}

