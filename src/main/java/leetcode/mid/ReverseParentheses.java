package leetcode.mid;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 * <p>
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * @author wangxiang
 * @since 2021/5/26 10:31
 */
public class ReverseParentheses {
    /**
     * 使用stack，针对每一对括号，进行一次反转后再入栈
     * 可以保证最后栈中存放的即为最终的结果
     */
    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
                continue;
            }

            Queue<Character> queue = new LinkedList<>();
            while (stack.peek() != '(') {
                queue.add(stack.pop());
            }
            stack.pop();

            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }


    /**
     * 官方题解：
     * <p>
     * 对于括号序列相关的题目，通用的解法是使用递归或栈。本题中我们将使用栈解决。
     * <p>
     * 我们从左到右遍历该字符串，使用字符串 str 记录当前层所遍历到的小写英文字母。对于当前遍历的字符：
     * <p>
     * 如果是左括号，将 str 插入到栈中，并将 str 置为空，进入下一层；
     * <p>
     * 如果是右括号，则说明遍历完了当前层，需要将 str 反转，返回给上一层。具体地，将栈顶字符串弹出，然后将反转后的 str 拼接到栈顶字符串末尾，将结果赋值给 str。
     * <p>
     * 如果是小写英文字母，将其加到 str 末尾。
     * <p>
     * 注意到我们仅在遇到右括号时才进行字符串处理，这样可以保证我们是按照从括号内到外的顺序处理字符串。
     * <p>
     * 作者：LeetCode-Solution
     */
    public static String reverseParentheses2(String s) {
        StringBuilder sb = new StringBuilder();

        Deque<String> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }


    /**
     * 我们可以将括号的反转理解为逆序地遍历括号，如下图：
     *
     * 读者们可以自行尝试模拟两层乃至多层括号嵌套的移动方案，规律可以从当前的单层括号中总结出来。
     * <p>
     * 假设我们沿着某个方向移动，此时遇到了括号，那么我们只需要首先跳跃到该括号对应的另一个括号所在处，然后改变我们的移动方向即可。
     * 这个方案同时适用于遍历时进入更深一层，以及完成当前层的遍历后返回到上一层的方案。
     * <p>
     * 在实际代码中，我们需要预处理出每一个括号对应的另一个括号所在的位置，这一部分我们可以使用栈解决。
     * 当我们预处理完成后，即可在线性时间内完成遍历，遍历的字符串顺序即为反转后的字符串。
     * <p>
     * 作者：LeetCode-Solution
     */
    public String reverseParentheses3(String s) {
        int n = s.length();

        //预处理每对括号的位置
        int[] pair = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                int left = stack.pop();
                pair[i] = left;
                pair[left] = i;
            }
        }

        int index = 0, step = 1;
        StringBuilder sb = new StringBuilder();
        while (index < n) {
            char c = s.charAt(index);
            if (c == '(' || c == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(c);
            }

            index += step;
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses(""));
        System.out.println(reverseParentheses("()"));
        System.out.println(reverseParentheses2("(abc)"));
    }
}
