package leetcode.mid;

import java.util.Stack;

/**
 * 921
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 * <p>
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * <p>
 * <p>
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："())"
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入："((("
 * 输出：3
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入："()"
 * 输出：0
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入："()))(("
 * 输出：4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * S.length <= 1000
 * S 只包含 '(' 和 ')' 字符。
 * <p>
 * <p>
 * <p>
 * Related Topics 栈 贪心算法
 *
 * @author XIANG
 * @since 2021/3/1 9:38
 */
public class MinAddToMakeValid {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))(("));
    }

    public static int minAddToMakeValid(String S) {
        int count = 0;
        char c;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (c == '(') {
                stack.push('(');
                continue;
            }

            if (stack.size() == 0) {
                count++;
                continue;
            }

            if (stack.peek() == '(' && c == ')') {
                stack.pop();
                continue;
            }

            count++;
        }
        count += stack.size();
        return count;
    }
}
