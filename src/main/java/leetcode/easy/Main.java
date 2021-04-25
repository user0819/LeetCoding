package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * #22/23044444411
 * bad i.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(getString("25343634#1/12"));
    }

    private static String getString(String str) {
        Map<Character, Character[]> num2Chars = new HashMap<>();
        num2Chars.put('0', new Character[]{' '});
        num2Chars.put('1', new Character[]{',', '.'});
        num2Chars.put('2', new Character[]{'a', 'b', 'c'});
        num2Chars.put('3', new Character[]{'d', 'e', 'f'});
        num2Chars.put('4', new Character[]{'g', 'h', 'i'});
        num2Chars.put('5', new Character[]{'j', 'k', 'l'});
        num2Chars.put('6', new Character[]{'m', 'n', 'o'});
        num2Chars.put('7', new Character[]{'p', 'q', 'r', 's'});
        num2Chars.put('8', new Character[]{'t', 'u', 'v'});
        num2Chars.put('9', new Character[]{'w', 'x', 'y', 'z'});

        StringBuilder sb = new StringBuilder();
        boolean numFlag = true;

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((c < 47 || c > 57) && c != '#') {
                sb.append(c);
                continue;
            }
            if (c == '#') {
                numFlag = !numFlag;
                continue;
            }

            if (c == '/') {
                continue;
            } else if (numFlag) {
                sb.append(c);
                continue;
            } else {
                int count = 1;
                while (i + 1 < chars.length && chars[i + 1] == chars[i]) {
                    count++;
                    i++;
                }
                Character[] thisChar = num2Chars.get(c);
                sb.append(thisChar[(count - 1) % thisChar.length]);
            }
        }
        return sb.toString();
    }


}
