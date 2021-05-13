package leetcode.mid;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a*a + b*b = c 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 * <p>
 * <p>
 * <p>
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：c = 1
 * 输出：true
 *
 * @author XIANG
 * @since 2021/4/28 12:59
 */
public class JudgeSquareSum {

    //暴力法
    //使用Math.sqrt()方法
    //用时击败11%， 内存击败55.5%
    public static boolean judgeSquareSum(int c) {
        int bMax = (int) Math.sqrt(c);

        double tmpA;
        for (int i = 0; i <= bMax; i++) {
            tmpA = Math.sqrt(c - i * i);
            if (tmpA == (int) tmpA) {
                return true;
            }
        }
        return false;
    }

    //双指针
    public static boolean judgeSquareSum2(int c) {
        int bMax = (int) Math.sqrt(c);
        int left = 0;
        int right = bMax;
        int sum;
        while (left <= right) {
            sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum2(2147482647));
    }

}
