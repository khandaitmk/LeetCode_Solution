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
       ListNode temp = head;
        Stack<ListNode> ss = new Stack<>();
        while(temp != null){
            ss.push(temp);
            temp = temp.next;
        }
        while(head != null && !ss.isEmpty()){
            if(ss.pop().val != head.val) return false;
            head = head.next;
        }
        return true;
    }
}