package src;

public class QuickSorter implements IntSorter {

    public void sort(int[] a) {
        int[] shuffledArr = ArrayUtil.createShuffeled(a.length); //skapa array och blanda om den
        int N = shuffledArr.length-1;
        quickSort(0, N, shuffledArr);
    }

    public void quickSort(int lo,  int hi, int[] a) {
        if(hi > lo){
            int pivot = partition(lo, hi, a);
            quickSort(lo, pivot-1, a);
            quickSort(pivot+1, hi, a);
        }
    }

    public int partition(int lo, int hi, int[] a) {
        int pivot = a[lo];
        int greaterElement = lo-1;
        for(int i = lo; i < hi-1; i++){
            if(a[i] < pivot){ //if element smaller than pivot is found
                greaterElement++;
                int temp = a[greaterElement]; //swaping!
                a[greaterElement] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[greaterElement+1];
        a[greaterElement+1] = a[hi];
        a[hi] = temp;
        return (greaterElement+1);
    }
}
