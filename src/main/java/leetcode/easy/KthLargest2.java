package leetcode.easy;

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
public class KthLargest2 {

    /**
     * 初始化时
     *
     * 初始化堆【】
     * 将初始化数组的数据，逐个入堆
     * 新增数据时
     *
     * 当堆数据不满K位，则直接加入到堆尾，然后从堆尾【上浮】，维护堆的性质
     * 当数据满k位，且插入元素大于堆顶时，说明现在堆顶元素已经不再是前k大中的元素了，将其弹出，替换成新增数据，从根节点【下沉】维护堆的性质
     * 当数据满k位，但插入元素小于等于堆顶时，说明其在后续数据流入也不会成为第k大的元素
     */

    private int[] heap;
    private int size = 0;//堆内数量
    public KthLargest2(int k, int[] nums) {
        this.heap=new int[k];
        for (int num: nums) add(num);
    }
    public int add(int val) {
        if(size < heap.length){
            heap[size]=val;
            up(heap ,size++);
        }
        else if(val> heap[0]) {
            heap[0]=val;
            down(heap , heap.length ,0);
        }
        return heap[0];
    }
    /**
     * 下沉,弹出堆顶时，维护堆的性质，小根堆，父节点小于等于子节点
     */
    private void down (int[] array , int n ,int i){ //维护小根堆
        int lson= i*2 + 1; //左孩子
        int rson= i*2 + 2; //右孩子
        int smallest = i;
        if(lson < n && array[lson] < array[smallest]) smallest = lson;
        if(rson < n && array[rson] < array[smallest]) smallest = rson;
        if(smallest != i){ //保证父节点是最小的
            swap(array, i, smallest);
            down(array , n , smallest);
        }
    }
    /**
     * 上浮，堆尾插入数据，维护堆的性质，小根堆，父节点小于等于子节点
     */
    private void up(int[] array ,int i){
        int parent = (i-1)/2;
        if(parent>=0 &&  array[i] <array[parent]) {
            swap(array, parent, i);
            up(array, parent);
        }
    }
    private void swap(int[] array ,int i,int j){
        int tmp = array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    public static void main(String[] args) {
        KthLargest2 kthLargest = new KthLargest2(1, new int[]{});
        for (int i = 0; i <= 104; i++) {
            System.out.println(kthLargest.add(i));
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
