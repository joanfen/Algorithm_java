package Sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[]{4, 6, 1, 3, 4, 0, 11, 64};
        sort(a);
        show(a);
    }

    private static void sort(int[] a) {
        int size = a.length;
        if (size <= 1) return;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
        }
    }

    private static void exch(int[] a, int i, int j) {
        if (i == j) return;
        System.out.println("exchange");
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
