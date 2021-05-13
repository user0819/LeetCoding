package leetcode.easy;

/**
 * 1486. 数组异或操作
 * <p>
 * 给你两个整数，n 和 start 。
 * <p>
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * <p>
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * "^" 为按位异或 XOR 运算符。
 * 示例 2：
 * <p>
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 * 示例 3：
 * <p>
 * 输入：n = 1, start = 7
 * 输出：7
 * 示例 4：
 * <p>
 * 输入：n = 10, start = 5
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 *
 * @author XIANG
 * @since 2021/5/7 9:44
 */
public class XorOperation {
    public static int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }


    public int xorOperation2(int n, int start) {
        int s = start >> 1, e = n & start & 1;
        int ret = sumXor(s - 1) ^ sumXor(s + n - 1);
        return ret << 1 | e;
    }

    public int sumXor(int x) {
        if (x % 4 == 0) {
            return x;
        }
        if (x % 4 == 1) {
            return 1;
        }
        if (x % 4 == 2) {
            return x + 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(xorOperation(10,5));
    }
}
