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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while(list1 != null && list2 !=null){
            if(list1.val < list2.val){
                temp.val = list1.val;
                ListNode node = new ListNode();
                temp.next=node;
                temp = temp.next;
                list1= list1.next;
            }
            else{
                temp.val = list2.val;
                ListNode node = new ListNode();
                temp.next=node;
                temp = temp.next;
                list2= list2.next;
            }
        }
        if(list1 == null){
            while(list2 != null){
                temp.val = list2.val;
                list2=list2.next;
                if(list2 != null){
                    ListNode node = new ListNode();
                    temp.next=node;
                    temp=temp.next;
                }
            }
        }
        if(list2 == null){
            while(list1 != null){
                temp.val = list1.val;
                list1=list1.next;
                if(list1 != null){
                    ListNode node = new ListNode();
                    temp.next=node;
                    temp=temp.next;
                }                
            }
        }
        return dummy;
    }
}