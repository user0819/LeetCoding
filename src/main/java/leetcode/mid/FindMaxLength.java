package leetcode.mid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author wangxiang
 * @since 2021/6/3 10:25
 */
public class FindMaxLength {
    /**
     * 遍历每一位，获取由它开始最大能获取到{1，0}的配对数，然后对比获取最大结果
     * <p>
     * 如何获取当前位开始最大的配对数？
     * 借用栈，如果当前值与栈顶值相同时，当前数组值入栈。
     * 若当前值与栈顶值不同时，则为一对{0，1}，则对数加一，同时抛出顶部元素。
     * 若{0，1}对出现抛出栈顶元素后，栈正好为空，说明这是一组满足条件的子数组，记录当前数组长度。
     *
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        int maxPair = 0;
        for (int i = 0; i < nums.length; i++) {
            int pair = 0, tmpPair = 0;
            Stack<Integer> stack = new Stack<>();
            for (int j = i; j < nums.length; j++) {
                if (stack.isEmpty() || stack.peek() == nums[j]) {
                    stack.add(nums[j]);
                    continue;
                }

                tmpPair++;
                stack.pop();
                if (stack.isEmpty()) {
                    pair += tmpPair;
                    tmpPair = 0;
                }
            }
            maxPair = Math.max(maxPair, pair);
        }

        return maxPair * 2;
    }

    /**
     * 前缀和
     * 若子数组满足条件，前缀和数组中一定有满足条件： (prefix[j] - prefix[i]) * 2 = j - i;
     * 本题题解为找到最大的 j-i ;
     */
    public static int findMaxLength2(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int maxLength = 0;
        for (int i = 0; i < prefix.length; i++) {
            for (int j = i + 1; j < prefix.length; j++) {
                if ((prefix[j] - prefix[i]) * 2 == j - i) {
                    maxLength = Math.max(maxLength, j - i);
                }
            }
        }
        return maxLength;
    }

    public static int findMaxLength3(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        int maxLength = 0;
        for (int i = 0; i < prefix.length; i++) {
            for (int j = prefix.length -1; j >= i + 1; j--) {
                if ((prefix[j] - prefix[i]) * 2 == j - i) {
                    maxLength = Math.max(maxLength, j - i);
                    break;
                }
            }
        }
        return maxLength;
    }

    /**
     * 前缀和
     * 将0视为-1
     * 若子数组满足条件，前缀和数组中一定有满足条件： (prefix[j] - prefix[i]) = 0；
     */
    public static int findMaxLength4(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLength = 0;
        int sum =0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == 1){
                sum++;
            }else {
                sum--;
            }
            if(map.containsKey(sum)){
                //说明数组在【map.get(sum), i】这段范围内和为0
                maxLength = Math.max(maxLength, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1}));
        System.out.println(findMaxLength2(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1}));
        System.out.println(findMaxLength3(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1}));
        System.out.println(findMaxLength3(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0, 1}));
    }
}
