package leetcode.easy;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 *  说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *  示例 1:
 *
 *  输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 *
 *  示例 2:
 *
 *  输入: "race a car"
 * 输出: false
 *
 *  Related Topics 双指针 字符串
 * @since 2020/12/31 14:21
 */
public class IsPalindrome {
    private static final char A = 'A';
    private static final char Z = 'Z';
    private static final char a = 'a';
    private static final char z = 'z';
    private static final char ZERO = '0';
    private static final char NINE = '9';

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        char leftC, rightC;
        while (left < right) {
            leftC = s.charAt(left);
            rightC = s.charAt(right);
            if (!validCharacter(leftC)) {
                left++;
                continue;
            }
            if (!validCharacter(rightC)) {
                right--;
                continue;
            }
            leftC = isUpperChar(leftC) ? Character.toLowerCase(leftC) : leftC;
            rightC = isUpperChar(rightC) ? Character.toLowerCase(rightC) : rightC;
            if (leftC != rightC) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean validCharacter(char c) {
        if((c >= ZERO && c <= NINE) || ((c >= A && c <= Z)) || (c >= a && c <= z)) {
            return true;
        }
        return false;
    }

    private boolean isUpperChar(char c) {
        return c >= A && c <= Z;
    }

    public static void main(String[] args) {
        IsPalindrome demo = new IsPalindrome();
        System.out.println(demo.isPalindrome("race a car"));
    }


}
