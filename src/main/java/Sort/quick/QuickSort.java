package Sort.quick;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 5, 8, 11, 2, 1, 0, 15, 5};
//        int[] a = new int[]{4, 3, 5, 8};
        quickSort(a);
        System.out.println("排序后的 a: ");
        show(a);

    }
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if(lo >= hi) return;
        int index = partition(a, lo, hi);
        quickSort(a, lo, index - 1);
        quickSort(a, index + 1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        System.out.println("-------action-------");
        int pivot = a[hi];
        int i = lo;
        for (int j = lo; j < hi ; ++j) {
            System.out.println("i:" + i + ", j:" + j);

            if (a[j] < pivot) {
                exch(a, i, j);
                i++;
                System.out.println("a: ");
                System.out.println("---------------");
                show(a);
            }
        }
        exch(a, i, hi);
        System.out.println("-------end-------");
        System.out.println();
        return i;
    }

    private static void exch(int[] a, int i, int j) {
        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

    }
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
