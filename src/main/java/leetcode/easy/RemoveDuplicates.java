package leetcode.easy;

import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 *  在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 *  在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 *
 *  示例：
 *
 *  输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
 * 只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 *
 *
 *  提示：
 *
 *
 *  1 <= S.length <= 20000
 *  S 仅由小写英文字母组成。
 *
 *  Related Topics 栈
 * @author wangxiang
 * @since 2021/2/25 19:15
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c: S.toCharArray()) {
            if(stack.empty()){
                stack.push(c);
                continue;
            }
            char top = stack.peek();
            if(c == top){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character c: stack) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
