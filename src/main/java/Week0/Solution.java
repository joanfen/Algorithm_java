package Week0;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {


    /**
     * 双指针，交换值
     * 时间复杂度 0(n)
     */
    public void moveZeroesByTwoPointers(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length;) {
            if (nums[i] == 0 ) {
                zero++;

            } else  {
                int targetPoint = i - zero;
                int temp = nums[i];
                nums[i] = nums[targetPoint];
                nums[targetPoint] = temp;

            }
        }
    }

    /**
     * 双指针，直接将非0的数 cover 掉为0的值，再将后面的值一起设置为0
     * 对我自己来说，这个思路先理解了再去理解上面的交换会容易一些
     */
    public void moveZeroesByCoverZero(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 26. 删除排序数组中的重复项
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return -1;
        int repeatNum = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length ; i++) {
            if (repeatNum != nums[i]) {
                repeatNum = nums[i];
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

    /**
     * #11. 盛水最多的容器
     * 暴力循环
     * 时间复杂度 O(n^2)
     */
    public int maxAreaWithForLoop(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }

        }
        return maxArea;
    }

    /**
     * #盛水最多的容器
     * 时间复杂度 O(n)
     */
    public int maxAreaWithDoublePointers(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    /**
     * #20 有效的括号
     *
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && map.keySet().contains(stack.peek())) {
                if (map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;

                }
            }
            else {
                stack.push(c);
            }

        }
        return stack.isEmpty();

    }



}
