package leetcode.easy;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int mod = x % 10;
            if (result > (Integer.MAX_VALUE / 10 - mod / 10) || result < (Integer.MIN_VALUE / 10 - mod / 10)) {
                return 0;
            }
            result = result * 10 + mod;
            x /= 10;
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(reverse(123));
//        System.out.println(reverse(120));
        System.out.println(reverse(-123));
    }
}
