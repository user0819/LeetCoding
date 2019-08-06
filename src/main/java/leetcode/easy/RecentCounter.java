package leetcode.easy;

import java.util.LinkedList;

/**
 * Created by Mr.Wang on 2019/6/20.
 */
public class RecentCounter {
    private LinkedList<Integer> list ;

    public RecentCounter() {
        list = new LinkedList<Integer>();
    }

    public int ping(int t) {
        list.addLast(t);
        while(list.getFirst() < t - 3000){
            list.removeFirst();
        }
        return list.size();

    }

    public static void main(String[] args) {
         RecentCounter obj = new RecentCounter();
         int param_1 = obj.ping(1);
        System.out.println(param_1);
    }
}
