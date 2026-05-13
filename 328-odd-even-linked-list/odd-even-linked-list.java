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
    // public ListNode oddEvenList(ListNode head) {
    //     if(head == null){
    //         return null;
    //     }
    //     List<ListNode> l1 = new ArrayList<>();

    //     ListNode temp = head;
    //     while(temp != null && temp.next !=null ){
    //         l1.add(temp.next);
    //         ListNode dummy = temp.next;
    //         temp.next=temp.next.next;
    //         if(temp.next != null){
    //             temp = temp.next;
    //         }
    //         dummy.next=null;       

    //     }
    //     for(int i=0;i<l1.size();i++){
    //         temp.next=l1.get(i);
    //         temp=temp.next;
    //     }
    //     return head;
        
    // }
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = null;
        ListNode even = null;
        ListNode res = null;
        ListNode temp_even = null;
        ListNode temp = head;
        int i = 1;
        while(temp != null){
            if(i % 2 == 0){
                if(even == null){
                    even  = new ListNode(temp.val);
                    temp_even = even;
                }else{
                    even.next = new ListNode(temp.val);
                    even  = even.next;
                }
            }else{
                if(odd == null){
                    odd = new ListNode(temp.val);
                    res = odd;
                }else{
                    odd.next = new ListNode(temp.val);
                    odd = odd.next;
                }
            }
            i++;
            temp = temp.next;
        }
        odd.next = temp_even;
        return res;
    }
}