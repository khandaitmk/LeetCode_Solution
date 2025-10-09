/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int length=0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                ListNode temp = slow;
                do{
                    temp=temp.next;
                    length++;
                } while(temp != slow);
                ListNode first = head;
                ListNode second = slow;
                int index = 0;
                while(first != second){
                    first=first.next;
                    second = second.next;
                    index++;
                }
                return first;
            }
        }
        
       return null;
    }
}