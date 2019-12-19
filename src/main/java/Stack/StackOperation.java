package Stack;

import java.util.HashMap;
import java.util.Stack;

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
}
