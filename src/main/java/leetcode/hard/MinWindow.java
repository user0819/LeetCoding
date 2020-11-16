package leetcode.hard;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window
 *
 * @author wangxiang
 * @since 2020/11/5 9:33
 */
public class MinWindow {
    public static String minWindow(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        int[] chars = new int[128];
        boolean[] flag = new boolean[128];

        // 先统计T中的字符情况
        for (int i = 0; i < t.length(); ++i) {
            flag[T[i]] = true;
            ++chars[T[i]];
        }
        // 移动滑动窗口，不断更改统计数据
        int cnt = 0, l = 0, min_l = 0, min_size = s.length() + 1;
        for (int r = 0; r < S.length; ++r) {
            if (!flag[S[r]]) {continue;}

            if (--chars[S[r]] >= 0) {
                ++cnt;
            }
            // 若目前滑动窗口已包含T中全部字符，
            // 则尝试将l右移，在不影响结果的情况下获得最短子字符串
            while (cnt == T.length) {
                if (r - l + 1 < min_size) {
                    min_l = l;
                    min_size = r - l + 1;
                }
                if (flag[S[l]] && ++chars[S[l]] > 0) {
                    --cnt;
                }
                ++l;
            }
        }
        return min_size > S.length ? "" : s.substring(min_l, min_l + min_size);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
