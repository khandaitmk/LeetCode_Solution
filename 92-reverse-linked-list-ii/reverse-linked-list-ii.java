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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        if(left == right){
            return head;
        }
        ListNode temp = head;
        ListNode last = getNode(temp,right-1);
        ListNode first = getNode(temp,left-2);
        if(last.next == null && first == null){
            ListNode reversed = reverse(temp,null,left,right);
            return reversed;
        }
        else if(last.next != null && first == null){
            ListNode reversed = reverse(temp,last.next,left,right);
            return reversed;
        }
        else if(last.next == null && first != null){
            ListNode reversed = reverse(first.next,null,left,right);
            first.next = reversed;
            return head;
        }
        ListNode reversed = reverse(first.next,last.next,left,right);
        first.next = reversed;
        return head;

    }
    public static ListNode getNode(ListNode node , int n){
        if(node == null){
            return null;
        }
        ListNode temp = node;
        while(temp!=null && n-- != 0){
            temp = temp.next;
        }
        return temp;
    }
    public static ListNode reverse(ListNode node ,ListNode oriPrev, int left , int right){
        ListNode tempPrev = oriPrev;
        ListNode present = node;
        ListNode nextNode = present.next;
        for(int i=0;i<=right-left;i++){
            present.next = tempPrev;
            tempPrev = present;
            present = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
        }
        return tempPrev;


    }
}