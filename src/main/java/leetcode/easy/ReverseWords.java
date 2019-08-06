package leetcode.easy;

import java.util.Arrays;

/**
 * Created by Mr.Wang on 2019/6/24.
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String singString: array ){
            sb.append(reverse(singString) + " ");
        }
        String newString = sb.toString();
        if(newString.endsWith(" ")){
            return newString.substring(0,newString.length()-1);
        }else{
            return newString;
        }

    }

    public static String reverse(String s){
        if(s==null || "".equals(s)){
            return "";
        }
        int len = s.length();
        char[] chars = new char[len];
        for(int i = len -1; i >= 0; i--){
            chars[len-1 -i] = s.charAt(i);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
