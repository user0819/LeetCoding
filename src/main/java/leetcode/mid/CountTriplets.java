package leetcode.mid;

/**
 * @author wangxiang
 * @since 2021/5/18 18:43
 */
public class CountTriplets {
    public static int countTriplets(int[] arr) {

        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if ((prefix[i] ^ prefix[j]) == (prefix[j] ^ prefix[k + 1])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }


    //针对方法1，还可以再省去一层
    public static int countTriplets2(int[] arr) {

        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if (prefix[i] == prefix[k + 1]) {
                    count += k - i;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }
}
