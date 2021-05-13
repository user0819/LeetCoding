package leetcode.easy;

/**
 * @author XIANG
 * @since 2020/9/2 9:24
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(1343464));
    }

    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
