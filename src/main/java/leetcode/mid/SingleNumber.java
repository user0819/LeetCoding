package leetcode.mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 *  进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 *
 * @author wangxiang
 * @since 2021/4/30 11:03
 */
public class SingleNumber {
    //就是用额外map  (不满足空间)
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }


    //排完序再找 （不满足时间）
    public static int singleNumber2(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }
        return nums[nums.length - 1];
    }


    //位操作，对每一位都对3取余,然后将每一位都拼接起来即为最终值
    public static int singleNumber3(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bitTotal = 0;
            for (int num : nums) {
                bitTotal += ((num >> i) & 1);
            }
            if (bitTotal % 3 == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(singleNumber3(new int[]{30000, 500, 100, 30000, 100, 30000, 100}));
    }
}
