package leetcode.easy;


//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
// 示例:
// 给定 nums = [2, 7, 11, 15], target = 9
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// Related Topics 数组 哈希表

//思路：
//1.暴力遍历：O(n*n)
//2.使用Hash:遍历一遍，放入Hash;再遍历一遍，获取Hash; ->  一遍遍历，一边放入一边获取

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangxiang
 * @since 2020/6/13 10:31
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{1,3,9},4));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        int other;
        for (int i = 0; i < nums.length; i++) {
            other = target - 1 - nums[i];
            if( map.get(other)!= null){
                result[0] = i;
                result[1] = map.get(other);
                break;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
