package leetcode.easy;

import util.ArrayUtil;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * <p>
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * <p>
 * 你可以想象内部操作如下:
 * <p>
 * <p>
 * nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * <p>
 * 在函数里修改输入数组对于调用者是可见的。
 * 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 num
 * s = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面
 * 的元素。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * <p>
 * Related Topics 数组 双指针
 * 👍 864 👎 0
 *
 * @author XIANG
 * @since 2021/4/19 10:17
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(removeElement2(nums, 3));
        ArrayUtil.print(nums);
    }

    //思路：遇到val值，则将后面的数往前平移：O(n*n)
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length - count; i++) {
            int num = 0;
            while (i + num < nums.length - count && nums[i + num] == val) {
                num++;
            }

            for (int j = i; j < nums.length - count && j + num < nums.length - count & num > 0; j++) {
                nums[j] = nums[j + num];
            }
            count += num;
        }
        return nums.length - count;
    }

    //思路：遇到val值，则将后面的数直接替换到当前位置O(n)
    public static int  removeElement2(int[] nums, int val) {
        int tail = nums.length;
        for (int i = 0; i < tail; i++) {
            if(nums[i] == val){
                nums[i--] = nums[--tail];
            }
        }
        return tail;
    }
}
