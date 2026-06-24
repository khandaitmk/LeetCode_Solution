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
    public ListNode swapNodes(ListNode head, int k) {
     ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        temp = head;
        ListNode[] arr = new ListNode[size];
        int i=0;
        while(temp != null){
            arr[i++] = temp;
            temp = temp.next;
        }
        int tempVal= arr[k-1].val;
        arr[k-1].val = arr[size - k].val;
        arr[size - k].val = tempVal;
        return head;   
    }
}