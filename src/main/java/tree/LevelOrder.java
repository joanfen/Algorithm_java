package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 二叉树的层序遍历
     * 递归方式
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode node, int level) {
        if (result.size() == level) { // 说明当前的层级的数组还未被创建
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    /**
     * 二叉树的层序遍历
     * 迭代方式
     *
     * @param root
     */
    private List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root  == null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while ( !queue.isEmpty()) {
            levels.add(new ArrayList<>());
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level ++;
        }
        return levels;


    }


}
