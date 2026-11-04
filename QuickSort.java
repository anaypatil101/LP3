import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    // ---------- Deterministic ----------
    public void quickSortDet(int[] arr, int low, int high) {
        if (low < high) {
            int p = detPartition(arr, low, high);
            quickSortDet(arr, low, p - 1);
            quickSortDet(arr, p + 1, high);
        }
    }

    public int detPartition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[low];
        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1)
                i++;

            while (arr[j] > pivot && j >= low + 1)
                j--;

            if (i < j)
                swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    // ---------- Randomized ----------
    public int ranPartition(int[] arr, int low, int high) {
        int r = low + new Random().nextInt(high - low + 1);
        swap(arr, low, r);
        return detPartition(arr, low, high);
    }

    public void quickSortRan(int[] arr, int low, int high) {
        if(low < high) {
            int p = ranPartition(arr, low, high);
            quickSortRan(arr, low, p-1);
            quickSortRan(arr, p+1, high);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();

        int[] a = {5, 4, 2, 3, 1, 0};
        q.quickSortDet(a, 0, a.length - 1);
        System.out.println("Deterministic: " + Arrays.toString(a));

        int[] b = {5, 4, 2, 3, 1, 0};
        q.quickSortRan(b, 0, b.length - 1);
        System.out.println("Randomized:    " + Arrays.toString(b));


        //  QuickSort s = new QuickSort();
        // int n = 2000;

        // // Worst case for deterministic: already sorted input
        // int[] a = new int[n], b = new int[n];
        // for (int i = 0; i < n; i++) a[i] = b[i] = i;

        // QuickSort.comparisons = 0;
        // long t1 = System.nanoTime();
        // s.quickSortDet(a, 0, n - 1);
        // long d = System.nanoTime() - t1;
        // System.out.println("Deterministic (sorted input): comparisons=" + QuickSort.comparisons + ", time(ns)=" + d);

        // QuickSort.comparisons = 0;
        // long t2 = System.nanoTime();
        // s.quickSortRand(b, 0, n - 1);
        // long r = System.nanoTime() - t2;
        // System.out.println("Randomized    (sorted input): comparisons=" + QuickSort.comparisons + ", time(ns)=" + r);

        // // Random input check
        // int[] c = new int[n];
        // int[] e = new int[n];
        // Random rnd = new Random();
        // for (int i = 0; i < n; i++) 
        //     c[i] = e[i] = rnd.nextInt(10000);

        // QuickSort.comparisons = 0;
        // s.quickSortDet(c, 0, n - 1);
        // System.out.println("Deterministic (random input): comparisons=" + QuickSort.comparisons);

        // QuickSort.comparisons = 0;
        // s.quickSortRand(e, 0, n - 1);
        // System.out.println("Randomized    (random input): comparisons=" + QuickSort.comparisons);
    }
}