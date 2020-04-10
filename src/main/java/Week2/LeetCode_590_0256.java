package Week2;


import java.util.ArrayList;
import java.util.List;

/**
 * 590. 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 */
public class LeetCode_590_0256 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        getNode(root, list);
        return list;
    }

    private void getNode(Node node, List<Integer> list) {
        if (node != null) {
            for (Node n : node.children) {
                getNode(n, list);
            }
            list.add(node.val);
        }
    }

}
