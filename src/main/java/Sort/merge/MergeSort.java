package Sort.merge;

public class MergeSort {
    public static void main(String[] args) {
        String[] a = new String[] {"M", "E", "R", "G", "E"};
        show(a);
        sort(a);
        System.out.println("排序后");
        show(a);

    }
    private static void mergeSort(Comparable[] a, Comparable[] aux,  int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        mergeSort(a, aux, 0, a.length - 1);
        assert isSorted(a);
    }

    /**
     * 使用辅助数组 aux merge a[lo..mid] 和 a[mid+1, hi]
     */
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }

    }

    // is v < w?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            // a[i] < a[i-1] 说明未排好序
            if (less(a[i], a[i-1])) return false;
        }
        return true;
    }

    private static void show(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.println(comparable);
        }
    }
}
