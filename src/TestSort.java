package src;

import src.InsertionSorter;
import src.IntSorter;
import src.MergeSorter;
import src.QuickSorter;

public class TestSort {

    private static int[] create(int N, boolean ordered) {
        return ordered ?
            ArrayUtil.createOrdered(N) :
            ArrayUtil.createShuffeled(N);
    }
    
    private static double timeit(IntSorter sorter, int[] a) {
        long before = System.currentTimeMillis();
        sorter.sort(a);
        return (System.currentTimeMillis() - before) / 1000.0;
    }

    private static void testSort(IntSorter sorter, int firstN, boolean ordered) {
        double t1 = 0;
        int N = firstN/2;

        while (t1 < 0.7 && N < 10000000) {
            N *= 2;
            int[] a = create(N, ordered);
            t1 = timeit(sorter, a);
            System.out.println("T("+N+")="+t1);
            ArrayUtil.testOrdered(a);
        }
        int[] a = create(4*N, ordered);
        double t4 = timeit(sorter, a);
        ArrayUtil.testOrdered(a);
        double t01 = t1 / (N   * Math.log(N  )); // ”tid” per jämförelse
        double t04 = t4 / (4*N * Math.log(4*N));
        System.out.println("T("+4*N+")="+t4+" growth per N log N: "+t04/t01);
        if (t04/t01 > 1.25) {
            System.out.println(sorter.getClass().getName()+".sort appears not to run in O(N log N) time");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        IntSorter intSorter = (IntSorter) new InsertionSorter();
        IntSorter mergeSorter = new MergeSorter();
        IntSorter quickSorter = new QuickSorter();

        int firstN = 10000;

        System.out.println("Unordered:");
        testSort(intSorter, firstN, false);
        System.out.println("\nOrdered:");
        testSort(intSorter, firstN, true);

        System.out.println("\n" + intSorter.getClass().getName() + ".sort tested ok!");
        System.exit(0);
    }
}
