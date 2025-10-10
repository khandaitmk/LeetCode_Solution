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
        List<Integer> list=new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp=temp.next;
        }
        int size = list.size();
        int n=size-1;
        while(n >= size/2){
            if(head.val != list.get(n--)){
                return false;
            }
            head = head.next;
        }
        return true;
         
    }
}