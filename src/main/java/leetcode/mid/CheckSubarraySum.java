package leetcode.mid;

import java.util.HashSet;
import java.util.Set;

/**
 * 523. 连续的子数组和
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * <p>
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 * <p>
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 *
 * @author wangxiang
 * @since 2021/6/2 9:38
 */
public class CheckSubarraySum {
    //暴力
    public static boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    //使用前后缀和
    public static boolean checkSubarraySum2(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((prefix[j + 1] - prefix[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 官方题解： 前缀和 + hash
     * 首先比较容易想到用前缀和计算某个子数组[m,n]的和
     * 子数组[m,n]的和可表示为：  prefix[n+1] - prefix[m]
     * 若有子数组符合条件，则有： prefix[n+1] - prefix[m] = z * k
     * 转换上述条件，可得： (prefix[n+1] - prefix[m]) % k = 0，再转换等式可得： prefix[n+1] % k = prefix[m] % k
     *
     * 所以若前缀和数组有{i，j}满足如下条件，则存在子数组和为k的倍数：
     * 1.  j - i >= 2
     * 2.  prefix[j] % k = prefix[i] % k
     */
    public static boolean checkSubarraySum3(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 2; i < prefix.length; i++) {
            int mod = prefix[i - 2] % k;
            set.add(mod);
            if (set.contains(prefix[i] % k)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));

        System.out.println();

        System.out.println(checkSubarraySum2(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(checkSubarraySum2(new int[]{23, 2, 6, 4, 7}, 13));


        System.out.println();

        System.out.println(checkSubarraySum3(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(checkSubarraySum3(new int[]{23, 2, 6, 4, 7}, 13));
    }
}
