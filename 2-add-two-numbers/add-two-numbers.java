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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode temp1 = l1;
         ListNode temp2 = l2;
         ListNode temp = null;
         ListNode resHead = null;
         int carry = 0;
         
         while(temp1 != null && temp2 != null){
             int data1 = temp1.val;
             int data2 = temp2.val;
             int data = data1 + data2 + carry;
             if(data>9){
                 carry = 1;
             }else{
                 carry=0;
             }
             if(temp == null){
                 temp = new ListNode(data%10);
                 resHead = temp;
                 
             } else{
                 ListNode newNode = new ListNode(data%10);
                 temp.next = newNode;
                 temp = newNode;
             }
             temp1 = temp1.next;
             temp2 = temp2.next;
         }
         while(temp1 != null){
             int data1 = temp1.val;
             int data = data1 + carry;
              if(data>9){
                 carry = 1;
             }else{
                 carry=0;
             }
             ListNode newNode = new ListNode(data%10);
                 temp.next = newNode;
                 temp = newNode;
                 
                 temp1 = temp1.next;
         }
         while(temp2 != null){
             int data2 = temp2.val;
             int data = data2 + carry;
              if(data>9){
                 carry = 1;
             }else{
                 carry=0;
             }
             ListNode newNode = new ListNode(data%10);
                 temp.next = newNode;
                 temp = newNode;
                 temp2 = temp2.next;
         }
         if(carry == 1){
             ListNode newNode = new ListNode(1);
                 temp.next = newNode;
                 temp = newNode;
         }
          
          return resHead;
    }
}