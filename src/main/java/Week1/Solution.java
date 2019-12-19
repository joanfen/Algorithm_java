package Week1;

public class Solution {
    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    //
    // 示例:
    //
    // 输入: [0,1,0,3,12]
    // 输出: [1,3,12,0,0]
    //
    // 说明:
    //
    //
    // 必须在原数组上操作，不能拷贝额外的数组。
    // 尽量减少操作次数。
    //
    // Related Topics 数组 双指针


    public void moveZeroes(int[] nums) {
        // 一个指针记录0 的位置，一个指针记录非 0 的位置
        // 将 0 和非 0 换位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                index++;
            }
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
    }


    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     */
    public int maxArea(int[] height) {
        int area = 0;

        for (int left = 0, right = height.length - 1; left < right; ) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(area, currentArea);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return area;
    }

    //给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//
// 示例 1:
//
// 给定数组 nums = [1,1,2],
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
//
//你不需要考虑数组中超出新长度后面的元素。
//
// 示例 2:
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
//
//
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢?
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
// Related Topics 数组 双指针
    public int removeDuplicates(int[] nums) {
        // 1. 两个指针 flag, i
        // flag 指向可以被替换区间的左边界，另一个指针遍历，flag ~ i 之间的位置就是可以填数据的位置
        // 值比较，如果两个指针指向的值相等，flag 按住不动
        // 如果值不等，则 flag ++ 位置的值 赋值为 i 位置的值，然后将 flag ++
        // 有效值区域到 flag，所以长度为 flag + 1
        if (nums.length == 0) return 0;
        int flag = 0;
        int repeat = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != repeat) {
                repeat = nums[i];
                nums[++flag] = nums[i];
            }
        }
        return flag + 1;
    }
}