package leetcode.easy;

/**
 * @author wangxiang
 * @since 2020/3/31 12:52
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
    }

    public static String longestPalindrome(String s) {
        if(s==null||s.length()==0 ){
            return s;
        }
        char[] chars = s.toCharArray();
        int i, leftIndex ,rightIndex,minLeft=0,maxRight=0;
        for (i = 0; i < chars.length; i++) {
            leftIndex = i;
            rightIndex=i;
            while(leftIndex >= 0 && chars[leftIndex] ==chars[i]){
                leftIndex--;
            }
            while(rightIndex < chars.length && chars[rightIndex] ==chars[i]){
                rightIndex++;
            }
            while (leftIndex >= 0 && rightIndex< chars.length && chars[leftIndex] == chars[rightIndex]) {
                rightIndex++;
                leftIndex--;
            }

            if ((rightIndex-1)-(leftIndex + 1) + 1 > maxRight - minLeft) {
                minLeft = leftIndex + 1;
                maxRight = rightIndex-1;
            }
        }
        return s.substring(minLeft,maxRight+1);
    }
}
