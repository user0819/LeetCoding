package leetcode.middle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Mr.Wang on 2019/7/8.
 *
 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

 注意:

 可以认为区间的终点总是大于它的起点。
 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 示例 1:

 输入: [ [1,2], [2,3], [3,4], [1,3] ]

 输出: 1

 解释: 移除 [1,3] 后，剩下的区间没有重叠。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class EraseOverlapIntervals {


    /**
     如果两个区间有重叠，应该保留那个结尾短的。

     即要删除的是：与之前的区间有重叠的，并且结尾还比当前结尾长的那个区间。
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)-> {
            if (o1[0] == o2[0]) return o1[o1.length - 1] - o2[o2.length - 1];
            else return o1[0] - o2[0];
            }
        );

        int res = 0;
        int prev  =0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[prev][intervals[prev].length-1]){
                res++;
                if(intervals[i][intervals[i].length-1] < intervals[prev][intervals[prev].length-1])
                    prev = i;
            }else{
                prev = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1,2},{2,3},{1,4}};

        System.out.println(eraseOverlapIntervals(arrays));

    }
}
