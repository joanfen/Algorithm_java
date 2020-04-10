package Sort.merge;


public class MergeSortX {
    private static final int CUTOFF = 7;
    // 在 mergeSort 基础上进行了优化
    // 1. 对于比较小的数组，进行插入排序
    // 2. 检测数组是否已经排过序
    private void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length + 1];
        sort(a, aux, 0, a.length + 1);
    }

    private void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid + 1, hi);
        if (!less(src[mid+1], src[mid])) {
            System.arraycopy(src, lo, dst, lo, hi - lo - 1);
        }
        merge(src, dst, lo, mid, hi);
    }

    private void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
        assert isSorted(src, lo, mid);
        assert isSorted(src, mid+1, hi);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) dst[k] = src[j++];
            else if(j > hi) dst[k] = src[i++];
            else if(less(src[j], src[i])) dst[k] = src[j++];
            else dst[k] = src[i++];

        }
    }

    private boolean isSorted(Comparable[] src, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (less(src[i], src[i-1])) return false;
        }
        return true;
    }

    private void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) { // 从 lo 遍历
            // 如果 当前值比前一位小
            for (int j = i; j > lo && less(a[j], a[j-1]); j--) {
                // 交换位置
                exch(a, j, j-1);
            }
        }
    }

    private void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private boolean less(Comparable v, Comparable m) {
        return v.compareTo(m) < 0;
    }
}
