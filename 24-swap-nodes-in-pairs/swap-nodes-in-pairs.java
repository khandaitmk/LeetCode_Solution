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
    public ListNode swapPairs(ListNode head) {
        return reverse(true , head);
    }
    public static ListNode reverse(boolean swap , ListNode temp){
        if(temp == null || temp.next == null){
            return temp;
        }
        
        ListNode reversed = reverse(!swap , temp.next);
        if(!swap ){
            temp.next = reversed;   
            return temp;
        }
        ListNode next = temp.next.next;
        temp.next.next = temp;
        temp.next = next;
        return reversed;
    }
}