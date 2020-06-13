package leetcode.easy;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * @author wangxiang
 * @since 2020/4/9 12:48
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-123));
    }

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int cal = x;
        int reverse = 0;
        while(cal!=0){
            reverse = reverse*10 + cal%10;
            cal/=10;
        }
        return reverse == x;
    }
}
