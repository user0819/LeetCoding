package leetcode.mid;

/**
 * 477. 汉明距离总和
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * <p>
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * <p>
 * 示例:
 * <p>
 * 输入: 4, 14, 2
 * <p>
 * 输出: 6
 * <p>
 * 解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
 * 所以答案为：
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 注意:
 * <p>
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 *
 * @author wangxiang
 * @since 2021/5/27 11:49
 */
public class TotalHammingDistance {

    // 暴力法，非最优解，超时
    public static int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                total += hammingDistance(nums[i], nums[j]);
            }
        }
        return total;
    }

    //汉明距离
    public static int hammingDistance(int x, int y) {
        //return Integer.bitCount(x ^ y);


        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;

    }


    // 位操作，针对每一位，计算汉明距离
    public static int totalHammingDistance2(int[] nums) {
        int total = 0;
        for (int i = 0; i <= 31; i++) {
            int zeroCount = 0;
            int oneCount = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
            total += zeroCount * oneCount;
        }
        return total;
    }

    // 针对totalHammingDistance2，做个小优化：只对位值为1的进行计数
    public int totalHammingDistance3(int[] nums) {
        int total = 0, len = nums.length;
        for (int i = 0; i <= 31; i++) {
            int oneCount = 0;
            for (int num : nums) {
                oneCount += ((num >> i) & 1);
            }
            total += (len - oneCount) * oneCount;
        }
        return total;
    }


    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[]{4, 14, 2}));
        System.out.println(totalHammingDistance2(new int[]{4, 14, 2}));
        System.out.println(totalHammingDistance(new int[]{Integer.MAX_VALUE, 14, Integer.MIN_VALUE}));
        System.out.println(totalHammingDistance2(new int[]{Integer.MAX_VALUE, 14, Integer.MIN_VALUE}));
    }
}
