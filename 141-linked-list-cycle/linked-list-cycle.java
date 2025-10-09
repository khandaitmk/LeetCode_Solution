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
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        if(temp== null){
            return false;
        }
        List<ListNode> l= new ArrayList<>();
        while(!l.contains(temp) && temp.next !=null ){
            l.add(temp);
            temp=temp.next;
        }
        if(temp.next == null || temp== null){
            return false;
        }
        return true;

    }
}