package leetcode;

/**
 * @author wangxiang
 * @since 2020/4/2 13:01
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(Integer.MAX_VALUE));
    }
    public static int reverse(int x) {
        int result = 0;
        int pop;
        while(x!=0){
            pop = x%10;
            //累加之前判断是否会溢出
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            result = result*10 +pop ;
            x/=10;
        }
        return result;
    }
}
