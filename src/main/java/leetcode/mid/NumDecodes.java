package leetcode.mid;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wangxiang
 * @since 2021/4/21 13:41
 */
public class NumDecodes {

    //动态规划： f(i) = f(i-1) * t(i) + f(i-2) * q(i)
    //t(i) 表示 s.charAt(i) 是否为 0
    //q(i) 表示 s.subString(i-1,i+2) 是否在范围[10-26]内
    public int NumDecodes(String s) {
        int[] tmp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                tmp[i] = equalZero(s.charAt(i));
                continue;
            }
            if (i == 1) {
                int result = getTwoBitResult(s, i);
                tmp[i] = result;
                continue;
            }
            tmp[i] = tmp[i - 1] * equalZero(s.charAt(i)) + tmp[i - 2] * isValidTwoBit(s, i);
        }
        return tmp[s.length() - 1];
    }

    private int equalZero(char c) {
        return c == '0' ? 0 : 1;
    }

    private int getTwoBitResult(String s, int i) {
        String numStr = s.substring(i - 1, i + 1);
        int num = Integer.parseInt(numStr);
        int result;
        if (numStr.indexOf('0') != -1 && num != 10 && num != 20) {
            result = 0;
        } else if (num > 26 || num == 10 || num == 20) {
            result = 1;
        } else {
            result = 2;
        }
        return result;
    }

    //判断最后两位是否在[10,26]范围内
    private int isValidTwoBit(String s, int i) {
        String numStr = s.substring(i - 1, i + 1);
        int num = Integer.parseInt(numStr);
        return num >= 10 && num <= 26 ? 1 : 0;
    }

    public int NumDecodes2(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }


    public static void main(String[] args) {
        NumDecodes numDecodes = new NumDecodes();
        System.out.println(numDecodes.NumDecodes("2220"));
    }
}
