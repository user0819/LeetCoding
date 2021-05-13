package leetcode.mid;

import java.util.Arrays;

/**
 * @author XIANG
 * @since 2020/6/2 13:04
 */
public class ShiftingLetters {
    public static void main(String[] args) {
        System.out.println(shiftingLetters("ruu",new int[]{26,9,17}));
    }

    public static String shiftingLetters(String S, int[] shifts) {
        int length = shifts.length;
        int[] total = new int[length];
        total[length-1] = shifts[length-1];
        for (int i = length-2; i >=0 ; i--) {
            total[i] = total[i+1] + shifts[i];
        }
         char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (chars[i] + total[i]%26) > 'z'? (char) ('a'-1 + (chars[i] + total[i] % 26) - 'z') : (char) (chars[i] + total[i] % 26);
        }
        return new String(chars);
    }
}
