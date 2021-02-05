package leetcode.middle;

import leetcode.util.ArrayUtils;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int begin = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
             if(target == nums[i] ){
                 end = i;
                 if (begin == -1){
                     begin = i;
                 }
             }

        }
        return new int[]{begin, end};
    }

    public static int[] searchRange2(int[] nums, int target) {
        int begin = -1, end = -1;
        int i = 0, j = nums.length -1,mid ;
        while(i <= j){
            mid = (i + j) /2;
            System.out.println(mid);
            if(nums[mid] > target) {
                j= --mid;
            }else if(nums[mid] < target){
                i = ++mid;
            }else {
                begin = mid;
                end = mid;
                while(begin >= 0 && nums[begin] == target){
                    begin--;
                }
                begin += 1;
                while(end < nums.length && nums[end] == target){
                    end++;
                }
                end -= 1;
                break;
            }
        }


        return new int[]{begin, end};
    }

    public static void main(String[] args) {
        int[] result = searchRange2(new int[]{1}, 1);
        ArrayUtils.printArray(result);
    }


}
