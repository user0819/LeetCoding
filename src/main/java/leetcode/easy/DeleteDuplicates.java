package leetcode.easy;

/**
 * @author wangxiang
 * @since 2020/9/7 21:22
 */
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
//输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
//输出: 1->2->3
// Related Topics 链表
// 👍 389 👎 0


public class DeleteDuplicates {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode move = head;
        while(move !=null && move.next!=null){
            if(move.val == move.next.val){
                move.next =move.next.next;
            }else{
                move =move.next;
            }
        }
        return head;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
