package Week3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */
public class LeetCode_78_0256 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> sets, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(sets));
            return;
        }

        dfs(result, nums, sets, index + 1);

        sets.add(nums[index]);
        dfs(result, nums, sets, index + 1);

        sets.remove(sets.size() - 1);
    }
}
