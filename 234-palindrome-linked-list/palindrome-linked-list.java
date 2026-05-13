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
    public static boolean isPalindrome(ListNode head) {
    ListNode temp = head;
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }
    ListNode mid = reverse(slow);
    while(mid != null){
        if(temp.val != mid.val) return false;
        temp = temp.next;
        mid = mid.next;
    }
    return true;
}
    public static ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode prev = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

}