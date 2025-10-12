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
    public void reorderList(ListNode head) {
        if(head==null){
            return ;
        }
        ListNode temp = head;
        ListNode temp2 = head;
        List<ListNode> l1 = new ArrayList<>();
        while(temp != null){
            l1.add(temp);
            temp = temp.next;
        }
        int size = getSize(head);
        int k=size-1;
        int i=0;
        while(i<k){
            ListNode last = l1.get(k--);
            ListNode nextNode = temp2.next;

            // disconnect the last node from old chain
            last.next = null;

            // insert last node after current
            temp2.next = last;
            last.next = nextNode;

            // move forward
            temp2 = nextNode;
            i++;
        }
        if (temp2 != null) temp2.next = null;
    }
    
    public static int getSize(ListNode node){
        if(node == null){
            return 0;
        }
        int size =0;
        while(node != null){
            size++;
            node = node.next;
        }
        return size;
    }
}