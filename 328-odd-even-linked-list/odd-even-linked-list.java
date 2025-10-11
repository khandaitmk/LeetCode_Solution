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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        List<ListNode> l1 = new ArrayList<>();

        ListNode temp = head;
        while(temp != null && temp.next !=null ){
            l1.add(temp.next);
            ListNode dummy = temp.next;
            temp.next=temp.next.next;
            if(temp.next != null){
                temp = temp.next;
            }
            dummy.next=null;       

        }
        for(int i=0;i<l1.size();i++){
            temp.next=l1.get(i);
            temp=temp.next;
        }
        return head;
        
    }
}