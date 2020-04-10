package Week3;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_102_0256 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        DFS(root, 0);
        return lists;

    }
    private void DFS(TreeNode root, int level) {
        if (root == null) return;
        if (lists.size() <= level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        DFS(root.left, level + 1);
        DFS(root.right, level + 1);
    }

}
