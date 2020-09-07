package leetcode.easy;

/**
 * @author wangxiang
 * @since 2020/9/1 9:43
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] result = plusOne(new int[]{9,9,9});
        for (int i:result) {
            System.out.println(i);
        }

    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] =digits[i]%10;
            if(digits[i] != 0) return digits;
        }

        int[] copy = new int[digits.length + 1];
        copy[0] = 1;
        return  copy;
    }
}
