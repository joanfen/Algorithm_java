package Sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{4, 6, 1, 3, 4, 0, 11, 64};
        sort(a);
        show(a);
    }
    private static void sort(int[] a) {
        int size = a.length;
        if (size <= 1) return;
        for (int i = 1; i < size; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j]; // 数据后移
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 数据插入
        }
    }
    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
