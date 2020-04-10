import java.util.Arrays;
import java.util.List;

public class DynamicProgram {
    /**
     * 62. 不同路径
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for(int i = 1; i < m; i--) {
            for(int j = 1; j < n; j--) {
                result[j] += result[j-1];
            }
        }
        return result[n-1];
    }

    /**
     * 63. 最小路径 2
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // DP 方程
        /**
         * if grid[i][j] == 1 return 0
         * else opt[i, j] = opt[i+1, j] + opt[i, j+1];
         */
        int width = obstacleGrid[0].length;

        int[] result = new int [width];
        result[0] = 1;
        for(int[] row: obstacleGrid) {
            for(int j = 1; j < width; j++) {
                if (row[j] == 1) { // 障碍物
                    result[j] = 0;
                } else {
                    result[j] += result[j-1];
                }
            }
        }
        return result[width - 1];

    }

    /**
     * 1143 最长公共子序列
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];

    }

    /**
     * 120. 三角形最小路径和
     *
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        // 自底向下
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level --) {
            for (int i = 0; i <= level; i++) {
                minlen[i] = Math.min(minlen[i], minlen[i + 1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }
    Integer[][] memo;
    public int minimumTotal2(List<List<Integer>> triangle) {
        // 2. 记忆化搜索，将中间值存储
        int size = triangle.size();
        memo = new Integer[size][size];
        return helper(0, 0, triangle);

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        // 1. 递归
        return helper(0, 0, triangle);
    }

    private int helper(int level, int c, List<List<Integer>> triangle) {
        if (memo[level][c] != null) {
            return memo[level][c];
        }
        if (level == triangle.size() - 1) {
            return memo[level][c] = triangle.get(level).get(c);
        }
        int left = helper(level + 1, c, triangle);
        int right = helper(level + 1, c + 1, triangle);
        return memo[level][c]  = Math.min(left, right) + triangle.get(level).get(c);
    }

    /**
     * 53. 最大子序和
     * 暴力法
     * 时间复杂度 O(N^3)
     */
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                int sum = sumOfSubArray(nums, j, i);
                res = Math.max(res, sum);
            }
        }
        return res;

    }
    private int sumOfSubArray(int[] nums, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += nums[i];
        }
        return res;
    }
    /**
     * 53. 最大子序和
     * 暴力法 - 优化
     * 时间复杂度 O(N^2)
     */
    public int maxSubArray2(int[] nums) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum = nums[j];
                res = Math.max(res, sum);
            }
        }
        return res;

    }

    /**
     * 53. 最大子序和
     * 动态规划解法
     */
    public int maxSubArray3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pre = nums[0];
        int max = pre;
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }

    /**
     * 打家劫舍
     *
     */
    public int rob(int[] nums) {
        // 暴力法
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
            }
        }
        return max;
    }

    public static void main(String[] args) {


    }
}
