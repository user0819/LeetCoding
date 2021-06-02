package leetcode.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * @author wangxiang
 * @since 2021/6/2 11:48
 */
public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }


        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prefix.length; i++) {
            int target =  prefix[i] - k;
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}
