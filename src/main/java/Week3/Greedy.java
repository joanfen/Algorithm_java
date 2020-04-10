package Week3;

import java.util.Arrays;

public class Greedy {
    /**
     * 455. 分发饼干
     * @param g 孩子胃口数组
     * @param s 饼干大小数组
     * @return 能喂饱的孩子数量
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; i < g.length && j < s.length ; j++) {
            if (g[i] <= s[j]) i++;
        }
        return i;
    }

    /**
     * 柠檬水找零
     * @param bills 投入零钱数组
     * @return 能否找零
     */
    public boolean lemonadeChange(int[] bills) {
        int countOfFive = 0;
        int countOfTen = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                countOfFive ++;
                continue;
            }
            if (bills[i] == 10) {
                if (countOfFive == 0) return false;
                countOfFive --;
                countOfTen++;
            }
            if (bills[i] == 20) {
                if (countOfTen > 0 && countOfFive > 0) {
                    countOfTen --;
                    countOfFive--;
                } else if (countOfFive > 3){
                    countOfFive -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     *
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    /**
     * 874. 模拟行走机器人
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        return 0;
    }

    /**
     * 55. Jump Game
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

}
