package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Mr.Wang on 2019/7/12.
 */
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
         //1. map 将小数组存进去, map格式 [数组中数字 => 下一个更大元素],题干不重复保证可以在map中对两个数组取出同一个值
         Map<Integer,Integer> map = new HashMap<>();
         for (int num: nums1){
             map.put(num,-1);
         }
         // 2. 单调栈找大数组下一个最大值, 栈中存储的是nums2中元素
         int length = nums2.length;
         Stack<Integer> stack = new Stack<>();
         for(int i = 0; i < length; i++){
            while(!stack.empty() && stack.peek() < nums2[i]){
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
         }
         // 3. 根据上面map将 nums1数组赋值
         for (int i=0; i< nums1.length;i++){
             nums1[i] = map.get(nums1[i]);
         }
         return nums1;
     }

    public static void main(String[] args) {
        nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }
}
