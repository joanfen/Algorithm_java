package Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{4, 6, 1, 3, 4, 0, 11, 64};
        sort2(a);
        show(a);
    }
    public static void sort(int[] a) {
        int size = a.length;
        if (size <= 1) return;
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - i - 1 ; j++) {
                if (a[j] > a[j + 1]) {
                    exch(a, i, j+1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    private static void sort2(int[] a) {
        int size = a.length;
        if (size <= 1) return;

        int sortBorder = size - 1;
        int lastChangeIndex = 0;
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < sortBorder ; j++) {
                if (a[j] > a[j + 1]) {

                    exch(a, i, j+1);
                    flag = true;
                    lastChangeIndex = j;
                }
            }
            sortBorder = lastChangeIndex;
            if (!flag) break;
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
