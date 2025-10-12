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
    public ListNode sortList(ListNode head) {
        
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        return mergeSort(head);
    }
    public static ListNode mergeSort(ListNode node){
        if(node.next == null){
            return node;
        }
        ListNode temp = node;
        ListNode mid = getMiddle(node);
        ListNode dummy = mid.next;
        mid.next = null;
        ListNode first = mergeSort(temp);
        ListNode second = mergeSort(dummy);
        return merge(first,second);

    }
    public static ListNode merge(ListNode node1,ListNode node2){

        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while( node1 !=null && node2 != null){
            if(node1.val < node2.val){
                res.next = node1;
                node1 = node1.next;
            }else{
                res.next = node2;
                node2 = node2.next;
            }
            res = res.next;
        }
        if(node1 == null){
            while(node2 != null){
                res.next=node2;
                node2 = node2.next;
                res = res.next;
            }
        }
        if(node2 == null){
            while(node1 != null){
                res.next=node1;
                node1 = node1.next;
                res = res.next;
            }
        }
        return temp.next;
    }
    public static ListNode getMiddle(ListNode temp){
        ListNode slow = temp;
        ListNode fast = temp.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}