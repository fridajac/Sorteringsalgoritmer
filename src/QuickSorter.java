package src;

public class QuickSorter implements IntSorter {

    public void sort(int[] a) {
        int[] shuffledArr = ArrayUtil.createShuffeled(a.length);
        partition(0, shuffledArr.length - 1, shuffledArr);
    }

    public void partition(int lo, int hi, int[] a) {
        if (lo < hi) {
            int p = a[lo];
            int i = lo;
            int j = hi + 1;
            do {
                i++;
            } while(i < hi && a[i] < p);
            do{
                j--;
            } while(a[j] > p);
            swap(a, i, j);
        }
    }
    static void swap(int[] arr, int low, int p){
        int tmp = arr[low];
        arr[low] = arr[p];
        arr[p] = tmp;
    }
}
