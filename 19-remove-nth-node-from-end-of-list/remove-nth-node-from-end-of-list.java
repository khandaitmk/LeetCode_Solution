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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode temp = head;
        ListNode first = head;
        ListNode second = head;
        
        for(int i=0;i<n;i++){
            second=second.next;
        }
        if(second == null){
            first.val = first.next.val;
            first.next=first.next.next;
            return temp;
        }
        while(second.next != null){
            first=first.next;
            second= second.next;
        }
        
        if(first.next != null){
            first.next = first.next.next;
        }
        return temp;

        
    }
}