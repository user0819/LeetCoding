package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mr.Wang on 2019/6/20.
 */
public class RepeatedNTimes {
    public static int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        int result = 0;
        for (int a : A) {
            if(!set.add(a)){
                result = a;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{}));
    }
}
