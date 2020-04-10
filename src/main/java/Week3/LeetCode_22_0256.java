package Week3;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 */
public class LeetCode_22_0256 {
    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
//        _generateAll(0, 2 * n, "");
        _generate(0, 0, n, "");
        return result;
    }

    private void _generateAll(int level, int max, String s) {
        if (level >= max) {
            // 判断
            if (validate(s)) {
                result.add(s);
            }
            return;
        }
        _generateAll(level + 1, max, s + "(");
        _generateAll(level + 1, max, s + ")");
    }

    private boolean validate(String s) {
        return false;
    }

    private void _generate(int left, int right, int n, String s) {
        // terminator
        // 左右括号的个数都=n 说明遍历完毕
        if (left == n ) {
            result.add(s);
            return;
        }
        // process current logic
        // drill down
        if (left < n) {
            _generate(left + 1, right, n, s + "(");
        }
        if (right < n) {
            _generate(left, right + 1, n, s + ")");
        }
    }

}
