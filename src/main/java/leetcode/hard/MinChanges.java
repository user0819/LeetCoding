package leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1787. 使所有区间的异或结果为零
 *
 *
 * 这题又cv了！
 *
 *
 * <p>
 * 给你一个整数数组 nums​​​ 和一个整数 k​​​​​ 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。
 * <p>
 * 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0,3,0], k = 1
 * 输出：3
 * 解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
 * 输出：3
 * 解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
 * 输出：3
 * 解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 2000
 * ​​​​​​0 <= nums[i] < 210
 *
 * @author wangxiang
 * @since 2021/5/25 13:45
 */
public class MinChanges {

    //长度为 k 的区间异或结果等于零，则每k个数为一个循环
    public static int minChanges(int[] nums, int k) {
        if (k > nums.length || (nums.length == 1 && nums[0] == 0)) {
            return 0;
        }

        int minChangeCount = Integer.MAX_VALUE;

        //遍历获取所有的cycle可能，并针对每一个cycle数组，计算需要改变的数
        for (int i = 0; i <= nums.length - k; i++) {
            int[] cycle = new int[k];
            int lastCycleValue = 0;

            //以i开头的k个数，组成循环数组cycle
            for (int m = 0; m < k - 1; m++) {
                cycle[m] = nums[i + m];
                lastCycleValue ^= cycle[m];
            }
            cycle[k - 1] = lastCycleValue;

            int changeCount = 0;
            for (int j = 0; j < nums.length; j++) {
                int cycleIndex = (j - i) % k;
                if (cycleIndex < 0) cycleIndex = cycleIndex + k;

                if (nums[j] != cycle[cycleIndex]) {
                    changeCount++;
                }
            }

            minChangeCount = Math.min(changeCount, minChangeCount);
        }

        return minChangeCount;
    }


    // x 的范围为 [0, 2^10)
    static final int MAXX = 1 << 10;
    // 极大值，为了防止整数溢出选择 INT_MAX / 2
    static final int INFTY = Integer.MAX_VALUE / 2;

    public int minChanges2(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[MAXX];
        Arrays.fill(f, INFTY);
        // 边界条件 f(-1,0)=0
        f[0] = 0;

        for (int i = 0; i < k; ++i) {
            // 第 i 个组的哈希映射
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            int size = 0;
            for (int j = i; j < n; j += k) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
                ++size;
            }

            // 求出 t2
            int t2min = Arrays.stream(f).min().getAsInt();

            int[] g = new int[MAXX];
            Arrays.fill(g, t2min);
            for (int mask = 0; mask < MAXX; ++mask) {
                // t1 则需要枚举 x 才能求出
                for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                    int x = entry.getKey(), countx = entry.getValue();
                    g[mask] = Math.min(g[mask], f[mask ^ x] - countx);
                }
            }

            // 别忘了加上 size
            for (int j = 0; j < MAXX; ++j) {
                g[j] += size;
            }
            f = g;
        }

        return f[0];
    }

    public static void main(String[] args) {
//        System.out.println(minChanges(new int[]{1,2,0,3,0}, 1));
//        System.out.println(minChanges(new int[]{3,4,5,2,1,7,3,4,7}, 3));
//        System.out.println(minChanges(new int[]{1,2,4,1,2,5,1,2,6}, 3));
//        System.out.println(minChanges(new int[]{0}, 1));
        System.out.println(minChanges(new int[]{11,20,3,18,26,30,20,7,3,0,25,9,19,21,3,23}, 5));
    }
}
