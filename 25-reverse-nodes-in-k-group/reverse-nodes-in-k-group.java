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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode temp = head;
        if(k==1){
            return head;
        }
        ListNode newHead = null;
        ListNode prevGroupEnd = null;
        while(temp != null){
            ListNode first = temp;
            ListNode last = getNodee(first,k);
            if (last == null) {
                if (prevGroupEnd != null) {
                    prevGroupEnd.next = temp; // connect leftover nodes
                }
                break;
            }
            ListNode nextGroupStart = last.next;
            ListNode reversedHead = reverse(first,last,k);
            if (newHead == null) {
                newHead = reversedHead;  // first reversed group becomes new head
            }
            if (prevGroupEnd != null) {
                prevGroupEnd.next = reversedHead;  // \U0001f539 Fix #3: link previous group
            }
            prevGroupEnd = first;
            temp = nextGroupStart;


        }
//        printLLNode(Head);
        head = newHead;
        return head;

    };

    public static ListNode reverse(ListNode first ,ListNode last , int k){
        ListNode present =first;
        ListNode prev = last.next;
        ListNode nextNode = present.next;
        for(int i=0;i<k;i++){
            present.next = prev;
            prev = present;
            present = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }
        return prev;
    };

    public static ListNode getNodee(ListNode node , int n){
        if(node == null){
            return null;
        }
        ListNode temp = node;
        while(temp!=null && --n != 0){
            temp = temp.next;
        }
        return temp;
    }   
}