package leetcode.mid;

/**
 * 给你两个长度相同的字符串，s 和 t。
 * <p>
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * <p>
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * <p>
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * <p>
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 * <p>
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 * <p>
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 * <p>
 * "krpgjbjjznpzdfy"
 * "nxargkbydxmsgby"
 * 14
 */
public class EqualSubstring {
    public static void main(String[] args) {
        //System.out.println(equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));
        System.out.println(equalSubstring("abcd", "acde", 0));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        //象征性校验
        if (s == null || t == null || s.length() != t.length()) {
            return 0;
        }
        //获取s、t每一个字符的差值
        int[] diff = new int[s.length()];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = Math.abs(t.charAt(i) - s.charAt(i));
        }

        //问题转化成计算数组diff的元素和不超maxCost的最长子数组的长度
        int maxLength = 0, sum, j;
        for (int i = 0; i < diff.length; i++) {
            sum = 0;
            j = i;
            while (j < diff.length && (sum += diff[j]) <= maxCost) {
                j++;
            }
            if (j - i > maxLength) {
                maxLength = j - i;
            }
        }

        return maxLength;
    }
}
