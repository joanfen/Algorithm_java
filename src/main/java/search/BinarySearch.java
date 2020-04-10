package search;

/**
 * 二分查找的特性
 * 1. 单调性
 * 2. 存在上下界
 * 3. 能够索引访问
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    /**
     * 69. x 的平方根
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        return mySqrtByBinarySearch(x);
    }

    /**
     * 二分查找法
     *
     * @param x
     * @return
     */
    private static int mySqrtByBinarySearch(int x) {
        if (x == 0 || x == 1) return x;

        int left = 1, right = x;
        long target;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            target = (long) mid * mid;
            if (target > x) { // 中间的值的平方 > x，说明 mid 偏大，目标值在左侧
                right = mid - 1; // 右边界缩小到 mid - 1
            } else if (target < x) {
                left = mid + 1;
            } else return mid;
        }
        return right;
    }
    /**
     * 牛顿迭代法
     */
    private static int mySqrtByNewton(int x) {
        if(x < 2) return x;
        double x0 = x;
        double x1 = (x0 + x /  x0) / 2.0;
        while (Math.abs(x0 - x1) >= 1) {
            x0 = x1;
            x1 = (x0 + x / x0) / 2.0;
        }
        return (int)x1;
    }



    public static boolean isPerfectSquare(int num) {
        int s = mySqrtByNewton(num);
        return s * s == num;
    }

    /**-----------------------------------------------------------------------------*/
    /**
     * 33. 搜索旋转排序数组
     * @param nums
     * @param target
     * @return
     */
    public int searchRotatedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] <= nums[mid] && (target > nums[mid] || target < nums[left])) { //当前半段有序（0 < mid)，且target 不在其中
                left = mid + 1;
            } else if (target > nums[mid] && target < nums[left]) { // 比左边大且比 mid 小，说明在右边
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return (left == right && nums[left] == target) ? left : -1;
    }

    /**
     * 74. 搜索二维矩阵
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0, hi = m*n - 1;
        int idx, element;
        while (lo <= hi) {
            idx = lo + (hi - lo) / 2;
            int i = idx / n, j = idx % n;
            element = matrix[i][j];
            if (target == element) return true;
            if (target > element) {
                lo = idx + 1;
            } else {
                hi = idx - 1;
            }
        }
        return false;
    }

    /**
     * 查找第一个值=给定值的元素
     */
    public int searchFirstMin(int[] a, int target) {
        if(a == null || a.length == 0) return -1;
        int left = 0, right = a.length;
        while (left <= right) {
            int mid =  left + (right - left) / 2;
            if (a[mid] > target)  {
                right = mid - 1;
            } else if (a[mid] < target){
                left = mid + 1;
            } else if (mid  == 0 || a[mid - 1] != target) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public int searchBotanicArray(int[] a, int target) {
        // 1, 3, 5, 10, 15, 16, 20, 18, 15, 12, 1

        if(a == null || a.length < 3) return -1;
        int left = 0, right = a.length;
        int mid =  left + (right - left) / 2;

        while(mid - 1 >= 0 && mid + 1 < a.length)  {
            if (a[mid - 1] < a[mid] && a[mid] > a[mid + 1]) {
                return mid;
            }
            else{
                if (a[mid] >= a[mid+1]) {
                    right = mid;
                } else if (a[mid] < a[mid] + 1) {
                    left = mid;
                }
            }


        }

    }
}
