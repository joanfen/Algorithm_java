package Week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;
/**
 * 144. 给定一个二叉树，返回它的 前序 遍历。
 * 根 左 右
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 */
public class LeetCode_144_0256 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getNode(root, list);
        return list;
    }

    private void getNode(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            getNode(root.left, list);
            getNode(root.right, list);
        }
    }

    private List<Integer> getNodeByStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return list;
    }

}
