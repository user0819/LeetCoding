package leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 703
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * <p>
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 * <p>
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);    return 4
 * kthLargest.add(5);    return 5
 * kthLargest.add(10);   return 5
 * kthLargest.add(9);    return 8
 * kthLargest.add(4);    return 8
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= k <= 10的四次方
 * 0 <= nums.length <= 10的四次方
 * -10的四次方 <= nums[i] <= 10的四次方
 * -10的四次方 <= val <= 10的四次方
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 * <p>
 * Related Topics 堆 设计
 *
 * @author XIANG
 * @since 2021/3/3 10:01
 */
public class KthLargest {
    //优先队列，只保存前k的数
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {     // 维持 队列的大小与kk值相等
            pq.poll();    //弹出元素
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(1, new int[]{});
        for (int i = 0; i <= 104; i++) {
            System.out.println(kthLargest.add(i));
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
