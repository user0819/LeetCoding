package leetcode.easy;

/**
 * @author wangxiang
 * @since 2021/5/27 11:45
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n &= (n -1);
            count++;
        }
        return  count;
    }
}
