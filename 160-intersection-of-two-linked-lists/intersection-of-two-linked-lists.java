/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int n1=getSize(temp1);
        int n2=getSize(temp2);
        int k = (n1>n2)?n1-n2:n2-n1;
        if(n2>n1){
            while(k!=0){
                temp2=temp2.next;
                k--;
            }
        }else{
            while(k!=0){
                temp1=temp1.next;
                k--;
            }
        }

        if(temp1 == temp2){
            return temp1;
        }

        

        while(temp1 != null && temp2 != null){
            if(temp1.next == temp2.next){
                return temp1.next;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
    public static int getSize(ListNode node){
        if(node == null) return 0;
        int size=0;
        while(node != null){
            node = node.next;
            size++;
        }
        return size;
    }
}