package src;

public class MergeSorter implements IntSorter {

    public void sort(int[] a){
        mergeSort(0, a.length-1, a);
    }

    //mergeSort på del av array från lo till hi
    public static void mergeSort(int lo, int hi, int[] a) {
        int mid = 0;
        if(hi > lo) { //om vi har fler än 1 element
            mid = (lo + hi) / 2;
            mergeSort(lo, mid, a);
            mergeSort(mid + 1, hi, a);
            merge(lo, hi, mid, a);
        }
    }

    //merge på delar av array(lo...mid) och (mid+1...hi)
    public static void merge(int lo, int hi, int mid, int[] a) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;
        int[] tempLeftArr = new int[n1];
        int[] tempRightArr = new int[n2];
        //kopiera över alla värden till extra lagringsarrayer
        for (int i = 0; i < n1; i++) {
            tempLeftArr[i] = a[lo+i];
        }
        for (int j = 0; j < n2; j++) {
            tempRightArr[j] = a[mid+1+j];
        }
        
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = lo; i < hi+1; i++) {
            if (leftIndex < tempLeftArr.length && rightIndex < tempRightArr.length) {
                if (tempLeftArr[leftIndex] < tempRightArr[rightIndex]) {
                    a[i] = tempLeftArr[leftIndex];
                    leftIndex++;
                } else {
                    a[i] = tempRightArr[rightIndex];
                    rightIndex++;
                }
            }
            else if(leftIndex < tempLeftArr.length){ //lägg över resten av elementetn!
                a[i] = tempLeftArr[leftIndex];
                leftIndex++;
            }
            else if(rightIndex < tempRightArr.length){ //lägg över resten av elementen!
                a[i] = tempRightArr[rightIndex];
                rightIndex++;
            }
        }
    }
}

