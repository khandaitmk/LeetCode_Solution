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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast=fast.next.next;
        }

        if(fast.next == null){
            ListNode node = slow.next;
             ListNode nodeRev = reverse(node);
             while(nodeRev != null){
                if(temp.val != nodeRev.val){
                    return false;
                }
                temp=temp.next;
                nodeRev=nodeRev.next;
             }
        }else{
             ListNode node = slow.next;
             ListNode nodeRev = reverse(node);
             while(nodeRev != null){
                if(temp.val != nodeRev.val){
                    return false;
                }
                temp=temp.next;
                nodeRev=nodeRev.next;
             }
        }
        return true;

    }

    public static ListNode reverse(ListNode temp){
        if(temp.next == null){
            return temp;
        }
        ListNode nextNode = reverse(temp.next);
        temp.next.next = temp;
        temp.next = null;
        return nextNode;
    }
}