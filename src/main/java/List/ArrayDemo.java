package List;

import java.util.ArrayList;
import java.util.List;

public class ArrayDemo {
    static private List<Integer> list = new ArrayList<>();


    public static void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        System.out.println(nums);
    }

    public static void rotate1(int[] nums, int k) {
        k %= nums.length; // 防止 K 超出数组长度
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(nums);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args)  {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate1(nums, 5);


    }

    private static void testArrayList() throws InterruptedException {
        list.add(null);

        Thread thread1 = new Thread(() -> {
            add10K();
        });
        Thread thread2 = new Thread(() -> {
            add10K();
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list.size());
    }

    private static void add10K() {
        Integer idx = 0;
        while (idx++ < 20) {
            list.add(idx);
        }
    }
}
