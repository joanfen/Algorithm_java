package Week3;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_515_0256 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        bfs(root, 0, result);
        return result;
    }

    private void bfs(TreeNode root, int level, List<Integer> result) {
        if (root.left == null && root.right == null) return;

        if (level == result.size()) {
            result.add(level, root.val);
        }
        result.set(level, Math.max(result.get(level), root.val));
        if (root.left != null) bfs(root.left, level + 1, result);
        if (root.right != null) bfs(root.right, level + 1, result);
    }
}
