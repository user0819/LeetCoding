package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mr.Wang on 2019/6/20.
 */
public class FindComplement {

    public static int findComplement(int num) {
        int power = 0;
        int sum = 0;
        int bit = 0;
        while(num!=0){
            bit = num%2 == 0?1:0;
            sum += bit*Math.pow(2,power);
            num/=2;
            power++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(0));
    }
}
