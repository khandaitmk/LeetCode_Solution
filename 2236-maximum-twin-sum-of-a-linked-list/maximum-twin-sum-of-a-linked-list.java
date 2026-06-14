/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode temp = head;
        ListNode slow = temp;
        ListNode fast = temp;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next .next;
        }
        ListNode mid = reverseLL(slow);
        int max = 0;
        while(mid != null && temp != null){
            int tempSum = mid.val + temp.val;
            max = Math.max(max , tempSum);
            temp = temp.next;
            mid = mid.next;
        }
        return max;
    }
    public static ListNode reverseLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}