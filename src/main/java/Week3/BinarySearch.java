package Week3;

public class BinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;

        int idx, element;
        while (left <= right) {
            idx = (left + right) / 2;
            element = matrix[idx / n][idx % n];
            if (target == element) return true;
            else {
                if (target > element) {
                    left = idx + 1;
                }
                else {
                    right = idx - 1;
                }
            }
        }
        return false;
    }

    /**
     * 153. 寻找旋转排序数组中的最小值
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[right] > nums[left]) {
            return nums[left];
        }
        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[mid+1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
