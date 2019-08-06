package leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Mr.Wang on 2019/7/20.
 */
public class TopKFrequent {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap();
        for(int i: nums){
            if(map.get(i) == null){
                map.put(i,1);
            }else{
                map.put(i,map.get(i) + 1);
            }
        }
        return new ArrayList<>(map.keySet()).subList(0,k);
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,1,3,2,2},2);
    }
}
