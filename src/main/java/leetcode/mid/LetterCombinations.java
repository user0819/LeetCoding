package leetcode.mid;

import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2 -> abc
 * 3 -> def
 * 4 -> ghi
 * 5 -> jkl
 * 6 -> mno
 * 7 -> pqrs
 * 8 -> tuv
 * 9 -> wxyz
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * Related Topics 深度优先搜索 递归 字符串 回溯算法
 *
 * @author XIANG
 * @since 2021/2/20 9:28
 */
public class LetterCombinations {
    private Map<Character, String> letterMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    private List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }

        appendStringToResult(digits, 0, "");
        return result;
    }

    private void appendStringToResult(String digits, int index, String str){
        if(index == digits.length()){
            result.add(str);
            return ;
        }

        char c = digits.charAt(index);
        String letters = letterMap.get(c);
        for (char letter : letters.toCharArray()) {
            appendStringToResult(digits, index + 1, str + letter);
        }
    }
    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("235"));
    }
}
