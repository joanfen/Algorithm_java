package Stack;

import java.util.*;

public class StackOperation {

    /**
     * remove adjacent duplicates in string
     * @param s
     * #1047 in LeetCode
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character target = s.charAt(i);
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if (target == peek) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(target);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }

    /**
     *
     * 匹配括号
     */
    public boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!stack.isEmpty()
                    && map.containsKey(stack.peek())
                    && map.get(stack.peek()).equals(c)) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }

//    /**
//     * next greater num
//     * @param nums1
//     * @param nums2
//     * @return
//     */
//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i< nums2.length; i++) {
//            map.put(nums1[i], i);
//        }
//
//    }

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(1); // offerLast
        deque.offer(2); // offerLast
        deque.offer(3);
        System.out.println(deque.poll());

        System.out.println(deque.toString());

        System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7,}, 3).toString());

//        System.out.println(largestRectangleArea(new int[]{1}));
    }


    public static int largestRectangleArea(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() > 0 ) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int size = nums.length;
        int[] result = new int[size - k + 1];
        int index = 0;
        // store index
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            // remove numbers out of range k
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.pollFirst();
            }
            // remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                // 将 deque 中的数据与 当前 索引的数据进行比较
                deque.pollLast();
            }
            // q contains index... r contains content
            deque.offerLast(i);
            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }


}
