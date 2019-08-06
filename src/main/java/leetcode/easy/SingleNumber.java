package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mr.Wang on 2019/7/11.
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Set<Integer> myset = new HashSet();
        long sumSet = 0 ;
        long sumNum = 0;

        for(int a:nums){
            if(myset.add(a)){
                sumSet += a;
            }
            sumNum+=a;
        }
        return (int)((3*sumSet-sumNum)/2);
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43}));
    }
}
