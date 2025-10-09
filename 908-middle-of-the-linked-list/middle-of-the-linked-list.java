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
    public ListNode middleNode(ListNode head) {
        int size = getSize(head);
        int mid = (int)size/2;
        ListNode temp = head;
        int index =0;
        while(index != mid){
            temp=temp.next;
            index++;
            if(index == mid){
                return temp;
            }
        }
        return head;
    }
    public static int getSize(ListNode node){
        if(node == null)  return 0;
        int size =0;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }
}