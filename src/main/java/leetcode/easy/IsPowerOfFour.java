package leetcode.easy;

/**
 * 342. 4的幂
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能不使用循环或者递归来完成本题吗？
 */
public class IsPowerOfFour {
    /**
     * 转换为位操作
     * 若n为4的幂次方
     * 则n的二进制中，有且仅有一位为1，且该位一定是0，2，4，6等偶数位
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfFour(int n) {
        if (n < 0 || Integer.bitCount(n) != 1) {
            return false;
        }

        int i = 0;
        for (; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                break;
            }
        }
        return i % 2 == 0;
    }

    //官方
    public static boolean isPowerOfFour2(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0b10101010101010101010101010101010) == 0;
    }

    //官方：对3取模
    public static boolean isPowerOfFour3(int n) {
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(-1));
    }
}
