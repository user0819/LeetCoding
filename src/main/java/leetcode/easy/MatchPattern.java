package leetcode.easy;

/**
 * @author wangxiang
 * @since 2020/4/10 13:04
 */
public class MatchPattern {

    public static void main(String[] args) {

    }

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        if (text.isEmpty()) return false;

        boolean first_match = (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

        if (!first_match) return false;

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) || isMatch(text.substring(1), pattern));
        } else {
            return isMatch(text.substring(1), pattern.substring(1));
        }

    }
}
