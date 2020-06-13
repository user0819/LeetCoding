package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mr.Wang on 2019/6/12.
 */
public class OuterParentheses {
    public static String removeOuterParentheses(String s){
        if(s==null || s == ""){
            return null;
        }

        char[] chars = s.toCharArray();
        char[] charsave = new char[chars.length];

        boolean saveFlag = false;
        int saveIndex = 0;
        int count = 0;

        for (int i = 0; i < chars.length ; i++) {
            if( '(' == chars[i]){
                count++;
            }
            if( ')' == chars[i]){
                count--;
            }
            if(count == 0 && i != 0){
                saveFlag = false;
                continue;
            }

            if(saveFlag){
                charsave[saveIndex] = chars[i];
                saveIndex++;
            }
            saveFlag =true;
        }

        return new String(charsave).trim();

    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }
}
