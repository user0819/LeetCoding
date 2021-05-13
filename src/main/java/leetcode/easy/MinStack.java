package leetcode.easy;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *
 *  push(x) —— 将元素 x 推入栈中。
 *  pop() —— 删除栈顶的元素。
 *  top() —— 获取栈顶元素。
 *  getMin() —— 检索栈中的最小元素。
 *
 *
 *
 *
 *  示例:
 *
 *  输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @author XIANG
 * @since 2021/2/20 10:29
 */
public class MinStack {
    Integer[] myStack;
    int index;

    /** initialize your data structure here. */
    public MinStack() {
        myStack = new Integer[10];
        index = -1;
    }

    public void push(int x) {
        if(index == myStack.length -1){
            enLarge();
        }
        myStack[++index] = x;
    }

    public void enLarge(){
        Integer[] newStack = new Integer[myStack.length * 2];
        for (int i = 0; i < myStack.length; i++) {
            newStack[i] = myStack[i];
        }
        myStack = newStack;
    }

    public void pop() {
        if(index < 0){
            return;
        }
        myStack[index--] = null;
    }

    public int top() {
        return myStack[index];
    }



    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= index; i++) {
            if(myStack[i] < min){
                min = myStack[i];
            }
        }
        return min;
    }

    public void look(){
        for (int i = 0; i <= index; i++) {
            System.out.print(myStack[i] + " ");
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.push(2147483647);
        minStack.push(2147483647);
        minStack.push(2147483647);
        minStack.push(2147483647);
        minStack.push(2147483647);
        minStack.push(2147483647);
        minStack.push(2147483647);
        minStack.push(2147483647);

        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);



        System.out.println(minStack.top());
        System.out.println(minStack.getMin());


        minStack.push(-2147483648);


        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
