package leetcode.easy;

import java.util.*;

/**
 * Created by Mr.Wang on 2019/7/16.
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Stack stack =new Stack();
        Queue queue = new ArrayDeque();

        List<Integer> list = new ArrayList<>();

        for(int num : nums){

            if(nums[num] > 0){
                nums[num] = -1 * nums[num];
            }else{
                list.add(num);
            }

        }

        return list;
    }
}
